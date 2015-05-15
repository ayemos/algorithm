import java.util.Random;
public class RandomInt {
    public static int[] randomArray(int begin, int end, int n) {
        if((end - begin + 1) < n)
            return new int[0];

        int[] source = new int[end - begin + 1];
        for(int i = 0; i < end - begin + 1; i++) 
            source[i] = begin + i;

        Random rand = new Random();
        for(int i = 0; i < end - begin + 1; i++) 
            swap(source, i, Math.abs(rand.nextInt()) % (end - begin + 1));

        int[] res = new int[n];
        System.arraycopy(source, 0, res, 0, n);
        return res;
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] res = randomArray(10, 20, 5);
        for(int i = 0; i < 5; i++)
            System.out.print(res[i] + " ");
        System.out.println();
    }

}
