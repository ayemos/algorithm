import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    Deque<String> stack = new LinkedList<String>();

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] ins = line.split(" ");

            for(int i = 0; i < ins.length; i++) {
                String in = ins[i];
                double a = checkNumeric(in);
                if(a >= 0) {
                    if(stack.isEmpty()) {
                        stack.addFirst(in);
                        continue;
                    }

                    // in is number
                    String next = stack.removeFirst();
                    double b = checkNumeric(next);
                    if(b >= 0) {
                        String op = stack.removeFirst();
                        double res = 0;
                        // calc
                        switch(op) {
                            case "+":
                                res = b + a;
                                break;
                            case "/":
                                res = b / a;
                                break;
                            case "*":
                                res = b * a;
                                break;
                        }

                        stack.addFirst(Double.toString(res));
                    } else {
                        stack.addFirst(next);
                        stack.addFirst(in);
                    }
                } else {
                    // in is not number
                    stack.addFirst(in); 
                }
            }

            System.out.println(Math.round(Double.parseDouble(stack.removeFirst())));
        }
    }

    double checkNumeric(String str) {  
        try {  
            return Double.parseDouble(str);  
        } catch(NumberFormatException nfe) {  
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


