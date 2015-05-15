import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int t = ni();
        int n, tmp, count;
        int[] primes;

        for(int i = 0; i < t; i++) {
            n = ni();
            primes = new int[n];
            primes[0] = -1;
            primes[1] = -1;
            primes[2] = 1;
            count = 0;
            for(int j = 4; j < n/2; j+=2) 
                primes[j] = -1;

            for(int j = 3; j < n; j+=2) {
                if(primes[j] == -1)
                    continue;

                primes[j] = 1;
                tmp = j + j;
                while(tmp < n) {
                    primes[tmp] = -1;
                    tmp += j;
                }

            }

            for(int s = 1; s * s * 2 < n; s++) {
                for(int j = 2; j < n; j++) {
                    if(j + s * s * 2 > n)
                        break;
                    if(primes[j] == 1 && j + s * s * 2 == n) {
                        count++;
                    }
                }
            }

            System.out.println(count);
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




