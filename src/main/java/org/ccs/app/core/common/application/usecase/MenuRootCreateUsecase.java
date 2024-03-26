package org.ccs.app.core.common.application.usecase;

import org.ccs.app.core.common.domain.Menu;
import org.ccs.app.core.common.model.RootMenuCreateParameter;

/**
 * root menu를 생성한다.
 * root menu의 경우 parentid = 0, depth = 0으로 생성한다.
 */
public interface MenuRootCreateUsecase {

    Menu create(RootMenuCreateParameter parameter);
}
