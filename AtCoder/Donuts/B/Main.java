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

        Arrays.sort(idols);

        int b, c;
        String[] bs; 
        for(int i = 0; i < m; i++) {
            List<Integer> ids = new ArrayList<Integer>();
            bs = ns().trim().split(" "); 
            b = Integer.parseInt(bs[0]);
            c = Integer.parseInt(bs[1]);
            for(int j = 2; j < c + 2; j++) {
                int id = Integer.parseInt(bs[j]) - 1;

                b += idols[id];
                ids.add(id);
            }

            combos.add(new Combo(b, ids));
        }

        System.out.println(solve(new ArrayList<Combo>(), 0, 0));
    }

    int solve(List<Combo> cs, int i, int score) {
        System.out.println("cs:i:score" + cs + ":" + i + ":" + score);
        List<Integer> ids = new ArrayList<Integer>();
        for(Combo c : cs) {
            for(int id : ids) {
                if(!ids.contains(id))
                    ids.add(id);
            }

        }

        if(combos.size() < i + 1 || ids.size() > 6) {
            // 残りのアイドルから高い順に取って足して終了
            while(ids.size() < MAX) {
                for(int j = n - 1; j >= 0; j--) 
                    if(!ids.contains(j)) {
                        ids.add(j);
                        score += idols[j];
                        System.out.println(score);
                        break;
                    }
            }
            System.out.println("finally: " + ids);
            
            return score;
        }

        Combo c = combos.get(i);
        List<Combo> tmp = new ArrayList<Combo>();
        tmp.addAll(cs);

        int res1 = solve(tmp, i+1, score);
        List<Integer> tmpid = new ArrayList<Integer>();
        tmpid.addAll(ids);
        for(int id : c.ids) {
            if(!tmpid.contains(id)) 
                tmpid.add(id);
        }

        if(tmpid.size() > 6)
            return res1;

        tmp.add(c);
        int res2 = solve(tmp, i+1, score+c.score);

        return Math.max(res1, res2);
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




