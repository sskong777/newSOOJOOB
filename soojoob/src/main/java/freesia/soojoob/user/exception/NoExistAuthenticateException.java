package freesia.soojoob.user.exception;

public class NoExistAuthenticateException extends RuntimeException{
    public NoExistAuthenticateException() {
        super("로그인이 필요합니다.");
    }
}