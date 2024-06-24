package org.ccs.app.core.community;

import org.assertj.core.api.Assertions;
import org.ccs.app.core.community.domain.Article;
import org.ccs.app.core.community.domain.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ArticleAssertJTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5L, "board");
    }

    @Test
    @DisplayName("AssertJ Assertion - updateArticle")
    void updateArticle() {
        // Arrange
        // Act (실행)
        var article = Article.builder()
                .id(1L)
                .title("title")
                .content("content").build();

        // Act
        // article.update("new subject", "new content");

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
}
