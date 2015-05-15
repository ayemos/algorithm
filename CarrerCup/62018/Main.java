import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private int[] memo;

    public int count(int n) {
        memo = new int[n + 1];
        return countSub(n);
    }

    private int countSub(int n) {
        if(n <= 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        } else {
            if(memo[n] == 0)
                memo[n] = countSub(n - 1) + countSub(n - 2);
            return memo[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Main().count(10));
    }
}
