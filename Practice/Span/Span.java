import java.util.*;

public class Span {
    public static int[] span(int[] graph, int n) {
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int j = i;
            while(j > 0 && graph[j - 1] <= graph[i]) 
                j--;
            res[i] = i - j + 1;
        }

        return res;
    }

    public static int[] span2(int[] graph, int n) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && graph[i] >= graph[stack.peek()]) 
                stack.pop();

            int p = 0;
            if(stack.isEmpty())
                p = -1;
            else
                p = stack.peek();

            res[i] = i - p;
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] in = {6, 3, 4, 5, 2};
        for(int i : Span.span(in, 5)) {
            System.out.print(i + ", ");
        }
        System.out.println();

        for(int i : Span.span2(in, 5)) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
