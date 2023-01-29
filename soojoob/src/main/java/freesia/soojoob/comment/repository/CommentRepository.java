package freesia.soojoob.comment.repository;

import freesia.soojoob.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByArticle_ArticleId(Long articleId);
}
