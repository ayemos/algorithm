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
    Map<Long, Integer> memo = new LinkedHashMap<Long, Integer>();
    Map<Range, Integer> maxs = new LinkedHashMap<Range, Integer>();

    class Range {
        int begin, end;
        public Range(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }

        public String toString() {
            return "(" + this.begin + ", " + this.end + ")";
        }
    }

    void run() throws Exception {
        int t = nn();
        int n;
        int max;
        int res = 0;
        int tmp;
        Map.Entry<Range, Integer> maxMap;
        maxs.put(new Range(1, 1), 1);

        for(int i = 0 ; i < t; i++) {
            n = nn();
            maxMap = findMax(n);
 //           System.out.println(maxs);
            if(maxMap != null && n <= maxMap.getKey().end) {
//                System.out.println("MEMO");
                System.out.println(findMax(n).getKey().begin);
            } else {
                max = maxMap.getValue();

                for(int k = maxMap.getKey().end; k <= n; k++) {
                    tmp = chain(k, 0);    
                    memo.put((long)k, tmp);
                    if(tmp >= max) {
                        max = tmp;
                        res = k;
                    }
                }
                maxs.put(new Range(res, n), max);
                System.out.println(res);
            }
        }
    }

    Map.Entry<Range, Integer> findMax(int n) {
        Map.Entry<Range, Integer> res = null;
        for(Map.Entry<Range, Integer> e : maxs.entrySet()) {
            if(e.getKey().end > n)
                break;
            res = e;
        }

        return res;
    }

    int chain(long n, int c) {
        System.out.println(n);
        if(memo.containsKey(n)) {
            System.out.println("MEMO");
            return memo.get(n) + c;
        }
        
        if(n == 1) {
            return c;
        } else if(n % 2 == 0) {
            return chain(n / 2, c+1);
        } else {
            return chain(3 * n + 1, c+1);
        }
    }

    /*
     * Templates
     */
    void dumpObjArr(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
        System.out.println("");
    }

    void dumpObjArr2(Object[][] arr, int m, int n) {
        for(int j = 0; j < m; j++) 
            dumpObjArr(arr[j], n);
    }

    int nn() throws Exception {
        return Integer.parseInt(br.readLine());
    }

    String nl() throws Exception {
        return br.readLine();
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    int getPrime(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        int count = 1;

        int x = 1;
        while(primes.size() < n) {
            x+=2;
            int m = (int)Math.sqrt(x);
            for(int p : primes) {
                if(p > m) {
                    primes.add(x);
                    break;
                }

                if(x % p == 0) 
                    break;
            }
        }

        return primes.get(primes.size() - 1);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




