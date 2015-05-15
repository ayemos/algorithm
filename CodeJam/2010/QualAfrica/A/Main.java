import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void run() throws Exception {
        int nt = ni();

        for(int t = 0; t < nt; t++) {
            int c = ni();
            int k = ni();
            String[] gs = ns().split(" ");

            int[] nums = new int[gs.length];

            for(int i = 0; i < k; i++) 
                nums[i] = Integer.parseInt(gs[i]);

            boolean found = false;
            for(int i = 0; i < k - 1 && !found; i++) {
                for(int j = i + 1; j < k && !found; j++) {
                    if(nums[i] + nums[j] == c) {
                        System.out.println("Case #" + (t + 1) + ": " + 
                                (i + 1) + " " + (j + 1));
                        found = true;
                    }
                }
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




