public class Main {
    public static int getBiggestSum(int[] arr, int n) {
        int subMax = Integer.MIN_VALUE;
        for(int a : arr)
            if(a > subMax)
                subMax = a;
        if(subMax <= 0)
            return subMax;

        // arr has some positive numbers
        int current = 0;
        int max = 0;
        for(int i = 0; i < n; i++) {
            if(current < 0)
                current = 0;
            current += arr[i];
            if(current > max)
                max = current;
        }

        return max;
    }

    public static void main(String[] args) throws Exception {
        int[] arr = {3, -1, -5, 2, 3, -2, 1};
        System.out.println(getBiggestSum(arr, 7));
    }
}




