package lesson2;

import java.util.Scanner;

public class Main1_scanner {
    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        System.out.print("Enter name: ");
//        String name = scn.next(); //Ivan\n
//        System.out.print("Enter line: ");
//        //scn.nextLine();
////        scn = new Scanner(System.in);
//        String line = scn.next();
//        System.out.println("name: "+name);
//        System.out.println("line: "+line);


        System.out.println("Ввести 5 чисел с консоли");
        Scanner scn = new Scanner(System.in);

        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();
        int d = scn.nextInt();
        int e = scn.nextInt();
        System.out.println(a+b+c+d+e);
    }
}
