package Main;

import Calculator.Calculator;
import UI.UI;
import java.util.*;
//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("계산식을 입력하세요: ");
        String input = scanner.nextLine(); // 사용자 입력 받기

        int result = Calculator.calculate(input); // Calculator 클래스 호출
        System.out.println("결과: " + result); // 결과 출력

        scanner.close();

    }
}