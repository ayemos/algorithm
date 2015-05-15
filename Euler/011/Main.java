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

    void run() throws Exception {
        int[][] grid = new int[20][20];
        String[] nums;
        for(int i = 0; i < 20; i++) {
            nums = nl().trim().split(" ");
            for(int j = 0; j < 20; j++) {
                grid[j][i] = Integer.parseInt(nums[j]);
            }
        }

        int[] dxs = {0, 1, 1, 1};
        int[] dys = {1, 0, 1, -1};

        int[] res = new int[3];
        int[] grids = new int[4];
        long tmp;
        long max = -1L;
        for(int i = 0; i < 20; i++) {
            for(int j = 0; j < 20; j++) {
                int dx, dy;
                for(int d = 0; d < 4; d++) {
                    dx = dxs[d]; dy = dys[d];

                    if((i+dx*3 >= 20) || (i+dx*3 < 0)
                            || (j+dy*3 >= 20) || (j+dy*3 < 0)) {
                        continue;
                            }

                    tmp = grid[i][j] 
                        * grid[i+dx*1][j+dy*1]
                        * grid[i+dx*2][j+dy*2]
                        * grid[i+dx*3][j+dy*3];
                    
                    if(tmp > max) {
                        max = tmp;
                        res[0] = i;
                        res[1] = j;
                        res[2] = d;
                        grids[0] = grid[i][j];
                        grids[1] = grid[i+dx*1][j+dy*1];
                        grids[2] = grid[i+dx*2][j+dy*2];
                        grids[3] = grid[i+dx*3][j+dy*3];
                    }
                }
            }
        }

        System.out.println(max);
        /*
        for(int i = 0; i < 3; i++)
            System.out.println(res[i]);
        for(int i = 0; i < 4; i++)
            System.out.println(grids[i]);
            */
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
        return Integer.parseInt(br.readLine());
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




