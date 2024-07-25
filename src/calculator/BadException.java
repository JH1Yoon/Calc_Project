package calculator;

public class BadException extends Exception {
    public BadException(String type) {
        super("잘못 입력되었습니다.! " + type + "를 다시 입력해주세요.");
    }
}
