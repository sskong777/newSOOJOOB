package freesia.soojoob.global.login.exception;

public class NoExistEmail extends RuntimeException{
    public NoExistEmail() {
        super("이메일을 찾을 수 없습니다");
    }

}
