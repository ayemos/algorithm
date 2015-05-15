import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    class Node {
        boolean visited;
        List<Node> succs = new ArrayList<Node>();
        public Node() { this.visited = false; }
    }

    void run() throws Exception {
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        List<Node> nodes = new ArrayList<Node>();
        for(int i = 0; i < n; i++)
            nodes.add(new Node());
        
        String line;
        while((line = br.readLine()) != null) {
            String[] ab = line.split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;
            
            nodes.get(a).succs.add(nodes.get(b));
            nodes.get(b).succs.add(nodes.get(a));
        }

        int j = 0;
        int c = 0;
        while(j < n) {
            // Next node not visited yet
            Node node = nodes.get(j);
            j++;

            if(node.visited) 
                continue;

//            dumpNodes(nodes);
            node.visited = true;
            c++;
            
            // mark all successor* s
            Deque<Node> queue = new LinkedList<Node>();
            queue.offer(node);
            while(!queue.isEmpty()) {
                Node tmp = queue.poll();
                tmp.visited = true;

                for(Node succ : tmp.succs) 
                    if(!succ.visited)
                        queue.offer(succ);
            }
        }

        System.out.println(c-1);
    }

    public void dumpNodes(List<Node> nodes) {
        for(Node n : nodes) {
            System.out.println(n.succs);
            System.out.println(n.visited);
        }
        System.out.println(" ");
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


