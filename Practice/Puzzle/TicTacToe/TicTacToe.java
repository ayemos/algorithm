import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TicTacToe {

    private int[][] board;
    private int[] memo;
    private int n;

    private TicTacToe() {}

    public static TicTacToe initGame(int n) throws Exception {
        if(n <= 0) {
            throw new Exception("n has to be positive integer");
        } else {
            TicTacToe ttt = new TicTacToe();
            ttt.n = n;
            ttt.board = new int[n][n];
            ttt.init();
            return ttt;
        }
    }

    public void init() {
        int max = (int)Math.pow(3, n * n);
        this.memo = new int[max];
        for(int i = 0; i < max; i++) 
            memo[i] = check(intToBoard(i, n), n);

        for(int i = 0; i < max; i++) 
            System.out.println(memo[i]);

    }

    public void act(int x, int y, int sign) {
        board[x][y] = sign;
    }

    public int result() {
        System.out.println(boardToInt(board, n));
        int[][] board = intToBoard(boardToInt(this.board, n), n);
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                System.out.print(board[x][y] + " ");
            }
            System.out.println();
        }
        return memo[boardToInt(board, n)];
    }

    private int check(int[][] board, int n) {
        int[] ysums = new int[n];
        int sum;
        // 横
        for(int y = 0; y < n; y++) {
            sum = 0;
            for(int x = 0; x < n; x++) {
                sum += board[x][y];
                ysums[x] += board[x][y];
            }

            if(sum == n) 
                return 1;
            else if(sum == n * 2)
                return 2;
        }

        // 縦
        for(int x = 0; x < n; x++) 
            if(ysums[x] == n) 
                return 1;
            else if(ysums[x] == n * 2)
                return 2;

        // 斜め
        int sum2 = 0;
        sum = 0;
        for(int p = 0; p < n; p++) {
            sum += board[p][p];
            sum2 += board[n - p - 1][p];
        }

        if(sum == n || sum2 == n)
            return 1;
        else if(sum == n * 2 || sum2 == n * 2)
            return 2;

        return 0;
    }

    private int boardToInt(int[][] board, int n) {
        int exp = 0;
        int res = 0;
        for(int y = 0; y < n; y++) 
            for(int x = 0; x < n; x++) 
                res += board[x][y] * Math.pow(3, exp++);

        return res;
    }

    private int[][] intToBoard(int code, int n) {
        int[][] board = new int[n][n];
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                board[x][y] = code % 3;
                code /= 3;
            }
        }

        return board;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) 
                sb.append(Integer.toString(board[x][y]) + " ");
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int turn = 1;
        String line;
        int n = 3;
        int x, y;
        TicTacToe ttt = TicTacToe.initGame(n);

        while((line = br.readLine()) != null) {
            String[] nums = line.split(" ");
            x = Integer.parseInt(nums[0]);
            y = Integer.parseInt(nums[1]);
            ttt.act(x, y, turn);
            turn = turn == 1 ? 2 : 1;
            System.out.println(ttt);
            int res = ttt.result();
            if(res != 0) {
                System.out.println(res == 1 ? "0 won" : "* won");
                break;
            }
        }
    }
}
