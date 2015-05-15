import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String line;
        String[] ws;
        while((line = br.readLine()) != null) {
            ws = line.split(" ");
            System.out.println(Puzzle(ws[0], ws[1]));
        }
    }


    public static String Puzzle(String a, String b) {
        int tmp = t2d(a) + t2d(b);
        System.out.println("a + b = " + tmp);

        return d2t(tmp);
    }

    public static int t2d(String t) {
        int res = 0;
        char c;
        for(int i = 0; i < t.length(); i++) {
            c = t.charAt(t.length() - i - 1);

            if(c == 'T')
                res += 2 * Math.pow(3, i);
            else
                res += (c - '0') * Math.pow(3, i);
        }
        return res;
    }

    public static String d2t(int d) {
        String res = "";
        int p;

        while(d > 0) {
            p = d % 3;
            if(p == 2)
                res += "T";
            else
                res += Integer.toString(p);

            d /= 3;
        }

        return res;
    }

    public static String trm(String s) {
        int i;
        for(i = 0; i < s.length(); i++) 
            if(s.charAt(i) != '0')
                break;
        if(i == s.length())
            return "0";
        else 
            return s.substring(i, s.length());
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




