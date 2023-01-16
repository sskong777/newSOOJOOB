package freesia.soojoob.article.dto.response;

import freesia.soojoob.article.entity.ArticleList;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticlesGetRes extends BaseResponseBody {

    List<ArticleList> articleList;

    public static ArticlesGetRes of(List<ArticleList> articleList, Integer statusCode, String message) {
        return ArticlesGetRes.builder()
                .statusCode(statusCode)
                .message(message)
                .articleList(articleList)
                .build();
    }

    @Builder
    public ArticlesGetRes(Integer statusCode, String message, List<ArticleList> articleList) {
        super(statusCode, message);
        this.articleList = articleList;
    }
}
