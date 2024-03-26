package org.ccs.app.core.common.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.common.application.usecase.MenuItemGetUsecase;
import org.ccs.app.core.common.application.usecase.MenuRootCreateUsecase;
import org.ccs.app.core.common.domain.Menu;
import org.ccs.app.core.common.exception.NotFoundMenuItemException;
import org.ccs.app.core.common.infra.MenuRepository;
import org.ccs.app.core.common.model.RootMenuCreateParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MenuApplication implements MenuItemGetUsecase, MenuRootCreateUsecase {
    private final Logger log = LoggerFactory.getLogger(MenuApplication.class);
    private final MenuRepository menuRepository;

    private final static Long ROOT_PARENT_ID = 0L;

    @Override
    public Menu getMenu(Long id) {
        return this.findMenu(id).orElseThrow(NotFoundMenuItemException::new);
    }

    @Transactional
    @Override
    public Menu create(RootMenuCreateParameter parameter) {
        Integer itemOrders = menuRepository.findTopByParentIdOrderByItemOrderDesc(ROOT_PARENT_ID)
                .map(Menu::getItemOrder)
                .orElse(0);
        Menu menu = parameter.toEntity();
        menu.changeItemOrder(itemOrders);
        menuRepository.save(menu);
        return menu;
    }

    private Optional<Menu> findMenu(Long id) {
        return menuRepository.findById(id);
    }
}
