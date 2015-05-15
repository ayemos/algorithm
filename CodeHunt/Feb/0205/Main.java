import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String line, s;
        String[] ws;
        int n;

        while((line = br.readLine()) != null) {
            ws = line.split(" ");
            n = Integer.parseInt(ws[1]);
            System.out.println(Puzzle(ws[0], n));
        }
    }

    public static String Puzzle(String s, int n) {
        int len, tmp;
        String[] ss;
        String res = "";

        s = s.replaceAll("\\.+", ".");
        ss = s.split("\\.");
        if(ss.length == 1) {
            res = s;
            for(int i = 0; i < n - s.length(); i++) {
                res += ".";
            }
            return res;
        }

        len = n - s.length() + ss.length - 1;

        System.out.println(s);
        System.out.println(len);

        String w;
        for(int i = 0; i < ss.length - 1; i++) {
            w = ss[i];
            res += w;
            tmp = len;
            for(int j = 0; j < (int)Math.ceil((double)tmp / (ss.length - i - 1)); j++) {
                res += ".";
                len--;
            }
        }
        return res + ss[ss.length - 1];
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




