package org.ccs.app.core.authenticate.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ccs.app.core.authenticate.domain.RoleCode;

@Converter
public class RoleCodeToStringConverter implements AttributeConverter<RoleCode, String>  {
    @Override
    public String convertToDatabaseColumn(RoleCode attribute) {
        return (attribute != null)
                ? attribute.name()
                : null;
    }

    @Override
    public RoleCode convertToEntityAttribute(String dbData) {
        return dbData != null
                ? RoleCode.valueOf(dbData)
                : null;
    }
}
