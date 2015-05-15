import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int n = ni();
        int[] ps = new int[n];

        for(int i = 0; i < n; i++) 
            ps[i] = ni();

        int m1, m2;
        int tmp;
        long sum = 0;
        while(n > 1) {
            m1 = 0;
            m2 = 1;
            if(ps[m1] > ps[m2]) {
                tmp = m1;
                m1 = m2;
                m2 = tmp;
            }

            // 小さい方から二つ求める
            for(int i = 2; i < n; i++) {
                if(ps[i] < ps[m1]) {
                    m2 = m1;
                    m1 = i;
                } else if(ps[i] < ps[m2]) {
                    m2 = i; 
                }
            }

            int t = ps[m1] + ps[m2];
            sum += t;
            
            if(m1 == n - 1) {
                tmp = m1;
                m1 = m2;
                m2 = tmp;
            }

            ps[m1] = t;
            ps[m2] = ps[n-1];

            n--;
        }
        System.out.println(sum);
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




