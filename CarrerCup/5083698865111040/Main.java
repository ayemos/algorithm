public class Main {
    private int[][] memo;
    private int[] coins;

    public int denom(int[] coins, int p) {
        this.memo = new int[p][coins.length];
        this.coins = coins;
        return count(p, 0);
    }

    private int count(int rem, int biggest) {
        if(rem < 0) {
            return 0;
        } else if(rem == 0) {
            return 1;
        } else {
            // rem > 0
            int res = 0;
            for(int i = biggest; i < coins.length; i++) 
                res += count(rem - coins[i], i);
            return res;
        }
    }

    public static void main(String[] args) throws Exception {
        int[] coins = {1, 2, 3};
        System.out.println(new Main().denom(coins, 5));
    }
}




