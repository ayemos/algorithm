import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int pa = 0, pb = 0;

        StringBuffer res = new StringBuffer();
        while(pa < a.length() || pb < b.length()) {
            if(pa == a.length()) {
                res.append(b.substring(pb, b.length()));
                break;
            } else if(pb == b.length()) {
                res.append(a.substring(pa, a.length()));
                break;
            }
            char ca = a.charAt(pa);
            char cb = b.charAt(pb);

            if(ca < cb) {
                res.append(ca);
                pa++;
            } else {
                res.append(cb);
                pb++;
            }
        }

        System.out.println(res.toString());
    }
}
