public class Chess {
    public static void queens(int[] board, int index) {
        if(index == board.length) {
            if(check(board))
                dump(board);
        } else {
            for(int i = 0; i < 8; i++) {
                board[index] = i;
                queens(board, index + 1);
            }
        }
    }

    public static boolean check(int[] board) {
        boolean[] columns = new boolean[8];
        for(int a : board)
            if(!columns[a])
                columns[a] = true;
            else
                return false;

        boolean flg1 = true, flg2 = true;
        for(int i = 0; i < 8; i++) 
            for(int j = i + 1; j < 8; j++) 
                if(Math.abs(board[i] - board[j]) == j - i) 
                    return false;

        return true;
    }

    public static void dump(int[] board) {
        for(int y = 0; y < board.length; y++) {
            for(int x = 0; x < board.length; x++) 
                if(board[x] == y)
                    System.out.print("Q ");
                else
                    System.out.print("- ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] board = new int[8];
        queens(board, 0);
    }
}
