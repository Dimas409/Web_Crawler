package Generics;

public class ParametrizedClass2 {

    public static void main(String[] args) {
        Pair<String , Integer> pair = new Pair<>("privet", 20);
        System.out.println("Znacheniya pari: value1 = " + pair.getValue1() +
                ", value2 = " + pair.getValue2());
        Pair<Integer, Double> pair1= new Pair<>(156, 3.14);
        System.out.println("Znacheniya pari: value1 = " + pair1.getValue1() +
                ", value2 = " + pair1.getValue2());

        OtherPair<String> otherPair = new OtherPair<>("privet", "poka");
        System.out.println(otherPair.getValue1() + otherPair.getValue2());
    }
}
class Pair<V1, V2>{
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getValue1() {
        return value1;
    }

    public V2 getValue2() {
        return value2;
    }
}
class OtherPair<V>{
    private V value1;
    private V value2;

    public OtherPair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getValue1() {
        return value1;
    }

    public V getValue2() {
        return value2;
    }
}