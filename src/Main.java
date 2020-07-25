import java.io.File;
import java.io.IOException;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        String folderPath = "/Users/derevnin/Desktop/";
        File file = new File(folderPath);
        FolderSizeCalculator calculator = new FolderSizeCalculator(file);
        ForkJoinPool pool = new ForkJoinPool();
        long sum = pool.invoke(calculator);
        System.out.println(humanReadable(sum));
    }

    public static String humanReadable(long size){
        double BYTE = 0.001;
        double KB = 0.000001;
        double MB = 0.000000001;
        double GB = 0.000000000001;

        String result = "";

        if ((int) (size * BYTE) == 0) {
            result = (size + " B");
        } else if ((int) (size * KB) == 0) {
            result += (size * BYTE) + " KB";
        } else if ((int) (size * MB) == 0) {
            result += (size * KB) + " MB";
        } else if ((int) (size * GB) == 0) {
            result += (size * MB) + " GB";
        }
        return result;
    }
}
