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

    void run() throws Exception {
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            long n = Long.parseLong(br.readLine());
            long x = n;
            long m = (long)Math.floor(Math.sqrt(n));
            long max = n;
            for(int pi : new int[]{2, 3, 5}) {
                if(x == pi) {
                    max = x;
                } else if(x % pi == 0) {
                    x /= pi;
                    while(x % pi == 0 && x > pi) 
                        x /= pi; 
                    max = x;
                }
            }

            long p = 6;
            long[] ds = new long[]{1L, 5L};

            while(true) {
                if(p >= m) break;

                for(long d : ds) {
                    long pi = p + d;
                    if(x == pi) {
                        max = pi;
                    } else if(x % pi == 0) {
                        x /= pi; 
                        while(x % pi == 0 && x > pi)
                            x /= pi; 
                        max = x;
                    } 
                }
                p+=6;
            }

            System.out.println(max);
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




