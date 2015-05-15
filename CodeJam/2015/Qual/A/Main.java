import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            String[] ws = ns().split(" ");
            int max = Integer.parseInt(ws[0]);
            String aud = ws[1];
            int stands = 0;
            int friends = 0;
            for(int i = 0; i <= max; i++) {
                int num = aud.charAt(i) - '0';
                /*
                System.out.println("s:f:i:n -> " + stands + ":" + friends +
                        ":" + i + ":" + num);
                        */
                if(num > 0) {
                    if(stands < i) {
                        friends += i - stands;
                        stands += num + i - stands;
                        continue;
                    } else {
                        stands += num;
                    }
                }
            }

            gcjPrint(Integer.toString(friends), t + 1);
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

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




