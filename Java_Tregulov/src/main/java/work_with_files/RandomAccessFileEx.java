package work_with_files;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx {
    public static void main(String[] args) {
        try(RandomAccessFile file
                    = new RandomAccessFile("test10.txt", "rw")){

            int a = file.read();
            System.out.println((char)a);
            String s1 = file.readLine();
            System.out.println(s1);

            file.seek(101);
            String s2 = file.readLine();
            System.out.println(s2);
            long pos = file.getFilePointer();
            System.out.println(pos);

//            file.seek(0);
//            file.writeBytes("privet");
            file.seek(file.length());
            file.writeBytes("\n\t\t\t\t\tWilliam Butler Yeats");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
