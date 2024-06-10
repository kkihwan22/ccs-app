package org.ccs.app.core.authenticate.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void test_confirm_password() {
        String expected = "password!234";
        LocalDateTime now = LocalDateTime.now();
        UserAccount account = UserAccount.builder()
                .loginFailureCount(0)
                .lastAccessAt(now)
                .status(UserAccountStatus.ENABLED)
                .password("password!234")
                .build();

        account.confirmPassword("password!234");

        assertAll(
                () -> assertEquals(0, account.getLoginFailureCount()),
                () -> assertNotEquals(now, account.getLastAccessAt())
        );
    }

        // TODO : 숙제 - 비밀번호가 틀린 경우에 대한 테스트 코드를 짜보세요.

}