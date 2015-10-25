import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[][] A, B;
    int m, n;
    int d;

    void run() throws Exception {
        String[] mn = ns().split(" ");
        m = Integer.parseInt(mn[0]);
        n = Integer.parseInt(mn[1]);
        A = new int[m][n];
        B = new int[m][n];
        d = 0;

        for(int i = 0; i < m; i++) {
            String[] row = ns().split(" ");
            for(int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(row[j]);
            }
        }

        for(int i = 0; i < m; i++) {
            String[] row = ns().split(" ");
            for(int j = 0; j < n; j++) {
                B[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(count(0, 0, 0));
    }

    int count(int x, int y, int c) {
        System.out.println("--------------------");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }

        if(x == m - 1 && y == n - 1)
            return c;

        System.out.println("d:" + d++);
        if(A[x][y] == B[x][y]) {
            if(x == m - 1) {
                return count(0, y + 1, c);
            } else {
                return count(x + 1, y, c);
            }
        }
        System.out.println("d:" + d--);

        int[] dxs = {0, 1, 0, -1};
        int[] dys = {1, 0, -1, 0};

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 4; i++) {
            int dx = dxs[i];
            int dy = dys[i];
            if(x+dx >= 0 && x+dx < m && y+dy >= 0 && y+dy < n) {
                if(A[x][y] == B[x+dx][y+dy] && A[x+dx][y+dy] == B[x][y]) {
                    // swap
                    int tmp = A[x][y];
                    A[x][y] = A[x+dx][y+dy];
                    A[x+dx][y+dy] = tmp;
                    System.out.println("d:" + d++);
                    if(x == m - 1) {
                        min = Math.min(min, count(0, y + 1, c + 1));
                    } else {
                        min = Math.min(min, count(x + 1, y, c + 1));
                    }
                    System.out.println("d:" + d--);
                    // swap back
                    tmp = A[x][y];
                    A[x][y] = A[x+dx][y+dy];
                    A[x+dx][y+dy] = tmp;
                }
            }
        }

        // change
        A[x][y] = 1 - A[x][y];
        System.out.println("d:" + d++);
        if(x == m - 1) {
            min = Math.min(min, count(0, y + 1, c + 1));
        } else {
            min = Math.min(min, count(x + 1, y, c + 1));
        }
        System.out.println("d:" + d--);
        A[x][x] = 1 - A[x][y];
        return min;
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




