import java.util.*;

public class SetDivision {
    // 32個の集合から、指定個数の要素を含む部分集合を列挙する
    public static int next(int n) {
        // n = **** 0111 0000
        // n-1 = **** 0110 1111
        // -n = ~**** 1001 0000
        // want = **** 1000 0111
        int r = n & -n;  // **** 0001 0000
        int e = n + r; // **** 1000 0000
//        System.out.println("r:e:e^n => " + r + ":" + e + ":" + (e^n));
        // e^n = 0000 1111 0000
        return e | (((e ^ n) >> 2) / r);
    }

    public static List<Integer> bitToIndice(int n) {
        List<Integer> res = new ArrayList<Integer>();
        int c = 0;
        while(n > 0) {
            if(n % 2 == 1)
                res.add(c);
            c++;
            n /= 2;
        }

        return res;
    }

    public static void main(String[] args) {
        int tmp = 7;
        for(int i = 0; i < 100; i++) {
            System.out.println(bitToIndice(tmp));
            tmp = next(tmp);
        }
    }
}
