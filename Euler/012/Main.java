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
    Map<Integer, Integer> facs = new LinkedHashMap<Integer, Integer>();
    Map<Integer, Long> memo = new LinkedHashMap<Integer, Long>();

    void run() throws Exception {
        int t = nn();
        int n;
        int tri;
        for(int i = 0; i < t; i++) {
            n = nn();
            int j = 1;
            while(true) {
                long res = 1;
                if(memo.containsKey(j)) {
                    res = memo.get(j);
                } else {
                    facs.clear();
                    count(j);
                    count(j + 1);
                    facs.put(2, facs.get(2) - 1);
                    for(Map.Entry<Integer, Integer> e : facs.entrySet()) {
                        res *= (e.getValue() + 1);
                    }
                    memo.put(j, res);
                }
                if(res >= n + 1) {
                    System.out.println(j * (j + 1) / 2);
                    break;
                }
                j++;
            }
        
        }
    }

    void count(int n) {
        int c = 0;
        while(n % 2 == 0) {
            n /= 2;
            c++;
        }
        if(c > 0) 
            add(2, c);

        int d = 3;

        while(d <= n) {
            c = 0;
            while(n % d == 0) {
                n /= d;
                c++;
            }

            if(c > 0) 
                add(d, c);

            d += 2;
        }
    }

    void add(int n, int c) {
        if(facs.containsKey(n)) {
            facs.put(n, facs.get(n) + c);
        } else {
            facs.put(n, c);
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




