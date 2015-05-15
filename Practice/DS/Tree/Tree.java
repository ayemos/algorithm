import java.util.*;

class TreeNode {
    TreeNode left, right;
    int value;
}

public class Tree {

    public TreeNode root;

    public void preorder(TreeNode root) {
        if(root != null) {
            System.out.println(root.value);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }

    public void preorderNr(TreeNode root) {
        // non recursive
        if(root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node != null) {
                    System.out.println(node.value);
                    stack.push(node.right);
                    stack.push(node.left);
                }
            }
        }
    }

    public void inorderNr(TreeNode root) {
        // non recursive
        if(root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if(node != null) {
                    stack.push(node.right);
                    System.out.println(node.value);
                    stack.push(node.left);
                }
            }
        }
    }

    public void insert(int value) {
        TreeNode node = new TreeNode();
        node.value = value;
        if(root == null) {
            root = node;
        } else {
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode tmp = queue.poll();
                if(tmp.left == null) {
                    tmp.left = node;
                    break;
                } else if(tmp.right == null) {
                    tmp.right = node;
                    break;
                } else {
                    queue.offer(tmp.left);
                    queue.offer(tmp.right);
                }
            }
        }
    }

    public void revLevel(TreeNode root) {
        if(root == null) {
            return ;
        } else {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if(node != null) {
                    stack.push(node);
                    if(node.left != null) 
                        queue.offer(node.left);
                    if(node.right != null)
                        queue.offer(node.right);
                }
            }

            while(!stack.isEmpty())
                System.out.println(stack.pop().value);
        }
    }

    public TreeNode getDeepest(TreeNode root) {
        if(root == null) {
            return null;
        } else {
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(root);
            TreeNode tmp = null;
            while(!queue.isEmpty()) {
                tmp = queue.poll();
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
            }

            return tmp;
        }
    }

    public boolean isReachable(Node start, Node target) {
        Deque<Node> queue = new Queue<Node>();
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        } else {
            int hDiff = Math.abs(getHeight(root.right) - getHeight(root.left));

            if(hDiff > 1)
                return false;
            else 
                return isBalanced(root.right) && isBalanced(root.left);
        }
    }

    public int getHeight(TreeNode root) {
        if(root == null)
            return 0;
        else 
            return Math.max(getHeight(root.right), getHeight(root.left)) + 1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        for(int i = 1; i <= 10; i++) {
            tree.insert(i);
        }

        System.out.println(tree.isBalanced(tree.root));
    }
}
