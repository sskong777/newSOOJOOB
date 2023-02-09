package freesia.soojoob.comment.entity;

import freesia.soojoob.article.entity.Article;
import freesia.soojoob.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    private String commentContent;

    private Long commentDate;

    @Builder
    public Comment(Long commentId, User user, Article article, String commentContent, Long commentDate) {
        this.commentId = commentId;
        this.user = user;
        this.article = article;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
    }
}