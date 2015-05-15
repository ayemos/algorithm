import java.util.*;

public class Subset {
    public static List<List<Integer>> subsets(List<Integer> set, int index) {
        if(index == set.size()) {
            List<List<Integer>> emp = new ArrayList<List<Integer>>();
            emp.add(new ArrayList<Integer>());
            return emp;
        } else {
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            List<List<Integer>> minus = subsets(set, index + 1);
            res.addAll(minus);
            List<List<Integer>> more = new ArrayList<List<Integer>>();
            for(List<Integer> list : minus) {
                List<Integer> tmp = new ArrayList<Integer>();
                tmp.add(set.get(index));
                tmp.addAll(list);
                more.add(tmp);
            }

            res.addAll(more);
            return res;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(10);
        list.add(1);

        System.out.println(subsets(list, 0));

    }
}
