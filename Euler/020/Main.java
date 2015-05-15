import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int debug = 0;
    final int MAX = 10000;

    void run(int debug) throws Exception {
        this.debug = debug;

        int t = ni();
        long f;
        int n, l;
        int[] digits = new int[MAX];
        int tmp, ovf;
        long sum;

        for(int i = 0; i < t; i++) {
            n = ni();
            l = 1;
            digits[0] = 1;
            ovf = 0;

            for(int j = n; j > 1; j--) {
                for(int k = 0; k < l; k++) {
                    tmp = digits[k] * j + ovf;
                    if(tmp >= 10) {
                        ovf = tmp / 10;
                        digits[k] = tmp % 10;
                        if(k == l - 1)
                            l++;
                    } else {
                        ovf = 0;
                        digits[k] = tmp;
                    }
                }
            }

            sum = 0;
            for(int j = 0; j < l; j++) {
                sum += digits[j];
                digits[j] = 0;
            }


            System.out.println(sum);
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

    void log(String str) {
        if(debug == 1) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        int debug = 0;
        try {
            debug = Integer.parseInt(args[0]);
        } catch (Exception e) { }

        new Main().run(debug);
    }
}




