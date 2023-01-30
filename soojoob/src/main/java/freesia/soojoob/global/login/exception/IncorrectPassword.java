package freesia.soojoob.global.login.exception;

public class IncorrectPassword extends RuntimeException{
    public IncorrectPassword() {
        super("비밀번호가 일치하지 않습니다");
    }

}
