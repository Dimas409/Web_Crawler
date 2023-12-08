package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test8 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Maria", 'f', 23, 3, 7.4);
        List<Student> students = new ArrayList<>(List.of(st1, st2, st3, st4, st5));
//        Map<Integer, List<Student>> collect = students.stream().peek(s -> s.setName(s.getName().toUpperCase()))
//                .collect(Collectors.groupingBy(Student::getCourse));
//        for(Map.Entry<Integer, List<Student>> entry: collect.entrySet()){
//            System.out.println(entry);
//        }

        Map<Boolean, List<Student>> collect =
                students.stream()
                .collect(Collectors.partitioningBy(s-> s.getAvgGrade() > 7));
        for(Map.Entry<Boolean, List<Student>> entry: collect.entrySet()){
            System.out.println(entry);
        }
    }
}
