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
    Map<Integer, Integer> memo = new LinkedHashMap<Integer, Integer>();

    void run() throws Exception {
        int t = nn();
        
        int n;
        for(int i = 0; i < t; i++) {
            n = nn();
            if(memo.containsKey(n)) {
                System.out.println(memo.get(n));
                continue;
            }

            boolean flg = false;
            int res = -1;
            for(int a = 1; a <= n; a++) {
                for(int b = a; a + b <= n; b++) {
                    int c = n - (a + b);
                    if(a * a + b * b == c * c) {
                        int tmp = a * b *c;
                        if(res < tmp)
                            res = tmp;
                    }
                }

            }

            memo.put(n, res);
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




