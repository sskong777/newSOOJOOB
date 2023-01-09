package freesia.soojoob.user.exception;

public class NoExistUserException extends RuntimeException{
    public NoExistUserException(){ super("존재하지 않는 유저입니다");}
}
