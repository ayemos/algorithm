import java.util.Stack;

public class SortStack extends Stack<Integer> {
    public static final long serialVersionUID = 1;

    public void sort() {
        int max = Integer.MIN_VALUE;
        int x;
        Stack<Integer> memo = new Stack<Integer>();

        while(true) {
            x = super.pop();
            if(x <= max) {
                while(!memo.isEmpty()) 
                    super.push(memo.pop());

                super.push(x);
                max = Integer.MIN_VALUE;
            } else {
                max = x;
                memo.push(x);

                if(super.isEmpty()) {
                    while(!memo.isEmpty())
                        super.push(memo.pop());
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        SortStack ss = new SortStack();
        ss.push(1);
        ss.push(3);
        ss.push(5);
        ss.push(9);
        System.out.println(ss);
        ss.sort();
        System.out.println(ss);
    }
}




