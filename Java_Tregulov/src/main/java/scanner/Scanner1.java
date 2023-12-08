package scanner;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Scanner1 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Vvedite chislo");
//        int i = scanner.nextInt();
//        System.out.println("Vvedennoe chislo: " + i);
//        System.out.println("Napishite paru slov");
//        String s = scanner.nextLine();
//        System.out.println("Вы написали: " + s);
//        System.out.println("Vvedite  drobnoe chislo");
//        double i = scanner.nextDouble();
//        System.out.println("Vvedennoe chislo: " + i);

        Scanner scanner = new Scanner("Privet moy drug!\nKak pojivaesh?\nChto xoroshego?");
//        String s = scanner.nextLine();
//        System.out.println(s);
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());
//        while (scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }

        System.out.println(scanner.next().charAt(2));

    }
}
