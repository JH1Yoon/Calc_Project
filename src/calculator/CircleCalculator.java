package calculator;

import java.util.*;

public class CircleCalculator extends Calculator {
    // 필드
    private static ArrayList<Double> circleList;

    private static final double PI = 3.14;
    private double radius;

    // 생성자
    public CircleCalculator() {
        this.circleList = new ArrayList<>();
    }

    // Setter 메서드
    public void setCircle(double circleRadius) {
        this.radius = circleRadius;
    }

    // 원의 넓이 메서드
    @Override
    public double calculate() {
        return PI * radius * radius;
    }

    //  Getter 메서드
    @Override
    public ArrayList<Double> getResult() {
        return circleList;
    }

    // 결과값을 리스트에 저장하는 메서드
    @Override
    public void addResult(double result) {
        this.circleList.add(result);
    }

    // 저장된 리스트에서 가장 먼저 저장된 데이터를 삭제하는 메서드
    @Override
    public void removeResult() {
        double removeResult = circleList.get(0);
        circleList.remove(0);
        System.out.println("삭제된 값 : " + removeResult);
    }

    // 결과가 저장된 연산결과를 조회하는 메서드
    @Override
    public void inquiryResult() {
        System.out.print("저장된 연산 결과 : ");
        for (double value : circleList) {
            System.out.print(value + " ");
        }
        System.out.println();
    }


}
