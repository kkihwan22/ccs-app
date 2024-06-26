package playground.testsample;

import org.ccs.app.core.community.domain.Article;
import org.ccs.app.core.community.domain.Board;
import org.junit.jupiter.api.*;

public class JunitTests {

    @BeforeAll
    static void initAll() {
        System.out.println("Before All\n");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("After All");
    }

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each\n");
    }


    @Disabled("개발 스펙 변경")
    @Test
    @DisplayName("성공 테스트 - Article 생성")
    void constructArticle() {
        // Arrange (준비)
        var board = new Board(5L, "board");

        // Act (실행)
        var article = Article.builder()
                .id(1L)
                .title("title")
                .content("content").build();

        // Assert (검증)
        Assertions.assertEquals(1L, article.getId());
        Assertions.assertEquals("content", article.getContent());
        System.out.println("succeedingTest");
    }

    @Test
    @DisplayName("실패 테스트")
    void failingTest() {
        // expected 혹은 actual 을 다른 값으로 바꿔서 test fail 시키기
        Assertions.assertEquals(4, 2 + 2, "테스트 실패시 출력되는 failure message");

        System.out.println("failingTest");
    }

    @Test
    @Disabled("이 테스트를 Disable 이유")
    void skippingTest() {
        System.out.println("DisabledTest");

        Assertions.assertEquals(3, 1 + 2);
    }
}
