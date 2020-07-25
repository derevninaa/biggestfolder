import java.util.HashMap;
import java.util.Map;

public class SizeCalculator {

    private static char[] sizeChar = {'B', 'K', 'M', 'G', 'T'};
    private static Map<Character, Integer> char2multiplier = getMultipliers();

    public static String getHumanReadableSize(long size) {
        for (int i = 0; i < sizeChar.length; i++) {
            double value = ((double) size) / Math.pow(1024, i);
            if (value < 1024) {
                return Math.round(value * 100) / 100. + "" +
                    sizeChar[i] +
                    (i > 0 ? "b" : "");
            }
        }
        return "Very big!";
    }

    public static long getSizeFromHumanReadable(String size) {
        char sizeFactor = size
            .replaceAll("[0-9\\s+]+", "")
            .charAt(0);
        int multiplier = char2multiplier.get(sizeFactor);
        long length = multiplier * Long.valueOf(
            size.replaceAll("[^0-9]", "")
        );
        return length;
    }

    private static Map<Character, Integer> getMultipliers() {
        char[] multipliers = {'B', 'K', 'M', 'G', 'T'};
        Map<Character, Integer> char2multiplier = new HashMap<>();
        for (int i = 0; i < multipliers.length; i++) {
            char2multiplier.put(
                multipliers[i],
                (int) Math.pow(1024, i)
            );
        }
        return char2multiplier;
    }
}
