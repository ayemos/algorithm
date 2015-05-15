public class Histogram {
    public static int maxRange(int[] g, int n) {
        int max = 0;
        int min;
        for(int i = 0; i < n; i++) {
            min = g[i];
            for(int j = i - 1; j >= 0; j--) {
                if(g[j] < min)
                    min = g[j];
                int tmp = (i - j + 1) * min;
                if(max < tmp)
                    max = tmp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] g = {3, 2, 5, 7, 1, 6, 6};
        System.out.println(Histogram.maxRange(g, 7));
    }
}
