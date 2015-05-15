import java.util.*;

public class BiggestWindow {
    public static int[] maxWindow(int arr[], int n, int w) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int[] res = new int[n - w + 1];
        for(int i = 0; i < n; i++) {
            // キューの先頭が現在の窓における最大値
            if(i >= w) 
                res[i - w] = arr[deque.getFirst()];

            // これから追加する要素よりも小さいものは要らない
            // なぜなら、追加される新しい要素が最後まで残るから
            while(!deque.isEmpty() && arr[i] >= arr[deque.getLast()]) 
                deque.removeLast();

            // 窓から漏れたものを削除
            if(i >= w) {
                while(!deque.isEmpty() && deque.getFirst() <= i - w)
                    deque.removeFirst();
            }

            deque.addLast(i);
        }

        res[n - w] = arr[deque.getFirst()];
        return res;
    }

    public static int biggestSum(int[] arr, int begin, int end) {
        if (begin > end) {
            return 0;
        } else if(begin == end) {
            return Math.max(0, arr[begin]);
        } else {
            int m = (begin + end) / 2;
            int sum1 = biggestSum(arr, begin, m);
            int sum2 = biggestSum(arr, m + 1, end);

            int lmax = 0;
            int sum = 0;
            for(int i = m; i >= begin; i--) {
                sum += arr[i];
                if(sum > lmax)
                    lmax = sum;
            }

            int rmax = 0;
            sum = 0;
            for(int i = m + 1; i <= end; i++) {
                sum +=  arr[i];
                if(sum > rmax)
                    rmax = sum;
            }

            return Math.max(lmax + rmax, Math.max(sum1, sum2));
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println("max of each windows with width 3");
        for(int a : maxWindow(arr, 8, 3)) 
            System.out.print(a + ", ");
        System.out.println();

        System.out.println("max of all windows");
        System.out.println(biggestSum(arr, 0, arr.length - 1));
    }

}
