import java.util.Random;

public class Shuffle {
    public static void shuffle(int[] cards, int n) {
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            swap(cards, i, (Math.abs(rand.nextInt()) % (n - i)) + i);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] cards = new int[52];
        for(int i = 0; i < 52; i++)
            cards[i] = i + 1;
        for(int i = 0; i < 52; i++) 
            System.out.print(cards[i] + " ");
        System.out.println();

        shuffle(cards, 52);

        for(int i = 0; i < 52; i++) 
            System.out.print(cards[i] + " ");
        System.out.println();

    }
}
