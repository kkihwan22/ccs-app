package org.ccs.app.entrypoints.admin.service;

import org.ccs.app.entrypoints.admin.model.AdminMenuCreateRequest;
import org.ccs.app.entrypoints.admin.model.AdminMenuResponse;

public interface AdminMenuService {

    AdminMenuResponse createMenu(AdminMenuCreateRequest request);
}
