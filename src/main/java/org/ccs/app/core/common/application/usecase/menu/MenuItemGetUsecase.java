package org.ccs.app.core.common.application.usecase.menu;

import org.ccs.app.core.common.domain.Menu;

public interface MenuItemGetUsecase {

    Menu getMenu(Long id);
}
