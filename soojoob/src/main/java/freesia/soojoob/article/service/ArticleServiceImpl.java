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

import java.time.LocalDateTime;
import java.util.List;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List getArticleList() {
        return articleRepository.findAll();
    }

    @Override
    public Article createArticle(ArticlePostReq articlePostReq, Long userId) {
        User user = userRepository.findById(userId).get();
        LocalDateTime today = LocalDateTime.now();
        String url = null;

        Article article = Article.builder()
                .user(user)
                .articleTitle(articlePostReq.getArticleTitle())
                .articleContent(articlePostReq.getArticleContent())
                .articleImage(url)
                .build();
        return articleRepository.save(article);
    }

    @Override
    public ArticleOne getArticle(Long articleId) {
        return null;
    }

    @Override
    public void deleteArticle(Long articleId) {

    }

    @Override
    public void patchArticle(ArticlePatchReq articlePatchReq, Long articleId) {

    }
}
