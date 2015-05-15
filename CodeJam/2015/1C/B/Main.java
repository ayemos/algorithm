import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            String[] nums = ns().split(" ");
            int k = Integer.parseInt(nums[0]);
            int l = Integer.parseInt(nums[1]);
            int s = Integer.parseInt(nums[2]);
            String source = ns();
            String target = ns();
            System.out.println(calcExp(s, target, source));
        }
    }

    int countCharSet(boolean[] charset) {
        int c = 0;
        for(boolean flg : charset) 
            if(flg)
                c++;
        return c;
    }

    float calcExp(int len, String target, String source) {
        int maxbananas = calcMax(target, len);
        boolean[] charSet = strToSet(source);
        int chars = countCharSet(charSet);
        int maxBananas = calcMax(target, len);
        List<String> cands = compose(target, maxbananas);
        System.out.println(cands);
        if(isAble(target, charSet)) {
            float res = 0.0f;
            for(String cand : cands) {
                float pro = calcPro(cand, source, s);
            }
            

            return res;
        } else {
            return 0.0f;
        }
    }

    float calcPro(String target, String source) {
        float prob = 1.0f;
        int[] counts = strToCount(source);

        for(int i = 0; i < target.length(); i++) {
            prob *= counts[target.charAt(i) - 'A'] / source.length();
        }

        return prob;
    }

    List<String> compose(String target, int max) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        int dup = calcDup(target);
        String part = target.substring(dup, target.length());
        sb.append(target);
        for(int i = 0; i < max; i++) {
            res.add(sb.toString());
            sb.append(part);
        }

        return res;
    }

    boolean isAble(String str, boolean[] charSet) {
        for(char c : str.toCharArray()) 
            if(!charSet[c - 'A'])
                return false;

        return true;
    }

    boolean[] strToSet(String str) {
        boolean[] res = new boolean[26];
        for(char c : str.toCharArray()) 
            res[c - 'A'] = true;

        return res;
    }

    int[] strToCount(String str) {
        int[] res = new int[26];
        for(char c : str.toCharArray()) 
            res[c - 'A']++;

        return res;
    }

    int calcMax(String target, int len) {
        int dup = calcDup(target);
        int strlen = target.length();
        if(len < strlen) return 0;

        return 1 + (len - strlen) / (strlen - dup);
    }

    int calcDup(String str) {
        int n = 0;
        int len = str.length();
        for(int i = 1; i < len; i++) 
            if(str.substring(i, len)
                    .equals(str.substring(0, len - i)))
                return len - i;
        return 0;
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




