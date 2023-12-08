package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class StudentInfo {
    void testStudents(ArrayList<Student> al, Predicate<Student> pr){
        for (Student s : al) {
            if(pr.test(s)){
                System.out.println(s);
            }
        }
    }

//    void printStudentOverGrade(ArrayList<Student> al, double grade){
//        for(Student s : al){
//            if(s.avgGrade > grade){
//                System.out.println(s);
//            }
//        }
//    }
//    void printStudentUnderAge(ArrayList<Student> al, int age){
//        for(Student s : al){
//            if(s.age < age){
//                System.out.println(s);
//            }
//        }
//    }
//    void printStudentMixCondition(ArrayList<Student> al, int age, double grade, char sex){
//        for(Student s : al){
//            if(s.avgGrade < grade && s.age > age && s.sex == sex){
//                System.out.println(s);
//            }
//        }
//    }
}
class Test{
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("Nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("Elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("Petr", 'm', 35, 4, 7);
        Student st5 = new Student("Maria", 'f', 23, 3, 9.1);
        ArrayList<Student> students = new ArrayList<>(List.of(st1, st2, st3, st4, st5));

        StudentInfo info = new StudentInfo();


        double res = avgOfSmth(students, student -> (double)student.age);
        System.out.println(res);



//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.course - o2.course;
//            }
//        });
//        Collections.sort(students, (s1, s2) -> s1.course - s2.course);
//        System.out.println(students);

//        System.out.println("----------------");
//
//        StudentChecks sc = p -> p.sex == 'f';
//        info.testStudents(students, sc);
//        System.out.println("xnjn");
//
//        info.testStudents(students, (Student s) -> s.avgGrade > 8);
//        System.out.println("----------------");
//        info.testStudents(students, (Student s) -> s.age < 30);
//        System.out.println("----------------");
//        info.testStudents(students, (Student s) ->
//                s.age > 20 && s.avgGrade < 9.3 && s.sex == 'f');
//        System.out.println("----------------");
//        Predicate<Student> p1 = student -> student.avgGrade > 7.5;
//        Predicate<Student> p2 = student -> student.sex == 'm';
//
//        info.testStudents(students, p1.negate());

    }
    private static double avgOfSmth(List<Student> list, Function<Student, Double> f){
        double result =  0;
        for (Student student : list) {
            result += f.apply(student);
        }
        result = result/ list.size();
        return result;
    }

}
//interface StudentChecks{
//    boolean check(Student s);
//}
//class CheckOverGrade implements StudentChecks{
//    @Override
//    public boolean check(Student s) {
//        return s.avgGrade > 8;
//    }
//}