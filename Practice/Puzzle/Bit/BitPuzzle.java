public class BitPuzzle {
    public static void swap(int[] arr, int a, int b) {
        arr[b] = arr[a] - arr[b];
        arr[a] = arr[a] - arr[b];
        arr[b] = arr[a] + arr[b];
    }

    public static int max(int a, int b) {
        int s = sign(a - b);
        int si = s ^ 1;
        return a * s + b * si;
    }

    private static int sign(int n) {
        return (n >> 31) + 1;
    }

    public static int rotateL(int n, int k) {
        if(k >= 32)
            k %= 32;
        return (n << k) | (n >>> (32 - k));
    }

    public static int countbit(int n) {
        int sum = n;
        for(int i = 1; i <= 31; i++) {
            n = rotateL(n, 1);
            sum += n;
        }

        return -sum;
    }

    public static int countAlt(int a, int b) {
        return countbit(a ^ b);
    }

    public static int alterEvenAndOdd(int n) {
        int a = (n & 0x55555555) << 1;
        int b = (n & 0xAAAAAAAA) >>> 1;
        return a | b;
    }

    public static int findMissing(byte[] bits) {
    }

    public static void main(String[] args) {
        System.out.println(alterEvenAndOdd(13));
        System.out.println(alterEvenAndOdd(31));
    }
}
