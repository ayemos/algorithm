import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Entry implements Comparable<Entry> {
        int a, b;
        public Entry(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int compareTo(Entry o) {
            return this.a - o.a;
        }

        public String toString() {
            return "(" + this.a + ", " + this.b + ")";
        }
    }

    void run() throws Exception {
        int n = ni();
        Entry es[] = new Entry[n];
        for(int i = 0; i < n; i++) {
            String nums[] = ns().split(" ");
            es[i] = new Entry(Integer.parseInt(nums[0]),
                    Integer.parseInt(nums[1]));
        }

        Arrays.sort(es);

        int c = 0;
        int tmp;
        for(int i = 0; i < n; i++) {
            int a = es[i].a;
            int b = es[i].b;
            for(int j = 0 ; j < n ; j++) {
                System.out.println(es[j]);
            }

            if(a != b) {
                c++;
                System.out.println("swap: => " + (b - 1) + ":" + i);
                tmp = es[b - 1].a;
                es[b - 1].a = es[i].a;
                es[i].a = tmp;
            }
        }


        System.out.println(c);
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




