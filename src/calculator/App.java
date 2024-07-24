package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<Integer> results = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {

            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();    // num1 : 첫 번째 숫자
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt(); // num2 : 두 번째 숫자

            // 사칙연산 기호를 전달 받기
            System.out.print("사칙연산 기호를 입력하세요: ");   // +, -, *, /, %
            char op = sc.next().charAt(0);   // charAt(idx) : charAt 메서드는 매개변수로 char 타입으로 반환하고자 하는 문자열의 위치(idx)를 받는다.

            // 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
            int result = 0;
            boolean error = false;          // 오류가 발생했는지 확인
            String errorMessage = "";       // 오류 발생시 출력할 메시지
            switch (op) {
                case '+':           // 기호가 '+'인 경우
                    result = num1 + num2;
                    break;
                case '-':           // 기호가 '-'인 경우
                    result = num1 - num2;
                    break;
                case '*':           // 기호가 '*'인 경우
                    result = num1 * num2;
                    break;
                case '/':           // 기호가 '/'인 경우
                    // 나눗셈 연산에서 예외 처리
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        error = true;
                        errorMessage = "나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.";
                    }
                    break;
                case '%':           // 기호가 '%'인 경우
                    // 나눗셈 연산에서 예외 처리
                    if (num2 != 0) {
                        result = num1 % num2;
                    } else {
                        error = true;
                        errorMessage = "나눗셈 연산에서 분모(두 번째 정수)에 0이 입력될 수 없습니다.";
                    }
                    break;
                default:            // 기호가 잘못 입력될 경우
                    error = true;
                    errorMessage = "사칙연산 기호가 잘못 입력되었습니다.";
                    break;
            }

            // 오류가 없는 경우 배열에 결과를 저장 및 count 증가
            if (!error) {
                System.out.println("결과 : " + result);
                results.add(result);
            } else {
                System.out.println("오류 : " + errorMessage);
            }

            // 가장 먼저 저장된 결과 삭제 여부 확인
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            String questionRemove = sc.next();
            if (questionRemove.equals("remove")) {
                int removeResult = results.remove(0);
                System.out.println("삭제된 값 : " + removeResult );
            }

            // 추가 계산 여부 확인
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            String answer = sc.next();
            if (answer.equals("exit")) {
                System.out.println("프로그램을 종료하겠습니다.");
                break;
            }
        }

        sc.close();
    }
}