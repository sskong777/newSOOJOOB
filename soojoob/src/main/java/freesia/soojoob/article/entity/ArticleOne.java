package freesia.soojoob.article.entity;

import lombok.Getter;

@Getter
public class ArticleOne {
    private Long articleId;

    private String articleTitle;

    private String articleContent;

    private String articleDate;

    private String articleImage;


    public ArticleOne(Long articleId, String articleTitle, String articleContent, String articleDate, String articleImage) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleImage = articleImage;
    }
}
