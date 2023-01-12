package freesia.soojoob.article.db.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;

import static javax.persistence.GenerationType.IDENTITY;

@Table(name = "article")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(length = 40, nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private Blob articleImage;


    //== 내용 수정 ==//
    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateArticleImage(Blob articleImage) {
        this.articleImage = articleImage;
    }
}