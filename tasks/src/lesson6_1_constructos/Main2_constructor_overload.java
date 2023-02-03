package lesson6_1_constructos;

public class Main2_constructor_overload {
    public static void main(String[] args) {
        //перегрузка конструкторов (overload)
        //при регистрации обязательными полями являются логин и пароль
        Registration reg1 = new Registration("login1", "pass1");
        Registration reg2 = new Registration("login1", "pass1", "name1");
        Registration reg3 = new Registration("login1", "pass1", "name1", "Russia");
        Registration reg4 = new Registration("login1", "pass1", "name1", "Russia", 30);

    }
}
class Registration {
    String login;
    String password;
    String name;
    String country;
    int age;

    //Перегруженные конструкторы:
    //Правила перегрузки:
    //1. Конструкторы должны отличаться кол-во параметров
    //2. если кол-во параметров совпадает, они должны отличаться типами параметров
    //3. если кол-во и типы параметров совпадают, они должны отличаться порядком следвоания этих параметров

    public Registration(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Registration(String login, String password, String name) {
//        this.login = login;
//        this.password = password;
        this(login, password);
        this.name = name;
    }
    public Registration(String login, String password, String name, String country) {
//        this.login = login;
//        this.password = password;
//        this.name = name;
        this(login, password, name);
        this.country =country;
    }

    public Registration(String login, String password, String name, String country, int age) {
//        this.login = login;
//        this.password = password;
//        this.name = name;
//        this.country = country;
        this(login, password, name, country);
        this.age = age;
    }
}