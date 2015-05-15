import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String line;
        String[] nums, ws;
        int p;
        int[] a;
        while((line = br.readLine()) != null) {
            ws = line.split(" ");
            nums = ws[0].split(",");
            p = Integer.parseInt(ws[1]);

            a = new int[nums.length];
            for(int i = 0; i < nums.length; i++)
                a[i] = Integer.parseInt(nums[i]);
                    
            int[] res = Puzzle(a, p);


            for(int i = 0; i < res.length; i++)
                System.out.print(res[i] + ", ");
            System.out.println("");

            //,,,
        }
    }


    public static int[] Puzzle(int[] a, int p) {
        if(p == 1)
            return a;
        for(int i = 0; i < a.length; i++){
            if(a[i] < 0) {
                if(a[i] == -100)
                    a[i] -= a[i] % p;

                if(a[i] < 0 && a[i] % p == 0)
                    a[i] += p;
                else 
                    a[i] -= a[i] % p;



            } else if(a[i] % p != 0) { 
                a[i] += p - a[i] % p;
            }
        }

        return a;
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




