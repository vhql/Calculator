//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println("Hello and welcome!\n");
        Control_IO control_IO = new Control_IO(a,b);
        for (int i = 1; i <= 5; i++) {
            control_IO.add(a,b);
            System.out.println("i = " + i);
        }
    }
}