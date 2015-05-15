import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static final int EMPTY  = 0;
    private static final int BLACK  = 1;
    private static final int WHITE  = 2;
    private static final int EDGE   = 3;

    public static int black_score;
    public static int white_score;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[10][10];
        init(board);


        for (int i = 0; i < n; i++) {
            String[] ls = br.readLine().split(" ");
            int x = Integer.parseInt(ls[1]); 
            int y = Integer.parseInt(ls[2]);

            int turn = 0;
            if (ls[0].equals("B")) {
                turn = BLACK;
                board[x][y] = BLACK;
                black_score++;
            } else {
                turn = WHITE;
                board[x][y] = WHITE;
                white_score++;
            }

            proc(board, turn, Integer.parseInt(ls[1]), Integer.parseInt(ls[2]));
//            printBoard(board);
        }

        if(black_score == white_score) {
            System.out.println(digitToString(black_score) + "-" +
                    digitToString(white_score) + " Draw!");
        } else {
            System.out.print(digitToString(black_score) + "-" + 
                digitToString(white_score) + " The ");
            System.out.print(black_score > white_score ? "black" : "white");
            System.out.println(" won!");
        }

    }

    public static String digitToString(int digit) {
        if(digit < 10) 
            return "0" + digit;
        else 
            return Integer.toString(digit);
    }

    public static void init(int[][] board) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if (i == 0 || i == 9 || j == 0 || j == 9)
                    board[i][j] = EDGE;
                else 
                    board[i][j] = EMPTY;
            }
        }
        board[4][4] = WHITE;
        board[5][4] = BLACK;
        board[4][5] = BLACK;
        board[5][5] = WHITE;
        black_score = 2;
        white_score = 2;
    }

    public static void proc(int[][] board, int turn, int x, int y) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;

                // try to find sandwich
                int n = 1;
                while(board[x+dx*n][y+dy*n] != turn
                        && board[x+dx*n][y+dy*n] != EDGE
                        && board[x+dx*n][y+dy*n] != EMPTY) {
                    n++;
                }

                if(board[x+dx*n][y+dy*n] == turn) {
                    n--;
                    // trace back sandwich (if there're one)
                    while(n > 0) {
                        board[x+dx*n][y+dy*n] = turn;

                        if(turn == BLACK) {
                            black_score++;
                            white_score--;
                        } else {
                            black_score--;
                            white_score++;
                        }
                        n--;
                    }
                }
            }
        }
    }

    public static void printBoard(int[][] board) {
        System.out.println("black:white = " + black_score + ":" + white_score);
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[j][i] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

