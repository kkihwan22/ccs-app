package org.ccs.app.core.user.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ccs.app.core.user.domain.FellowShipGroup;

@Converter
public class FellowShipGroupToStringConverter implements AttributeConverter<FellowShipGroup, String> {

    @Override
    public String convertToDatabaseColumn(FellowShipGroup attribute) {
        return (attribute != null)
                ? attribute.name()
                : null;
    }

    @Override
    public FellowShipGroup convertToEntityAttribute(String dbData) {
        return dbData != null
                ? FellowShipGroup.valueOf(dbData)
                : null;
    }
}
