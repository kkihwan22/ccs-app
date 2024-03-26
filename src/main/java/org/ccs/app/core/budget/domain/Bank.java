package org.ccs.app.core.budget.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Embeddable
@Getter
@ToString
public class Bank {
    private BankCode code;
    private String accountNumber;

    public Bank(BankCode code, String accountNumber) {
        this.code = code;
        this.accountNumber = accountNumber;
    }
}
