package freesia.soojoob.article.dto.response;

import freesia.soojoob.article.entity.ArticleOne;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleGetRes extends BaseResponseBody {

    private Long articleId;

    private String articleTitle;

    private String articleContent;

    private Long articleDate;

    private String articleImage;

    public static ArticleGetRes of(ArticleOne articleOne, Integer statusCode, String message) {
        return ArticleGetRes.builder()
                .statusCode(statusCode)
                .message(message)
                .articleId(articleOne.getArticleId())
                .articleTitle(articleOne.getArticleTitle())
                .articleContent(articleOne.getArticleContent())
                .articleDate(articleOne.getArticleDate())
                .articleImage(articleOne.getArticleImage())
                .build();
    }

    @Builder
    public ArticleGetRes(Integer statusCode, String message, Long articleId, String articleTitle,
                         String articleContent, Long articleDate, String articleImage) {
        super(statusCode, message);
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleImage = articleImage;
    }
}
