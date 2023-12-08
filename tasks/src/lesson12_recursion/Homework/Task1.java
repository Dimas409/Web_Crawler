package lesson12_recursion.Homework;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add(null);
        list.add("Ivan");
        list.add("Semen");
        list.add(null);
        list.add("Viktoria");
        rec(list, 0);
    }
    public static void rec(ArrayList<String> list, int i){
        if(list.size() > i){
            if (list.get(i) != null){
                System.out.println(list.get(i));
            }
            rec(list, i + 1);
        }
    }

}
