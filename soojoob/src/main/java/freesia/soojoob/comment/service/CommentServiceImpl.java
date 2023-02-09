package freesia.soojoob.comment.service;

import freesia.soojoob.article.entity.Article;
import freesia.soojoob.comment.dto.request.CommentUpdateReq;
import freesia.soojoob.comment.entity.Comment;
import freesia.soojoob.comment.repository.CommentRepository;
import freesia.soojoob.user.entity.User;
import freesia.soojoob.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service("CommentService")
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Comment> getCommentList(Long articleId) {

        return commentRepository.findByArticle_ArticleId(articleId);
    }

    @Override
    public Comment createComment(Long articleId, Long userId, String commentContent) {
        User user = userRepository.findById(userId).get();

        Comment comment = Comment.builder()
                .user(user)
                .article(Article.builder().articleId(articleId).build())
                .commentContent(commentContent)
                .commentDate(getTimestamp())
                .build();
        return commentRepository.save(comment);
    }

    @Override
    public Optional<Comment> getComment(Long commentId) {

        return commentRepository.findById(commentId);
    }

    @Override
    public void updateComment(CommentUpdateReq commentUpdateReq, Long commentId) {
        Comment comment = commentRepository.findById(commentId).get();

        Comment updateComment = CommentUpdateReq.ofUpdate(comment, commentUpdateReq.getCommentContent());

        commentRepository.save(updateComment);
    }

    @Override
    public void deleteComment(Comment comment) {

        commentRepository.delete(comment);
    }

    private Long getTimestamp() {

        return Timestamp.valueOf(LocalDate.now().atStartOfDay()).getTime() / 1000;
    }
}
