import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;
import java.lang.StringBuffer;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");

    void run() throws Exception {
        long t = Long.parseLong(br.readLine());
        long n;
        for(int i = 0; i < t; i++) {
            n = Long.parseLong(br.readLine());
            System.out.println(ebo(n));
        }
    }

    long ebo(long n) {
        long a = 1;
        long b = 2;
        long res = 2;
        long ta;

        if(n < 2) return 0;

        while(true) {
            ta = a;
            a = ta + b * 2;
            b = ta * 2 + b * 3;
            if (n < b)
                break;
            res = res + b;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




