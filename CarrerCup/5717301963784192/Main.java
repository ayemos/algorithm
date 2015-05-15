import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// brace expansion
public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    class Result {
        List<String> res;
        int next;
        public Result(List<String> res, int next) { this.res = res; this.next = next; }
    }

    void run() throws Exception {
        String line;
        

        while((line = br.readLine()) != null) 
            for(String s : expand(line, 0).res) 
                System.out.println(s);
    }

    Result expand(String str, int i) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();

        char c;
        boolean fin = false;
        String tmp = "";
        while(!fin && i < str.length()) {
            c = str.charAt(i++);
            switch (c) {
                case '(':
                    Result r = expand(str, i);
                    if(sb.length() > 0) 
                        r.res = multiple(sb.toString(), r.res);
                    sb.setLength(0);
                    res = multiple(res, r.res);
                    i = r.next;
                    break;
                case ',':
                    res.addAll(multiple(res, sb.toString()));
                    sb.setLength(0);
                    break;
                case ')':
                    fin = true;
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        if(sb.length() > 0) 
            res.add(sb.toString());

        System.out.println("ret: " + res);
        return new Result(res, i);
    }

    List<String> multiple(String str, List<String> a) {
        List<String> tmp = new ArrayList<String>();
        tmp.add(str);
        return multiple(tmp, a);
    }

    List<String> multiple(List<String> a, String str) {
        List<String> tmp = new ArrayList<String>();
        tmp.add(str);
        return multiple(a, tmp);
    }

    List<String> multiple(List<String> a, List<String> b) {
        if(a.isEmpty()) return b;
        if(b.isEmpty()) return a;

        List<String> res = new ArrayList<String>();
        for(String sb : b) {
            for(String sa : a) {
                res.add(sa + sb);
            }
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




