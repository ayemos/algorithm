public class RotateMatrix {
    public static void rotate(int[][] matrix, int n) {
        for(int p = 0; p < n; p++) {
            int tmp, end, bc;
            for(int c = p + 1; c < n - p; c++) {
                end = n - p - 1;
                bc = n - c - 1;
                System.out.println("c:p:bc:end => " + c + ":" + p + ":" + bc + ":" + end);
                tmp = matrix[c][p];
                matrix[c][p] = matrix[p][bc];
                matrix[p][bc] = matrix[bc][end];
                matrix[bc][end] = matrix[end][c];
                matrix[end][c] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        int n = 3;
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) 
                System.out.print(matrix[y][x] + " ");
            System.out.println();
        }
        rotate(matrix, n);

        System.out.println();
        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) 
                System.out.print(matrix[y][x] + " ");
            System.out.println();
        }
    }
}
