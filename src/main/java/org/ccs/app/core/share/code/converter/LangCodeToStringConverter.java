package org.ccs.app.core.share.code.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Convert;
import org.ccs.app.core.share.code.LangCode;

import java.util.Objects;

@Convert
public class LangCodeToStringConverter implements AttributeConverter<LangCode, String> {

    @Override
    public String convertToDatabaseColumn(LangCode attribute) {
        return (Objects.nonNull(attribute))
                ? attribute.name()
                : null;
    }

    @Override
    public LangCode convertToEntityAttribute(String dbData) {
        return LangCode.get(dbData);
    }
}
