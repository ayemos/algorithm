import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    class TreeNode { 
        int num;
        TreeNode left, right;

        public String toString() {
            String left = this.left != null ? this.left.toString() : "";
            String right = this.right != null ? this.right.toString() : "";
            return Integer.toString(num) + "\nleft: " + left + "\nright:" + right;
        }
    }

    void run() throws Exception {
        String[] ss = ns().split(" ");
        int len = ss.length;
        int[] nums = new int[len];
        for(int i = 0; i < len; i++) 
            nums[i] = Integer.parseInt(ss[i]);

        TreeNode res = new TreeNode();
        addToTree(nums, 0, len - 1, res);
        System.out.println(res);
    }

    void addToTree(int[] arr, int low, int high, TreeNode root) {
        if(low > high) 
            return;
        int mid = (high + low) / 2;
        root.num = arr[mid];

        if(low <= mid - 1) {
            TreeNode left = new TreeNode();
            addToTree(arr, low, mid - 1, left);
            root.left = left;
        } 

        if (mid + 1 <= high) {
            TreeNode right = new TreeNode();
            addToTree(arr, mid + 1, high, right);
            root.right = right;
        }
    } 

    String ns() throws Exception {
        return br.readLine();
    }

    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}




