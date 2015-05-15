
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int MATCH = 3;
    final int MIS_MATCH = -3;
    final int INDEL_START = -8;
    final int INDEL_EXTENSION = -1;
    boolean indeling = false;
    int[][] memo1;
    int[][] memo2;

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] ab = line.split("\\|");
            String a = ab[0].trim();
            String b = ab[1].trim();

            memo1 = new int[a.length()+1][b.length()+1];
            memo2 = new int[a.length()+1][b.length()+1];
            // init
            int score = INDEL_START;
            for(int i = 1; i < a.length() + 1; i++) {
                memo1[i][0] = score;
                memo2[i][0] = score;
                score += INDEL_EXTENSION;
            }
            
            score = INDEL_START;
            for(int i = 1; i < b.length() + 1; i++) {
                memo1[0][i] = score;
                memo2[0][i] = score;
                score += INDEL_EXTENSION;
            }

            for(int i = 1; i < a.length() + 1; i++)
                for(int j = 1; j < b.length() + 1; j++) {
                    memo1[i][j] = Integer.MIN_VALUE;
                    memo2[i][j] = Integer.MIN_VALUE;
                }

            memo1[0][0] = 0;
            memo2[0][0] = 0;
            // init end

            for(int i = 1; i < a.length() + 1; i++) {
                for(int j = 1; j < b.length() + 1; j++) {
                }
            }
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


