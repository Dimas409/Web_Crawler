
public class Car {

    private String name;

    private int fuel;

    private int price;
    public Car(){}

    public Car(String name, int fuel, int price) {
        this.name = name;
        this.fuel = fuel;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", fuel=" + fuel +
                ", price=" + price +
                '}';
    }
}
