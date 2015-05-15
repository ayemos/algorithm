import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    int[] array;

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] nums = line.trim().split(",");
            int n = Integer.parseInt(nums[0]);
            int k = Integer.parseInt(nums[1]);
            int a = Integer.parseInt(nums[2]);
            int b = Integer.parseInt(nums[3]);
            int c = Integer.parseInt(nums[4]);
            int r = Integer.parseInt(nums[5]);

            array = new int[k];
            array[0] = a;
            for(int i = 1; i < k; i++) 
                array[i] = (b * array[i - 1] + c) % r;

            Arrays.sort(array);
            dumpIntArray(array, array.length);
            List<Integer> mins = new ArrayList<Integer>();

            for(int i = 0; i < array[0]; i++)
                mins.add(i);
            for(int i = 1; i < array.length; i++) 
                for(int j = array[i - 1] + 1; j < array[i]; j++) 
                    mins.add(j);
            System.out.println(mins);


            if(n > mins.size()) 
                System.out.println(n);
            else
                System.out.println(mins.get(n));
        }
    }


    /*
     * Templates
     */
    void dumpIntArray(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
        System.out.println("");
    }

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


