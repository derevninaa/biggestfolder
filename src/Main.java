import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Main {

    public static void main(String[] args) throws IOException {
        String folderPath = "/Users/derevnin/Desktop/";
        File file = new File(folderPath);
        System.out.println(getFolderSize(file));
    }

    public static long getFolderSize(File file) throws IOException {
        return Files.walk(file.toPath())
            .filter(f -> f.toFile().isFile())
            .mapToLong(f -> f.toFile().length())
            .sum();
    }
}
