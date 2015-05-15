import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    void run() throws Exception {
        String line = br.readLine();
        String str = "";
        int i = 0;
        if(line.indexOf("C") > 0) {
            i = line.indexOf("C"); 
            str = line.substring(0, i);
            str += "|";
            str += line.substring(i+1, line.length());
        } else if(line.indexOf("_") > 0) {
            i = line.indexOf("_");
            str = line.substring(0, i);
            str += "|";
            str += line.substring(i+1, line.length());
        }
        System.out.println(str);

        while((line = br.readLine()) != null) {
            int cp = line.indexOf("C");
            int bp = line.indexOf("_");
            str = "";
            if(cp >= i - 1 && cp <= i + 1) {
                str = line.substring(0, cp);
                if(cp == i - 1) 
                    str += "/";
                else if(cp == i)
                    str += "|";
                else if(cp == i + 1)
                    str += "\\";
                str += line.substring(cp+1, line.length());
                i = cp;
            } else if(bp >= i - 1 && bp <= i + 1) {
                str = line.substring(0, bp);
                if(bp == i - 1) 
                    str += "/";
                else if(bp == i)
                    str += "|";
                else if(bp == i + 1)
                    str += "\\";
                str += line.substring(bp+1, line.length());
                i = bp;
            }
            System.out.println(str);
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


