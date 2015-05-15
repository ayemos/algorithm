import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[] coefs = new int[10001];
    int[] last = new int[10001];

    void run() throws Exception {
        int n = ni();
        int k = ni();
        int tmp;

        /*
        for(int j = 1; j <= n; j++) {
            tmp = j;
            while(tmp % 2 == 0) {
                tmp /= 2;
                coefs[2]++;
            }

            for(int i = 3; i <= tmp; i+=2) {
                while(tmp % i == 0) {
                    tmp /= i;
                    coefs[i]++;
                }
            }
        }
        */
        tmp = n;
        while(tmp % 2 == 0) {
            tmp /= 2;
            coefs[2]++;
        }

        for(int i = 3; i <= tmp; i+=2) {
            while(tmp % i == 0) {
                tmp /= i;
                coefs[i]++;
            }
        }

        last[0] = -1;

        System.out.println("COEFS");
        for(int j = 0; j < 10; j++) {
            System.out.print(j + ":" + coefs[j] + " ");
        }
        System.out.println("");

        /*
        System.out.println("INCS");
        while(inc(last)) {
            inc(last);
            for(int j = 0; j < 10; j++) {
                System.out.print(j + ":" + last[j] + " ");
            }
            System.out.println("");
        }
        */
        System.out.println(count(coefs, last, 0, k) / 2);
    }

    long count(int[] rem, int[] last, int i, int n) {
        /*
        System.out.println("i:n = " + i + ":" + n);
        System.out.println("rem");
        dump(rem);
        System.out.println("last");
        dump(last);
        */
        if(i == n)
            return 1;

        long res = 0;
        int[] tmp, tmplast;

        while(inc(last)) {
            if(check(rem, last)) {
                tmp = rem.clone();
                tmplast = last.clone();
                min(tmp, tmplast);
                res += count(tmp, tmplast, i + 1, n);
                if(res > BIG_MOD)
                    res -= BIG_MOD;
            }
        }

        return res;
    }

    void dump(int[] arr) {
        for(int j = 0; j < 10; j++) {
            System.out.print(j + ":" + arr[j] + " ");
        }
        System.out.println("");
    }

    boolean check(int[] rem, int[] last) {
        for(int i = 0; i < rem.length; i++) 
            if(rem[i] < last[i]) 
                return false;

        return true;
    }

    boolean inc(int[] last) {
        int i = 0;
        while(true) {
            if(i < coefs.length) {
                if(last[i] < coefs[i]) {
                    last[i]++;
                    break;
                } else {
                    last[i] = 0;
                    i++;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    void min(int[] a, int[] b) {
        // a - b
        for(int i = 0; i < a.length; i++) 
            a[i] -= b[i];
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




