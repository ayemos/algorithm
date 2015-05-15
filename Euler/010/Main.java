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
    List<Long> primes = new ArrayList<Long>();
    List<Long> sums = new ArrayList<Long>();

    void run() throws Exception {
        int t = nn();

        primes.add(2L);
        sums.add(2L);
        primes.add(3L);
        sums.add(5L);
        for(int i = 0; i < t; i++) {
            System.out.println(sumPrime(nn()));
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

    long findMax(int n) {
        if(n < 2)
            return 0;
        if(n < 3)
            return 2;
        if(n < 5)
            return 5;

        for(int i = 1; i < primes.size(); i++) {
            if(primes.get(i) > n) {
                return sums.get(i - 1);
            }
        }

        return 0;
    }
    
    long sumPrime(int n) {
        if(n <= primes.get(primes.size() - 1))
            return findMax(n);

        long sum = sums.get(sums.size() - 1);
        long x = primes.get(primes.size() - 1) + 2;
        while(x <= n) {
            int m = (int)Math.sqrt(x);
            for(long p : primes) {
                if(p > m) {
                    primes.add(x);
                    sum += x;
                    sums.add(sum);
                    break;
                }

                if(x % p == 0) 
                    break;
            }

            x+=2;
        }

        return sum;
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




