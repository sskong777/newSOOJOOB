package freesia.soojoob.plogging.exception;

public class NoExistPloggingException extends RuntimeException{
    public NoExistPloggingException(){super("플로깅이 존재하지 않습니다.");}
}
