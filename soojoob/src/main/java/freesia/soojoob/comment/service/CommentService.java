package freesia.soojoob.comment.service;

import freesia.soojoob.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getCommentList(Long articleId);

    void createComment(Long articleId, Long userId, String commentContent);

    Optional<Comment> getComment(Long commentId);

    void updateComment(Comment comment, String commentContent);

    void deleteComment(Comment comment);
}
