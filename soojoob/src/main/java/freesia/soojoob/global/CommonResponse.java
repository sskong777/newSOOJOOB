package freesia.soojoob.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse <T>{

    private static final int FAIL = 400;
    private int statusCode;
    private String message;
    private T data;


    public static <T> CommonResponse getSuccessResponse(int statusCode, String message, T data){
        return new CommonResponse(statusCode, message, data);
    }

    public static CommonResponse getErrorResponse(String message){
        return new CommonResponse(FAIL, message, null);
    }
}

