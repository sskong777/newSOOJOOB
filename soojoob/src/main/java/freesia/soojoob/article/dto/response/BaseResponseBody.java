package freesia.soojoob.article.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponseBody {

    String message = null;
    Integer statusCode = null;

    public BaseResponseBody() {}

    public BaseResponseBody(Integer statusCode){
        this.statusCode = statusCode;
    }

    public BaseResponseBody(Integer statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }

    public static BaseResponseBody of(Integer statusCode, String message) {
        BaseResponseBody body = new BaseResponseBody();
        body.statusCode = statusCode;
        body.message = message;
        return body;
    }
}
