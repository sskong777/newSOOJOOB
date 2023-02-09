package freesia.soojoob.article.dto.request;

import freesia.soojoob.article.entity.Article;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class ArticleUpdateReq {

    private String articleTitle;

    private String articleContent;

    @Nullable
    private String articleImage;

    public static Article ofUpdate(Article article, String articleTitle, String articleContent, String articleImage) {
        return Article.builder()
                .articleId(article.getArticleId())
                .user(article.getUser())
                .articleTitle(articleTitle)
                .articleContent(articleContent)
                .articleImage(articleImage)
                .articleDate(article.getArticleDate())
                .build();
    }
}
