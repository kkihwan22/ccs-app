package org.ccs.app.core.user.application;

import org.ccs.app.core.user.application.usecase.UserCreateUsecase;
import org.ccs.app.core.user.application.usecase.UserUpdateUsecase;
import org.springframework.stereotype.Component;

@Component
public class UserApplicationCreate implements
        UserCreateUsecase,
        UserUpdateUsecase {

    @Override
    public void create(CreateUserCommnad commnad) {

    }

    @Override
    public void update(UpdateUserCommand command) {

    }
}
