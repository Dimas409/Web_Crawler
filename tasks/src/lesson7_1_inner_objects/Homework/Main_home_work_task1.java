package lesson7_1_inner_objects.Homework;

public class Main_home_work_task1 {
    public static void main(String[] args) {
        Passport passport = new Passport(2008, 306130, "Иван", "Иванов", "Иванович", 27 );
        passport.printInfo();
        passport.setSerial(3131);
        passport.setNumber(205120);
        passport.setName("Игорь");
        passport.setSurname("Петров");
        passport.setPatronymic("Сергеевич");
        passport.setAge(32);
        System.out.println("Паспорт\n Серия: " + passport.getSerial() + "\n Номер: " + passport.getNumber() + "\n Имя: " +
                passport.getName() + "\n Фамилия: " + passport.getSurname() + "\n Отчество: " + passport.getPatronymic() +
                "\n Возраст: " + passport.getAge());
        Passport p1 = new Passport(1234, 123456);
        Passport p2 = new Passport(2234, 223456);
        p1.setSerial(p2.getSerial());
        p1.setNumber(p2.getNumber());
        System.out.println("Серия: " + p1.getSerial() + "\nНомер: " + p1.getNumber());

    }
}
 class Passport {
    private int serial;
    private int number;
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    public Passport(int serial, int number, String name, String surname, String patronymic, int age){
        this.serial = serial;
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;

    }

     public Passport(int serial, int number) {
         this.serial = serial;
         this.number = number;
     }

     public int getSerial() {
         return serial;
     }

     public void setSerial(int serial) {
         this.serial = serial;
     }

     public int getNumber() {
         return number;
     }

     public void setNumber(int number) {
         this.number = number;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getSurname() {
         return surname;
     }

     public void setSurname(String surname) {
         this.surname = surname;
     }

     public String getPatronymic() {
         return patronymic;
     }

     public void setPatronymic(String patronymic) {
         this.patronymic = patronymic;
     }

     public int getAge() {
         return age;
     }

     public void setAge(int age) {
         this.age = age;
     }

     public void printInfo() {
        System.out.println("Пасспорт");
        System.out.println(" Серия: " + serial + "\n Номер: " + number + "\n Имя: " + name +
                "\n Фамилия: " + surname + "\n Отчество: " + patronymic + "\n Возраст: " + age);
        System.out.println();
    }

}
