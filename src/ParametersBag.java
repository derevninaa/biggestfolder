import java.io.File;
import java.io.FileNotFoundException;

public class ParametersBag {
    private String[] args;

    public ParametersBag(String[] args) {
        this.args = args;
    }

    public String getPath() throws FileNotFoundException {
        String folderPath = args[0];
        File file = new File(folderPath);
        if (file.exists() || !file.isDirectory()) {
            return folderPath;
        } else {
            throw new FileNotFoundException();
        }
    }

    public long getLimit(){
        if(isDigit(args[1])) {
            return Long.parseLong(args[1]);
        }else throw new NumberFormatException();
    }

    private static boolean isDigit(String number){
        try{
            Long.parseLong(number);
            return true;
        }catch (NumberFormatException numberFormatException) {
            return false;
        }
    }
}
