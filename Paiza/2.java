import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] nums = line.split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int k = Integer.parseInt(nums[2]);

        String[] cs = br.readLine().split(" ");
        float[] scores = new float[n];
        for (int i = 0; i < n; i++) 
            scores[i] = Float.parseFloat(cs[i]);


        int[] highs = new int[k];

        for (int i = 0; i < k; i++) 
            highs[i] = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            String[] xs = br.readLine().split(" ");

            float score = 0.0f;
            for (int j = 0; j < n; j++) 
                score += Integer.parseInt(xs[j]) * scores[j];

            int intScore = Math.round(score);

            for (int l = k - 1; l >= 0; l--) {
                if(highs[l] < intScore) {
                    if (l < k - 1) 
                        highs[l+1] = highs[l];

                    highs[l] = intScore;
                }
            }
        }

        for(int i = 0; i < k; i++) 
            System.out.println(highs[i]);
    }
}

