package freesia.soojoob.comment.service;

import freesia.soojoob.comment.dto.request.CommentUpdateReq;
import freesia.soojoob.comment.entity.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    List<Comment> getCommentList(Long articleId);

    Comment createComment(Long articleId, Long userId, String commentContent);

    Optional<Comment> getComment(Long commentId);

    void updateComment(CommentUpdateReq commentUpdateReq, Long commentId);

    void deleteComment(Comment comment);
}
