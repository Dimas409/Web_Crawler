package Generics;

public class ParametrizedClass {
    public static void main(String[] args) {
//        Info<String> info1 = new Info<>("privet");
//        System.out.println(info1);
//        String s = info1.getValue();
//        Info<Integer> info2 = new Info<>(18);
//        System.out.println(info2);
//        Integer i1 = info2.getValue();
    }
//    public void abc(Info<String> info){
//        String s = info.getValue();
//    }
//    public void abc(Info<Integer> info){
//        Integer i = info.getValue();
//    }

}
class Info<T extends Number&i1&i2> {
    private T value;

    public Info(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Info{" +
                "value=" + value +
                '}';
    }
}
interface i1{}
interface i2{}
//class Parent {
//        public void abc(Info<String> info){
//        String s = info.getValue();
//    }
//}
//class Child extends Parent {
//        public void abc(Info<Integer> info){
//        Integer i = info.getValue();
//    }
//}