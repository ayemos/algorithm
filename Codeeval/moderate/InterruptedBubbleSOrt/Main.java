import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] ws = line.split("\\|");
            String[] nums = ws[0].trim().split(" ");
            long n = Math.min(Long.parseLong(ws[1].trim()), nums.length);
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < nums.length - i - 1; j++) {
                    long a = Long.parseLong(nums[j]);
                    long b = Long.parseLong(nums[j + 1]);
                    if(a > b) {
                        String tmp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = tmp;
                    }
                }
            }
            String ret = "";
            for(int i = 0; i < nums.length; i++) 
                ret += nums[i] + " ";

            System.out.println(ret.substring(0, ret.length() - 1));
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


