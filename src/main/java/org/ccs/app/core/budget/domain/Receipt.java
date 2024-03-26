package org.ccs.app.core.budget.domain;

import jakarta.persistence.*;
import lombok.*;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "receipt")
@DynamicInsert
@DynamicUpdate
@Getter
@ToString
@Builder
public class Receipt extends BaseCreatedAndUpdatedDateTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "receipt")
    private List<ReceiptItem> items;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "requester")
    private Long requester;

    @AttributeOverrides({
            @AttributeOverride(name = "code", column = @Column(name = "bank_code")),
            @AttributeOverride(name = "accountNumber", column = @Column(name = "bank_account_number")),
    })
    @Embedded
    private Bank depositAccount;

    @Column(name = "comment")
    private String comment;

    @Column(name = "status")
    private ReceiptStatus status;

    @Column(name = "attached_file")
    private String attachedFile;

    // TODO: 연관관계 편의 메서드 무한루프 방지 코드 추가
    public void addItem(ReceiptItem item) {
        if (Objects.isNull(this.items)) this.items = new ArrayList<>();

        this.items.add(item);
        item.setReceipt(this);
    }

    // TODO : 처리자(수정자) 정보 추가 - 로그인 정보 추가 시
}
