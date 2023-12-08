package nested_classes.static_nested_class;

public class Car {
    String color;
    int doorCount;
    Engine engine;
    private static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }
    void method(){
        System.out.println(Engine.countOfObjects);
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }
    public static class Engine{
        int horsePower;
        static int countOfObjects;

        public Engine(int horsePower) {
            countOfObjects++;
            System.out.println(a);
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "My engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}
class Test1{
    public static void main(String[] args) {
        Car.Engine e = new Car.Engine(256);
        System.out.println(e);
        Car car = new Car("red", 2, e);
        System.out.println(car);
    }
}
