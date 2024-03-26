package org.ccs.app.core.user.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ccs.app.core.user.domain.UserType;

@Converter
public class UserTypeToStringConverter implements AttributeConverter<UserType, String> {

    @Override
    public String convertToDatabaseColumn(UserType attribute) {
        return (attribute != null)
                ? attribute.name()
                : null;
    }

    @Override
    public UserType convertToEntityAttribute(String dbData) {
        return dbData != null
                ? UserType.valueOf(dbData)
                : null;
    }
}
