
package UI;

import java.util.Scanner;

public class UI {
    final private Scanner scanner;

    public UI() {
        this.scanner = new Scanner(System.in);
    }
    public void menu(){
        System.out.println("---- Main menu ----");
        System.out.println("1. Calculator mode");
        System.out.println("2. Log mode");
        System.out.println("b. exit");
        System.out.print("Choice: ");
    }

    public void message() {
        System.out.print("Input expressions : \n");
        System.out.print("Input b for going to Main \n");
    }
    public String UserFlag() {
        return scanner.nextLine();
    }
    public String inputExpression() {
        return scanner.nextLine();
    }

    public void outputExpression(double result) {
        System.out.println("result: " + String.format("%.3f", result));
    }

    public void closeScanner() {
        scanner.close();
    }
}