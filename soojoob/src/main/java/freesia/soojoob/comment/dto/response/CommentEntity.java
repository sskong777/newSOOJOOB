package freesia.soojoob.comment.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentEntity {

    private Long commentId;

    private String commentContent;

    private String commentDate;

    @Builder
    public CommentEntity(Long commentId, String commentContent, String commentDate) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }
}
