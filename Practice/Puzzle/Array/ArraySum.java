import java.util.*;

public class ArraySum {
    static class Pair {
        int first, second;
        public Pair(int f, int s) {
            this.first = f; this.second = s;
        }

        public boolean equals(Object obj) {
            if(obj instanceof Pair) {
                Pair p = (Pair)obj;
                return (p.first == first && p.second == second) 
                    || (p.first == second && p.second == first);
            } else {
                return false;
            }
        }

        public int hashCode() {
            return first + second;
        }

        public String toString() {
            return "(" + first + ", " + second + ")";
        }
    }

    public static Set<Pair> count(int[] arr, int n) {
        Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
        Set<Pair> res = new HashSet<Pair>();

        for(int a : arr) {
            if(memo.containsKey(a))
                memo.put(a, memo.get(a) + 1);
            else 
                memo.put(a, 0);
        }

        for(int a : arr) {
            if(a * 2 == n) {
                if(memo.containsKey(a) && memo.get(a) >= 2)
                    res.add(new Pair(a, a));
            } else {
                if(memo.containsKey(n - a))
                    res.add(new Pair(a, n - a));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 0, 2, 8, 10, 4, 9};
        System.out.println(count(arr, 11));
    }
}
