package work_with_files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) {

        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\User\\Desktop\\1 World Trade.jpg");
             FileOutputStream outputStream = new FileOutputStream("1 World Trade.jpg")){
            int i;
            while ((i = inputStream.read()) != -1){
                outputStream.write(i);
            }
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
