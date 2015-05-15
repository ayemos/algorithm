import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        long start, stop;
        int n = 100000;
        List<Integer> al = new ArrayList<Integer>();
        start = System.currentTimeMillis();
        for(int i = 0; i < n; i++) 
            al.add(al.size(), i);
        stop = System.currentTimeMillis();
        System.out.println("ArrayList(" + n + "): " + (stop - start));

        List<Integer> ll = new LinkedList<Integer>();
        start = System.currentTimeMillis();
        for(int i = 0; i < n; i++) 
            ll.add(ll.size(), i);
        stop = System.currentTimeMillis();
        System.out.println("LinkedList(" + n + "): " + (stop - start));
    }
}
