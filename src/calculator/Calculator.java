package calculator;

import java.util.*;

public abstract class Calculator {

    // 추상 메서드로 정의
    public abstract double calculate() throws BadException;

    public abstract ArrayList<Double> getResult();
    public abstract void addResult(double result);
    public abstract void removeResult();
    public abstract void inquiryResult();
}