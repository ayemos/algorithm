import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String line, res;
        while((line = br.readLine()) != null) {
            System.out.println(Puzzle(line));
        }
    }

    public static String Puzzle(String line) {
        String res = "";
        int d, c, i;
        res = "";
        c = 0;
        d = 4;
        i = 0;
        while(i < line.length()) {
            res += line.charAt(i);
            c++;
            i+=d;
            if(c == line.length())
                break;
            if(c > 0 && c % 5 == 0)
                res += " ";
        }

        i = 1;
        d = 2;
        while(i < line.length()) {
            res += line.charAt(i);
            c++;
            i+=d;
            if(c == line.length())
                break;
            if(c > 0 && c % 5 == 0)
                res += " ";
        }

        i = 2;
        d = 4;
        while(i < line.length()) {
            res += line.charAt(i);
            c++;
            i+=d;
            if(c == line.length())
                break;
            if(c > 0 && c % 5 == 0)
                res += " ";
        }

        return res;
    }


    /*
     * Templates
     */
    void dumpObjArr(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
        System.out.println("");
    }

    void dumpObjArr2(Object[][] arr, int m, int n) {
        for(int j = 0; j < m; j++) 
            dumpObjArr(arr[j], n);
    }

    int ni() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    long nl() throws Exception {
        return Long.parseLong(br.readLine().trim());
    }

    String ns() throws Exception {
        return br.readLine();
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




