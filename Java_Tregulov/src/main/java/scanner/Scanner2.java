package scanner;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Scanner2 {
    public static void main(String[] args) {
        Scanner scanner = null;
        Set<String> set = new TreeSet<>();
        try {
            scanner = new Scanner(new FileReader("C:\\Users\\User\\Desktop\\test.txt"));
            scanner.useDelimiter("\\W");
            while (scanner.hasNext()){
                String word = scanner.next();
                set.add(word);
            }
            for (String s : set) {
                System.out.println(s);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            scanner.close();
        }
    }
}
