
public class CountFactorials {
    public int countZerosInFactorials(int n) {
        // count 5s
        int fives = 0;
        int exp = 5;
        while(exp <= n) {
            fives += n / exp;
            exp *= exp;
        }

        // count 2s
        int twos = 0;
        exp = 2;
        while(exp <= n) {
            twos += n / exp;
            exp *= exp;
        }

        return Math.min(twos, fives);
    }

    public static void main(String[] args) throws Exception {
        CountFactorials cf = new CountFactorials();
        System.out.println(cf.countZerosInFactorials(25));
    }
}




