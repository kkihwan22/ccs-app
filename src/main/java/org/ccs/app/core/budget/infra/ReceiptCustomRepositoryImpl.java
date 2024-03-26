package org.ccs.app.core.budget.infra;

import com.querydsl.core.types.Expression;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.ccs.app.core.budget.model.QueryReceiptParameter;
import org.ccs.app.core.budget.model.QueryReceiptResult;
import org.ccs.app.core.share.support.QueryExpressionSupport;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static org.ccs.app.core.budget.domain.QReceipt.receipt;
import static org.ccs.app.core.budget.domain.QReceiptItem.receiptItem;
import static org.ccs.app.core.user.domain.QUser.user;

@RequiredArgsConstructor
@Repository
public class ReceiptCustomRepositoryImpl implements ReceiptCustomRepository {

    private final JPAQueryFactory queryDsl;

    private static final Map<String, Expression<?>> RECEIPT_PROPERTY_MAP = new HashMap<>();

    static {
        RECEIPT_PROPERTY_MAP.put("id", receipt.id);
        RECEIPT_PROPERTY_MAP.put("updatedAt", receipt.updatedDateTime);
    }

    @Override
    public List<QueryReceiptResult> query(QueryReceiptParameter parameter) {
        JPAQuery<QueryReceiptResult> query = queryDsl.select(Projections.constructor(QueryReceiptResult.class, receipt, user))
                .from(receipt)
                .join(user).on(receipt.requester.eq(user.id))
                .join(receiptItem).on(receipt.eq(receiptItem.receipt))
                .where(
                        QueryExpressionSupport.inOperation(receipt.requester, parameter.getRequesterSet()),
                        QueryExpressionSupport.inOperation(receipt.status, parameter.getStatusSet())
                )
                .distinct();

        PageRequest pageRequest = parameter.getPageRequest();
        if (!Objects.isNull(pageRequest)) {
            OrderSpecifier<?> orders = QueryExpressionSupport.getOrderSpecifier(RECEIPT_PROPERTY_MAP, pageRequest.getSort());
            if (!Objects.isNull(orders)) {
                query.orderBy(orders);
            }

            query.offset(pageRequest.getOffset());
            query.limit(pageRequest.getPageSize());
        }

        return query.fetch();
    }
}
