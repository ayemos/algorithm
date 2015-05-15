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
    final int BIG_MOD = 1000000007;
    final int MAX_DIGITS = 200000;

    void run() throws Exception {
        int t = nn();
        int n, k;
        long sum;
        int[] digits = new int[MAX_DIGITS];
        long[] memo = new long[10001];
        for(int i = 0; i < t; i++) {
            digits = new int[MAX_DIGITS];
            n = nn();
            if(memo[n-1] > 0) {
                System.out.println(memo[n-1]);
                continue;
            }

            digits[0] = 1;
            k = 1;

            int c = 0;
            sum = 0;
            for(int j = 0; j < n; j++) {
                for(int l = 0; l < k; l++) {
                    // 0 ~ k has digit
                    digits[l] = digits[l] * 2 + c;
                    if(digits[l] >= 10) {
                        digits[l] -= 10;
                        c = 1;
                        if(l == k - 1)
                            k++;
                    } else {
                        c = 0;
                    }
                }
            }

            for(int j = 0; j < k; j++) {
//                System.out.print(digits[j] + " ");
                sum += digits[j];
            }

 //           System.out.println("");
            memo[n-1] = sum;
            System.out.println(sum);
            for(int j = 0; j < k; j++) {
                digits[j] = 0;
            }
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
        return Integer.parseInt(br.readLine().trim());
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




