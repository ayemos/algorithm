import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final int MAX = 100000;
    int[] memo;

    void run() throws Exception {
        int t = 10;
        memo = new int[MAX];
        for(int i = 0; i < MAX; i++)
            memo[i] = -1;

        int n;
        long sum = 0;
        int prog = 0;
        for(int i = 1; i < t; i++) {
            if(i % 1000 == 0) {
                System.out.println(prog++);
            }
            n = i;
//            n = ni();

            boolean flg = false;
            for(int j = 12; j <= n / 2; j++) {
                for(int k = j; k <= (n + 1) / 2; k++) {
                    if(j + k == n && isAb(j) && isAb(k)) {
                        flg = true; 
                        break;
                    }
                }

                if(flg)
                    break;
            }

            if(!flg)
                sum+= i;

            System.out.println(i);
            System.out.println(sum);
        }

        System.out.println(sum);
    }


    boolean isAb(int n) {
        if(n == 1) return false;
        if(memo[n] > 0) {
            return memo[n] == 1 ? true : false;
        }

        int sum = 1;
        for(int p = 2; p < n; p++) {
            if(n % p == 0) {
                sum += p;
            }
        }

        boolean res = sum > n;
        memo[n] = res ? 1 : 0;
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

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




