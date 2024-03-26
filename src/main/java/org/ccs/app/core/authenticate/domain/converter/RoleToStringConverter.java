package org.ccs.app.core.authenticate.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ccs.app.core.authenticate.domain.Role;

@Converter
public class RoleToStringConverter implements AttributeConverter<Role, String>  {
    @Override
    public String convertToDatabaseColumn(Role attribute) {
        return (attribute != null)
                ? attribute.name()
                : null;
    }

    @Override
    public Role convertToEntityAttribute(String dbData) {
        return dbData != null
                ? Role.valueOf(dbData)
                : null;
    }
}
