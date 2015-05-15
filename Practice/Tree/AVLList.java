import java.util.List;
import java.util.ArrayList;

public class AVLList {
    public void childrenList(TreeNode root, int depth) {
        List<TreeNode> tmp = new ArrayList<TreeNode>();
        List<TreeNode> tmp2 = new ArrayList<TreeNode>();
        int d = 0;
        tmp.add(root);
        while(d < depth) {
            System.out.println("depth: " + d);
            tmp2.clear();
            for(TreeNode node : tmp) {
                System.out.println(node);
                tmp2.add(node.left);
                tmp2.add(node.right);
            }

            tmp.clear();
            tmp.addAll(tmp2);

            d++;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode child1 = new TreeNode();
        TreeNode child2 = new TreeNode();
        TreeNode child3 = new TreeNode();
        TreeNode child4 = new TreeNode();
        TreeNode child5 = new TreeNode();
        TreeNode child6 = new TreeNode();
        root.left = child1;
        root.right = child2;
        child1.left = child3;
        child1.right = child4;
        child2.left = child5;
        child2.right = child6;


        new AVLList().childrenList(root, 3);
    }

    static class TreeNode {
        TreeNode left, right;
        int value;
    }
}
