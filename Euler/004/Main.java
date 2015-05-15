import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    List<Integer> memo = new ArrayList<Integer>();

    void run() throws Exception {
        int t = Integer.parseInt(br.readLine());
        memo.add(101101);
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            int max = 101101;
            if(n < max) {
                System.out.println(getMax(n));
            } else {
                int x;
                for(int j = 100; j < 1000; j++) {
                    for(int k = j; k < 1000; k++) {
                        x = j * k;   
                        if(x > max && x < n && isPar(x)) {
                            insert(x);
                            max = x;
                        }
                    }
                }

                System.out.println(max);
            }
        }
    }

    int getMax(int lim) {
        for(int i = memo.size() - 1; i >= 0; i--) {
            int n = memo.get(i);
            if(n < lim) 
                return n;
        }
        return 0;
    }

    void insert(int n) {
        if(memo.contains(n)) return;
        
        for(int i = 0; i < memo.size(); i++) {
            if(memo.get(i) > n || i == memo.size() - 1) {
                memo.add(i + 1, n);
                return;
            }
        }
    }

    boolean isPar(int n) {
        int m = 0;
        int tmp = n;
        while(tmp > 0) {
            m++;
            tmp /= 10;
        }
        
        int a = m / 2;
        int b = m % 2 == 0 ? (m / 2) + 1 : ((m + 1) / 2) + 1;
        
        for(int i = 0; i < a; i++) {
            if((n / (int)Math.pow(10, a - i - 1)) % 10 != (n / (int)Math.pow(10, b + i - 1)) % 10)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




