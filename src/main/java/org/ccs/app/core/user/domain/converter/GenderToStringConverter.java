package org.ccs.app.core.user.domain.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.ccs.app.core.user.domain.Gender;

@Converter
public class GenderToStringConverter implements AttributeConverter<Gender, String> {

    // Gender enum 값을 데이터베이스에 저장하기 위한 문자열로 변환
    @Override
    public String convertToDatabaseColumn(Gender attribute) {
        return (attribute != null)
                ? attribute.name()
                : null;
    }

    //  데이터베이스에서 데이터를 검색할 때, 데이터베이스 데이터를 다시 Gender 열거형 값으로 변환
    @Override
    public Gender convertToEntityAttribute(String dbData) {
        return dbData != null
                ? Gender.valueOf(dbData)
                : null;
    }
}
