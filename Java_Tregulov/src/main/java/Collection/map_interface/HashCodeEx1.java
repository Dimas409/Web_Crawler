package Collection.map_interface;

import multithreading.InterruptionEx;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeEx1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        map.put(new Student("Zaur", "Tregulov", 3), 7.5);
        map.put(new Student("Maria", "Ivanova", 1), 8.7);
        map.put(new Student("Sergey", "Petrov", 4), 9.2);
        System.out.println(map);

//        Student st = new Student("Zaur", "Tregulov", 3);
//        Student st1 = new Student("Igor", "Sidorov", 4);
//        boolean result = map.containsKey(st);
//        System.out.println(result);;
//        System.out.println(st.hashCode());
//        System.out.println(st1.hashCode());
//        for(Map.Entry<Student, Double> entry: map.entrySet()){
//            System.out.println(entry.getKey().hashCode() + " : " + entry.getValue());
//        }

        Map<Integer, String> map2 = new HashMap<>(16, 0.75F);


    }
}
class Student implements Comparable<Student>{
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course='" + surname + '\'' +
                ", age=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);
    }
}