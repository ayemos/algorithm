public class QuickSelect {
    public static int getKthSmallest(int[] arr, int l, int r, int k) {
        System.out.println("l:r => " + l + ":" + r);
        for(int i = l; i <= r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        if(r - l + 1 == k) {
            return max(arr, l, r);
        } else {
            int t = arr[l];
            int left = l + 1;
            int right = r;

            while(left <= right) {
                while(left <= r && arr[left] < t)
                    left++;

                while(arr[right] > t)
                    right--;

                if(left < right) {
                    swap(arr, left, right);
                    left++;
                    right--;
                }
            }
            swap(arr, l, right);

            if(right - l + 1 >= k) {
                // 左にある
                return getKthSmallest(arr, l, right, k);
            } else {
                // 右にある
                int remain = k - (right - l + 1);
                return getKthSmallest(arr, right + 1, r, remain); 
            }
        }
    }

    public static void swap(int[] arr, int a, int b) {
        System.out.println("swap(a, b) => " + a + ":" + b);
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int max(int[] arr, int l, int r) {
        int max = Integer.MIN_VALUE;
        for(int i = l; i <= r; i++)
            if(arr[i] > max)
                max = arr[i];
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, -1, -3, 5, 8, -5, 7};
        System.out.println(getKthSmallest(arr, 0, 6, 5));
        System.out.println(getKthSmallest(arr, 0, 6, 1));
    }
}
