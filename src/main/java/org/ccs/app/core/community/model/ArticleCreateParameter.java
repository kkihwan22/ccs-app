package org.ccs.app.core.community.model;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public class ArticleCreateParameter {
    private Long boardId;
    private String subject;
    private String content;
    private String username;
}
