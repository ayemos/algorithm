import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    int n;

    void run() throws Exception {
        n = ni();

        List<String> res = new ArrayList<String>();
        addParen(0, 0, 0, new char[n * n], res);
        System.out.println(res);
    }

    void addParen(int left, int right, int count, char[] str, List<String> res) {
        if(left < right) return;

        if(left == n && right == n) {
            // finish
            res.add(String.copyValueOf(str));
            return;
        } else {
            if(left < n) {
                str[count] = '(';
                addParen(left + 1, right, count + 1, str, res);
            }

            if(left > right) {
                str[count] = ')';
                addParen(left, right + 1, count + 1, str, res);
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




