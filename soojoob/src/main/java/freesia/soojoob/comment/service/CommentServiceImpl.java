package freesia.soojoob.comment.service;

import freesia.soojoob.article.entity.Article;
import freesia.soojoob.comment.entity.Comment;
import freesia.soojoob.comment.repository.CommentRepository;
import freesia.soojoob.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("CommentService")
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public List<Comment> getCommentList(Long articleId) {

        return commentRepository.findByArticle_ArticleId(articleId);
    }

    @Override
    public void createComment(Long articleId, Long userId, String commentContent) {
        commentRepository.save(Comment.builder()
                .user(User.builder().id(userId).build())
                .article(Article.builder().articleId(articleId).build())
                .commentContent(commentContent)
                .commentDate(getTimestamp())
                .build());
    }

    @Override
    public Optional<Comment> getComment(Long commentId) {

        return commentRepository.findById(commentId);
    }

    @Override
    public void updateComment(Comment comment, String commentContent) {
        comment.setCommentContent(commentContent);
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Comment comment) {

        commentRepository.delete(comment);
    }

    private Long getTimestamp() {

        return Timestamp.valueOf(LocalDate.now().atStartOfDay()).getTime() / 1000;
    }
}
