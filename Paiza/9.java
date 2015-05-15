import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int r = Integer.parseInt(nums[4]);
        int a = Integer.parseInt(nums[0]) - r * 2;
        int b = Integer.parseInt(nums[1]) - r * 2;
        int x = Integer.parseInt(nums[2]);
        int y = Integer.parseInt(nums[3]);
        int t = Integer.parseInt(nums[5]);
        int l = Integer.parseInt(nums[6]);

        double dx = l*Math.cos(Math.PI * t / 180) + x;
        double dy = l*Math.sin(Math.PI * t / 180) + y;

        // 水平方向にぶつかる回数
        int ao = (int)Math.floor(dx) / (a);
        if (dx < 0) ao--;
        // 垂直方向にぶつかる回数
        int bo = (int)Math.floor(dy) / (b);
        if (dy < 0) bo--;

        // 座標の反転係数
        int as = ao % 2;
        int bs = bo % 2;

        System.out.println(
                (as == 0 ? dx % a : a - dx % a + r * 2) + " " + 
                (bs == 0 ? dy % b : b - dy % b + r * 2)
                );
    }
}

