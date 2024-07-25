package calculator;

import java.util.*;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    List<Double> results = new ArrayList<>();

    public Double calculate(int num1, int num2, char op) throws BadException {
        double result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 == 0) {
                    throw new BadException("분모가 0이 아닌 양의 정수");
                } else {
                    result = num1 / num2;
                }
                break;
            default:
                throw new BadException("사칙연산자[+, -, *, /]");
        }
        results.add(result);
        return result;
    }
}