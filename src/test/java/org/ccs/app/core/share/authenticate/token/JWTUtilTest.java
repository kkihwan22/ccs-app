package org.ccs.app.core.share.authenticate.token;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class JWTUtilTest {
    private final Logger log = LoggerFactory.getLogger(JWTUtilTest.class);

    @Autowired
    JWTUtil jwtUtil;

    private Long userId;
    private String accessToken;
    private String refreshToken;

    @BeforeEach
    public void setUp() {
        userId = 1000L;
        accessToken = jwtUtil.issued(JWTType.ACCESS, userId);
        refreshToken = jwtUtil.issued(JWTType.REFRESH, userId);
    }


    @Test
    public void generateTest() {
        // TODO: access token의 유효시간, refresh token의 유효시간이 우리가 설정한 시간이 맞는지 확인하는 테스트 코드를 넣으세요.
        assertAll(
                () -> assertNotNull(accessToken),
                () -> assertNotNull(refreshToken)
        );
    }

    @Test
    public void verifyTest() {
        assertAll(() -> assertTrue(jwtUtil.verify(accessToken)), () -> assertTrue(jwtUtil.verify(refreshToken)));
    }

    @Test
    public void decodeTest() {
        String a = jwtUtil.decode(accessToken).toString();
        String r = jwtUtil.decode(refreshToken).toString();

        assertAll(() -> assertEquals(userId.toString(), a), () ->  assertEquals(userId.toString(), r));
    }
}