public class BinarySearch {
    static int binarySearch(int[] arr, int x, int low, int high) {
        if(low > high)
            return -1;

        int mid = (high + low) / 2;

        if(arr[mid] > x)
            return binarySearch(arr, x, low, mid - 1);
        else if(arr[mid] < x)
            return binarySearch(arr, x, mid + 1, high);
        else 
            return mid;
       
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 5, 40, 599, 4039, 80049};
        System.out.println("search(5) : " + binarySearch(arr, 5, 0, arr.length - 1));
        System.out.println("search(4847) : " + binarySearch(arr, 4847, 0, arr.length - 1));
    }
}
