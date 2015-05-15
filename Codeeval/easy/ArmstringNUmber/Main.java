import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            int num = Integer.parseInt(line);
            char[] nums = line.toCharArray();

            int ret = 0;
            for(int i = 0; i < nums.length; i++)
                ret += Math.pow(nums[i] - '0', nums.length);

            System.out.println(ret == num ? "True" : "False");
        }
    }
}

