public class QuickSort {
    static void sort(int[] arr, int low, int high) {
        int mid = (high + low) / 2;
        int pivot = arr[mid];
        int l = low;
        int r = high;

        while(true) {
            while(arr[pivot] < arr[l]) l++;
            while(arr[pivot] > arr[r]) r--;
        }

    }

    public static void main(String[] args) {
    }
}
