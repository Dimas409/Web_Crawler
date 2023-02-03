package lesson6_1_constructos.Homework;

public class Main_home_work_task1 {
    public static void main(String[] args) {
        Passport katyaPass = new Passport(2030, 306130, "Екатерина", "Иванова",
                "Федоровна", 23);
        Passport vadimPass = new Passport(2323, 202246, "Вадим", "Петров",
                "Егорович", 46);
        Passport denisPass = new Passport(6363, 262728, "Денис", "Синицин",
                "Олегович", 37);
        katyaPass.printInfo();
        vadimPass.printInfo();
        denisPass.printInfo();

    }
}
 class Passport {
    int serial;
    int number;
    String name;
    String surname;
    String patronymic;
    int age;
    public Passport(int serial, int number, String name, String surname, String patronymic, int age){
        this.serial = serial;
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;

    }
    public void printInfo() {
        System.out.println("Пасспорт");
        System.out.println(" Серия: " + serial + "\n Номер: " + number + "\n Имя: " + name +
                "\n Фамилия: " + surname + "\n Отчество: " + patronymic + "\n Возраст: " + age);
        System.out.println();
    }

}
