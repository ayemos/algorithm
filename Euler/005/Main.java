import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

// Project Euler #5: Smallest multiple

/*
 * 1 ~ Nのいずれでも割り切ることの出来る最小の整数を求める問題。
 * 愚直に、N+1から順番に1 ~ Nで割れるかチェックしていくと、解のオーダーがMだとしてO(N * M)
 * 解のオーダーとは一体。
 *
 * そうでなく、1 ~ Nの数に対して素因数分解を掛けて、現れる素因数とその次数の最大値をマップに記録
 * していって、解を計算するとO(N * N)
 * 
 * 解は少なくとも 2 * N以上になるので、多分後者のほうが速い？よくわからない。
 *
 */
public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    Map<Integer, Integer> memo;

    void run() throws Exception {
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            memo = new LinkedHashMap<Integer, Integer>();

            buildMemo(n);                

            int res = 1;
            for(Map.Entry<Integer, Integer> e : memo.entrySet()) 
                res *= Math.pow(e.getKey(), e.getValue());

            System.out.println(res);
        }
    }

    void buildMemo(int n) {
        memo.clear();

        for(int k = 2; k <= n; k++) {
            int tk = k;
            if(tk % 2 == 0) {
                int c = 0;
                while(tk % 2 == 0) {
                    tk /= 2;
                    c++;
                }

                add(2, c);
            }

            for(int i = 3; i <= tk; i+=2) {
                if(tk % i == 0) {
                    int c = 0;
                    while(tk % i == 0) {
                        tk /= i;
                        c++;
                    }
                    add(i, c);
                }
            }
        }
    }

    void add(int n, int c) {
        if(memo.containsKey(n)) {
            memo.put(n, Math.max(memo.get(n), c));
        } else {
            memo.put(n, c);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




