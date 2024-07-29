package calculator;

import java.util.*;

public class ArithmeticCalculator extends Calculator {
    // 필드
    private static ArrayList<Double> arithmeticList;

    private int num1;           // 첫 번째 정수
    private int num2;           // 두 번째 정수
    private char operator;      // 연산자

    // 생성자
    public ArithmeticCalculator() {
        this.arithmeticList = new ArrayList<>();
    }

    // Setter 메서드
    public void setArithmetic(int num1, int num2, char op) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = op;
    }

    // 사칙연산 메서드
    @Override
    public double calculate() throws BadException {
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

    //  Getter 메서드
    @Override
    public ArrayList<Double> getResult() {
        return arithmeticList;
    }

    // 결과값을 리스트에 저장하는 메서드
    @Override
    public void addResult(double result) {
        this.arithmeticList.add(result);
    }

    // 저장된 리스트에서 가장 먼저 저장된 데이터를 삭제하는 메서드
    @Override
    public void removeResult() {
        double removeResult = arithmeticList.get(0);
        arithmeticList.remove(0);
        System.out.println("삭제된 값 : " + removeResult);
    }

    // 결과가 저장된 연산결과를 조회하는 메서드
    @Override
    public void inquiryResult() {
        System.out.print("저장된 연산 결과 : ");
        for (double value : arithmeticList) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

}
