import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final int MAX = 10000;

    void run() throws Exception {
        int t = ni();
        int n, c, res, begin;
        long tmp, max;

        List<Long> memo = new ArrayList<Long>();
        int[] maxs = new int[MAX];
        for(int i = 0; i < MAX; i++)
            maxs[i] = -1;

        for(int i = 0; i < t; i++) {
            n = ni();
//            System.out.println("n:maxs[n] = " + n + ":" + maxs[n]);
            if(maxs[n] > 0) {
                System.out.println(maxs[n]);
                continue;
            }
                
            max = 1;
            res = 3;
            for(int j = MAX - 1; j >= 0; j--) {
                if(maxs[j] > 0) {
                    max = maxs[j];
                    res = j-1;
                    break;
                }
            }
//            System.out.println("max:res = " + max + ":" + res);

            for(int j = res; j <= n; j++) {
                /*
                System.out.println("j = " + j);
                System.out.println("max = " + max);
                System.out.println("res = " + res);
                */
                memo.clear();

                c = 1;
                tmp = 10;

                while(tmp < j) 
                    tmp *= 10;

                while(true) {
                    while(tmp < j) {
                        tmp *= 10;
                        c++;
                    }

                 //   System.out.println("tmp = " + tmp);
                    long k = tmp / j;
                    if(memo.contains(tmp)) {
                        break;
                    } else if(tmp == j * k) {
                        c = 0;
                        break;
                    } else {
                        memo.add(tmp);
                        c++;
                        tmp = (tmp - j * k) * 10; 
                    }
                }

                if(c > max) {
                    max = c;
                    res = j;
                }
                maxs[j] = res;
            }
            System.out.println(res);
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




