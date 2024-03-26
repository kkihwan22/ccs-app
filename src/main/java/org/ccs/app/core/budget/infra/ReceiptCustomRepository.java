package org.ccs.app.core.budget.infra;

import org.ccs.app.core.budget.model.QueryReceiptParameter;
import org.ccs.app.core.budget.model.QueryReceiptResult;

import java.util.List;

public interface ReceiptCustomRepository {
    List<QueryReceiptResult> query(QueryReceiptParameter parameter);
}
