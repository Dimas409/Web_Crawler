package Collection;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(List.of(-3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19));
        Collections.sort(arrayList);
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        Collections.shuffle(arrayList);
        System.out.println(arrayList );
//        int index1 = Collections.binarySearch(arrayList, 12);
//        System.out.println(index1);

//        List<Employee> employeeList = new ArrayList<>(List.of(
//                new Employee(100, "Zaur", 12345),
//                new Employee(15, "Ivan", 6542),
//                new Employee(123, "Petr", 8542),
//                new Employee(15, "Maria", 5678),
//                new Employee(182, "Kolya", 125),
//                new Employee(15, "Sasha", 9874),
//                new Employee(250, "Elena", 1579)
//        ));
//        System.out.println(employeeList);
//        Collections.sort(employeeList);
//        System.out.println(employeeList);
//        int index2 = Collections.binarySearch(employeeList, new Employee(182, "Kolya", 125));
//        System.out.println(index2);
//        int [] array = {-3, 8, 12, -8, 0, 5, 10, 1, 150, -30, 19};
//        System.out.println(Arrays.toString(array));
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        int index3 = Arrays.binarySearch(array, 150);
//        System.out.println(index3);
    }
}
class Employee implements Comparable<Employee>{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int result = this.id - o.id;
        if(result == 0){
           result =  this.name.compareTo(o.name);
        }
        return result ;
    }
}
