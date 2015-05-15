import java.math.BigDecimal;

public class Main {
    static void f1() {
        System.out.println(2.00 - 1.10);
    }

    static void f2() {
        System.out.println(new BigDecimal("2.00")
                .subtract(new BigDecimal("1.10")));
    }

    static void f3() {
        final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000 ;
        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }

    static void f4() {
        System.out.println(12345 + 5432l);
    }

    public static void main(String[] args) {
        f4();
    }
}




