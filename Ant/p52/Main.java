import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[][] memo;
    int[] vs, ws;
    int n;

    void run() throws Exception {
        String[] nums = ns().split(" ");
        n = Integer.parseInt(nums[0]);
        int wmax = Integer.parseInt(nums[1]);
        memo = new int[n][wmax + 1];

        vs = new int[n];
        ws = new int[n];
        for(int i = 0; i < n; i++) {
            nums = ns().split(" ");
            ws[i] = Integer.parseInt(nums[0]);
            vs[i] = Integer.parseInt(nums[1]);
        }

        System.out.println(solve(0, wmax));
    }

    int solve(int i, int w) {
        if(i == n)
            return 0;
        if(memo[i][w] > 0)
            return memo[i][w];

        int res = 0;

        if(ws[i] <= w) {
            int res1 = solve(i + 1, w - ws[i]) + vs[i];
            int res2 = solve(i + 1, w);
            return memo[i][w] = Math.max(res1, res2);
        } else {
            return memo[i][w] = solve(i + 1, w);
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




