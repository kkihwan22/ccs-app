package org.ccs.app.core.authenticate.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.authenticate.application.usecase.userdevice.UserDeviceCreateUsecase;
import org.ccs.app.core.authenticate.infra.repository.UserDeviceJpaRepository;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserDeviceApplication implements UserDeviceCreateUsecase {

    private final UserDeviceJpaRepository userDeviceJpaRepository;

    @Override
    public void create(UserDeviceCreateParameter parameter) {
        userDeviceJpaRepository.save(parameter.toEntity());
    }
}
