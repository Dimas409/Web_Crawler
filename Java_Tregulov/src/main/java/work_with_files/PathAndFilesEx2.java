package work_with_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathAndFilesEx2 {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("test15.txt");
        Path directoryPath = Path.of("C:\\Users\\User\\Desktop\\M");
        Path directoryBPath = Path.of("C:\\Users\\User\\Desktop\\B");

//        Files.copy(filePath, directoryPath.resolve(filePath), StandardCopyOption.REPLACE_EXISTING);
//        Files.copy(filePath, directoryPath.resolve("test16.txt"));
//        Files.copy(directoryBPath, directoryPath.resolve("B"));


//        Files.move(filePath, directoryPath.resolve("test15.txt"));
//        System.out.println("Done!");
//        Files.move(Path.of("test10.txt"), Path.of("test11.txt"));

//        Files.delete(Path.of("test5.txt"));
        Files.delete(directoryPath);


    }
}
