import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int t = ni();
        String[] nums;
        int n, k, a, b, d;
        long res, tmp;
        int c = 0;
        for(int i = 0; i < t; i++) {
            res = 1;
            nums = ns().trim().split(" ");
            for(String s : nums) {
                tmp = Long.parseLong(s);
                if(tmp < 10) {
                    res *= tmp;
                    continue;
                }

                tmp -= 10;
                c = 2;
                while(true) {
                    b = (int)(c * Math.pow(10, c) * 9 / 10);
                    if(tmp < b)
                        break;

                    tmp -= b;
                    c++;
                }

                /*
                System.out.println("tmp: " + tmp);
                System.out.println("c: " + c);
                */
                a = (int)Math.floor(tmp / c) + (int)Math.pow(10, c - 1);
                d = c - (int)(tmp % c) - 1;
                /*
                System.out.println("a:" + a);
                System.out.println("d:" + d);
                System.out.println("");
                System.out.print("(" + k + ":" + (int)(a / Math.pow(10, d)) % 10 + ")");
                */

                res *= (int)(a / Math.pow(10, d)) % 10;
            }
            System.out.println(res);

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




