import java.util.*;

public class BST {
    private class Node {
        Node left, right, parent;
        int value;

        public String toString() {
            return Integer.toString(value);
        }
    }

    private Node root = null;

    public Node getRoot() {
        return root;
    }

    public void insert(int value) {
        this.root = insertSub(this.root, value);
    }

    private Node insertSub(Node root, int value) {
        if(root == null) {
            Node node = new Node();
            node.value = value; 
            root = node;
        } else {
            Node tmp;
            if(value > root.value) {
                tmp = insertSub(root.right, value);
                root.right = tmp;
                tmp.parent = root;
            } else {
                tmp = insertSub(root.left, value);
                root.left = tmp;
                tmp.parent = root;
            }
        }
        return root;
    }

    public List<Integer> toSortedArray() {
        return getInOrderList(root);
    }

    private List<Integer> getInOrderList(Node root) {
        if(root == null)
            return new ArrayList<Integer>(); // return empty array rather than null

        List<Integer> res = new ArrayList<Integer>();
        res.addAll(getInOrderList(root.left));
        res.add(root.value);
        res.addAll(getInOrderList(root.right));
        return res;
    }

    public void buildTreeFromSortedArray(int[] arr) {
        this.root = arrayToNode(arr, 0, arr.length - 1);
    }

    private Node arrayToNode(int[] arr, int begin, int end) {
        if(begin > end) {
            return null;
        } else if(begin == end) {
            Node node = new Node();
            node.value = arr[begin];
            return node;
        } else {
            // begin < end
            int m = (begin + end) / 2;
            Node node = new Node();
            Node tmp;
            node.value = arr[m];
            tmp = arrayToNode(arr, begin, m - 1);
            node.left = tmp;
            tmp.parent = node;
            tmp = arrayToNode(arr, m + 1, end);
            node.right = tmp;
            tmp.parent = node;
            return node;
        }
    }

    public int getMin() {
        return getMinSub(root);
    }

    private int getMinSub(Node root) {
        if(root == null) 
            return Integer.MAX_VALUE;
        else if(root.left == null)
            return root.value;
        else
            return getMinSub(root.left);
    }

    public int getMax() {
        return getMaxSub(root);
    }

    private int getMaxSub(Node root) {
        if(root == null) 
            return Integer.MAX_VALUE;
        else if(root.right == null)
            return root.value;
        else
            return getMaxSub(root.right);
    }

    public Node findLCA(Node a, Node b) {
        return findLCASub(root, a, b);
    }

    private Node findLCASub(Node root, Node a, Node b) {
        if(root == null || a == null || b == null) {
            return null;
        } else {
            Node tmpa = a;
            Node tmpb = b;
            // a < b
            if(a.value > b.value) {
                Node tmp = tmpa;
                tmpa = tmpb;
                tmpb = tmp;
            }
            if(a.value < root.value && root.value < b.value) 
                return root;
            else if(b.value < root.value) 
                return findLCASub(root.left, a, b);
            else
                return findLCASub(root.right, a, b);
        }
    }

    public Node nextNode(Node node) {
        if(node.right != null) {
            node = node.right;
            while(node.left != null) 
                node = node.left;
            return node;
        } else {
            if(node.parent == null) {
                return node;
            } else {
                if(node.parent.left == node) {
                    return node.parent;
                } else {
                    node = node.parent;
                    while(node.parent != null) {
                        if(node.parent.left == node)
                            return node.parent;
                        node = node.parent;
                    }
                }
            }

            return null;
        }
    }

    public void print() {
        if(root == null) {
            return ;
        } else {
            Queue<Node> queue = new ArrayDeque<Node>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                Node tmp = queue.poll();
                System.out.println(tmp.value);
                if(tmp.left != null)
                    queue.offer(tmp.left);
                if(tmp.right != null)
                    queue.offer(tmp.right);
            }
        }
    }

    public static void main(String[] args) {
        BST bst = new BST();
        int[] sortedArr = {1, 5, 8, 9, 10, 11, 15};
        bst.buildTreeFromSortedArray(sortedArr);
        Node node = bst.getRoot();
        while(node.left != null) {
            node = node.left;
        }
        while(node != null) {
            System.out.println(node);
            node = bst.nextNode(node);
        }
    }
}
