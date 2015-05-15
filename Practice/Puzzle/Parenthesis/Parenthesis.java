public class Parenthesis {
    public static void parenthesis(char[] res, int c, int lrem, int rrem) {
        System.out.println("l:r => " + lrem + ":" + rrem);
        if(lrem == 0 && rrem == 0) {
            System.out.println(String.valueOf(res));
            return;
        } else {
            if(lrem < rrem) {
                res[c] = ')';
                parenthesis(res, c + 1, lrem, rrem - 1);
            }

            if(lrem > 0) {
                res[c] = '(';
                parenthesis(res, c + 1, lrem - 1, rrem);
            }
        }
    }

    public static void main(String[] args) {
        parenthesis(new char[6], 0, 3, 3);
    }
}
