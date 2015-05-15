import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    void run() throws Exception {
        String line;
        int[][] board = new int[256][256];
        while((line = br.readLine()) != null) {
            String[] ws = line.split(" ");
            String op = ws[0];
            int a = Integer.parseInt(ws[1]);
            int b = 0;
            if(ws.length == 3) b = Integer.parseInt(ws[2]);

            if(op.equals("SetCol")) {
                for(int i = 0; i < 256; i++) 
                    board[a][i] = b;
            } else if(op.equals("SetRow")) {
                for(int i = 0; i < 256; i++) 
                    board[i][a] = b;
            } else if(op.equals("QueryCol")) {
                int res = 0;
                for(int i = 0; i < 256; i++) 
                    res += board[a][i];
                System.out.println(res);
            } else if(op.equals("QueryRow")) {
                int res = 0;
                for(int i = 0; i < 256; i++) 
                    res += board[i][a];
                System.out.println(res);
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


