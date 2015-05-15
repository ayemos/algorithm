
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    String[][] marks = 
    {
        {"I", "V"}, {"X", "L"}, {"C", "D"}, {"M", ""}
    };

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            int num = Integer.parseInt(line);

            int exp = 0;
            String res = "";
            while(num > 0) {
                String nStr = "";
                int n = num % 10;
                if(n == 9) {
                    nStr = marks[exp][0] + marks[exp+1][0];
                } else if(n == 4) {
                    nStr = marks[exp][0] + marks[exp][1];
                } else {
                    if(n >= 5) {
                        n -= 5;
                        nStr += marks[exp][1];
                    }

                    for(int i = 0; i < n; i++) 
                        nStr += marks[exp][0];
                }

                res = nStr + res;
                num /= 10;
                exp++;
            }
            System.out.println(res);
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


