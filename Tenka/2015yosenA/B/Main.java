import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Range {
        long beg, end;
        boolean unknown;
        boolean ret;
        public Range(long beg, long end) {
            this.beg = beg;
            this.end = end;
            this.unknown = false;
            this.ret = false;
        }

        public boolean in(Range r) {
            return this.beg >= r.beg && this.end <= r.end;
        }

        public Range intsect(Range r) {
            if(this.end <= r.beg || this.beg >= r.end)
                return null;

            return new Range(Math.max(this.beg, r.beg), Math.min(this.end, r.end));
        }

        public long len() {
            return this.end - this.beg;
        }

        public String toString() {
            return "(" + this.beg + ", " + this.end + ")";
        }
    }

    long t2m(String time) {
        String[] times = time.split(":");
        String[] msecs = times[2].split("\\.");
        long msec = Long.parseLong(msecs[0]) * 1000 + Long.parseLong(msecs[1]);
        return msec + Long.parseLong(times[0]) * 1000 * 60 * 60 + Long.parseLong(times[1]) * 1000 * 60;
    }

    void run() throws Exception {
        int n = ni();
        Range[] ranges = new Range[n];
        Range proof = new Range(0, Long.MAX_VALUE);
        for(int i = 0; i < n; i++) {
            String[] times = ns().split(" ");
            long beg = t2m(times[0]);
            long end = t2m(times[1]);
            if(beg >= end) {
                end += 1000;
                ranges[i] = new Range(beg, end);
                ranges[i].ret = true;
                proof = proof.intsect(ranges[i]);
                continue;
            }

            ranges[i] = new Range(beg, end);
        }

        /*
        System.out.println(proof);
        dumpObjArr(ranges, n);
        */

        for(int i = 0; i < n; i++) {
            Range tmp = new Range(ranges[i].beg, ranges[i].end + 1000);
            if(proof.in(ranges[i])) {
                if(!ranges[i].ret)
                    ranges[i].end += 1000;
            } else if(!ranges[i].ret && proof.intsect(tmp) != null) {
                ranges[i].unknown = true;
            }
        }

        //dumpObjArr(ranges, n);

        for(int i = 0; i < n; i++) {
            if(ranges[i].unknown) {
                System.out.println("-1");
            } else {
                System.out.println(ranges[i].len());
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




