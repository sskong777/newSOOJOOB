package freesia.soojoob.article.controller;

import freesia.soojoob.article.dto.response.ArticlesGetRes;
import freesia.soojoob.article.entity.ArticleList;
import freesia.soojoob.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 게시글에 대한 명령 컨트롤러
 * */

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    // 1. 게시글 목록 List GET

    public ResponseEntity<ArticlesGetRes> getArticles() {
        List<ArticleList> articleList = articleService.getArticleList();

        return ResponseEntity.ok(ArticlesGetRes.of(articleList, 200, "success"));
    }


}
