import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        Deque<Integer> stack = new LinkedList<Integer>();

        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] nums = line.split(" ");
            for(int i = 0; i < nums.length; i++) 
                stack.addFirst(Integer.parseInt(nums[i]));

            while(!stack.isEmpty()) {
                System.out.print(stack.removeFirst());

                if(!stack.isEmpty()) {
                    stack.removeFirst();
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }

}
