import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static List<List<Integer>> MAGIC_SQUARE1 = List.of(List.of(8,1,6), List.of(3,5,7), List.of(4,9, 2));
    private static List<List<Integer>> MAGIC_SQUARE2 = List.of(List.of(6,1,8), List.of(7,5,3), List.of(2,9, 4));
    private static List<List<Integer>> MAGIC_SQUARE3 = List.of(List.of(4,9,2), List.of(3,5,7), List.of(8,1, 6));
    private static List<List<Integer>> MAGIC_SQUARE4 = List.of(List.of(2,9,4), List.of(7,5,3), List.of(6,1, 8));
    private static List<List<Integer>> MAGIC_SQUARE5 = List.of(List.of(8,3,4), List.of(1,5,9), List.of(6,7, 2));
    private static List<List<Integer>> MAGIC_SQUARE6 = List.of(List.of(4,3,8), List.of(9,5,1), List.of(2,7, 6));
    private static List<List<Integer>> MAGIC_SQUARE7 = List.of(List.of(6,7,2), List.of(1,5,9), List.of(8,3, 4));
    private static List<List<Integer>> MAGIC_SQUARE8 = List.of(List.of(2,7,6), List.of(9,5,1), List.of(4,3, 8));

    private static final List<List<Integer>> INPUT = List.of(List.of(4, 8, 2), List.of(4, 5, 7), List.of(6, 1, 6));

    public static void main(String[] args) {
        List<Integer> diffs = List.of(
                totalAbsDiff(INPUT, MAGIC_SQUARE1),
                totalAbsDiff(INPUT, MAGIC_SQUARE2),
                totalAbsDiff(INPUT, MAGIC_SQUARE3),
                totalAbsDiff(INPUT, MAGIC_SQUARE4),
                totalAbsDiff(INPUT, MAGIC_SQUARE5),
                totalAbsDiff(INPUT, MAGIC_SQUARE6),
                totalAbsDiff(INPUT, MAGIC_SQUARE7),
                totalAbsDiff(INPUT, MAGIC_SQUARE8));

        System.out.println(Collections.min(diffs));
    }

    private static int totalAbsDiff(List<List<Integer>> input, List<List<Integer>> magicSquare) {
        List<List<Integer>> newSquare = new ArrayList<>();
        AtomicInteger i = new AtomicInteger(0);
        input.forEach(row -> {
            AtomicInteger j = new AtomicInteger(0);
            List<Integer> newRow = new ArrayList<>();
            row.forEach(col -> {
                int index = j.getAndIncrement();
                newRow.add(Math.abs(row.get(index) - magicSquare.get(i.get()).get(index)));
            });
            newSquare.add(i.getAndIncrement(), newRow);
        });

        return sumSquare(newSquare);
    }

    private static int sumSquare(List<List<Integer>> square) {
        return square.stream()
                .map(list -> list.stream().reduce(0, Integer::sum))
                .reduce(0, Integer::sum);
    }
}