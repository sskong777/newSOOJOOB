package freesia.soojoob.user.exception;

public class AlreadyExistUsernameException extends RuntimeException{
    public AlreadyExistUsernameException() {
        super("이미 존재하는 닉네임 입니다.");
    }
}
