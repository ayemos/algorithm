/*
 * 0..k-1 の n個の列を列挙
 */
public class KIter {
    private int[] memo;
    private int k;

    public void iter(int n, int k) {
        memo = new int[n];
        this.k = k;
        iterSub(n);
    }

    private void iterSub(int n) {
        if(n == 0) {
            for(int i = 0; i < memo.length; i++) 
                System.out.print(memo[i] + " ");
            System.out.println();
        } else {
            for(int i = 0; i < k; i++) {
                memo[n - 1] = i;
                iterSub(n - 1);
            }
        }
    }

    public static void main(String[] args) {
        KIter ki = new KIter();
        ki.iter(3, 5);
    }
}

