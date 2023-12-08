package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods5 {
    public static void main(String[] args) {
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Zaur");
        arrayList1.add("Ivan");
        arrayList1.add("Maria");
        arrayList1.add("Kolya");
        arrayList1.add("Elena");

        List<Integer> list1 = new ArrayList<>(List.of(3, 8, 13));
        list1.add(18);
        List<Integer> list2 = new ArrayList<>(List.copyOf(list1));
        list2.add(20);


//        System.out.println(arrayList1);
//        Object[] array = arrayList1.toArray();
//        String [] array2 = arrayList1.toArray(new String[0]);
//        System.out.println(Arrays.toString(array2));

//        List<String> myList = arrayList1.subList(1, 4);
//        System.out.println(myList);
//        myList.add("Fedor");
//        System.out.println(myList);
//        System.out.println(arrayList1);
//        arrayList1.add("Sveta");
//        System.out.println(myList);
//        System.out.println(arrayList1);



//        ArrayList<String> arrayList2 = new ArrayList<>();
//        arrayList2.add("Ivan");
//        arrayList2.add("Maria");
//        arrayList2.add("Igor");
//        arrayList1.retainAll(arrayList2);
//        System.out.println(arrayList1);

//        boolean result = arrayList1.containsAll(arrayList2);
//        System.out.println(result);

    }
}
