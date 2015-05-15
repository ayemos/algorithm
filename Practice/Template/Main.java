import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LEFT = "{{";
    final String RIGHT = "}}";

    public String replace(String source, Map<String, String> vars) {
        int p = 0, q = 0;
        while(p < source.length() && q < source.length()) {
            p = source.indexOf(LEFT, p);
            q = source.indexOf(RIGHT, q);
            if(p == -1 || q == -1)
                break;
            String key = source.substring(p + 2, q);
            if(vars.containsKey(key)) {
                source = source.substring(0, p) + vars.get(key) + 
                    source.substring(q + 2, source.length());
            }
            p += 2;
            q += 2;
        }

        return source;
    }

    public static void main(String[] args) throws Exception {
        Main m = new Main();
        String source = "Hi {{recipient}},\n\nI'm {{name}}. How are you today?";
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("recipient", "John");
        vars.put("name", "Paul");

        System.out.println("source:");
        System.out.println(source);
        System.out.println();
        System.out.println("vars:");
        System.out.println(vars);
        System.out.println();
        System.out.println("result:");
        System.out.println(m.replace(source, vars));
    }
}




