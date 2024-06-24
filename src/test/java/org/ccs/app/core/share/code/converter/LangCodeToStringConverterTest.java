package org.ccs.app.core.share.code.converter;

import org.ccs.app.core.share.code.LangCode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class LangCodeToStringConverterTest {

    LangCodeToStringConverter converter = new LangCodeToStringConverter();

    @ValueSource(strings = {"KO", "EN", "JA"})
    @ParameterizedTest
    void successTest(String name) {

        LangCode langCode = converter.convertToEntityAttribute(name);
        assertNotNull(langCode, "The converted LangCode should not be null");
        assertEquals(name, langCode.name(), "The LangCode name should match the input string");
    }

    @ValueSource(strings = {"UK"})
    @NullSource
    @EmptySource
    @ParameterizedTest
    void convertToEntityAttributeWhenNotFoundName(String name) {

        LangCode langCode = converter.convertToEntityAttribute(name);
        assertNull(langCode);
    }
}