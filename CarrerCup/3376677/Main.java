import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void run() throws Exception {
        int tar = ni();
        String[] ss = ns().split(" ");
        int[] scores = new int[ss.length];
        for(int i = 0; i < ss.length; i++) 
            scores[i] = Integer.parseInt(ss[i]);

        System.out.println(countScore(scores, tar));
    }

    int countScore(int[] scores, int tar) {
        int l = 0;
        int r = scores.length;
        int p;

        while(r > l) {
            p = (r - l) / 2;
            if(scores[p] > tar) {
                r = p - 1;
            } else if(scores[p] < tar) {
                l = p + 1;
            } else {
                // found!
                int tmpl = p - 1;
                int tmpr = p + 1;
                while(scores[tmpl] == tar)
                    tmpl--;
                while(scores[tmpr] == tar)
                    tmpr++;
                return tmpr - tmpl - 1;
            }
        }
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

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




