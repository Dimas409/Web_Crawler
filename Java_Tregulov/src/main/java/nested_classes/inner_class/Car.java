package nested_classes.inner_class;


public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }
    public class Engine{
        int horsePower;


        public Engine(int horsePower) {
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
class Test1 {
    public static void main(String[] args) {
        Car car = new Car("black", 4);
        car.setEngine(car.new Engine(150));
        System.out.println(car);

//        Car.Engine engine2 = new Car("yellow", 4).new Engine(200);
//        System.out.println(engine2);


    }
}