import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String[] nums = ns().trim().split(" ");
        long n = Long.parseLong(nums[0]);
        int a = Integer.parseInt(nums[1]);
        int b = Integer.parseInt(nums[2]);
        int i = 0;
        long num = 1;
        while(true) {
            num = getNum(i, a);   
            if(num >= n)
                break;
            if(check(num, b)) 
                System.out.println(num);
            i++;
        }
    }

    long getNum(long n, int a) {
        long tmp = 0;
        switch(a) {
            case 3:
                tmp = n * (n + 1) / 2;
                break;
            case 5:
                tmp = n * (3 * n - 1) / 2;
                break;
            case 6:
                tmp = n * (2 * n - 1);
                break;
        }
        return tmp;
    }

    boolean check(long n, int a) {
        double tmp = 0.1;
        switch(a) {
            case 3:
                tmp = (Math.sqrt(8 * n + 1) - 1) / 2;
                break;
            case 5:
                tmp = (Math.sqrt(24 * n + 1) + 1) / 6;
                break;
            case 6:
                tmp = (Math.sqrt(8 * n + 1) + 1) / 4;
                break;
        }

        return (long)tmp == tmp;
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




