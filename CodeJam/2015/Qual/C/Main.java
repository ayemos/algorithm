import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Term {
        char ijk1;
        boolean sign;

        public Term() { this('1', true); }
        public Term(char ijk1, boolean sign) { this.ijk1 = ijk1; this.sign = sign; }
        public String toString() {
            return "(" + (sign ? "" : "-") + ijk1 + ")";
        }
    }

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            String[] nums = ns().split(" ");
            long l = Long.parseLong(nums[0]);
            long x = Long.parseLong(nums[1]);

            StringBuffer str = new StringBuffer();
            String source = ns();
            boolean found = false;
            Term term = new Term('1', true);
            char[] target = {'i', 'j', 'k'};
            int c = 0;
            while(true) {
                if(str.length() == 0) {
                    if(x > 0) {
                        str.append(source);
                        x--;
                    } else {
 //                       System.out.println(c);
                        found = c == 3 && term.ijk1 == '1' && term.sign;
                        break;
                    }
                }

                term = calc(term, new Term(str.charAt(0), true));
//                System.out.println(term);
                str.deleteCharAt(0);
                if(c < 3 && term.sign && term.ijk1 == target[c]) {
                    term.ijk1 = '1';
                    term.sign = true;
                    c++;
                }
            }

            gcjPrint(found ? "YES" : "NO", t + 1);
        }
    }

    Term calc(Term a, Term b) {
        Term ret = new Term();
        boolean sign = !(a.sign ^ b.sign);
        switch(a.ijk1) {
            case 'i':
                switch(b.ijk1) {
                    case 'i':
                        ret.ijk1 = '1';
                        sign = !sign;
                        break;
                    case 'j':
                        ret.ijk1 = 'k';
                        break;
                    case 'k':
                        ret.ijk1 = 'j';
                        sign = !sign;
                        break;
                }
                break;
            case 'j':
                switch(b.ijk1) {
                    case 'i':
                        ret.ijk1 = 'k';
                        sign = !sign;
                        break;
                    case 'j':
                        ret.ijk1 = '1';
                        sign = !sign;
                        break;
                    case 'k':
                        ret.ijk1 = 'i';
                        break;
                }
                break;
            case 'k':
                switch(b.ijk1) {
                    case 'i':
                        ret.ijk1 = 'j';
                        break;
                    case 'j':
                        ret.ijk1 = 'i';
                        sign = !sign;
                        break;
                    case 'k':
                        ret.ijk1 = '1';
                        sign = !sign;
                        break;
                }
                break;
            case '1':
                ret.ijk1 = b.ijk1;
        }
        ret.sign = sign;
        return ret;
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

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




