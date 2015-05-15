import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String[] nums = ns().trim().split(" ");
        int n = Integer.parseInt(nums[0]); // ~ 100000
        int k = Integer.parseInt(nums[1]); // 8 or 9

        int[] digits;

        int c, tmp;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 2; i < n; i++) {
            digits = new int[k+1];
            c = 1;
            while(true) {
                tmp = fill(digits, i * c);
                if(tmp == 0) {
                    c++;
                    continue;
                } else if(tmp == 1) {
                    res.add(i);
                    break;
                } else if(tmp == -1) {
                    break;
                }
            }
        }

        for(int i : res) {
            System.out.println(i);
        }
    }

    void dump(int[] digits) {
        for(int i = 0; i < digits.length; i++) {
            System.out.print(i + ":" + digits[i] + " ");
        }
        System.out.println("");
    }

    // return 1 if filling is perfect
    // return 0 if digits need to be filled again
    // return -1 if digits is overflown
    int fill(int[] digits, int n) {
        while(n > 0) {
            int d = n % 10; 
            if(d == 0 || d >= digits.length || digits[d] > 0) 
                return -1;
            digits[d]++;
            n /= 10;
        }

        for(int i = 1; i < digits.length; i++) 
            if(digits[i] != 1) 
                return 0;

        return 1;
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




