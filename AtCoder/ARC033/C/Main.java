import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    class SortStack {
        List<Integer> data = new ArrayList<Integer>();

        void add(int n) {
            addSub(0, data.size(), n);
        }

        void addSub(int a, int b, int n) {
            if(b == a) {
                data.add(b, n);
                return;
            }

            int m = (b + a) / 2;

            if(data.get(m) <= n) {
                addSub(m+1, b, n);
            } else {
                addSub(a, m, n);
            }
        }

        void remove(int n) {
            System.out.println(data.get(n-1));
            data.remove(n-1);
        }

        public String toString() {
            return data.toString();
        }
    }

    void run() throws Exception {
        int n = Integer.parseInt(br.readLine());
        String line;
        SortStack ss = new SortStack();

        while((line = br.readLine()) != null) {
            String[] ws = line.split(" ");

            int num = Integer.parseInt(ws[1]);
            if(ws[0].equals("1")) {
                ss.add(num);
            } else {
                ss.remove(num);
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


