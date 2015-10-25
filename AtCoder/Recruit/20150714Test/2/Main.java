import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int N = 10;

    void run() throws Exception {
        String line;
        int ds[] = new int[3];
        String nums[] = ns().split(" ");
        for(int i = 0; i < 3; i++) 
            ds[i] = Integer.parseInt(nums[i]);
        int n = ni();
        int aud_grid[][] = new int[N][N];
        boolean hear_grid[][] = new boolean[N][N];

        for(int i = 0; i < n; i++) {
            String xy[] = ns().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);
            aud_grid[x][y]++;
        }

        /*
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(aud_grid[i][j] + " ");
            }
            System.out.println();
        }
        */

        int max = 0;
        int tmp;
        int x1, y1, x2, y2, x3, y3;
        for(int i = 0; i < N * N; i++) {
            for(int j = 0; j < N * N; j++) {
                for(int k = 0; k < N * N; k++) {
                    hear_grid = new boolean[N][N];
                    x1 = i / N; y1 = i % N;
                    x2 = j / N; y2 = j % N;
                    x3 = k / N; y3 = k % N;

                    if(aud_grid[x1][y1] > 0 ||
                            aud_grid[x2][y2] > 0 ||
                            aud_grid[x3][y3] > 0)
                        continue;

                    if((x1 == x2 && y1 == y2) ||
                            (x2 == x3 && y2 == y3) ||
                            (x3 == x1 && y3 == y1))
                        continue;


                    fill(x1, y1, ds[0],
                            x2, y2, ds[1],
                            x3, y3, ds[2], hear_grid);

                    tmp = count(aud_grid, hear_grid);
                    if(tmp > max) 
                        max = tmp;
                }
            }
        }

        System.out.println(max);
    }

    void fill(int x1, int y1, int d1,
            int x2, int y2, int d2,
            int x3, int y3, int d3, boolean hear_grid[][]) {
        int tmpx, tmpy;
        for(int dx = -d1; dx <= d1; dx++) {
            for(int dy = -d1; dy <= d1; dy++) {
                if(hear_grid[x1 + dx][y1 + dy])
                    continue;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if(dist <= d1)
                    hear_grid[x1 + dx][y1 + dy] = true;
            }
        }

        for(int dx = -d2; dx <= d2; dx++) {
            for(int dy = -d2; dy <= d2; dy++) {
                if(hear_grid[x2 + dx][y2 + dy])
                    continue;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if(dist <= d2)
                    hear_grid[x2 + dx][y2 + dy] = true;
            }
        }

        for(int dx = -d3; dx <= d3; dx++) {
            for(int dy = -d3; dy <= d3; dy++) {
                if(hear_grid[x3 + dx][y3 + dy])
                    continue;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if(dist <= d3)
                    hear_grid[x3 + dx][y3 + dy] = true;
            }
        }
        /*
        for(int i = 0; i < N * N; i++) {
            tmpx = i / N;
            tmpy = i % N;
            if(hear_grid[tmpx][tmpy])
                continue;

            double dist;
            dist = calcDist(x1, y1, tmpx, tmpy);
            if(dist <= d1) {
                hear_grid[tmpx][tmpy] = true;
                continue;
            }

            dist = calcDist(x2, y2, tmpx, tmpy);
            if(dist <= d2) {
                hear_grid[tmpx][tmpy] = true;
                continue;
            }
            dist = calcDist(x3, y3, tmpx, tmpy);
            if(dist <= d3) {
                hear_grid[tmpx][tmpy] = true;
                continue;
            }
        }
        */
    }

    double calcDist(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    int count(int aud_grid[][], boolean hear_grid[][]) {
        int c = 0;
        int tmpx, tmpy;
        for(int i = 0; i < N * N; i++) {
            tmpx = i / N; 
            tmpy = i % N;
            if(hear_grid[tmpx][tmpy])
                c += aud_grid[tmpx][tmpy];
        }

        return c;
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

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    long gcd(long a, long b) {
        if(a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        // a >= b
        long mod = a % b;
        if(mod == 0) 
            return b;
        else 
            return gcd(b, mod);
    }

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




