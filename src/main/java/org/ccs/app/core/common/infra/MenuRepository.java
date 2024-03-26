package org.ccs.app.core.common.infra;

import org.ccs.app.core.common.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Long> {

    Optional<Menu> findTopByParentIdOrderByItemOrderDesc(Long parentId);
}
