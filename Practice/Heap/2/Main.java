import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final int BIG_MOD = 1000000007;
    final int MAX = 100;
    int current;
    int[] heap;

    void run() throws Exception {
        heap = new int[MAX];
        current = 0;

        push(5);
        push(3);
        push(10);
        push(1);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(pop());
    }

    void dump() {
        System.out.println("heap:");
        for(int i = 0; i < current; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    void push(int x) {
        if(current >= MAX - 1)
            return ;

        int i = current++;
        heap[i] = x;

        int p = (i - 1) / 2;
        int tmp;
        while(i > 0 && heap[i] > heap[p]) {
            tmp = heap[i];
            heap[i] = heap[p];
            heap[p] = tmp;

            i = p;
            p = (i - 1) / 2;
        }
    }

    int pop() {
        if(current == 0)
            return -1;

        current--;

        int top = heap[0];
        heap[0] = heap[current];

        int i = 0;
        int child = i * 2 + 1;
        while(child < current && heap[child] > heap[i]) {
            if(child + 1 < current && heap[child + 1] > heap[child])
                child = child + 1;

            int tmp = heap[i];
            heap[i] = heap[child];
            heap[child] = tmp;

            i = child;
            child = i * 2 + 1;
        }

        return top;
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




