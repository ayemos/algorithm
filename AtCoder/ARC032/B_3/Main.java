import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

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

        String line;
        while((line = br.readLine()) != null) {
            String[] ab = line.split(" ");
            int a = Integer.parseInt(ab[0]) - 1;
            int b = Integer.parseInt(ab[1]) - 1;

            uni(a, b);
        }
        
        int c = 0;
        for(int i = 0; i < n; i++) 
            if(nodes[i] < 0)
                c++;

        System.out.println(c-1);
    }

    int find(int n) {
        if(nodes[n] < 0)
            return n;
        return nodes[n] = find(nodes[n]);
    }

    void uni(int a, int b) {
        int ar = find(a);
        int br = find(b);
        if (ar == br) return;

        if(nodes[ar] > nodes[br]) {
            nodes[ar] += nodes[br];
            nodes[br] = ar;
        } else {
            nodes[br] += nodes[ar];
            nodes[ar] = br;
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


