import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        System.out.println(sockMerchant(List.of(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }

    public static int sockMerchant(List<Integer> ar) {
        HashMap<Integer, Integer> pairs = new HashMap<>();
        ar.forEach(sock -> {
            if (pairs.containsKey(sock)) {
                pairs.merge(sock, 1, Integer::sum);
            } else {
                pairs.put(sock, 1);
            }
        });

        AtomicInteger count = new AtomicInteger(0);
        pairs.forEach((key, value) -> {
            count.getAndAccumulate(value / 2, Integer::sum);
        });

        return count.get();
    }
}
