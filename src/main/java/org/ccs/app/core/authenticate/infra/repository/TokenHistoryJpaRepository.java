package org.ccs.app.core.authenticate.infra.repository;

import org.ccs.app.core.authenticate.domain.TokenHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenHistoryJpaRepository extends JpaRepository<TokenHistory, Long> {

    Optional<TokenHistory> findTokenHistoryByTokenAndAccountId(String token, Long accountId);
}
