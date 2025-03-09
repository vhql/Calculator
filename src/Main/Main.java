package Main;

import Calculator.Calculator;
import UI.UI;


//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        UI ui = new UI();
        while(true) {
            ui.message();
            String expression = ui.inputExpression();
            if(expression.equalsIgnoreCase("b")){
                System.out.println("계산기 종료");
                break;
            }
            try {
                double result = Calculator.calculate(expression);
                ui.outputExpression(result);
            }
            catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }
        }
        ui.closeScanner();
    }
}