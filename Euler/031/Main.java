import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
    long[][] memo = new long[100001][coins.length];
    int c = 0;

    void run() throws Exception {
        int t = ni();
        int n;
        for(int i = 0; i < t ; i++) {
            n = ni();

            System.out.println(calc(n, 0));
        }
    }

    long calc(int n, int i) {
        c++;
        if(memo[n][i] > 0)  {
            return memo[n][i];
        }

        if(n == 0)
            return 1;

        int res = 0;
        if(i < coins.length - 1) 
            res += calc(n, i + 1);

        if(n >= coins[i])
            res += calc(n - coins[i], i);

        memo[n][i] = res % BIG_MOD;

        return res % BIG_MOD;
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

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




