import java.util.*;

public class HeapTree {
    private List<Integer> heap;
    private int current;
    private HeapType type;

    public static enum HeapType {
        MAX,
        MIN
    }

    public int size() {
        return current;
    }

    public HeapTree(HeapType type) {
        heap = new ArrayList<Integer>();
        current = 0;
        this.type = type;
    }

    public void add(int i) {
        heap.add(current++, i);
        upheap();
    }

    public void removeMax() {
        if(current == 0)
            return;
        current--;
        int tmp = getMax();
        heap.set(0, heap.get(current));
        heap.set(current, tmp);
        downheap();
    }

    public int getMax() {
        if(heap.isEmpty()) 
            return -1;
        else 
            return heap.get(0);
    }

    public void downheap() {
        int i = 0;
        int tmp, target;
        while(i * 2 + 1 < current) {
            target = (i * 2) + 1;
            if(target + 1 < current && compare(heap.get(target + 1), heap.get(target)))
                // choose bigger child
                target++;

            tmp = heap.get(i);
            heap.set(i, heap.get(target));
            heap.set(target, tmp);
            i = target;
        }
    }

    private void upheap() {
        int i = current - 1;
        int tmp;
        while(i > 0 && compare(heap.get(i), heap.get((i - 1) / 2))) {
            tmp = heap.get(i);
            heap.set(i, heap.get((i - 1) / 2));
            heap.set((i - 1) / 2, tmp);
            i = (i - 1) / 2;
        }
    }

    private boolean compare(int a, int b) {
        if(this.type == HeapType.MAX) 
            return a > b;
        else 
            return b > a;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i < current; i++)
            sb.append(heap.get(i) + ", ");
        if(sb.length() > 2) 
            sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        HeapTree min = new HeapTree(HeapType.MIN);
        HeapTree max = new HeapTree(HeapType.MAX);
        int[] arr = {1, 4, 9, 2, 3, 14, 8, 10, 5, 6, 7, 13};
        for(int a : arr) {
            if(max.size() == 0 || max.getMax() > a)
                max.add(a);
            else 
                min.add(a);

            if(max.size() - min.size() > 1) {
                min.add(max.getMax());
                max.removeMax();
            } else if(min.size() - max.size() > 1) {
                max.add(min.getMax());
                min.removeMax();
            }
        }

        if(max.size() == min.size())
            System.out.println((max.getMax() + min.getMax()) / 2);
        else
            System.out.println(max.getMax());
    }
}
