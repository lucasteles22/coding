import java.util.AbstractMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static final Map<Character, Integer> SYMBOLS = Map.ofEntries(
        new AbstractMap.SimpleEntry<Character, Integer>('D', -1),
        new AbstractMap.SimpleEntry<Character, Integer>('U', 1));

    public static void main(String[] args) {
        System.out.println(countingValleys("UDDDUDUU"));
    }

    public static int countingValleys(String path) {
        AtomicInteger totalStep = new AtomicInteger(0);
        AtomicInteger countValley = new AtomicInteger(0);
        for (int i = 0; i < path.length(); i ++) {
            boolean mountainCondition = totalStep.get() >= 0;
            totalStep.getAndAccumulate(SYMBOLS.get(path.charAt(i)), Integer::sum);
            if (mountainCondition && totalStep.get() < 0) {
                countValley.getAndAccumulate(1, Integer::sum);
            }
        }

        return countValley.get();
    }
}
