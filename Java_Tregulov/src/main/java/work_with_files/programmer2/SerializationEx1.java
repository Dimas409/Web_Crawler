package work_with_files.programmer2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializationEx1 {
    public static void main(String[] args) {
        List<String> employees = null;
        try(ObjectInputStream inputStream = new ObjectInputStream( new FileInputStream("emoloyees1.bin"))){
            employees = (ArrayList) inputStream.readObject();
            System.out.println(employees);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
