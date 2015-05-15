import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Pair {
        int a, b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a + ":" + b;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return this.b == p.b && this.a == p.a;
        }

        public int hashCode() {
            return a + b * 100000;
        }
    }

    void run() throws Exception {
        String[] nums = ns().split(" ");
        int n = Integer.parseInt(nums[0]);
        int c = Integer.parseInt(nums[1]);
        String str = "";
        for(String tmp : ns().split(" ")) {
            str += tmp;
        }

        for(int i = 1; i <= c; i++) {
            Set<Pair> res = new HashSet<Pair>();
            int index = 0;

            while(index < n && index >= 0) {
                index = str.indexOf(Integer.toString(i), index);
                if(index == -1)
                    break;
                
                for(int j = 0; j <= index; j++) {
                    for(int k = index; k < n; k++) {
                        res.add(new Pair(j, k));
                    }
                }
                index++;
            }
            System.out.println(res.size());
        }

    }


    int code(int i, int j, int c) {
        return i + j * c;
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




