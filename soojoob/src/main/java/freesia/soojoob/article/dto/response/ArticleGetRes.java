package freesia.soojoob.article.dto.response;

import freesia.soojoob.article.entity.ArticleOne;
import freesia.soojoob.comment.dto.response.CommentEntity;
import freesia.soojoob.comment.entity.Comment;
import lombok.Builder;
import lombok.Getter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
public class ArticleGetRes extends BaseResponseBody {

    private Long articleId;

    private String articleTitle;

    private String articleContent;

    private String articleDate;

    private String articleImage;

    private List<CommentEntity> commentList;

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
                         String articleContent, String articleDate, String articleImage, List<Comment> commentList) {
        super(statusCode, message);
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleImage = articleImage;
        this.commentList = new ArrayList<>();
        for (Comment comment : commentList) {
            this.commentList.add(CommentEntity.builder()
                    .commentId(comment.getCommentId())
                    .commentContent(comment.getCommentContent())
                    .commentDate(new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date(comment.getCommentDate() * 1000)))
                    .build());
        }
    }
}
