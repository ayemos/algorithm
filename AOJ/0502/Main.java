import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;

    enum Direction{
        East,
        West,
        North,
        South
    }

    int[] dice = new int[3];

    int top() {
        return dice[0];
    }

    void dump() {
        System.out.println("  " + (7 - dice[1]));
        System.out.println((7 - dice[2]) + " " + dice[0] + " " + dice[2] + " " + (7 - dice[0]));
        System.out.println("  " + dice[1]);
    }

    void run() throws Exception {
        while(true) {
            int n = ni();
            if(n == 0)
                break;
            init();
            int res = top();
            for(int i = 0; i < n; i++) {
                turn(ns());
                res += top();
            }
            System.out.println(res);
        }
    }

    void init() {
        dice[0] = 1;
        dice[1] = 2;
        dice[2] = 3;
    }

    void turn(String dir) {
        if(dir.equals("East"))
            east();
        else if(dir.equals("West"))
            west();
        else if(dir.equals("South"))
            south();
        else if(dir.equals("North"))
            north();
        else if(dir.equals("Left"))
            left();
        else if(dir.equals("Right"))
            right();
    }

    void east() {
        int tmp = dice[0];
        dice[0] = 7 - dice[2];
        dice[2] = tmp;
    }

    void west() {
        east();
        east();
        east();
    }

    void north() {
        int tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = 7 - tmp;
    }

    void south() {
        north();
        north();
        north();
    }

    void left() {
        right();
        right();
        right();
    }

    void right() {
        int tmp = dice[1];
        dice[1] = dice[2];
        dice[2] = 7 - tmp;
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

    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    long gcd(long a, long b) {
        if(a < b) {
            long tmp = a;
            a = b;
            b = tmp;
        }
        // a >= b
        long mod = a % b;
        if(mod == 0) 
            return b;
        else 
            return gcd(b, mod);
    }

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




