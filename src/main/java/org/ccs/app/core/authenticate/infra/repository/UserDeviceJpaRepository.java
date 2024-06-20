package org.ccs.app.core.authenticate.infra.repository;

import org.ccs.app.core.authenticate.domain.UserDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDeviceJpaRepository extends JpaRepository<UserDevice, Long> {
}
