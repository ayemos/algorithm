import java.io.*;
public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main (String[] args) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            char[] nums = line.toCharArray();

            int exp = 0;
            int ret = 0;
            for(int i = nums.length - 1; i >= 0; i--) {
                ret += hexToDig(nums[i]) * Math.pow(16, exp);
                exp++;
            }

            System.out.println(ret);
        }
    }

    static int hexToDig(char hex) {
        if(hex >= 'a' && hex <= 'f')
            return hex - 'a' + 10;
        else if(hex >= '0' && hex <= '9')
            return hex - '0';
        return -1;
    }
}


