package org.ccs.app.core.common.application.usecase.clientproperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.common.domain.ClientProperty;
import org.ccs.app.core.share.model.EntityBuildable;

public interface ClientPropertyUpdateUsecase {

    Long update(Long id, UpdateParameter parameter);

    @AllArgsConstructor
    @Getter
    @ToString
    class UpdateParameter implements EntityBuildable<ClientProperty> {
        private String propertyValue;
        private Boolean usingIos;
        private Boolean usingAos;
        private Boolean usingWeb;

        @Override
        public ClientProperty toEntity() {
            return new ClientProperty(null, propertyValue, usingIos, usingAos, usingWeb);
        }
    }
}
