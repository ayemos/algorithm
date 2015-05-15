import java.util.Stack;

public class MinStack extends Stack<Integer> {
    public static final long serialVersionUID = 15;

    Stack<Integer> mins = new Stack<Integer>();

    public void push(int x) {
        if(x <= min()) 
            mins.push(x);
        System.out.println(mins);
        super.push(x);
    }

    public Integer pop() {
        int ret = super.pop();
        if(ret <= min()) 
            mins.pop();
        return ret;
    }

    public int min() {
        if(mins.isEmpty()) 
            return Integer.MAX_VALUE;
        else
            return mins.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack ms = new MinStack();

        ms.push(9);
        System.out.println("min: " + ms.min());
        ms.push(9);
        ms.push(1);
        System.out.println("min: " + ms.min());
        ms.push(3);
        System.out.println("min: " + ms.min());
        ms.push(1);
        ms.pop();
        System.out.println("min: " + ms.min());
        ms.pop();
        ms.pop();
        System.out.println("min: " + ms.min());

    }
}




