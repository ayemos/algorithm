import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class QueueStack<E> {
    private Stack<E> stack = new Stack<E>();

    public void enqueue(E item) {
        stack.push(item);
    }

    public E dequeue() {
        if(stack.isEmpty()) 
            return null;

        E item = stack.pop();
        if(stack.isEmpty()) {
            return item;
        } else {
            E tmp = dequeue();
            stack.push(item);
            return tmp;
        }
    }

    public static void main(String[] args) throws Exception {
        QueueStack<Integer> queue = new QueueStack<Integer>();
        queue.enqueue(5);
        queue.enqueue(3);
        queue.enqueue(7);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}




