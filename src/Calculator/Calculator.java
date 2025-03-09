package Calculator;

import java.util.*;

public class Calculator {
    public static final Map<Character,Integer> mark_cal = Map.of('+',1,'-',1,'*',2,'/',2);

    // convert to postfix expression
    public static List<String> change_cal(String expression){
        List<String> output = new ArrayList<>(); //output
        Stack<Character> operator = new Stack<>(); //memorize operator
        StringBuilder number = new StringBuilder(); //memorize number


        for (char ch : expression.toCharArray()){
            if (Character.isDigit(ch)|| ch =='.'){ //if number or decimal point then append to StringBuilder
                number.append(ch);
            }else{
                if (number.length()>0){
                    output.add(number.toString()); //if StringBuilder has number and get string then add to output
                    number.setLength(0); //reset
                }
                if (ch=='('){
                    operator.push(ch); //Push opening parenthesis onto the stack
                }else if (ch==')'){
                    while (!operator.isEmpty()&&operator.peek()!='('){
                        output.add(String.valueOf(operator.pop())); //Pop operators until '(' is found
                    }
                    operator.pop();
                }else if (mark_cal.containsKey(ch)){
                    while (!operator.isEmpty()&& mark_cal.getOrDefault(operator.peek(),0)>=mark_cal.get(ch)){
                        output.add(String.valueOf(operator.pop())); // Compare operator priorities and store them in a stack
                    }
                    operator.push(ch);
                }
            }

        }

        if (number.length()>0){
            output.add(number.toString()); // Store last number onto output
        }
        while (!operator.isEmpty()){
            output.add(String.valueOf(operator.pop())); // Store operators onto output
        }

        return output; //return List that has postfix expression
    }
    public static double evaluate(List<String> postfix) {
        Stack<Double> stack = new Stack<>();

        for (String token : postfix) {
            if (token.matches("\\d+(\\.\\d+)?")) { // integer or double
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();
                switch (token.charAt(0)) { // if meet operator then calculate and store onto stack
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/':
                        if (b == 0 ) throw new ArithmeticException("Division by zero");
                        stack.push(a / b);
                        break;
                    default: throw new ArithmeticException("Invalid operator");
                }
                if (Double.isInfinite(stack.get(0)) || Double.isNaN(stack.get(0))){
                    throw new ArithmeticException("Overflow or undefined result");
                }
            }
        }
        return stack.pop(); // return result
    }
    public static double calculate(String expression) {
        List<String> postfix = change_cal(expression.replaceAll("\\s+", ""));
        return evaluate(postfix);
    }
}
