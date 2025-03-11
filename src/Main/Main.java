package Main;

import Calculator.Calculator;
import UI.UI;
import Log.Log;


//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        UI ui = new UI();
        boolean running = true;

            ui.menu();
            String UserFlag = ui.UserFlag();
            if (UserFlag.equalsIgnoreCase("1")) {
                while (true) {
                    ui.message();
                    String expression = ui.inputExpression();
                    if (expression.equalsIgnoreCase("b")) {
                        break;
                    }
                    try {
                        double result = Calculator.calculate(expression);
                        ui.outputExpression(result);
                        Log.log(result, expression);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                }
            }
        }
        ui.closeScanner();
    }
}