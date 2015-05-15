import java.util.*;

public class SQueue<E> {
    private Stack<E> s1, s2;

    public SQueue() {
        s1 = new Stack<E>();
        s2 = new Stack<E>();
    }

    public void enqueue(E item) {
        s1.push(item);
    }

    public E dequeue() throws Exception {
        if(!s2.isEmpty()) {
            return s2.pop();
        } else if(!s1.isEmpty()) {
            while(!s1.isEmpty()) 
                s2.push(s1.pop());
            return s2.pop();
        } else {
            throw new Exception("Empty!");
        }
    }

    public static void main(String[] args) throws Exception {
        SQueue<Integer> sq = new SQueue<Integer>();
        sq.enqueue(5);
        sq.enqueue(3);
        sq.enqueue(4);
        sq.enqueue(2);
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
        System.out.println(sq.dequeue());
    }
}
