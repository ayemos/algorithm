import java.util.List;
import java.util.ArrayList;

public class Stack<E> {
    private List<E> stack;
    public Stack() {
        stack = new ArrayList<E>();
    }

    public void push(E item) {
        stack.add(0, item);
    }

    public E pop() throws Exception {
        if(stack.isEmpty())
            throw new Exception("Empty!");

        E res = stack.get(0);
        stack.remove(0);
        return res;
    }

    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println(stack);
        stack.push(5);
        stack.push(3);
        stack.push(2);
        stack.push(4);
        System.out.println(stack);
        try {
            while(true) {
                System.out.println(stack.pop());
                System.out.println(stack);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
