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

    void run() throws Exception {
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] nums = br.readLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            String[] ds = br.readLine().split("0");

            long max = 0;
            for(String d : ds) {
                if(d.length() < m) 
                    continue;
                long tmp = findMax(d, m);
                if(max < tmp) 
                    max = tmp;
            }


            System.out.println(max);
        }
    }

    long findMax(String dstr, int m) {
        int[] digits = new int[dstr.length()];
        int k = 0;
        for(char c : dstr.toCharArray()) 
            digits[k++] = c - '0';

        long res = 1;
        long max = 1;
        for(int j = 0; j < k; j++) {
            if(j < m) {
                res *= digits[j];
                max = res;
            } else {
                res *= digits[j];
                res /= digits[j - m];
                if(max < res)
                    max = res;
            }
        }
        return max;
    }


    /*
     * Templates
     */
    void dumpArray1(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
    }

    void dumpArray2(Object[][] arr, int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) { 
                System.out.print(arr[i][j]);
                if (i < m - 1) 
                    System.out.print(" ");
            }

            System.out.println(" ");
        }
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




