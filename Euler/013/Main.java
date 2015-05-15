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

    void run() throws Exception {
        int t = nn();

        String[] lines = new String[t];
        long a, tmp;
        long res = 0;
        for(int i = 0; i < t; i++) 
            lines[i] = nl();

        a = 0;
        tmp = 0;
        for(int j = 1; j < 6; j++) {
            a = tmp;
            for(int i = 0; i < t; i++) {
                a += lineToLong(lines[i], j);
            }

            tmp = a / (long)Math.pow(10, 10);
        }

        System.out.println(longToResult(a));
    }

    String longToResult(long n) {
        String res = n + "";
        int m = 0;
        long tmp = n;
        while(tmp > 0) {
            tmp /= 10;
            m++;
        }

        if(m > 10) {
            res = res.substring(0, 10);
        } else if(m < 10) {
            for(int i = m + 1; i < 10; i++)
                res = "0" + res;
        }
        return res;
    }

    long lineToLong(String line, int n) {
        int st = line.length() - n * 10;
        int ed = st + 10;
        return Long.parseLong(line.substring(st, ed));
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

    int nn() throws Exception {
        return Integer.parseInt(br.readLine());
    }

    String nl() throws Exception {
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




