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
        int n, k;
        long seq;
        int max = 0, res = 0;

        int[] memo;

        for(int i = 0 ; i < t; i++) {
            n = nn();
            max = 0;
            memo = new int[n];
            for(int j = 0; j < n; j++) 
                memo[j] = -1;
            memo[1] = 1;
            k = 0;
            for(int j = 2; j < n; j++) {
                seq = j;
                while(seq != 1 && seq >= j) {
                    if(seq % 2 == 0)
                        seq /= 2;
                    else 
                        seq = 3 * seq + 1;

                    k++;
                }

                memo[j] = k + memo[(int)seq];

                if(memo[j] >= max) {
                    max = memo[j];
                    res = j;
                }
            }
            System.out.println(max);
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




