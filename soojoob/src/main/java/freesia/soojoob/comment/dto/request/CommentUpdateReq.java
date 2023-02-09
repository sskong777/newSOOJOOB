package freesia.soojoob.comment.dto.request;

import freesia.soojoob.comment.entity.Comment;
import lombok.Getter;

@Getter
public class CommentUpdateReq {

    private String commentContent;

    public static Comment ofUpdate(Comment comment, String commentContent) {
        return Comment.builder()
                .commentId(comment.getCommentId())
                .user(comment.getUser())
                .commentContent(commentContent)
                .commentDate(comment.getCommentDate())
                .build();
    }
}
