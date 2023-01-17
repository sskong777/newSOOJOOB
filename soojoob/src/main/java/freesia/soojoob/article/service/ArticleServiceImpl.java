package freesia.soojoob.article.service;

import freesia.soojoob.article.dto.request.ArticlePatchReq;
import freesia.soojoob.article.dto.request.ArticlePostReq;
import freesia.soojoob.article.entity.Article;
import freesia.soojoob.article.entity.ArticleOne;
import freesia.soojoob.article.repository.ArticleRepository;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List getArticles() {
        return articleRepository.findAll();
    }

    @Override
    public Article createArticle(ArticlePostReq articlePostReq, Long userId) {
        User user = userRepository.findById(userId).get();
        LocalDateTime today = LocalDateTime.now();

        Article article = Article.builder()
                .user(user)
                .articleTitle(articlePostReq.getArticleTitle())
                .articleContent(articlePostReq.getArticleContent())
                .articleImage(articlePostReq.getArticleImage())
                .articleDate(getTimestamp(today))
                .build();
        return articleRepository.save(article);
    }

    @Override
    public ArticleOne getArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).get();

        String articleTitle = article.getArticleTitle();
        String articleContent = article.getArticleContent();
        String articleDate =new SimpleDateFormat("yyyy/MM/dd a KK:mm").format(new Date(article.getArticleDate() * 1000));
        String articleImage = article.getArticleImage();

        return new ArticleOne(articleId, articleTitle, articleContent, articleDate, articleImage);
    }

    @Override
    public void deleteArticle(Long articleId) {
        Article article = articleRepository.findById(articleId).get();

        articleRepository.deleteById(articleId);
    }

    @Override
    public void patchArticle(ArticlePatchReq articlePatchReq, Long articleId) {
        Article article = articleRepository.findById(articleId).get();

        Article patchArticle = ArticlePatchReq.ofPatch(article, articlePatchReq.getArticleTitle(),
                articlePatchReq.getArticleContent(), articlePatchReq.getArticleImage());

        articleRepository.save(patchArticle);
    }

    private Long getTimestamp(LocalDateTime today) {
        return Timestamp.valueOf(today).getTime() / 1000;
    }
}
