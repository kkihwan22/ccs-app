package org.ccs.app.core.user.infra.repository;

import org.ccs.app.core.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {

}
