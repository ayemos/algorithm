public class PrimArrayStack {
    private int[] stack;
    private int top;
    private int cap;

    public PrimArrayStack() {
        top = -1;
        cap = 100;
        stack = new int[1];
    }

    public void push(int value) throws Exception {
        if(top >= stack.length - 1) 
            reallocate();
        top++;
        stack[top] = value;
    }

    public int pop() throws Exception {
        if(top == -1)
            throw new Exception("Empty!");
        else
            return stack[top--];
    }

    private void reallocate() throws Exception {
        int size = stack.length * 2;
        if(size > cap)
            throw new Exception("Over Capacity!");
        int newStack[] = new int[stack.length * 2];
        System.arraycopy(stack, 0, newStack, 0, stack.length);
        stack = newStack;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i <= top; i++) 
            sb.append(stack[i] + ", ");

        if(sb.length() > 2) 
            sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        PrimArrayStack stack = new PrimArrayStack();
        for(int i = 0; i < 100; i++) {
            stack.push(i);
            System.out.println(stack);
        }
    }
}
