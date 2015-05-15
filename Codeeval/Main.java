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
            //,,,
        }
    }


    /*
     * Templates
     */
    void dumpArray1(Object[] arr, int n) {
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < n; i++) 
            sb.append(arr[i] + " ");

        System.out.println(sb.toString().substring(0, sb.length()));
    }

    void dumpArray2(Object[][] arr, int m, int n) {
        StringBuffer sb = new StringBuffer();
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) { 
                sb.append(arr[i] + " ");
            }

            sb.deleteCharAt(sb.length());
            sb.append("\n");
        }

        System.out.println(sb.toString().substring(0, sb.length()));
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


