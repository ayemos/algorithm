import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * n個の括弧の対応のとれている組み合わせ全てを出力
 */
public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int[][] memo;
    int n;

    void run() throws Exception {
        n = ni();
        memo = new int[n][n];
        List<String> res = new ArrayList<String>();
        addParen(0, 0, new char[n*2], res, 0);
        System.out.println(res);
    }

    void addParen(int left, int right, char[] str, List<String> res, int count) {
        if(left < right) return;

        if(left == n && right == n) {
            res.add(String.copyValueOf(str));
        } else {
            if(left < n) {
                str[count] = '(';
                addParen(left + 1, right, str, res, count+1);
            }

            if(left > right) {
                str[count] = ')';
                addParen(left, right + 1, str, res, count+1);
            }
        }
    }

    int ni() throws Exception {
        return Integer.parseInt(br.readLine().trim());
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




