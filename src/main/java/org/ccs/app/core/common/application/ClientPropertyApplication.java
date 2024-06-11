package org.ccs.app.core.common.application;

import lombok.RequiredArgsConstructor;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyCreateUsecase;
import org.ccs.app.core.common.application.usecase.clientproperty.ClientPropertyUpdateUsecase;
import org.ccs.app.core.common.domain.ClientProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientPropertyApplication
        implements ClientPropertyCreateUsecase, ClientPropertyUpdateUsecase {
    private final static Logger log = LoggerFactory.getLogger(ClientPropertyApplication.class);

    @Override
    public Long create(CreateParameter parameter) {
        ClientProperty entity = parameter.toEntity();
        return null;
    }

    @Override
    public Long update(Long id, UpdateParameter parameter) {

        // todo: find id

        ClientProperty entity = parameter.toEntity();
        return null;
    }
}
