import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final int[] primes = {2, 3, 5, 7, 11, 13, 17};

    void run() throws Exception {
        int n = ni();
        long start, end;
        long sum = 0;
        int d = 1;

        //頭0でn-1Panのパターン
        start = (long)Math.pow(10, n - 1);
        end = (long)Math.pow(10, n) - 1;

        if(n > 3) {
            // n > 3のときは奇数に限定してよし
            d++;
            start++; // 100..01
        }

        for(long i = start; i <= end; i+=d) {
            if(!isPan2(i, n))
                continue;

            for(int j = 0; j <= n - 3; j++) {
                if(((i / (int)Math.pow(10, n - 3 - j)) % 1000) % primes[j] != 0)
                    break;
                if(j == n - 3) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }

        if(n > 3) {
            // n > 3のときは奇数に限定してよし
            d++;
        }

        // 頭1~9のパターン
        start = (long)Math.pow(10, n);
        end = (long)Math.pow(10, n + 1) - 1;
        for(long i = start; i <= end; i+=d) {
            if(!isPan(i, n))
                continue;

            for(int j = 0; j <= n - 3; j++) {
                if(((i / (int)Math.pow(10, n - 3 - j)) % 1000) % primes[j] != 0)
                    break;
                if(j == n - 3) {
                    System.out.println(i);
                    sum += i;
                }
            }
        }

        System.out.println(sum);
    }

    long count(int i, int j, int n) {
        List<Long> res = new ArrayList<Long>();
        long tmp, c;
        for(long a = (long)Math.pow(10, i - 1); a < (long)Math.pow(10, i); a++) {
            for(long b = (long)Math.pow(10, j - 1); b < (long)Math.pow(10, j); b++) {
                c = a * b;
                if(isPan(concat(concat(a, b), c), n))
                    if(!res.contains(c))
                        res.add(c);
            }
        }

        long sum = 0;
        for(long l : res) 
            sum += l;
        return sum;
    }

    long concat(long a, long b) {
        int c = 0;
        long tmp = b;

        while(tmp > 0) {
            tmp /= 10;
            c++;
        }

        return a * (long)Math.pow(10, c) + b;
    }

    boolean isPan(long n, int k) {
        int i = k + 1;
        int[] digits = new int[i];
        long tmp = n;
        int p;
        while(tmp > 0) {
            p = (int)(tmp % 10);
            if(p < 0 || p >= digits.length || digits[p] >= 1)
                return false;
            digits[p]++;
            tmp /= 10;
        }

        for(int j = 0; j < i; j++) 
            if(digits[j] == 0)
                return false;

        return true;
    }

    boolean isPan2(long n, int k) {
        int i = k;
        int[] digits = new int[i+1];
        long tmp = n;
        int p;
        while(tmp > 0) {
            p = (int)(tmp % 10);
            if(p < 0 || p >= digits.length || digits[p] >= 1)
                return false;
            digits[p]++;
            tmp /= 10;
        }

        for(int j = 0; j < i; j++) 
            if(digits[j] == 0)
                return false;

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




