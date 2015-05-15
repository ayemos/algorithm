import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Hanoi {
    private Stack<Integer> from, to, middle;
    private int n;

    public Hanoi(int n) {
        from    = new Stack<Integer>();
        to      = new Stack<Integer>();
        middle  = new Stack<Integer>();
        for(int i = 0;  i < n; i++) 
            from.push(n-i);
        this.n = n;
    }

    public void solve() {
        move(this.n, from, to, middle);
    }

    private void move(int depth, Stack<Integer>from, 
            Stack<Integer>to, Stack<Integer>middle) {
        if(depth == 1) {
            to.push(from.pop());
            System.out.println(this);
            System.out.println();
            return;
        } else {
            move(depth - 1, from, middle, to);
            to.push(from.pop());
            System.out.println(this);
            System.out.println();
            move(depth - 1, middle, to, from);
        }
    }

    public String toString() {
        return "From: " + from.toString() + "\n"
            + "Middle: " + middle.toString() + "\n"
            + "To: " + to.toString();
    }


    public static void main(String[] args) throws Exception {
        Hanoi hanoi = new Hanoi(10);
        System.out.println(hanoi);
        hanoi.solve();
        System.out.println(hanoi);
    }
}




