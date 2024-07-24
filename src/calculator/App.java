package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int num1 = sc.nextInt();    // num1 : 첫 번째 숫자
        System.out.print("두 번째 숫자를 입력하세요: ");
        int num2 = sc.nextInt(); // num2 : 두 번째 숫자

        // 사칙연산 기호를 전달 받기
        System.out.print("사칙연산 기호를 입력하세요: ");   // +, -, *, /, %
        char op = sc.next().charAt(0);   // charAt(idx) : charAt 메서드는 매개변수로 char 타입으로 반환하고자 하는 문자열의 위치(idx)를 받는다.
    }
}