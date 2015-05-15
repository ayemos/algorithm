import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int n = ni();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++) 
            sb.append(ns());

        String str = sb.toString();
        sb.setLength(0);
        while(str.length() > 0) {
            if(isLeft(str)) {
                sb.append(str.charAt(0));
                str = str.substring(1, str.length());
            } else {
                sb.append(str.charAt(str.length() - 1));
                str = str.substring(0, str.length() - 1);
            }
        }

        System.out.println(sb.toString());
    }

    boolean isLeft(String s) {
        int len = s.length();
        for(int i = 0; i < len; i++) {
            if(s.charAt(i) > s.charAt(len - i - 1))
                return false;
            else if(s.charAt(i) < s.charAt(len - i - 1))
                return true;
        }
        return true;
    }

    String rev(String str) {
        return new StringBuffer(str).reverse().toString();
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

    char nc() throws Exception {
        return (char)br.read();
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




