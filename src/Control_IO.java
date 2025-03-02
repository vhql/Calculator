public class Control_IO {
    int a,b; // 덧셈으로 2개 들어오는 숫자
    Control_IO (int a,int b){
        this.a = a;
        this.b = b;
    }
    void add(int a, int b) {
        int add_res = a + b;
        System.out.println("덧셈결과 :" + add_res);

    }
}
