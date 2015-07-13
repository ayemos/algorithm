import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    Stack<Integer> a = new Stack<Integer>();
    Stack<Integer> b = new Stack<Integer>();
    Stack<Integer> c = new Stack<Integer>();
    Set<Problem> visited = new HashSet<Problem>();

    class Problem {
        Stack<Integer> a, b, c;
        int count;
        public Problem(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c, int count) {
            this.a = (Stack)a.clone(); 
            this.b = (Stack)b.clone(); 
            this.c = (Stack)c.clone();
            this.count = count;
        }

        public int hashCode() {
            return a.hashCode() + 31 * b.hashCode() + 31 * 31 * c.hashCode() + 31 * 31 * 31 * count;
        }

        public boolean equals(Object obj) {
            if(obj instanceof Problem) {
                Problem p = (Problem)obj;
                return a.equals(p.a) && b.equals(p.b) && c.equals(p.c) && count == p.count;
            } else {
                return false;
            }
        }
    }

    void run() throws Exception {
        while(true) {
            a.clear();
            b.clear();
            c.clear();
            String[] nums = ns().split(" ");
            int n = Integer.parseInt(nums[0]);
            int m = Integer.parseInt(nums[1]);
            if(n == 0 && m == 0)
                break;


            for(int i = 0; i < 3; i++) {
                String[] datas = ns().split(" ");
                int k = Integer.parseInt(datas[0]);
                for(int j = 0; j < k; j++) {
                    stackAt(i).push(Integer.parseInt(datas[j+1]));
                }
            }

            Deque<Problem> queue = new ArrayDeque<Problem>();
            queue.offer(new Problem(a, b, c, 0));
            while(!queue.isEmpty()) {
                Problem p = queue.poll();
            }
        }
    }

    Stack<Integer> stackAt(int n) {
        switch(n) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
        }
        return null;
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




