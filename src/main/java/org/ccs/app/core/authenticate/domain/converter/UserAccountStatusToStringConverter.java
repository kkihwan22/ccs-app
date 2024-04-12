package org.ccs.app.core.authenticate.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ccs.app.core.authenticate.domain.UserAccountStatus;

@Converter
public class UserAccountStatusToStringConverter implements AttributeConverter<UserAccountStatus, String>  {

    @Override
    public String convertToDatabaseColumn(UserAccountStatus attribute) {
        return (attribute != null)
                ? attribute.name()
                : null;
    }

    @Override
    public UserAccountStatus convertToEntityAttribute(String dbData) {
        return dbData != null
                ? UserAccountStatus.valueOf(dbData)
                : null;
    }
}
