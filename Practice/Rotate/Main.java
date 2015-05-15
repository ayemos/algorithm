import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * Googleから指定された練習問題
 *
 * 計算量O(n)を保ちつつ、定数量のメモリのみを使って、文字列の回転を行う
 * アルゴリズム
 *
 * エラトステネスみたい
 * 入れ替えギャップと残りの文字列の割り算が
 *
 */
public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] vars = line.split(" ");
            String tar = vars[0];
            int d = Integer.parseInt(vars[1]);
            int i = 0;
            int n = tar.length();
            int tmp;

            while(true) {
                for(int j = i; j < n - d; j++) 
                    tar = swap(tar, j, j + d);

                if(n % d == 0)
                    break;

                i = n - d;
                tmp = n;
                d = d - tmp % d;
            }

            System.out.println(tar);
        }
    }

    String swap(String str, int i, int j) {
        if(i > str.length() || j > str.length())
            return str;

        if(i > j) {
            int tmp = i;
            i = j;
            j = tmp;
        }

        return str.substring(0, i) + str.charAt(j) + 
            str.substring(i + 1, j) + str.charAt(i) + 
            str.substring(j + 1, str.length());
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




