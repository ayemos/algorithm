import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int len = ni();
        int n = ni();
        Set<Integer> set = new HashSet<Integer>();
        int[] bars = new int[n];
        for(int i = 0; i < n; i++) {
            bars[i] = ni();
            set.add(bars[i]);
        }
        Arrays.sort(bars);

        int sum;
        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                sum = bars[i] + bars[j];
                if(set.contains(len - sum)) {
                    if(len - sum > bars[j])
                        count++;
                }
            }
        }
        System.out.println(count);
    }

    boolean contains(int[] bars, int target, int begin, int end) {
        if(begin > end) return false;

        int m = (begin + end) / 2;

        if(bars[m] == target) {
            return true;
        } else if(bars[m] > target) {
            return contains(bars, target, m + 1, end);
        } else {
            return contains(bars, target, begin, m - 1);
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

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    long gcd(long a, long b) {
        if(a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        // a >= b
        long mod = a % b;
        if(mod == 0) 
            return b;
        else 
            return gcd(b, mod);
    }

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




