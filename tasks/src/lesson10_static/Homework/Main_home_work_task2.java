package lesson10_static.Homework;

import java.util.ArrayList;
import java.util.Objects;

public class Main_home_work_task2 {
    public static void main(String[] args) {
        Student student = new Student();
        if(student.add(new Subject("Математика", 1))){
            System.out.println("Предмет добавлен");
        }else{
            System.out.println("Предмет не добавлен");
        }
        Student student1 = new Student();
        student1.add(new Subject("Русский", 5));
        student.add(new Subject("Химия", 6));
        System.out.println();

    }
}
class Subject {
    private String nameSubject;
    private int grade;

    public Subject(String nameSubject, int grade) {
        this.nameSubject = nameSubject;
        this.grade = grade;
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return grade == subject.grade && Objects.equals(nameSubject, subject.nameSubject);
    }

    @Override
    public String toString() {
        return "Нназвание предмета " + nameSubject+
                ", оценка: " + grade;
    }


}

class SubjectInfo{
    private static ArrayList<String> subjectNames = new ArrayList<>();
    private static ArrayList<Integer> subjectMarks = new ArrayList<>();

    static{
        subjectNames.add("Математика");
        subjectNames.add("Русский");
        subjectNames.add("Английский");

        subjectMarks.add(1);
        subjectMarks.add(2);
        subjectMarks.add(3);
        subjectMarks.add(4);
        subjectMarks.add(5);
    }

    public static boolean checkSubject(Subject subject){
        return subjectNames.contains(subject.getNameSubject()) && subjectMarks.contains(subject.getGrade());
    }

}

class Student{
    private ArrayList<Subject> subjects = new ArrayList<>();
    public boolean add(Subject subject){
        if(SubjectInfo.checkSubject(subject)){
            subjects.add(subject);
            return true;
        }else{
            return false;
        }
    }
}