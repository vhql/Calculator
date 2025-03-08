
package UI;

import java.util.Scanner;

public class UI {
    final private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void message() {
        System.out.print("계산식을 입력하세요: ");
    }
    public String inputExpression() {
        return scanner.nextLine();
    }

    public void outputExpression(double result) {
        System.out.println("결과: " + String.format("%.3f", result));
    }

    public void closeScanner() {
        scanner.close();
    }
}