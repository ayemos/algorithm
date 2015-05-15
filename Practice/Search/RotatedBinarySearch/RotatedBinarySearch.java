public class RotatedBinarySearch {
    static int binarySearch(int[] arr, int x, int low, int high) {
        if(low > high)
            return -1;

        int mid = (high + low) / 2;

        boolean rotatedAtLeft = arr[mid] < arr[low];
        boolean rotatedAtRight = arr[mid] > arr[high];

        if((!rotatedAtLeft && arr[mid] > x)
                || (rotatedAtLeft && !isIn(arr[low], arr[mid], x)))
            return binarySearch(arr, x, low, mid - 1);
        else if((!rotatedAtRight && arr[mid] < x) 
            || (rotatedAtRight && !isIn(arr[mid], arr[high], x)))
            return binarySearch(arr, x, mid + 1, high);
        else 
            return mid;
    }

    static boolean isIn(int a, int b, int x) {
        if(a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        return x >= a && x <= b;
    }

    public static void main(String[] args) {
        int[] arr = {13, 20, 25, 1, 2, 5, 8, 9};
        System.out.println("search(5) : " + binarySearch(arr, 5, 0, arr.length - 1));
        System.out.println("search(21) : " + binarySearch(arr, 21, 0, arr.length - 1));
    }
}
