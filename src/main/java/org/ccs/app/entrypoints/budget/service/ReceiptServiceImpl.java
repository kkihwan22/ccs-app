package org.ccs.app.entrypoints.budget.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.budget.domain.ReceiptStatus;
import org.ccs.app.core.budget.infra.ReceiptRepository;
import org.ccs.app.core.budget.model.QueryReceiptParameter;
import org.ccs.app.core.budget.model.QueryReceiptResult;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;

    @Override
    public List<QueryReceiptResult> queryReceipt(PageRequest pageRequest, Set<Long> requesterSet, Set<ReceiptStatus> statusSet) {
        QueryReceiptParameter parameter = QueryReceiptParameter.builder()
                .requesterSet(requesterSet)
                .statusSet(statusSet)
                .build();

        return receiptRepository.query(parameter);
    }

    @Override
    public List<QueryReceiptResult> queryMyReceipt(PageRequest pageRequest) {
        QueryReceiptParameter parameter = QueryReceiptParameter.builder().build();
        return receiptRepository.query(parameter);
    }
}
