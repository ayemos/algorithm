import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Range implements Comparable<Range> {
        int left;
        int right;
        public Range(int left, int right) { this.left = left; this.right = right; }

        public int compareTo(Range r) {
            if(this.left > r.left)
                return 1;
            else if(this.left < r.left)
                return -1;
            else
                return 0;
        }

        public String toString() {
            return "(" + this.left + ":" + this.right + ")";
        }
    }

    void run() throws Exception {
        int n = ni();
        Range[] ranges = new Range[n];
        List<Range> results = new ArrayList<Range>();

        String[] nums;
        for(int i = 0; i < n; i++) {
            nums = ns().split(" ");
            ranges[i] = new Range(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }
        Arrays.sort(ranges);

        Range r = ranges[0];
        results.add(r);
        for(int i = 1; i < n; i++) {
            if(ranges[i].left > r.right + 1) {
                // not consequtive
                results.add(ranges[i]);
                r = ranges[i];
            } else {
                if(r.right < ranges[i].right)
                    r.right = ranges[i].right;
            }
        }

        System.out.println(results);
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




