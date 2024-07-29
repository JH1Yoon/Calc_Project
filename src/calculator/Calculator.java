package calculator;

import java.util.*;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 (접근 제어)*/
    private static List<Double> results = new ArrayList<>();

    private int num1;
    private int num2;
    private char operator;

    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    /* 생성자 구현 */
    public Calculator(int num1, int num2, char op) throws BadException {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = op;
    }

    public Calculator() {
        results = new ArrayList<>();
    }


    public Double calculate() throws BadException {
        double result = 0;
        switch (this.operator) {
            case '+':
                result = this.num1 + this.num2;
                break;
            case '-':
                result = this.num1 - this.num2;
                break;
            case '*':
                result = this.num1 * this.num2;
                break;
            case '/':
                if (this.num2 == 0) {
                    throw new BadException("분모가 0이 아닌 양의 정수");
                } else {
                    result = this.num1 / this.num2;
                }
                break;
            default:
                throw new BadException("사칙연산자[+, -, *, /]");
        }
        return result;
    }

    // Getter 메서드
    public List<Double> getResults() {
        return results;
    }

    // 결과값을 리스트에 저장하는 Setter 메서드
    public void setResults(double result) {
        this.results.add(result);
    }

    // 가장 먼저 저장된 데이터를 삭제하는 메서드
    public void removeResult() {
        double removeResult = results.get(0);
        results.remove(0);
        System.out.println("삭제된 값 : " + removeResult);
    }

    // 저장된 연산결과를 조회하는 메서드
    public void inquiryResults() {
        System.out.print("저장된 연산 결과 : ");
        for (double value : results) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
