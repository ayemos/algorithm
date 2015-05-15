import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);

        List<String> waka = new ArrayList<String>();
        String kami = "";

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            if(i == m - 1)
                kami = str;
            else
                waka.add(str);
        }

        int max = 0;
        int c = 0;
        for(String w : waka) {
            c = 0;
            for(int i = 0; i < w.length(); i++) {
                if(w.charAt(i) != kami.charAt(i)) 
                    break;

                c++;
            }

            if(c > max)
                max = c;
        }

        if(max == kami.length())
            System.out.println(kami);
        else
            System.out.println(kami.substring(0, max+1));
    }
}

