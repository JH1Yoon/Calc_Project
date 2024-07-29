package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();   // Calculator 인스턴스 생성

        while (true) {
            // 계산 선택(getValidSelection를 메서드를 이용하여 사칙연산할지, 원의넓이를 계산할지 선택)
            int selection = getValidSelection(sc, "사칙연산[1], 원의 넓이[2] : ");
            if (selection == 1) {
                // 사칙연산 계산
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                System.out.print("첫 번째 숫자를 입력하세요: ");
                int num1 = sc.nextInt();    // num1 : 첫 번째 숫자
                if (num1 < 0) {
                    throw new BadException("양의 정수");
                }

                System.out.print("두 번째 숫자를 입력하세요: ");
                int num2 = sc.nextInt(); // num2 : 두 번째 숫자
                if (num2 < 0) {
                    throw new BadException("양의 정수");
                }

                // 사칙연산 기호를 전달 받기
                System.out.print("사칙연산 기호를 입력하세요: ");   // +, -, *, /, %
                char op = sc.next().charAt(0);   // charAt(idx) : charAt 메서드는 매개변수로 char 타입으로 반환하고자 하는 문자열의 위치(idx)를 받는다.
                // 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
                calculator.setArithmetic(num1, num2, op);
                double result = calculator.arithmeticCalculate();
                calculator.arithmeticAddResult(result);
                System.out.println("결과 : " + result);


                // 가장 먼저 저장된 결과 삭제 여부 확인
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String inputnRemove = sc.next();
                if (inputnRemove.equals("remove")) {
                    calculator.arithmeticRemoveResult();
                }

                // 연산 결과 전부 조회 여부 확인
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inputInquiry = sc.next();
                if (inputInquiry.equals("inquiry")) {
                    calculator.arithmeticInquiryResult();
                }

                // 추가 계산 여부 확인
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String answer = sc.next();
                if (answer.equals("exit")) {
                    System.out.println("프로그램을 종료하겠습니다.");
                    break;
                }
            } else {
                // 원의 넓이 계산
                double circleRadius = getRadiusSelection(sc, "반지름을 입력하세요(cm) : ");

                // setCircle로 값 지정
                calculator.setCircle(circleRadius);

                // 원의 넓이 계산 수행 및 결과 출력
                double result = calculator.circleCalculate(circleRadius);
                calculator.circleAddResult(result);
                System.out.println("결과 : " + result);

                // 원의 넓이가 저장된 리스트에서 가장 먼저 저장된 결과 삭제 여부 확인
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                String inputnRemove = sc.next();
                if (inputnRemove.equals("remove")) {
                    calculator.circleRemoveResult();
                }

                // 원의 넓이 결과 전부 조회 여부 확인
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                String inputInquiry = sc.next();
                if (inputInquiry.equals("inquiry")) {
                    calculator.circleInquiryResult();
                }

                // 원의 넓이의 추가 계산 여부 확인
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String answer = sc.next();
                if (answer.equals("exit")) {
                    System.out.println("프로그램을 종료하겠습니다.");
                    break;
                }
            }
        }

        sc.close();
    }

    private static int getValidSelection(Scanner sc, String str) {
        int selection;
        while (true) {
            System.out.println(str);
            if (sc.hasNextInt()) {
                selection = sc.nextInt();
                sc.nextLine();
                if (selection == 1 || selection == 2) {
                    return selection;
                } else {
                    System.out.println("잘못 입력하셨습니다. 1 또는 2를 입력해주세요.");
                }
            } else {
                System.out.println("숫자 1 또는 2를 입력해주세요.");
                sc.next();
            }
        }
    }

    private static double getRadiusSelection(Scanner sc, String str) {
        double selection;
        while (true) {
            System.out.println(str);
            if (sc.hasNextDouble()) {
                selection = sc.nextDouble();
                sc.nextLine();
                if (selection <= 0) {
                    System.out.println("양의 실수를 입력해주세요.");
                    continue;
                }
                return selection;
            } else {
                System.out.println("실수를 입력해주세요.");
                sc.next();
            }
        }
    }
}