package freesia.soojoob.article.entity;

import lombok.Getter;

@Getter
public class ArticleOne {
    private Long articleId;

    private String articleTitle;

    private String articleContent;

    private String articleImage;

    private String articleDate;


    public ArticleOne(Long articleId, String articleTitle, String articleContent, String articleImage, String articleDate) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleImage = articleImage;
        this.articleDate = articleDate;
    }
}
