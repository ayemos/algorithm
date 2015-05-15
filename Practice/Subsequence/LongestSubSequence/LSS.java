import java.util.*;

public class LSS {
    public static List<Integer> lss(int[] arr, int index, int current) {
        if(arr.length == index) {
            return new ArrayList<Integer>();
        } else {
            List<Integer> res = lss(arr, index + 1, current); // 取らない場合
            if(current < arr[index]) {
                List<Integer> another = new ArrayList<Integer>();
                another.add(arr[index]);
                another.addAll(lss(arr, index + 1, arr[index]));
                res = longer(res, another);
            }

            return res;
        }
    }

    public static List<Integer> longer(List<Integer> a, List<Integer> b) {
        if(a.size() > b.size())
            return a;
        else
            return b;
    }

    public static void main(String[] args) {
        int[] arr = {3, -3, -1, 8, 4, -2, 7};
        System.out.println(lss(arr, 0, Integer.MIN_VALUE));
    }
}
