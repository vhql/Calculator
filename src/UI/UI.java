
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
        System.out.println("3. Input e for exit");
        System.out.print("Choice: ");
    }

    public void calmenu() {
        System.out.println("---- Calculate mode ----");
        System.out.println("1. Input b for going to Main ");
        System.out.println("2. Input e for exit");
        System.out.print("Input expressions : ");
    }
    public void logmenu() {
        System.out.println("---- Log mode ----");
        System.out.println("1. Clear log");
        System.out.println("2. Read Last Expression");
        System.out.println("3. Input b for going to Main");
        System.out.println("4. Input e for exit");
        System.out.print("choice :");
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