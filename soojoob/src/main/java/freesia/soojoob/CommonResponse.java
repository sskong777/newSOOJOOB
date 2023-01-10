package freesia.soojoob;

public class CommonResponse <T>{
    private int statusCode;
    private String message;
    private T data;
}