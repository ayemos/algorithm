import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    static int l;

    void run() throws Exception {
        String line;
        String[] ws;
        int[] nums, res;
        int len;

        while((line = br.readLine()) != null) {
            ws = line.split(",");
            len = ws.length;
            nums = new int[len];
            for(int i = 0; i < len; i++) 
                nums[i] = Integer.parseInt(ws[i]);

            Puzzle(nums);
        }
    }

    public static int[] Puzzle(int[] n) {
        l = 0;
        int[] res = new int[n.length];
        solve(n, res, 0);

        return res;
    }

    public static void solve(int[] nodes, int[] res, int k) {
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i] == k) {
                solve(nodes, res, i);
            }
        }
        res[l++] = k;
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




