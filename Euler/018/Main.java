import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int debug = 0;
    int[][] pyr;
    int n;

    void run(int debug) throws Exception {
        this.debug = debug;
        int t = ni();
        String[] row;
        for(int i = 0; i < t; i++) {
            n = ni();
            pyr = new int[n][n];
            for(int j = 0 ; j < n; j++) {
                row = ns().trim().split(" ");
                for(int k = 0; k <= j; k++)  {
                    pyr[k][j] = Integer.parseInt(row[k]);
                }
            }

            System.out.println(solve(0, 0, 0));
        }
    }

    int solve(int x, int y, int score) {
        if(y == n - 1) 
            return score + pyr[x][y];

        return Math.max(solve(x, y + 1, score + pyr[x][y]),
                solve(x+1, y+1, score + pyr[x][y]));
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

    void log(String str) {
        if(debug == 1) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        int debug = 0;
        try {
            debug = Integer.parseInt(args[0]);
        } catch (Exception e) { }

        new Main().run(debug);
    }
}




