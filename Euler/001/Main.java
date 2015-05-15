import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

// Project Euler #1: Multiples of 3 and 5

/*
 * 与えられたnに対して、n未満の数のうち、3か5の倍数となっているものの和を返す。
 * 0~nでループして足していくとO(n)、15の倍数を最後に引く方法で等差数列の公式を使えばO(1)
 *
 */
public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    void run() throws Exception {
        String line = br.readLine();
        while((line = br.readLine()) != null) {
            long n = Integer.parseInt(line) - 1; // below n

            System.out.println(sum(n / 3, 3) + sum(n / 5, 5) - sum(n / 15, 15));
        }
    }

    long sum(long n, long d) {
        return d * n * (n + 1) / 2;
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




