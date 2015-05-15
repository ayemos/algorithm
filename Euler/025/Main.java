import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[] memo = new int[5000];

    void run() throws Exception {
        int t = ni();
        int n, k, l, co, car;
        memo[0] = 1;

        int[] a, b, c;
        for(int i = 0; i < t; i++) {
            n = ni();
            if(memo[n-1] > 0)  {
                System.out.println(memo[n-1]);
                continue;
            }

            a = new int[5000];
            b = new int[5000];
            c = new int[5000];
            k = 0;
            l = 1;
            co = 3;
            car = 0;
            a[0] = 1;
            b[0] = 1;

            while(true) {
                for(int j = 0; j < l; j++) {
                    c[j] = a[j] + b[j] + car;

                    if(c[j] >= 10) {
                        c[j] -= 10;
                        car = 1;

                        if(j == l - 1) {
                            memo[l] = co;
                            l++;
                        }
                    } else {
                        car = 0;
                    }
                    a[j] = b[j];
                    b[j] = c[j];
                }

                if(l == n) {
                    System.out.println(co);
                    for(int m = 0; m < 10; m++)
                    System.out.print(c[4999 - m]);
                    break;
                }

                co++;
            }
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




