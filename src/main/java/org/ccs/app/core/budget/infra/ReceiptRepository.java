package org.ccs.app.core.budget.infra;

import org.ccs.app.core.budget.domain.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptRepository extends
        JpaRepository<Receipt, Long>, ReceiptCustomRepository {



}
