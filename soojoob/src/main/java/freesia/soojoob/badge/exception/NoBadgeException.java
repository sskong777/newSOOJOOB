package freesia.soojoob.badge.exception;

public class NoBadgeException extends RuntimeException {
    public NoBadgeException() {
        super("뱃지가 존재하지 않습니다.");
    }
}
