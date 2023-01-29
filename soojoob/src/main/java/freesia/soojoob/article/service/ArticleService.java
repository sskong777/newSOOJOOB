package freesia.soojoob.article.service;

import freesia.soojoob.article.dto.request.ArticlePostReq;
import freesia.soojoob.article.dto.request.ArticleUpdateReq;
import freesia.soojoob.article.entity.Article;
import freesia.soojoob.article.entity.ArticleOne;

import java.util.List;

public interface ArticleService {

    List<Article> getArticles();

    Article createArticle(ArticlePostReq articlePostReq, Long userId);

    ArticleOne getArticle(Long articleId);

    void updateArticle(ArticleUpdateReq articleUpdateReq, Long articleId);

    void deleteArticle(Long articleId);

    boolean existsByArticleId(Long articleId);
}
