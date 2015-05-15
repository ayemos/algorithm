import java.util.Stack;

public class FindMinimalSort {
    public static void findMinimalSort(int[] arr) {
        int len = arr.length;
        int l, r;
        for(l = 0; l < len; l++) 
            if(min(arr, l + 1, len - 1) < arr[l])
                break;


        for(r = len - 1; r >= 0; r--) 
            if(max(arr, 0, r) > arr[r])
                break;
        System.out.println("(" + l + ", " + r + ")");
    }

    private static int min(int[] arr, int begin, int end) {
        int min = Integer.MAX_VALUE;
        for(int i = begin; i <= end; i++)
            if(arr[i] < min)
                min = arr[i];
        return min;
    }

    private static int max(int[] arr, int begin, int end) {
        int max = Integer.MIN_VALUE;
        for(int i = begin; i <= end; i++)
            if(arr[i] > max)
                max = arr[i];
        return max;
    }

    public static void findMinimalSort2(int[] arr) {
        Stack<Integer> maxs = new Stack<Integer>();
        Stack<Integer> mins = new Stack<Integer>();

        boolean flg = false;
        for(int i : arr) {
            if(!mins.isEmpty() && mins.peek() > i) {
                flg = true;
                while(!mins.isEmpty() && mins.peek() > i)
                    mins.pop();
            }

            if(!flg)
                mins.push(i);
        }

        flg = false;
        for(int i = arr.length - 1; i >= 0; i--) { 
            if(!maxs.isEmpty() && maxs.peek() < i) {
                flg = true;
                while(!maxs.isEmpty() && maxs.peek() < i)
                    maxs.pop();
            }

            if(!flg)
                maxs.push(arr[i]);
        }
        System.out.println(mins);
        System.out.println(maxs);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        findMinimalSort2(arr);
    }
}
