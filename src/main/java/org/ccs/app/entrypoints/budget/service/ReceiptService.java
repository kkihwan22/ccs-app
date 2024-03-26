package org.ccs.app.entrypoints.budget.service;

import org.ccs.app.core.budget.domain.ReceiptStatus;
import org.ccs.app.core.budget.model.QueryReceiptResult;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Set;

public interface ReceiptService {

    List<QueryReceiptResult> queryReceipt(PageRequest pageRequest, Set<Long> requesterSet, Set<ReceiptStatus> statusSet);
    List<QueryReceiptResult> queryMyReceipt(PageRequest pageRequest);
}