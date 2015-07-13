import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    char[][] grid;
    boolean[][] safe;
    int nr, nc;

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            String[] nums = ns().split(" ");
            nr = Integer.parseInt(nums[0]);
            nc = Integer.parseInt(nums[1]);
            grid = new char[nr][nc];
            safe = new boolean[nr][nc];
            for(int r = 0; r < nr; r++) {
                String cs = ns();
                for(int c = 0; c < nc; c++) {
                    grid[r][c] = cs.charAt(c);
                }
            }

            int res = solve();

            if(res == -1) {
                gcjPrint("IMPOSSIBLE", t + 1);
            } else {
                gcjPrint(Integer.toString(res), t + 1);
            }
        }
    }

    int solve() {
        int count = 0;
        for(int r = 0; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                if(safe[r][c])
                    continue;

                if(grid[r][c] != '.' && loop(r,c)) 
                    safe[r][c] = true;
            }
        }

        for(int r = 0; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                if(grid[r][c] == '.' || safe[r][c])
                    continue;

                boolean found = false;
                for(int c2 = 0; c2 < nc; c2++) {
                    if(safe[r][c2]) {
                        count++;
                        safe[r][c] = true;
                        found = true;
                        break;
                    }
                }


                if(found)
                    continue;

                for(int r2 = 0; r2 < nr; r2++) {
                    if(safe[r2][c]) {
                        count++;
                        safe[r][c] = true;
                        found = true;
                        break;
                    }
                }

                if(found)
                    continue;

                int calc = calc(r, c);
                if(calc == -1)
                    return -1;
                else
                    count += calc;
            }
        }
        return max;
    }

    int calc(int r, int c) {
        int max1 = 0, max2 = 0;
        boolean imp = true;
        for(int c2 = 0; c2 < nc; c2++) 
            if(c2 != c && grid[r][c2] != '.') {
                if(c2 > c && (grid[r][c] == '>' || grid[r][c2] == '<' )
                        || c2 < c && (grid[r][c] == '<' || grid[r][c2] == '>')) {
                    max1 = Math.max(1, max1);
                } else {
                    max1 = Math.max(2, max1);
                }
                imp = false;
            }


        for(int r2 = 0; r2 < nr; r2++) {
            if(r2 != r && grid[r2][c] != '.') {
                if(r2 > r && (grid[r][c] == 'v' || grid[r2][c] == '^') 
                        || r2 < r && (grid[r][c] == '^' || grid[r2][c] == 'v')) {
                    max2 = Math.max(1, max2);
                }else {
                    max2 = Math.max(2, max2);
                }
                imp = false;
            }
        }

        if(imp)
            return -1;
        else
            if(max1 == 0)
                return max2;
            else if(max2 == 0)
                return max1;
            else
                return Math.min(max1, max2);
    }

    boolean loop(int r, int c) {
        int tmpr = r, tmpc = c;
        int dr = 0, dc = 0;
        boolean[][] visited; 
        visited = new boolean[nr][nc];
        while(true) {
            dr = 0;
            dc = 0;
            switch(grid[tmpr][tmpc]) {
                case '>':
                    dc = 1;
                    break;
                case '<':
                    dc = -1;
                    break;
                case '^':
                    dr = -1;
                    break;
                case 'v':
                    dr = 1;
                    break;
            }

            // go as far as poss
            while(tmpr >= 0 && tmpr < nr && tmpc >= 0 && tmpc < nc) {
                // find arrow
                tmpr += dr;
                tmpc += dc;

                if(tmpr < 0 || tmpr >= nr || tmpc < 0 || tmpc >= nc)
                    return false;

                if(grid[tmpr][tmpc] != '.')
                    break;
            }


            if(visited[tmpr][tmpc])
                return true;
            visited[tmpr][tmpc] = true;
        }
    }

    void dump() {
        System.out.println("###");
        for(int r = 0; r < nr; r++) {
            for(int c = 0; c < nc; c++) {
                System.out.print(grid[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println("###");
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




