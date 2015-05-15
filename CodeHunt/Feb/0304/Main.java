import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String line, a, b;
        String[] ws;

        while((line = br.readLine()) != null) {
            ws = line.split(" ");
            System.out.println(Puzzle(ws[0], ws[1]));
        }
    }
    public static String Puzzle(String x, String y) {
        return solve(x, y, 0, 0, "");
    }

    public static String solve(String x, String y, int i, int j, String res) {
        if(i >= x.length() || j >= y.length()) 
            return res;
        char a = x.charAt(i);
        char b = y.charAt(j);
        String res1, res2;

        if(a == b) {
            return solve(x, y, i+1, j+1, res + String.valueOf(a));
        } else {
            res1 = solve(x, y, i+1, j, res);
            res2 = solve(x, y, i, j+1, res);
            if(res1.length() > res2.length())
                return res1;
            else 
                return res2;
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




