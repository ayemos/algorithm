public class Main {
    public static int examineTriangle(int a, int b, int c) {
        if(a > 0 && b > 0 && c > 0
                && a + b > c && b + c > a && c + a > b) {
            if(a == b && b == c) {
                return 3;
            } else if(a == b || b == c || c == a) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        System.out.println(examineTriangle(0, 0, 0));
        System.out.println(examineTriangle(-5, 4, 3));
        System.out.println(examineTriangle(4, 0, 2));
        System.out.println(examineTriangle(1, 2, 3));
        System.out.println(examineTriangle(1, 2, 4));
        System.out.println(examineTriangle(3, 3, 3));
        System.out.println(examineTriangle(2, 2, 3));
        System.out.println(examineTriangle(3, 2, 2));
        System.out.println(examineTriangle(2, 3, 2));
        System.out.println(examineTriangle(3, 4, 5));
    }
}

