import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int n, l, p;

    void run() throws Exception {
        n = ni();
        int[] as = new int[n + 1];
        int[] bs = new int[n + 1];
        String[] nums;
        for(int i = 1; i <= n; i++) {
            nums = ns().split(" ");
            as[i] = Integer.parseInt(nums[0]);
            bs[i] = Integer.parseInt(nums[1]);
        }

        nums = ns().split(" ");
        l = Integer.parseInt(nums[0]);
        p = Integer.parseInt(nums[1]);

        as[0] = 0;
        bs[0] = 0; // 簡単の為、ゴール地点を空っぽのガソリンスタンドとする

        int res = 0;
        int pos = 0;
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(1, Collections.reverseOrder());

        for(int i = n; i >= 0; i--) {
            int d = l - as[i] - pos;
            System.out.println("pos: " + pos);
            System.out.println("p: " + p);
            System.out.println(que);
            System.out.println("d: " + d);
            System.out.println("res: " + res);
            System.out.println("");

            while(p < d) {
                if(que.isEmpty()) {
                    System.out.println(-1);
                    return;
                } else {
                    p += que.poll();
                    res++;
                }
            }

            pos = l - as[i];
            p -= d;;
            que.add(bs[i]);
        }

        System.out.println(res);
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




