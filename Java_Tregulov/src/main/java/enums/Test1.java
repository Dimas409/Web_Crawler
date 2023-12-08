package enums;

public class Test1 {
    void method (String dayOfWeek){
        System.out.println("Today is " + dayOfWeek);
    }
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.method("Monday");
    }
}
