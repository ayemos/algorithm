import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final int MAX = 7652413;
    int[] primes;

    void run() throws Exception {
        int t = ni();
        int tmp, n;
        for(int i = 0; i < t; i++) {
            n = Math.min(ni(), MAX);
            primes = new int[n + 1];
            primes[0] = -1;
            primes[1] = -1;
            primes[2] = 1;

            for(int p = 3; p <= n; p+=2) {
                if(primes[p] == -1) 
                    continue;

                primes[p] = 1;
                tmp = p + p;
                while(tmp <= n) {
                    primes[tmp] = -1;
                    tmp += p;
                }
            }

            int res = -1;
            for(int j = 0; j <= n; j++) 
                if(primes[j] == 1 && check(j))
                    res = j;

            System.out.println(res);
        }
    }

    boolean check(int n) {
        int c = 0, i;
        int tmp = n;
        while(tmp > 0) {
            tmp /= 10;
            c++;
        }

        int[] digits = new int[c+1];

        tmp = n;
        while(tmp > 0) {
            i = tmp % 10;
            if(i == 0 || i > digits.length - 1 || digits[i] >= 1) 
                return false;

            digits[i]++;
            tmp /= 10;
        }

        for(int j = 1; j <= c; j++) 
            if(digits[j] != 1)
                return false;

        return true;

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




