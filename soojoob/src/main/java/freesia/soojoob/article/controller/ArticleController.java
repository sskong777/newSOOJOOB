package freesia.soojoob.article.controller;

import freesia.soojoob.article.dto.request.ArticlePostReq;
import freesia.soojoob.article.dto.request.ArticleUpdateReq;
import freesia.soojoob.article.dto.response.ArticleGetRes;
import freesia.soojoob.article.dto.response.ArticlesGetRes;
import freesia.soojoob.article.dto.response.BaseResponseBody;
import freesia.soojoob.article.entity.Article;
import freesia.soojoob.article.entity.ArticleOne;
import freesia.soojoob.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시글에 대한 명령 컨트롤러
 * */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // 1. 게시글 전체 조회 GET
    @GetMapping
    public ResponseEntity<ArticlesGetRes> getArticles() {
        List<Article> articles = articleService.getArticles();

        return ResponseEntity.ok(ArticlesGetRes.of(articles, 200, "전체 게시글 불러오기 성공"));
    }

    // 2. 게시글 개별 조회 GET
    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleGetRes> getArticle(@PathVariable(name = "articleId") Long articleId) {

        ArticleOne articleOne = articleService.getArticle(articleId);

        return ResponseEntity.ok(ArticleGetRes.of(articleOne, 200, "success"));
    }

    // 3. 게시글 생성 POST
    @PostMapping
    public ResponseEntity<BaseResponseBody> postArticle(@RequestBody ArticlePostReq articlePostReq, Authentication authentication) {
        Long userId = Long.parseLong((String) authentication.getPrincipal());
        articleService.createArticle(articlePostReq, userId);

        return ResponseEntity.ok(BaseResponseBody.of(200,"success"));
    }

    // 4. 게시글 수정 PATCH
    @PutMapping("/{articleId}")
    public ResponseEntity<BaseResponseBody> updateArticle(@RequestBody ArticleUpdateReq articleUpdateReq, @PathVariable(name = "articleId") Long articleId) {
        articleService.updateArticle(articleUpdateReq, articleId);

        return ResponseEntity.ok(BaseResponseBody.of( 200,"success"));
    }

    // 5. 이벤트 삭제 DELETE
    @DeleteMapping("/{articleId}")
    public ResponseEntity<BaseResponseBody> deleteArticle(@PathVariable(name = "articleId") Long articleId) {
        articleService.deleteArticle(articleId);

        return ResponseEntity.ok(BaseResponseBody.of( 200,"success"));
    }
}
