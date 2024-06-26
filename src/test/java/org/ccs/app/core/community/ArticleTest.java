package org.ccs.app.core.community;

import org.ccs.app.core.community.domain.Article;
import org.ccs.app.core.community.domain.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;


class ArticleTest {

    @Test
    @DisplayName("Article constructor")
    void constructorArticleTest() {
        var board = new Board(5L, "board");

        // Act (실행)
        var article = Article.builder()
                .id(1L)
                .title("title")
                .content("content").build();

        then(article)
                .isNotNull()
                .hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("board.id", 5L)
                .hasFieldOrPropertyWithValue("subject", "subject")
                .hasFieldOrPropertyWithValue("content", "content");

    }

    @Test
    @DisplayName("Article update")
    void updateArticle() {
        // Given
        // Act (실행)
        var article = Article.builder()
                .id(1L)
                .title("title")
                .content("content").build();

        // When

        // Assert
        then(article)
                .isNotNull()
                .hasNoNullFieldsOrProperties()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("board.id", 5L)
                .hasFieldOrPropertyWithValue("subject", "new subject")
                .hasFieldOrPropertyWithValue("content", "new content");
    }

}