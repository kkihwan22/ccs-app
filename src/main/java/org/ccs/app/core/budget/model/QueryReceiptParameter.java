package org.ccs.app.core.budget.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.budget.domain.ReceiptStatus;
import org.springframework.data.domain.PageRequest;

import java.util.Set;

@Getter @ToString
@Builder
@AllArgsConstructor
public class QueryReceiptParameter {
    private PageRequest pageRequest;
    private Set<Long> requesterSet;
    private Set<ReceiptStatus> statusSet;
}
