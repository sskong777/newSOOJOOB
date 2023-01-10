package freesia.soojoob.global;

import freesia.soojoob.user.exception.AlreadyExistEmailException;
import freesia.soojoob.user.exception.AlreadyExistUsernameException;
import freesia.soojoob.user.exception.NoExistUserException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerUtil {
    @ExceptionHandler(AlreadyExistEmailException.class)
    ResponseEntity<CommonResponse> handleAlreadyExistEmailException(AlreadyExistEmailException ex){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(AlreadyExistUsernameException.class)
    ResponseEntity<CommonResponse> handleAlreadyExistUsernameException(AlreadyExistUsernameException ex){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(NoExistUserException.class)
    ResponseEntity<CommonResponse> handleNoExistUserException(NoExistUserException ex){
        return ResponseEntity.badRequest().body(CommonResponse.getErrorResponse(ex.getMessage()));
    }

}
