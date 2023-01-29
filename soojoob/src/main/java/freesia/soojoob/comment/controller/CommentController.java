package freesia.soojoob.comment.controller;

import freesia.soojoob.article.dto.response.BaseResponseBody;
import freesia.soojoob.comment.dto.request.CommentUpdateReq;
import freesia.soojoob.comment.entity.Comment;
import freesia.soojoob.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    private Long getUserId(Authentication authentication) {
        return Long.parseLong((String) authentication.getPrincipal());
    }

    // 1. 댓글 수정 PUT
    @PutMapping("/{commentId}")
    public ResponseEntity<? extends BaseResponseBody> updateComment(@PathVariable(name = "commentId") Long commentId, @RequestBody CommentUpdateReq commentUpdateReq, Authentication authentication) {
        Long userId = getUserId(authentication);
        Optional<Comment> commentOptional = commentService.getComment(commentId);
        if(!commentOptional.isPresent())
            return ResponseEntity.ok(BaseResponseBody.of(405, "댓글이 존재하지 않습니다."));
        Comment comment = commentOptional.get();
        if(!userId.equals(comment.getUser().getId()))
            return ResponseEntity.ok(BaseResponseBody.of(406, "작성자 본인만 수정할 수 있습니다."));
        commentService.updateComment(comment, commentUpdateReq.getCommentContent());
        return ResponseEntity.ok(BaseResponseBody.of(200, "댓글이 수정되었습니다."));
    }

    // 2. 댓글 삭제 DELETE
    @DeleteMapping("/{commentId}")
    public ResponseEntity<? extends BaseResponseBody> deleteComment(@PathVariable(name = "commentId") Long commentId, Authentication authentication) {
        Long userId = getUserId(authentication);
        Optional<Comment> commentOptional = commentService.getComment(commentId);
        if(!commentOptional.isPresent())
            return ResponseEntity.ok(BaseResponseBody.of(405, "댓글이 존재하지 않습니다."));
        Comment comment = commentOptional.get();
        if(!userId.equals(comment.getUser().getId()))
            return ResponseEntity.ok(BaseResponseBody.of(406, "작성자 본인만 삭제할 수 있습니다."));
        commentService.deleteComment(comment);
        return ResponseEntity.ok(BaseResponseBody.of(200, "댓글이 삭제되었습니다."));
    }
}
