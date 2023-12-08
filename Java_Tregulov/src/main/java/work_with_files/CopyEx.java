package work_with_files;

import java.io.*;

public class CopyEx {
    public static void main(String[] args) {

        try (BufferedReader reader =  new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\1 World Trade.jpg"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("1 World Trade.jpg"))){
            int character;
            while ((character = reader.read()) != -1){
                writer.write(character);
            }
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.write('\n');
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
