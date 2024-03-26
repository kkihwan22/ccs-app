package org.ccs.app.core.share.domain.audit;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CustomAuditorAware implements AuditorAware<Long> {
    private final Logger log = LoggerFactory.getLogger(CustomAuditorAware.class);

    @Override
    public Optional<Long> getCurrentAuditor() {
        // TODO: 로그인 구현 후 로그인한 사용자 정보를 가져오는 로직을 구현하면 됩니다.
        return Optional.empty();
    }
}