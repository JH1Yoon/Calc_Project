package calculator;

import java.util.*;

public class Calculator {
    // 컬렉션 필드
    private static List<Double> arithmeticList = new ArrayList<>();     // 사칙연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 (접근 제어)  -  반복문을 사용하여 계속해서 객체를 생성하므로 static을 이용하여 메모리 절약
    private static List<Double> circleList = new ArrayList<>();         // 원의 넓이 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 (접근 제어) -  반복문을 사용하여 계속해서 객체를 생성하므로 static을 이용하여 메모리 절약

    // 필드
    private static final double PI = 3.14;  // 원주율을 고정되어 있으므로 final를 이용하여 상수로 지정하고, static을 이용함으로써 프로그램의 어떤 부분에서든 접근이 가능아형 메모리 효율 증가
    
    private int num1;           // 첫 번째 정수
    private int num2;           // 두 번째 정수
    private char operator;      // 연산자
    private double radius;      // 원의 반지름

    // 생성자에서  배열 초기화
    public Calculator() {
        arithmeticList = new ArrayList<>();
        circleList = new ArrayList<>();
    }

    // 사칙 연산 Setter
    public void setArithmetic(int num1, int num2, char op) throws BadException {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = op;
    }

    public void setArithmetic() {
        arithmeticList = new ArrayList<>();
    }

    // 원의 넓이 Setter 메서드
    public void setCircle(double circleRadius)  {
        this.radius = circleRadius;
    }

    // 사칙연산에 대한 결과를 반환하는 메서드
    public Double arithmeticCalculate() throws BadException {
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

    // 사칙연산 저장리스트 Getter 메서드
    public List<Double> arithmeticGetResult() {
        return arithmeticList;
    }

    // 사칙연산 결과값을 리스트에 저장하는 메서드
    public void arithmeticAddResult(double result) {
        this.arithmeticList.add(result);
    }

    // 사칙연산 결과가 저장된 리스트에서 가장 먼저 저장된 데이터를 삭제하는 메서드
    public void arithmeticRemoveResult() {
        double removeResult = arithmeticList.get(0);
        arithmeticList.remove(0);
        System.out.println("삭제된 값 : " + removeResult);
    }

    // 사칙연산 결과가 저장된 연산결과를 조회하는 메서드
    public void arithmeticInquiryResult() {
        System.out.print("저장된 연산 결과 : ");
        for (double value : arithmeticList) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // 원의 넓이를 구하는 메서드
    public double circleCalculate(double radius) {
        return PI * radius * radius;
    }

    // 원의 넓이 저장리스트 Getter 메서드
    public List<Double> circleGetResult() {
        return circleList;
    }

    // 원의 넓이 결과값을 리스트에 저장하는 Setter 메서드
    public void circleAddResult(double result) {
        this.circleList.add(result);
    }

    // 원의 넓이 결과가 저장된 리스트에서 가장 먼저 저장된 데이터를 삭제하는 메서드
    public void circleRemoveResult() {
        double removeResult = circleList.get(0);
        circleList.remove(0);
        System.out.println("삭제된 값 : " + removeResult);
    }

    // 원의 넓이 결과가 저장된 연산결과를 조회하는 메서드
    public void circleInquiryResult() {
        System.out.print("저장된 연산 결과 : ");
        for (double value : circleList) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
