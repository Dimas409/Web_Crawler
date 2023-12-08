package work_with_files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileEx {
    public static void main(String[] args) throws IOException {
        File file = new File("File.txt");
        File folder = new File("C:\\Users\\User\\Desktop\\A");
        File file2 = new File("C:\\Users\\User\\Desktop\\A\\File.txt");
        File folder2 = new File("C:\\Users\\User\\Desktop\\B");

        System.out.println("file.getAbsolutePath() " + file.getAbsolutePath());
        System.out.println("folder.getAbsolutePath() " + folder.getAbsolutePath());
        System.out.println("---------------------------------------");

        System.out.println("file.isAbsolute() " + file.isAbsolute());
        System.out.println("folder.isAbsolute() " + folder.isAbsolute());
        System.out.println("---------------------------------------");

        System.out.println("file.isDirectory() " + file.isDirectory());
        System.out.println("folder.isDirectory() " + folder.isDirectory());
        System.out.println("---------------------------------------");

        System.out.println("file.exists() " + file.exists());
        System.out.println("folder.exists() " + folder.exists());
        System.out.println("file2.exists() " + file2.exists());
        System.out.println("folder2.exists() " + folder2.exists());
        System.out.println("---------------------------------------");

        System.out.println("file2.createNewFile() " + file2.createNewFile());
        System.out.println("folder2.mkdir() " + folder2.mkdir());
        System.out.println("file.createNewFile() " + file.createNewFile());
        System.out.println("---------------------------------------");

//        System.out.println("folder.delete() " + folder.delete());
//        System.out.println("folder2.delete() " + folder2.delete());
//        System.out.println("file2.delete() " + file2.delete());
        System.out.println("---------------------------------------");

        File[] files = folder.listFiles();
        Arrays.stream(files).forEach(file1 -> System.out.println(file1.getName()));
        System.out.println("---------------------------------------");
        System.out.println("file2.isHidden()" + file2.isHidden());
        System.out.println("file2.canRead()" + file2.canRead());
        System.out.println("file2.canWrite()" + file2.canWrite());
        System.out.println("file2.canExecute()" + file2.canExecute());

    }
}
