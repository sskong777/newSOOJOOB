package freesia.soojoob.article.dto.response;

import freesia.soojoob.article.entity.Article;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticlesGetRes extends BaseResponseBody {

    List<Article> article;

    public static ArticlesGetRes of(List<Article> article, Integer statusCode, String message) {
        return ArticlesGetRes.builder()
                .statusCode(statusCode)
                .message(message)
                .article(article)
                .build();
    }

    @Builder
    public ArticlesGetRes(Integer statusCode, String message, List<Article> article) {
        super(statusCode, message);
        this.article = article;
    }
}
