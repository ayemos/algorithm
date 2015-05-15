import java.util.Arrays;

public class Binary {
    private int[] memo;

    public void binary(int n) {
        memo = new int[n];
        binarySub(n);
    }

    private void binarySub(int n) {
        if(n == 0) {
            for(int i = 0; i < memo.length; i++) 
                System.out.print(memo[i]);
            System.out.println();
        } else {
            memo[n - 1] = 0;
            binarySub(n - 1);
            memo[n - 1] = 1;
            binarySub(n - 1);
        }
    }

    public static void main(String[] args) {
        Binary b = new Binary();
        b.binary(10);
    }
}




