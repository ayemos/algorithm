import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    List<Integer> primes = new ArrayList<Integer>();

    void run() throws Exception {
        String line;
        int n = Integer.parseInt(br.readLine());
        primes.add(2);
        primes.add(3);
        for(int i = 0; i < n; i++) 
            System.out.println(getPrime(Integer.parseInt(br.readLine())));
    }

    int getPrime(int n) {
        if (n < primes.size()) 
            return primes.get(n - 1);

        int x = primes.get(primes.size()-1);

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




