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
    final int BIG_MOD = 1000000007;
    int debug = 0;
    final String[] NUMBERS = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    final String[] TYS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    final String[] TES = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final String[] MILS = {"", "Thousand", "Million", "Billion", "Trillion"};

    void run(int debug) throws Exception {
        this.debug = debug;

        int t = ni();
        long n;
        int mils;
        String res;
//        int stn = 0;
        for(int i = 0; i < t; i++) {
            n = nl(); 
            if(n == 0) {
                System.out.println("Zero");
                continue;
            }

            mils = 0;
            res = "";

            while(n > 0) {
                String tmp = numToStr((int)(n % 1000), mils);
                if(!tmp.equals(""))
                    res = numToStr((int)(n % 1000), mils) + " " + res;
                n /= 1000;
                mils++;
            }

            System.out.println(res.trim());
            /*
            String[] ws = res.trim().split(" ");
            System.out.println(res);

            for(String st: ws) {
                stn += st.length();
            }
            System.out.println(stn);
            */
        }
        //System.out.println(stn);
    }


    String numToStr(int num, int mils) {
        if(num == 0)
            return "";
        String res = "";
        if(num >= 100) {
            int huns = (num / 100) % 10;
            res += NUMBERS[huns] + " Hundred ";
            num = num - huns * 100;
        }

        if(num == 0) {
            // do nothing.
        }else if(num >= 10 && num <= 19) {
            res += TES[num - 10] + " ";
        } else {
            int tys = (num / 10) % 10;
            if(tys > 0) {
                res += TYS[tys] + " ";
            }
            res += NUMBERS[num - tys * 10] + " ";
        }
        
        return res.trim() + " " + MILS[mils];
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

    void log(String str) {
        if(debug == 1) {
            System.out.println(str);
        }
    }

    public static void main(String[] args) throws Exception {
        /*
        int debug = 0;
        try {
            debug = Integer.parseInt(args[0]);
        } catch (Exception e) { }

        */
        new Main().run(0);
    }
}




