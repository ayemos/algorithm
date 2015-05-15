import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Work implements Comparable<Work> {
        int start;
        int end;
        public Work(int start, int end) { this.start = start; this.end = end; }

        public int compareTo(Work w) {
            return this.end > w.end ? 1 : (this.end == w.end ? 0 : -1);
        }

        public String toString() {
            return "(" + start + ":" + end + ")";
        }
    }

    void run() throws Exception {
        int n = ni();
        Work[] works = new Work[n];
        String[] nums;

        for(int i = 0; i < n; i++) {
            nums = ns().split(" ");
            works[i] = new Work(Integer.parseInt(nums[0]), Integer.parseInt(nums[1]));
        }

        Arrays.sort(works);

        int time = 0;
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(works[i].start >= time) {
                time = works[i].end;
                count++;
            }
        }

        System.out.println(count);
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




