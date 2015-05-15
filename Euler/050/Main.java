import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[] memo, primes;

    void run() throws Exception {
        int T = ni();
        int n;
        for(int t = 0; t < T; t++) {
            n = ni();
            memo = new int[n+1];

            memo[0] = -1;
            memo[1] = -1;
            memo[2] = 1;
            int count = 1;
            for(int i = 4; i < n; i+=2) {
                memo[i] = -1;
            }

            int tmp;
            for(int i = 2; i <= n; i++) {
                if(memo[i] == -1)
                    continue;

                memo[i] = 1;
                count++;
                tmp = i + i;
                while(tmp <= n) {
                    memo[tmp] = -1;
                    tmp += i;
                }
            }

            primes = new int[count];
            int j = 0;
            for(int i = 0; i < n; i++) 
                if(memo[i] == 1) 
                    primes[j++] = i;

            int max = 0, res = 0;
            for(int i = 0; i < primes.length; i++) {
                tmp = 0;
                count = 0;
                for(int k = i; k < primes.length; k++) {
                    tmp += primes[k];
                    if(tmp >= n)
                        break;
                    if(count > max && isPrime(tmp)) {
                        if(count > max) { 
                            max = count;
                            res = tmp;
                        }
                    }
                    count++;
                }
            }
            System.out.println(res + " " + (max + 1));
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




