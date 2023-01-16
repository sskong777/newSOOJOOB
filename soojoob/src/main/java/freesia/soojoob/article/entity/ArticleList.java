package freesia.soojoob.article.entity;

import lombok.Getter;

@Getter
public class ArticleList {

    private Long articleId;

    private String articleTitle;

    private String articleContent;

    private Long articleDate;

    private String articleImage;

    public ArticleList(Long articleId, String articleTitle, String articleContent, String articleImage, Long articleDate) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleImage = articleImage;
        this.articleDate = articleDate;
    }
}
