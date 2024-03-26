package org.ccs.app.core.budget.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ccs.app.core.budget.domain.Receipt;
import org.ccs.app.core.budget.domain.ReceiptStatus;
import org.ccs.app.core.user.domain.User;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter @ToString(exclude = "items")
public class QueryReceiptResult {
    private Long id;
    private BigDecimal totalAmount;
    private String bankName;
    private String accountNumber;
    private String comment;
    private ReceiptStatus status;
    private String attachedFile;
    private Long requesterId;
    private String requestName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<QueryReceiptItemResult> items;

    public QueryReceiptResult(Receipt receipt, User user) {
        this.id = receipt.getId();
        this.totalAmount = receipt.getTotalAmount();
        this.bankName = receipt.getDepositAccount().getCode().name();
        this.accountNumber = receipt.getDepositAccount().getAccountNumber();
        this.comment = receipt.getComment();
        this.status = receipt.getStatus();
        this.attachedFile = receipt.getAttachedFile();
        this.requesterId = receipt.getRequester();
        this.requestName = user.getName();
        this.createdAt = receipt.getCreatedDateTime();
        this.updatedAt = receipt.getUpdatedDateTime();
        this.items = receipt.getItems()
                .stream()
                .map(it -> new QueryReceiptItemResult(it))
                .collect(Collectors.toList());
    }
}
