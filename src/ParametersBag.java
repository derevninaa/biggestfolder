import java.io.File;
import java.io.FileNotFoundException;

public class ParametersBag {
    private long limit;
    private String path;

    public ParametersBag(String[] args) throws FileNotFoundException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Введите корректные аргументы в формате -l ... -d ...");
        }

        limit = 0;
        path = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-l")) {
                limit = SizeCalculator.getSizeFromHumanReadable(args[i + 1]);
            } else if (args[i].equals("-d")) {
                path = args[i + 1];
            }
        }

        if (limit <= 0) {
            throw new IllegalArgumentException();
        }

        File folder = new File(path);
        if (!folder.exists() || !folder.isDirectory()) {
            throw new FileNotFoundException();
        }
    }

    public String getPath() {
        return path;
    }

    public long getLimit(){
        return limit;
    }
}
