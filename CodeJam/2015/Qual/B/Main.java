import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void run() throws Exception {
        int nt = ni();
        for(int t = 0; t < nt; t++) {
            int d = ni();
            List<Integer> ds = new ArrayList<Integer>();
            String[] ws = ns().split(" ");
            for(String w : ws) 
                ds.add(Integer.parseInt(w));
            gcjPrint(Integer.toString(solve(ds, 0)), t + 1);
        }
    }

    int solve(List<Integer> ds, int count) {
        int max = 0;
        int ind = 0;
        for(int i = 0; i < ds.size(); i++) {
            int d = ds.get(i);
            if(d > max) {
                max = d;
                ind = i;
            }
        }

        if(max <= 3) {
            return count + max;
        } else {
            List<Integer> tmp1 = new ArrayList<Integer>();
            for(int i = 0; i < ds.size(); i++) 
                if(ds.get(i) > 1) 
                    tmp1.add(ds.get(i) - 1);
            int res1 = solve(tmp1, count + 1);

            int min = Integer.MAX_VALUE;
            for(int k = 2; k <= max / 2; k++) {
                List<Integer> tmp2 = new ArrayList<Integer>();
                int m1 = k;
                int m2 = max - k;
                for(int i = 0; i < ds.size(); i++) 
                    if(i == ind) 
                        tmp2.add(m1);
                    else 
                        tmp2.add(ds.get(i));
                    
                tmp2.add(m2);

                int res2 = solve(tmp2, count + 1);
                if(res2 < min)
                    min = res2;
            }
            return Math.min(res1, min);
        }
    }

    int ni() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    String ns() throws Exception {
        return br.readLine();
    }

    void gcjPrint(String str, int t) {
        System.out.println("Case #" + t + ": " + str);
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}

