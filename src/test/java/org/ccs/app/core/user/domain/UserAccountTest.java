package org.ccs.app.core.user.domain;

import org.ccs.app.core.authenticate.domain.UserAccount;
import org.ccs.app.core.authenticate.domain.UserAccountStatus;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest {

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

        // TODO : 숙제 - 비밀번호가 틀린 경우에 대한 테스트 코드를 짜보세요.
    }
}