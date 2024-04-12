package org.ccs.app.core.authenticate.infra.repository;

import org.ccs.app.core.authenticate.domain.TokenHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenHistoryJpaRepository extends JpaRepository<TokenHistory, Long> {
}
