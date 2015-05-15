import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        res += Integer.parseInt(br.readLine());
        String nums[] = br.readLine().split(" ");
        res += Integer.parseInt(nums[0]); 
        res += Integer.parseInt(nums[1]); 
        System.out.println(res+ " " + br.readLine());
    }
}
