package lambda;

public class Test2 {
    static void def(I i ){
        System.out.println(i.abc("Privet"));
    }

    public static void main(String[] args) {
        def(str -> str.length());
    }
}
interface I {
    int abc(String s);
}