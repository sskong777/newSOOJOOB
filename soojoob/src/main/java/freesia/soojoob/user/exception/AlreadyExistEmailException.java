package freesia.soojoob.user.exception;

public class AlreadyExistEmailException extends RuntimeException{
    public AlreadyExistEmailException() {
        super("이미 존재하는 이메일 입니다.");
    }
}

