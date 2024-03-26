package org.ccs.app.entrypoints.admin.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.common.application.usecase.MenuRootCreateUsecase;
import org.ccs.app.core.common.domain.Menu;
import org.ccs.app.core.common.model.RootMenuCreateParameter;
import org.ccs.app.entrypoints.admin.model.AdminMenuCreateRequest;
import org.ccs.app.entrypoints.admin.model.AdminMenuResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AdminMenuServiceImpl implements AdminMenuService {
    private final Logger log = LoggerFactory.getLogger(AdminMenuServiceImpl.class);
    private final MenuRootCreateUsecase menuRootCreateUsecase;

    @Override
    public AdminMenuResponse createMenu(AdminMenuCreateRequest request) {
        Menu menu = menuRootCreateUsecase.create(new RootMenuCreateParameter(request.name(), request.target()));
        return new AdminMenuResponse(menu);
    }
}
