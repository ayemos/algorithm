import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    char[][] grid; 
    boolean[][] visited;
    int w, h;

    void run() throws Exception {
        String[] nums = ns().split(" ");
        h = Integer.parseInt(nums[0]);
        w = Integer.parseInt(nums[1]);
        grid = new char[w][h];
        visited = new boolean[w][h];

        char[] row;
        for(int i = 0; i < h; i++) {
            row = ns().toCharArray();
            for(int j = 0; j < w; j++) {
                grid[j][i] = row[j];
            }
        }

        int count = 0;
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                if(!visited[j][i] && grid[j][i] == 'W') {
                    visit(j, i);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    void visit(int x, int y) {
        if(visited[x][y]) return;
        visited[x][y] = true;

        int[] dxs = {0, 1, -1};
        int[] dyx = {0, 1, -1};
        for(int dx : dxs) {
            for(int dy : dyx) {
                if((dx == 0 && dy == 0) || 
                        x + dx < 0 || x + dx >= w ||
                        y + dy < 0 || y + dy >= h)
                    continue;

                if(grid[x + dx][y + dy] == 'W') 
                    visit(x + dx, y + dy);
            }
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




