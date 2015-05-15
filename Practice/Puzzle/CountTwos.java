public class CountTwos {
    public static int countTwos(int n) {
        int sum = 0;
        int exp = 10;
        int expL = 1;
        while(expL < n) {
            sum += expL * (n / exp) + Math.min(expL, Math.max(0, (n % exp) - 2 * expL + 1));

            exp *= 10;
            expL *= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println("2 => " + countTwos(2));
        System.out.println("205 => " + countTwos(205));
    }
}
