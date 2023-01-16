package freesia.soojoob.article.service;

import freesia.soojoob.article.dto.request.ArticlePatchReq;
import freesia.soojoob.article.dto.request.ArticlePostReq;
import freesia.soojoob.article.entity.Article;
import freesia.soojoob.article.entity.ArticleList;
import freesia.soojoob.article.entity.ArticleOne;

import java.util.List;

public interface ArticleService {

    List<ArticleList> getArticleList();

    Article createArticle(ArticlePostReq articlePostReq, Long userId);

    ArticleOne getArticle(Long articleId);

    void deleteArticle(Long articleId);

    void patchArticle(ArticlePatchReq articlePatchReq, Long articleId);

}
