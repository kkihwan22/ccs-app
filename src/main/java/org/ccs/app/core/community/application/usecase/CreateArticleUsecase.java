package org.ccs.app.core.community.application.usecase;

import org.ccs.app.core.community.domain.Article;
import org.ccs.app.core.community.model.ArticleCreateParameter;

public interface CreateArticleUsecase {

    Article createArticle(ArticleCreateParameter parameter);
}
