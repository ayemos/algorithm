import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final List<Character> A = new ArrayList<Character>();

    void run() throws Exception {
        int t = ni();
        long n;
        int k;

        List<Character> res ;
        for(int i = 0; i < t; i++) {
            res = new ArrayList<Character>();
            A.clear();
            for(int j = 0; j < 10; j++) 
                A.add((char)('0' + j));

            n = nl() - 1;
            k = 10;
            while(k > 0) {
                /*
                System.out.println(A.size());
                System.out.println(k);
                System.out.println(res.size());
                */
                for(int j = k - 1; j >= 0; j--) {
                    /*
                    System.out.println("A:" + A);
                    System.out.println("res:" + res);
                    System.out.println("n:x = " + n + ":" + j * fact(k));
                    System.out.println("j:k = " + j + ":" + k);
                    */
                    if(n >= j * fact(k - 1)) {
                        n -= j * fact(k - 1); 
                        res.add(A.remove(j));
                        break;
                    }
                }
                k--;
            }
            for(int j = 0; j < 10; j++)
                System.out.print(res.get(j));
            System.out.println("");
        }
    }

    long fact(int i) {
        return facts(i, 1L);
    }

    long facts(int i, long f) {
        if(i == 0)
            return f;

        return facts(i - 1, i * f);
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




