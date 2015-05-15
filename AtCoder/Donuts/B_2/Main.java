import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    List<Combo> combos = new ArrayList<Combo>();
    int n, m;
    final int MAX = 9;
    int[] idols;

    class Combo {
        int score;
        List<Integer> ids;
        public Combo(int score, List<Integer> ids) {
            this.score = score; this.ids = ids;
        };

        public String toString() {
            return ids.toString() + " : " + score;
        }
    }
    
    void run() throws Exception {
        String[] nums = ns().trim().split(" ");
        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);

        idols = new int[n]; // 基礎能力値
        String[] is = ns().trim().split(" ");
        for(int i = 0; i < n; i++) 
            idols[i] = Integer.parseInt(is[i]);

        int b, c;
        String[] bs; 
        for(int i = 0; i < m; i++) {
            List<Integer> ids = new ArrayList<Integer>();
            bs = ns().trim().split(" "); 
            b = Integer.parseInt(bs[0]);
            c = Integer.parseInt(bs[1]);
            for(int j = 2; j < c + 2; j++) {
                int id = Integer.parseInt(bs[j]) - 1;

                ids.add(id);
            }

            combos.add(new Combo(b, ids));
        }

        System.out.println(solve(new ArrayList<Integer>(), 0, 0));
    }

    int solve(List<Integer> ids, int i, int score) {
        int rem = n - i;
        if(ids.size() >= 9 || i > n - 1){
            return score;
        }
        if(ids.size() + rem <= MAX) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.addAll(ids);
            for(int j = i; j < n; j++) {
                tmp.add(j);
            }
            return calc(tmp);
        }

        List<Integer> tmp = new ArrayList<Integer>();
        tmp.addAll(ids);
        int res = solve(tmp, i+1, score);
        tmp.add(i);
        int res2 = solve(tmp, i+1, score+idols[i]);

        return Math.max(res, res2);
    }

    int calc(List<Integer> ids) {
        int res = 0;
        for(int id : ids)
            res += idols[id];

        for(Combo combo : combos) 
            if(ids.containsAll(combo.ids))
                res += combo.score;

        return res;
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




