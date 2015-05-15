import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] ws = line.split(",");
            String str = ws[0];
            String sub = ws[1];
            System.out.println(solve(str, sub, 0, 0));
        }
    }

    public static int solve(String str, String sub, int p1, int p2) {
        if (p2 == sub.length()) return 1;
        if (p1 == str.length()) return 0;

        if (str.charAt(p1) == sub.charAt(p2)) {
            int a = solve(str, sub, p1+1, p2);
            int b = solve(str, sub, p1+1, p2+1);
            return a+b;
        } else {
            return solve(str, sub, p1+1, p2);
        }
    }
}
