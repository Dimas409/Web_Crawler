package Generics.igra;

import javax.xml.namespace.QName;

public class Test {
    public static void main(String[] args) {
        Schoolar schoolar = new Schoolar("Ivan", 13);
        Schoolar schoolar1 = new Schoolar("Mariya", 15);

        Student student = new Student("Nikolay", 20);
        Student student1 = new Student("Kseniya", 18);

        Employee employee = new Employee("Zaur", 32);
        Employee employee1 = new Employee("Mikhail", 47);

        Team<Schoolar> schoolarTeam = new Team("Drakoni");
        Team<Student> studentTeam = new Team("Vpered!");
        Team<Employee> employeeTeam = new Team("Rabotyagi");
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar);
//        schoolarTeam.addNewParticipant(student1); Благодаря дженерикам мы не можем добавить любого участника в команду
//        schoolarTeam.addNewParticipant(employee1);
        studentTeam.addNewParticipant(student);
        studentTeam.addNewParticipant(student1);
        employeeTeam.addNewParticipant(employee);
        employeeTeam.addNewParticipant(employee1);

        Team<Schoolar> schoolarTeam2 = new Team("Mudreci");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Oliya", 14);
        schoolarTeam2.addNewParticipant(schoolar3);
        schoolarTeam2.addNewParticipant(schoolar4);
        schoolarTeam2.playWith(schoolarTeam);

    }
}
