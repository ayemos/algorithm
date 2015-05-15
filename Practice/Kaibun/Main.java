import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            int p = 0, q = 0;
            if(line.length() % 2 == 0) {
                p = (line.length() / 2) - 1;
                q = p + 1;
            } else {
                p = (line.length() / 2) - 1;
                q = p + 2;
            }

            boolean flag = true;
            while(p >= 0 && q <= line.length() && flag) 
                if(line.charAt(p--) != line.charAt(q++)) 
                    flag = false;

            System.out.println(flag ? "true" : "false");
        }
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




