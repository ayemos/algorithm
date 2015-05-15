import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class SortedRandomInteger {
    private static final int MAX = 100;
    public static List<Integer> sortedRandom(int n, int m) {
        Random rand = new Random();
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if((rand.nextInt(MAX) % (n - i)) < m) {
                res.add(i);
                m--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(sortedRandom(10, 5));
    }
}
