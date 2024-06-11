package org.ccs.app.core.common.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.ccs.app.core.share.domain.BaseCreatedAndUpdatedDateTime;

import java.util.Optional;

@Getter @ToString
@NoArgsConstructor
public class ClientProperty extends BaseCreatedAndUpdatedDateTime {
    private Long id;
    private String key;
    private String propertyValue;
    private Boolean usingIos;
    private Boolean usingAos;
    private Boolean usingWeb;

    public ClientProperty(Long id, String key, String propertyValue, Boolean usingIos, Boolean usingAos, Boolean usingWeb) {
        this.id = id;
        this.key = key;
        this.propertyValue = propertyValue;
        this.usingIos = Optional.of(usingIos).orElse(Boolean.FALSE);
        this.usingAos = Optional.of(usingAos).orElse(Boolean.FALSE);
        this.usingWeb = Optional.of(usingWeb).orElse(Boolean.FALSE);
    }

    public ClientProperty(String key, String propertyValue, Boolean usingIos, Boolean usingAos, Boolean usingWeb) {
        this(null, key, propertyValue, usingIos, usingAos, usingWeb);
    }
}
