import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String[] nums = ns().trim().split(" ");
        int n = Integer.parseInt(nums[0]);
        int k = Integer.parseInt(nums[1]);
        long con;
        boolean fault;
        for(int i = 1; i < n; i+=2) {
            for(int d = 2; count(i + d * (k - 1)) == count(i); d+=2) {
                fault = false;
                for(int j = 1; j < k ; j++) {
                    if(!isPerm(i, i + d * j)){
                        fault = true;
                        break;
                    }
                }

                if(!fault) {
                    con = 0;
                    for(int j = 0; j < k; j++) {
                        if(!isPrime(i + d * j)) {
                            fault = true;
                            break;
                        }
                        con = concat(con, i + d * j);
                    }

                    if(!fault) {
                        System.out.println(con);
                    }
                }
            }
        }
    }

    int count(int n) {
        int c = 0;
        while(n > 0) {
            n /= 10;
            c++;
        }
        return c;
    }

    long concat(long a, long b) {
        long tmp = b;
        int c = 0;
        while(tmp > 0) {
            tmp /= 10;
            c++;
        }
        
        return (long)Math.pow(10, c) * a + b;
    }

    boolean isPerm(int a, int b) {
        int[] digits = new int[10];
        while(a > 0) {
            digits[a % 10]++;
            a /= 10;
        }

        while(b > 0) {
            if(digits[b % 10]-- <= 0)
                return false;
            b /= 10; 
        }

        return true;
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




