import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]); int m = Integer.parseInt(nums[1]);

        int prof = 0;
        for (int i = 0; i < m; i++) {
            String[] ls = br.readLine().split(" ");

            int tmp = 0;
            for (int j = 0; j < n; j++) 
                tmp += Integer.parseInt(ls[j]);

            if (tmp > 0)
                prof += tmp;
        }

        System.out.println(prof);
    }
}

