
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int MATCH = 3;
    final int MIS_MATCH = -3;
    final int INDEL_START = -8;
    final int INDEL_EXTENSION = -1;
    boolean indeling = false;
    int[][] memo1;
    int[][] memo2;
    int count = 0;

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            String[] ab = line.split("\\|");
            String a = ab[0].trim();
            String b = ab[1].trim();

            memo1 = new int[a.length()+1][b.length()+1];
            memo2 = new int[a.length()+1][b.length()+1];
            for(int i = 0; i < a.length() + 1; i++)
                for(int j = 0; j < b.length() + 1; j++) {
                    memo1[i][j] = Integer.MIN_VALUE;
                    memo2[i][j] = Integer.MIN_VALUE;
                }
            System.out.println(align(a, 0, b, 0, false, 0));
            System.out.println("calls: " + count);
        }
    }

    int align(String ast, int ap, String bst, int bp, boolean indeling, int score) {
        count++;
        if(indeling && memo1[ap][bp] >= score) {
            return score;
        }

        if(ap == ast.length() || bp == bst.length()) {
            int ret = score;
            if(ap < ast.length()) {
                ret += INDEL_EXTENSION * (ast.length() - ap);
                if(!indeling)
                    ret += INDEL_START - INDEL_EXTENSION;
            }

            if(bp < bst.length()) {
                ret += INDEL_EXTENSION * (bst.length() - bp);
                if(!indeling)
                    ret += INDEL_START - INDEL_EXTENSION;
            }
               
            memo[ap][bp] = ret;
            return ret;
        }        

        char a = ast.charAt(ap);
        char b = bst.charAt(bp);
        /*
        System.out.println("+++++++++++++++++++++++++++");
        System.out.println("ast: " + ast);
        System.out.println("bst: " + bst);
        System.out.println("ast(" + ap + "): " + a);
        System.out.println("bst(" + bp + "): " + b);
        System.out.println("indeling: " + indeling);
        System.out.println("score: " + score);
        System.out.println("+++++++++++++++++++++++++++");
        */

        int res_match = Integer.MIN_VALUE;
        int res_mis_match = Integer.MIN_VALUE;
        int res1 = Integer.MIN_VALUE;
        int res2 = Integer.MIN_VALUE;

        if(a==b) 
            res_match = align(ast, ap+1, bst, bp+1, false, score + MATCH);
        else
            res_mis_match = align(ast, ap+1, bst, bp+1, false, score + MIS_MATCH);

        int indel_score = indeling ? INDEL_EXTENSION : INDEL_START;

        res1 = align(ast, ap+1, bst, bp, true, score + indel_score);
        res2 = align(ast, ap, bst, bp+1, true, score + indel_score);
        int res = Math.max(Math.max(res_match, res_mis_match), Math.max(res1, res2));
        memo[ap][bp] = res;
        return res;
    }

    /*
     * Templates
     */
    void dumpArray1(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
    }

    void dumpArray2(Object[][] arr, int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) { 
                System.out.print(arr[i][j]);
                if (i < m - 1) 
                    System.out.print(" ");
            }

            System.out.println(" ");
        }
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


