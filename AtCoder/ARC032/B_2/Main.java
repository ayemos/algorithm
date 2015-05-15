import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    int[] nodes;

    void run() throws Exception {
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        nodes = new int[n];
        for(int i = 0; i < n; i++) 
            nodes[i] = -1;

        for(int i = 0; i < m; i++) {
            String[] in = br.readLine().split(" ");
            int fr = Integer.parseInt(in[0]) - 1;
            int to = Integer.parseInt(in[1]) - 1;

            uni(fr, to);
        }

        // count roots
        int c = 0;
        for(int i = 0; i < n; i++) 
            if(find(i) == i) 
                c++;

        System.out.println(c-1);
    }

    int find(int node) {
        if(nodes[node] < 0) 
            return node;
        else 
            return find(nodes[node]);
    }

    void uni(int fr, int to) {
        int nodeA = find(fr);
        int nodeB = find(to);

        if(nodeA < nodeB) {
            // nodeA is bigger
            nodes[nodeA] += nodes[nodeB];
            nodes[nodeB] = nodeA;
        } else {
            nodes[nodeB] += nodes[nodeA];
            nodes[nodeB] = nodeA;
        }
    }

    /*
     * Templates
     */
    void dumpArray1(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
    }

    void dumpArray2(Object[][] arr, int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) { 
                System.out.print(arr[i][j]);
                if (i < m - 1) 
                    System.out.print(" ");
            }

            System.out.println(" ");
        }
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


