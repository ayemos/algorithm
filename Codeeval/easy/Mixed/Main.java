
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
            String[] ws = line.split(",");
            List<String> wl = new ArrayList<String>();
            List<String> nl = new ArrayList<String>();
    
            for(int i = 0; i < ws.length; i++) {
                int num = isNum(ws[i]);
                if(num < 0) {
                    // not num
                    wl.add(ws[i]);
                } else {
                    // is num
                    nl.add(ws[i]);
                }
            }

            String res = "";
            for(int i = 0; i < wl.size(); i++) 
                res += wl.get(i) + ",";

            if(!res.equals("")) {
                res = res.substring(0, res.length() - 1);
                res += "|";
            }
                
            for(int i = 0; i < nl.size(); i++) 
                res += nl.get(i) + ",";

            if(!res.equals("")) 
                res = res.substring(0, res.length() - 1);

            System.out.println(res);
        }
    }


    int isNum(String str) {
        try {
            return Integer.parseInt(str); 
        } catch (Exception e) {
            return -1;
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


