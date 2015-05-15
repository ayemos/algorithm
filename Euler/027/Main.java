import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int lim = ni();
        int as = lim % 2 == 0 ? lim - 1: lim;
        int bs = lim % 6 == 1 || lim % 6 == 5 ? lim : lim - lim % 6;
        int n1, n2, tmp, ma = -as, mb = -lim, max = 0;

        for(int a = -as; a <= as; a+=2) {
            for(int b = -bs; b < bs; b+=6) {
                n1 = 0;
                n2 = 0;
                tmp = b + 1;
                if(b + 1 > lim)
                    continue;
                while(true) {
                    if(!isPrime(n1 * n1 + n1 * a + tmp)) 
                        break;

                    n1++;
                }

                if(n1 > max) {
                    max = n1;
                    ma = a;
                    mb = tmp;
                }
                
                tmp = b + 5;
                if(b + 5 > lim)
                    continue;
                while(true) {
                    if(!isPrime(n2 * n2 + n2 * a + tmp))
                        break;

                    n2++;
                }

                if(n2 > max) {
                    max = n2;
                    ma = a;
                    mb = tmp;
                }
            }
        }

        System.out.println(ma + " " + mb);

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
        n = Math.abs(n);
        if(n % 2 == 0)
            return false;

        for(int i=3;i<n;i+=2) {
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




