import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        Map<String, String> dic = new HashMap<String, String>();
        dic.put("A", "4");
        dic.put("E", "3");
        dic.put("G", "6");
        dic.put("I", "1");
        dic.put("O", "0");
        dic.put("S", "5");
        dic.put("Z", "2");

        for(Map.Entry<String, String> e : dic.entrySet()) 
            line = line.replaceAll(e.getKey(), e.getValue());

        System.out.println(line);
    }
}

