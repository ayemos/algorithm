import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    // 簡単のため、1を囲む8つの数字を1層目と数え、
    // 初項(中央の1)を後から足す事で答えを得る。
    //
    // a[k] : k 層目に含まれる数字の数 = 8k 
    // c[k] : k 層目の四つ角の合計 = 4 * sum(a[0] ~ a[k - 1]) + 20k
    //  = 16k^2 + 4k + 4
    // sum(c[0] ~ c[k]) = (8 / 3)(2n + 1)(n + 1)n + 2(n + 1)n + 
    // 
    //
    void run() throws Exception {
        int t = ni();
        long n, res, pat;
        for(int i = 0; i < t; i++) {
            n = ((nl() - 1) / 2) % BIG_MOD;
            res = 1;
        
            if(n == 0)
                System.out.println(1);
            else if(n == 1) 
                System.out.println(25);
            else {
                pat = (((mod(mod((n * 2) + 1) * mod(n + 1)) * mod(n) * 8)
                    + mod(6 * mod(mod(n + 1) * mod(n)))+ mod(12 * n)));
                if(pat % 2 != 0)
                    pat += BIG_MOD;

                res = (pat / 3) + 1;
            
                System.out.println(mod(res));
            }
        }
    }

    long mod(long n) {
        return n % BIG_MOD;
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




