package playground.testsample;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.ccs.app.core.community.domain.Article;
import org.ccs.app.core.community.domain.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class JunitAssertJTests {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5L, "board");
    }

    @Test
    @DisplayName("AssertJ Assertion - updateArticle")
    void updateArticle() {
        // Arrange
        var article = Article.builder()
                .id(1L)
                .board(board)
                .subject("subject")
                .content("content")
                .username("user")
                .createdAt(LocalDateTime.now())
                .build();

        // Act
        article.update("new subject", "new content");

        // Assert
        Assertions.assertThat(article.getId())
                .isEqualTo(1L);

        Assertions.assertThat(article)
                .hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("board.id", 5L)    // article.getBoard().getId()
                .hasFieldOrPropertyWithValue("subject", "new subject")
                .hasFieldOrPropertyWithValue("content", "new content")
                .hasFieldOrProperty("createdAt");
    }

    @Test
    @DisplayName("BDD Style Assertion - updateArticle")
    void updateArticle_BDDStyle() {
        // Given
        var article = Article.builder()
                .id(1L)
                .board(board)
                .subject("subject")
                .content("content")
                .username("user")
                .createdAt(LocalDateTime.now())
                .build();

        // When
        article.update("new subject", "new content");

        // Then
        BDDAssertions.then(article)
                .hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("id", article.getId())
                .hasFieldOrPropertyWithValue("board.id", article.getBoard().getId())
                .hasFieldOrPropertyWithValue("subject", "new subject")
                .hasFieldOrPropertyWithValue("content", "new content")
                .hasFieldOrPropertyWithValue("createdAt", article.getCreatedAt());
    }
}
