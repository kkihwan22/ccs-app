package org.ccs.app.core.common.application.usecase.clientproperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.common.domain.ClientProperty;
import org.ccs.app.core.share.model.EntityBuildable;

public interface ClientPropertyCreateUsecase {

    Long create(CreateParameter parameter);

    @AllArgsConstructor
    @Getter
    @ToString
    class CreateParameter implements EntityBuildable<ClientProperty> {
        private String key;
        private String propertyValue;
        private Boolean usingIos;
        private Boolean usingAos;
        private Boolean usingWeb;

        @Override
        public ClientProperty toEntity() {
            return new ClientProperty(key, propertyValue, usingIos, usingAos, usingWeb);
        }
    }
}
