import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
        Integer[] bin = new Integer[nb];
        for(int i = 0; i < nb; i++) 
            bin[i] = Integer.parseInt(bar[i]);

        Arrays.sort(ain);
        Arrays.sort(bin);
        List<Integer> as = Arrays.asList(ain);
        List<Integer> bs = Arrays.asList(bin);

        double n = 0; 
        for(int i = 0; i < na; i++) {
            int a = as.get(i);
            if(contFast(bs, a)) {
                bs = bs.subList(bs.indexOf(a)+1, bs.size());
                n++;
            }
        }

        // n = a cup b
        System.out.println(n / (na + nb - n));
    }

    boolean contFast(List<Integer> arr, int n) {
        if(arr.size() < 100) return arr.contains(n);
        int m = arr.size() / 2;
        if(arr.get(m) > n) {
            return contFast(arr.subList(0, m), n);
        } else {
            return contFast(arr.subList(m+1, arr.size()), n);
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


