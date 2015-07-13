import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MozaicSolver {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    char[][] board;
    int w, h;

    class Point {
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }
    }

    void run() throws Exception {
        w = ni();
        h = ni();
        board = new char[h][w];
        char[][] answer = new char[h][w];
        char[] line;
        for(int j = 0; j < h; j++) {
            line = ns().toCharArray();
            for(int i = 0; i < w; i++) {
                board[j][i] = line[i];
                answer[j][i] = '*';
            }
        }

        for(int j = 0; j < h; j++) {
            for(int i = 0; i < w; i++) 
                System.out.print(board[j][i]);
            System.out.println("");
        }

        solve(answer);
    }

    boolean solve(char[][] answer) {
        // check all
        boolean mod = true;
        while(mod) {
            mod = false;
            for(int i = 0; i < w; i++) {
                for(int j = 0; j < h; j++) {
                    if(board[j][i] == '-')
                        continue;

                    int n = board[j][i] - '0';
                    int white = countWhite(i, j, answer);
                    int black = countBlack(i, j, answer);
                    int arbit = countArbit(i, j, answer);

                    // return if invalid
                    if(black > n || black + arbit < n) {
                        //System.out.println("INVALID!(" + i + ", " + j + ")");
                        return false;
                    }

                    if(black == n && arbit > 0) {
                        check(answer, i, j, false);
                        mod = true;
                    }

                    if(arbit + black == n && arbit > 0) {
                        check(answer, i, j, true);
                        mod = true;
                    }
                }
            }
        }

        if(complete(answer)) {
            dump(answer);
            return true;
        }

        int mini1 = 0, minj1 = 0;
        int mini2 = 0, minj2 = 0;
        int mindiff1 = 9;
        int mindiff2 = 9;
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(board[j][i] == '-')
                    continue;

                int n = board[j][i] - '0';
                int white = countWhite(i, j, answer);
                int black = countBlack(i, j, answer);
                int arbit = countArbit(i, j, answer);

                if(arbit > 0) {
                    if(black < n) {
                        if(n - black < mindiff1) {
                            mini1 = i;
                            minj1 = j;
                            mindiff1 = n - black;
                        }
                    }

                    if(9 - white > n) {
                        int diff = 9 - white - n;
                        if(diff < mindiff2) {
                            mini2 = i;
                            minj2 = j;
                            mindiff2 = diff;
                        }
                    }
                }
            }
        }

        char[][] copy = copy(answer);
        checkOne(copy, mini1, minj1, true);
        if(solve(copy))
            return true;
        copy = copy(answer);
        checkOne(copy, mini1, minj1, false);
        if(solve(copy))
            return true;

        /*
        copy = copy(answer);
        checkOne(copy, mini2, minj2, false);
        if(solve(copy))
            return true;
        copy = copy(answer);
        checkOne(copy, mini2, minj2, true);
        if(solve(copy))
            return true;

            */
        return false;
    }

    char[][] copy(char[][] answer) {
        char[][] res = new char[h][w];
        for(int i = 0; i < w; i++) 
            for(int j = 0; j < h; j++) 
                res[j][i] = answer[j][i];
        return res;
    }

    boolean complete(char[][] answer) {
        for(int i = 0; i < w; i++) 
            for(int j = 0; j < h; j++) 
                if(answer[j][i] == '*')
                    return false;
        return true;
    }

    Point checkOne(char[][] answer, int x, int y, boolean black) {
        //System.out.println("Check(" + x + ", " + y + ")");
        for(int i = y - 1; i <= y + 1; i++) 
            for(int j = x - 1; j <= x + 1; j++) 
                if(i >= 0 && i < board.length &&
                        j >= 0 && j < board[0].length)
                    if(answer[i][j] == '*') {
                        answer[i][j] = black ? '#' : '.';
                        return new Point(j, i);
                    }

        return null;
    }

    void dump(char[][] answer) {
        System.out.println("-----------------------------");
        for(int j = 0; j < h; j++) {
            for(int i = 0; i < w; i++) 
                System.out.print(answer[j][i]);
            System.out.println("");
        }
        System.out.println("-----------------------------");
    }

    void check(char[][] answer, int x, int y, boolean black) {
        for(int i = y - 1; i <= y + 1; i++) 
            for(int j = x - 1; j <= x + 1; j++) 
                if(i >= 0 && i < board.length &&
                        j >= 0 && j < board[0].length)
                    if(answer[i][j] == '*')
                        answer[i][j] = black ? '#' : '.';
    }

    int countWhite(int x, int y, char[][] answer) {
        return count(x, y, '.', answer);
    }

    int countBlack(int x, int y, char[][] answer) {
        return count(x, y, '#', answer);
    }

    int countArbit(int x, int y, char[][] answer) {
        return count(x, y, '*', answer);
    }

    int count(int x, int y, char c, char[][] answer) {
        int cnt = 0;
        for(int i = y - 1; i <= y + 1; i++) 
            for(int j = x - 1; j <= x + 1; j++) 
                if(i >= 0 && i < board.length &&
                        j >= 0 && j < board[0].length)
                    if(answer[i][j] == c)
                        cnt++;
        return cnt;
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
        new MozaicSolver().run();
    }
}




