package calculator;

public class DivideOperator{
    public double operate(int num1, int num2) throws BadException{
        if (num2 == 0) {
            throw new BadException("분모가 0이 아닌 양의 정수");
        } else {
            return num1 / num2;
        }
    }
}