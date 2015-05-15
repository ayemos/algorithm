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
    final int BIG_MOD = 1000000007;
    int debug = 0;
    final int MAX = 100000;
    int[] memo = new int[MAX];

    void run(int debug) throws Exception {
        this.debug = debug;
        int t = ni();
        int n, res, res2, sum;
        for(int i = 0; i < t; i++) {
            n = ni(); 
            sum = 0;

            for(int j = 2; j <= n; j++) {
                if(memo[j - 1] > 0) {
                    res = memo[j - 1];
                } else {
                    res = sum(j);
                    memo[j - 1] = res;
                }

                if(res <= n && res != j) {
                    if(memo[res - 1] > 0) {
                        res2 = memo[res - 1];
                    } else {
                        res2 = sum(res);
                        memo[res - 1] = res2;
                    }

                    if(j == res2) {
                        sum += j + res;
                    }
                }

            }

            System.out.println(sum / 2);
        }
    }

    int sum(int n) {
        if(n == 0) return 0;
        if(memo[n - 1] > 0) return memo[n - 1];

        int res = 1; // factor 1
        for(int p = 2; p < n; p++) 
            if(n % p == 0) 
                res += p;

        return res;
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

    int ni() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    long nl() throws Exception {
        return Long.parseLong(br.readLine().trim());
    }

    String ns() throws Exception {
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

    void log(String str) {
        if(debug == 1) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        int debug = 0;
        try {
            debug = Integer.parseInt(args[0]);
        } catch (Exception e) { }

        new Main().run(debug);
    }
}




