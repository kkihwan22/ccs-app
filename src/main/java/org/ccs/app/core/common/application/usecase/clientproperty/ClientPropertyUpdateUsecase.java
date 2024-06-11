package org.ccs.app.core.common.application.usecase.clientproperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.ccs.app.core.common.domain.ClientProperty;
import org.ccs.app.core.share.model.EntityBuildable;

public interface ClientPropertyUpdateUsecase {

    Long update(UpdateParameter parameter);

    @AllArgsConstructor
    @Getter
    @ToString
    class UpdateParameter implements EntityBuildable<ClientProperty> {
        private Long id;
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
