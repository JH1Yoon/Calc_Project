package calculator;

import java.util.*;

public abstract class Calculator {

    // Calculator 클래스에서 사칙연산 클래스 활용(interface를 이용)
    protected Operator addOperator = new AddOperator();             // 더하기
    protected Operator subOperator = new SubtractOperator();        // 빼기
    protected Operator multiOperator = new MultiplyOperator();      // 곱하기
    protected Operator divOperator = new DivideOperator();          // 나누기(몫)
    protected Operator modOperator = new ModOperator();             // 나누기(나머지)

    public int add(int num1, int num2) {
        return addOperator.operate(num1, num2);
    }

    public int sub(int num1, int num2) {
        return subOperator.operate(num1, num2);
    }

    public int multi(int num1, int num2) {
        return multiOperator.operate(num1, num2);
    }

    public int div(int num1, int num2) throws BadException{
        if (num2 == 0) {
            throw new BadException("\"분모가 0이 아닌 양의 정수\"");
        } else
            return divOperator.operate(num1, num2);
    }

    public int mod(int num1, int num2) throws BadException{
        if (num2 == 0) {
            throw new BadException("\"분모가 0이 아닌 양의 정수\"");
        } else
            return modOperator.operate(num1, num2);
    }

    // 추상 메서드로 정의
    public abstract double calculate() throws BadException;

    public abstract ArrayList<Double> getResult();
    public abstract void addResult(double result);
    public abstract void removeResult();
    public abstract void inquiryResult();
}