package work_with_files.programmer1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> employees = new ArrayList<>(List.of("Zaur", "Ivan", "Elena"));

        try (ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream("emoloyees1.bin"))){

            outputStream.writeObject(employees);
            System.out.println("Done!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
