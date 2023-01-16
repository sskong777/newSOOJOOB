package freesia.soojoob.article.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter
@Setter
public class ArticlePostReq {

    private String articleTitle;

    private String articleContent;

    @Nullable
    private String articleImage;
}
