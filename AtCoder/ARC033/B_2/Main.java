import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    void run() throws Exception {
        String[] nums = br.readLine().split(" ");
        int na = Integer.parseInt(nums[0]);
        int nb = Integer.parseInt(nums[1]);

        String[] aar = br.readLine().split(" ");
        Integer[] ain = new Integer[na];
        for(int i = 0; i < na; i++) 
            ain[i] = Integer.parseInt(aar[i]);
        String[] bar = br.readLine().split(" ");
        Set<Integer> bin = new HashSet<Integer>();
        for(int i = 0; i < nb; i++) 
            bin.add(Integer.parseInt(bar[i]));

        double n = 0; 
        for(int i = 0; i < na; i++) {
            int a = ain[i];
            if(bin.contains(a)) {
                bin.remove(a);
                n++;
            }
        }

        System.out.println(n / (na + nb - n));
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


