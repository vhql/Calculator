package Main;

import Calculator.Calculator;
import UI.UI;
import Log.Log;
import ExceptionHandler.*;


//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        String UserFlag = "0"; //Flag reset

        UI ui = new UI();
        Calculator calculator = new Calculator();

        while (!UserFlag.equalsIgnoreCase("e")) { // Main Loop
            ui.menu();
            UserFlag = ui.UserFlag();

            if (UserFlag.equalsIgnoreCase("1")) { // Calculator Mode
                while (true) {
                    ui.calmenu();
                    String expression = ui.inputExpression();
                    if (expression.equalsIgnoreCase("b")) {
                        break;
                    }

                    if (expression.equalsIgnoreCase("e")) {
                        UserFlag ="e";
                        break;
                    }

                    try {
                        if (!calculator.check_cal(expression)){
                            throw new InvalidException("Invalid expression : " + expression);
                        }
                        double result = calculator.calculate(expression);
                        ui.outputExpression(result);
                        Log.log(result, expression);
                    } catch (InvalidException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            else if (UserFlag.equalsIgnoreCase("2")) { // Log Mode
                while (!UserFlag.equalsIgnoreCase("b")) {
                    ui.logmenu();
                    UserFlag = ui.UserFlag();
                    switch (UserFlag) {
                        case "1" :
                            Log.clearLog();
                            break;
                        case "2" :
                            Log.readLastExpression();
                            break;
                        case "b" :
                            UserFlag = "b"; // End Log Mode
                            break;
                        case "e" :
                            UserFlag = "e"; // exit
                            break;
                        default :
                            try{
                                throw new WrongInputException("Wrong Input : " + UserFlag);
                            }
                            catch (WrongInputException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                }
            }

            else if (UserFlag.equalsIgnoreCase("e")){ //End
                break;
            }

            else {
                System.out.println("Wrong Input");
            }
        }
        ui.closeScanner();
        System.out.println("Calculator End");
    }
}