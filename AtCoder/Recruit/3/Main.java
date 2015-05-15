import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    Map<Integer, Node> nodes = new HashMap<Integer, Node>();

    class Node {
        PriorityQueue<Integer> succs = 
            new PriorityQueue<Integer>(10);
        int index;

        public Node(int i) {
            this.index = i;
        }

        public void addSucc(int n) {
            this.succs.add(n);
        }

        public String toString() {
            return this.succs.toString();
        }

    }

    void run() throws Exception {
        int n = ni();
        for(int i = 1; i <= n; i++) {
            nodes.put(i, new Node(i));
        }

        String[] nums;
        for(int i = 0; i < n - 1; i++) {
            nums = ns().split(" ");
            nodes.get(Integer.parseInt(nums[0])).addSucc(
                        Integer.parseInt(nums[1]));
            nodes.get(Integer.parseInt(nums[1])).addSucc(
                        Integer.parseInt(nums[0]));
        }
        List<Node> res = new ArrayList<Node>();
        Node now = nodes.get(1);
        res.add(now);

        while(!now.succs.isEmpty()) {
            int succ = now.succs.remove();
            res.add(nodes.get(succ));
            Node next = nodes.get(succ);
            for(int succ2 : next.succs) {
                if(!res.contains(nodes.get(succ2))) {
                    now.addSucc(succ2);
                }
            }
        }

        String r = "";
        for(Node no : res) {
            r += no.index + " ";
        }

        System.out.println(r.substring(0, r.length() - 1));

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




