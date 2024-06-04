package org.ccs.app.core.authenticate.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class UserAccountTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @NullAndEmptySource
    void parameterizedTestExample(String str) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserAccount(str, str));
    }

    @Test
    @DisplayName("UserAccount의 Email은 Null이면 NullPointException이 발생한다.")
    void userAccountEmailNullThenException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserAccount(null, null));
    }

    @Test
    @DisplayName("UserAccount의 Email이 공백이면 NullPointException이 발생한다.")
    void userAccountEmailIsBlankThenException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new UserAccount(" ", null));
    }

}