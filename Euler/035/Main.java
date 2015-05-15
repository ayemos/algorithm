import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    List<Integer> primes = new ArrayList<Integer>();
    int[] circles;

    void run() throws Exception {
        int n = ni();
        primes = new ArrayList<Integer>();
        int[] memo = new int[n];
        System.out.println(circles[11]);
        int tmp;
        primes.add(2);
        for(int i = 3; i < memo.length; i+=2) {
            if(memo[i] == 0) {
                memo[i] = 1;
                primes.add(i);
                tmp = i + i;
                while(tmp < memo.length) {
                    memo[tmp] = -1;
                    tmp += i;
                }
            }
        }

        long sum = 0;
        for(int p : primes) 
            if(check(p))
                sum += p;

        System.out.println(sum);
    }

    boolean check(int n) {
        if(n < 10)
            return true;

        int tmp = n, c = 0, car = 0;

        while(tmp > 0) {
            if(tmp % 2 == 0)
                return false;
            tmp /= 10;
            c++;
        }

        tmp = n;
        int[] memo = new int[n];
        memo[0] = n;
        for(int i = 1; i < c; i++) {
            car = (tmp / (int)Math.pow(10, c - 1)) % 10;
            tmp -= car * (int)Math.pow(10, c - 1);
            tmp *= 10;
            tmp += car;
            memo[i] = tmp;
            if(!primes.contains(tmp) 
                    || (tmp < n && circles[tmp] == 0)) 
                return false;
        }

        for(int i = 0; i < n; i++) 
            circles[memo[i]] = 1;

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




