
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    String[][] memo;

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] ws = line.trim().split(";");
            if(ws.length != 2) continue;
            String a = ws[0].trim();
            String b = ws[1].trim();
            memo = new String[a.length()][b.length()];

            System.out.println(solve(a, 0, b, 0));
        }
    }

    String solve(String as, int ap, String bs, int bp) {
        if(ap == as.length() || bp == bs.length()) return "";
        if(memo[ap][bp] != null) { 
            return memo[ap][bp];
        }

        char a = as.charAt(ap);
        char b = bs.charAt(bp);
        if(a == b) {
            String ret = solve(as, ap+1, bs, bp+1);
            memo[ap][bp] = a + ret;
            return a + ret;
        }


        String res1 = "";
        String res2 = solve(as, ap+1, bs, bp);
        String res3 = solve(as, ap, bs, bp+1);
        if(res2.length() > res3.length()) 
            res1 = res2;
        else 
            res1 = res3;

        memo[ap][bp] = res1;
        return res1;
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


