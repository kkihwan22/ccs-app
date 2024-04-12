package org.ccs.app.core.authenticate.infra.repository;

import org.ccs.app.core.authenticate.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountJpaRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByEmail(String email);
    Boolean existsByEmail(String email);
}
