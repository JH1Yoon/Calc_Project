package calculator;

// 각 사칙연산에 대하여 계산하는 클래스와 Calculator 클래스를 연결 해주는 interface 선언
public interface Operator {
    // 각 사칙연산의 인터페이스 추상 메서드 오버라이딩
    public int operate(int num1, int num2);
}
