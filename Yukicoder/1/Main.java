import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Proc {
        int index;
        int money;
        int time;

        public Proc(int index, int money, int time) {
            this.index = index;
            this.money = money;
            this.time  = time;
        }

        public int hashCode() {
            return index + money * 31 + time * 31 * 31;
        }

        public boolean equals(Object obj) {
            if(obj instanceof Proc) {
                Proc proc = (Proc)obj;
                return index == proc.index && money == proc.money && time == time;
            } else {
                return false;
            }
        }

        public String toString() {
            return "PROC(" + index + ":" + money + ":" + time + ")";
        }
    }

    void run() throws Exception {
        String line;
        int n = ni();
        int c = ni();
        int v = ni();
        int[][] graph = new int[n][n];
        int[][] costs = new int[n][n];
        String[] sstr = ns().split(" ");
        String[] tstr = ns().split(" ");
        String[] ystr = ns().split(" ");
        String[] mstr = ns().split(" ");

        for(int i = 0; i < v; i++)  {
            int s, t, y, m;
            s = Integer.parseInt(sstr[i]);
            t = Integer.parseInt(tstr[i]);
            y = Integer.parseInt(ystr[i]);
            m = Integer.parseInt(mstr[i]);
            graph[s-1][t-1] = m;
            costs[s-1][t-1] = y;
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(graph[j][i] + " ");
            }
            System.out.println();
        }

        Proc init = new Proc(1, c, 0);
        Deque<Proc> queue = new ArrayDeque<Proc>();
        int res = Integer.MAX_VALUE;
        queue.offer(init);
        while(!queue.isEmpty()) {
            Proc proc = queue.poll();
            if(proc.index == n) {
                res = Math.min(res, proc.time);
                System.out.println("new min: " + res);
                continue;
            }

            int s = proc.index - 1;
            for(int t = 0; t < n; t++) {
                if(s == 25)
                    System.out.println(graph[s][t]);
                if(graph[s][t] > 0 &&
                        costs[s][t] <= proc.money) {
                    // affordable
                    queue.offer(new Proc(t + 1, proc.money - costs[s][t],
                                proc.time + graph[s][t]));
                }
            }
        }

        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
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




