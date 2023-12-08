package lesson12_recursion;

import java.util.ArrayList;

public class Main2_return {
    public static void main(String[] args) {
        //найти сумму элементов списка
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println(findSum(list ,0));
    }

    static int findSum(ArrayList<Integer> list, int i){
        if(i<list.size()){
            return list.get(i) + findSum(list, i + 1);
            //или так:
//            int sum = list.get(i) + findSum(list, i + 1);
//            return sum;
        }
        return 0;
    }
    //1. return 10 + findSum(list, 1) -> return 10 + 90 -> return 100
    //2. return 20 + findSum(list, 2) -> return 20 + 70 -> return 90
    //3. return 30 + findSum(list, 3) -> return 30 + 40 -> return 70
    //4. return 40 + findSum(list, 4) -> return 40 + 0 -> return 40
    //5. return 0;
}
