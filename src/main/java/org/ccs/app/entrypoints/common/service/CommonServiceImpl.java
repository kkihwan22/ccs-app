package org.ccs.app.entrypoints.common.service;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.userdevice.UserDeviceCreateUsecase;
import org.ccs.app.core.authenticate.application.usecase.userdevice.UserDeviceCreateUsecase.UserDeviceCreateParameter;
import org.ccs.app.core.share.support.generator.UUIDGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommonServiceImpl implements CommonService {
    private final UserDeviceCreateUsecase userDeviceCreateUsecase;

    @Override
    @Transactional
    public String issueClientId(String rowData) {
        String clientId = UUIDGenerator.withoutBar();
        userDeviceCreateUsecase.create(new UserDeviceCreateParameter(clientId, rowData));
        return clientId;
    }
}
