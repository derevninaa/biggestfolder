import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        String folderPath = "/Users/derevnin/Desktop/";
        long sizeLimit = 50 * 1024 * 1024;
        File file = new File(folderPath);
        Node root = new Node(file, sizeLimit);

        FolderSizeCalculator calculator = new FolderSizeCalculator(root);
        ForkJoinPool pool = new ForkJoinPool();
        long sum = pool.invoke(calculator);
        System.out.println(root);
    }
}
