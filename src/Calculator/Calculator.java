package Calculator;

import java.util.*;

public class Calculator {
    public static final Map<Character,Integer> mark_cal = Map.of('+',1,'-',1,'*',2,'/',2);
    public static List<String> change_cal(String expression){
        List<String> output = new ArrayList<>(); //output
        Stack<Character> operator = new Stack<>(); //memorize operator
        StringBuilder number = new StringBuilder(); //memorize number

        for (char ch : expression.toCharArray()){
            if (Character.isDigit(ch)|| ch =='.'){
                number.append(ch);
            }else{
                if (number.length()>0){
                    output.add(number.toString());
                    number.setLength(0);
                }
                if (ch=='('){
                    operator.push(ch);
                }else if (ch==')'){
                    while (!operator.isEmpty()&&operator.peek()!='('){
                        output.add(String.valueOf(operator.pop()));
                    }
                    operator.pop();
                }else if (mark_cal.containsKey(ch)){
                    while (!operator.isEmpty()&& mark_cal.getOrDefault(operator.peek(),0)>=mark_cal.get(ch)){
                        output.add(String.valueOf(operator.pop()));
                    }
                    operator.push(ch);
                }
            }

        }

        if (number.length()>0){
            output.add(number.toString());
        }
        while (!operator.isEmpty()){
            output.add(String.valueOf(operator.pop()));
        }

        return output;
    }
    public static double evaluate(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+(\\.\\d+)?")) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        return stack.pop();
    }
    public static double calculate(String expression) {
        List<String> postfix = change_cal(expression.replaceAll("\\s+", ""));
        return evaluate(postfix);
    }
}
