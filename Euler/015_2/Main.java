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

    void run() throws Exception {
        int t = nn();
        int m, n;
        String[] nums;
        int[][] grid;

        for(int i = 0; i < t; i++) {
            nums = nl().trim().split(" ");
            m = Integer.parseInt(nums[0]) + 1;
            n = Integer.parseInt(nums[1]) + 1;
            grid = new int[m][n];

            long res = 0L;
            for(int j = 0; j < m; j++) 
                grid[j][0] = 1;
            for(int k = 0; k < n; k++)
                grid[0][k] = 1;

            for(int j = 1; j < m; j++) 
                for(int k = 1; k < n; k++) 
                    grid[j][k] = (grid[j-1][k] + grid[j][k-1]) % BIG_MOD;

            /*
            for(int k = 0; k < n; k++) {
                for(int j = 0; j < m; j++)  
                    System.out.print(grid[j][k] + " ");

                System.out.println("");
            }
            */

            System.out.println(grid[m-1][n-1]);
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

    int nn() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    String nl() throws Exception {
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




