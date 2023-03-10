package freesia.soojoob.article.entity;

import freesia.soojoob.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String articleTitle;

    private String articleContent;

    private Long articleDate;

    private String articleImage;


    @Builder
    public Article(Long articleId, User user, String articleTitle, String articleContent,
                 String articleImage, Long articleDate) {
        this.articleId = articleId;
        this.user = user;
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleImage = articleImage;

    }
}
