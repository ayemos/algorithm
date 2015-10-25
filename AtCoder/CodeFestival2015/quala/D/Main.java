import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String[] nums = ns().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        
        int[] sei = new int[m];
        for(int i = 0; i < m; i++) {
            sei[i] = ni();
        }

        int l = 0, r = m - 1;
        int max = 0;
        int d1, d2;
        while(r - l > 3) {
            d1 = sei[l + 1] - sei[l];
            d2 = sei[r] - sei[r - 1];
            System.out.println("d1:d2 -> " + d1 + ":" + d2);
            System.out.println("l:r -> " + l + ":" + r);
            if(d1 < d2) {
                max = Math.max(d1, max);
                l++;
            } else {
                max = Math.max(d2, max);
                r--;
            }
            System.out.println(max);
        }

        d1 = sei[l + 1] - sei[l];
        d2 = sei[r] - sei[r - 1];
        if(d1 < d2) {
            max = Math.max(d1, max);
            l++;
            max = Math.max((r - l) / 2, max);
        } else if(d1 > d2) {
            max = Math.max(d2, max);
            r--;
            max = Math.max((r - l) / 2, max);
        } else {
            max = Math.max((d1 / 4) * 3 + d1 % 4, max);
        }

        System.out.println(max);
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




