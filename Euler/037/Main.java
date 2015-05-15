import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[] primes;

    void run() throws Exception {
        int n = ni();
        primes = new int[n + 1];
        // era
        primes[0] = -1;
        primes[1] = -1;
        primes[2] = 1;
        int tmp;
        for(int i = 3; i <= n; i+=2) {
            if(primes[i] == 0) {
                primes[i] = 1;
                tmp = i + i;
                while(tmp < n && primes[tmp] <= n) {
                    primes[tmp] = -1;
                    tmp += i;
                }
            }
        }

        int sum = 0;
        for(int i = 11; i <= n; i++) 
            if(check(i)) 
                sum+= i;

        System.out.println(sum);
    }


    boolean check(int n) {
        int tmp = n, c = 0;
        while(tmp > 0) {
            if(primes[tmp] != 1)
                return false;
            tmp /= 10;
            c++;
        }

        tmp = n;
        // right
        while(tmp > 0) {
            if(primes[tmp] != 1)
                return false;

            tmp -= ((tmp / (int)Math.pow(10, c - 1)) % 10) * (int)Math.pow(10, c - 1);
            c--;
        }

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




