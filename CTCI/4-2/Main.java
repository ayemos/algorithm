import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 有向グラフNで0からnに到達できるかどうか。
 */

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int n;
    int[][] graph;
    boolean[] visited;

    void run() throws Exception {
        n = ni();
        graph = new int[n][n];
        visited = new boolean[n];
        
        String[] row;
        for(int i = 0; i < n; i++) {
            row = ns().split(" ");
            for(int j = 0; j < n; j++) {
                graph[j][i] = Integer.parseInt(row[j]);
            }
        }

        Deque<Integer> deque = new ArrayDeque<Integer>();
        deque.offer(0);

        while(!deque.isEmpty()) {
            System.out.println(deque);
            int current = deque.poll();
            if(visited[current])
                continue;
            visited[current] = true;

            if(current == n - 1) {
                System.out.println("OK");
                return;
            }

            for(int i = 0; i < n; i++) {
                if(graph[i][current] == 1) {
                    deque.offer(i);
                }
            }

        }

        System.out.println("NG");
        return;
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




