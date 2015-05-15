import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            int n = ni();
            String[] ds = ns().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) 
                nums[i] = Integer.parseInt(ds[i]);
            gcjPrint(calcFirst(nums, n) + " " + calcSecond(nums, n), t + 1);
        }
    }

    int calcFirst(int[] nums, int n) {
        int count = 0;
        for(int i = 1; i < n; i++) 
            if(nums[i] < nums[i-1]) 
                count += nums[i-1] - nums[i];
        return count;
    }

    int calcSecond(int[] nums, int n) {
        int maxDown = 0;
        int down;
        for(int i = 1; i < n; i++) {
            down = nums[i-1] - nums[i];
            if(down > maxDown)
                maxDown = down;
        }

        int count = 0;
        for(int i = 0; i < n - 1; i++) {
            count += Math.min(nums[i], maxDown);
        }

        return count;
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

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




