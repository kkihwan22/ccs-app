package org.ccs.app.core.authenticate.application.usecase.userdevice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.authenticate.domain.UserDevice;
import org.ccs.app.core.share.model.EntityBuildable;

public interface UserDeviceCreateUsecase {

    void create(UserDeviceCreateParameter parameter);

    @AllArgsConstructor
    @Getter
    @ToString
    class UserDeviceCreateParameter implements EntityBuildable<UserDevice> {
        private String clientId;
        private String rawData;

        @Override
        public UserDevice toEntity() {
            return new UserDevice(this.clientId, rawData);
        }
    }
}
