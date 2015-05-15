public class AVL {
    class AVLNode {
        AVLNode left, right, parent;
        int value;

        public String toString() {
            System.out.println(this.value);
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(Integer.toString(value));
            sb.append("(");
            if(left != null) 
                sb.append(left.toString());
            sb.append(",");
            if(right != null)
                sb.append(right.toString());
            sb.append(")");
            sb.append(")");
            return sb.toString();
        }
    }

    private int height;
    private AVLNode root;

    public AVLNode getRoot() {
        return this.root;
    }

    public void insert(int value) {
        if(this.root == null) {
            this.root = new AVLNode();
            this.root.value = value;
        } else {
            insertSub(this.root, value);
        }
    }

    private void insertSub(AVLNode root, int value) {
        if(root == null) {
            return;
        } else {
            // root != null
            AVLNode tmp = new AVLNode();
            tmp.value = value;
            if(value > root.value) {
                if(root.right != null) {
                    insertSub(root.right, value);
                } else {
                    root.right = tmp;
                    tmp.parent = root;
                }
            } else {
                if(root.left != null) {
                    insertSub(root.left, value);
                } else {
                    root.left = tmp;
                    tmp.parent = root;
                }
            }
        }
    }

    public int getHeight() {
        return getHeightSub(root);
    }

    public int getHeightSub(AVLNode root) {
        if (root == null) 
            return 0;
        else 
            return Math.max(getHeightSub(root.left), 
                    getHeightSub(root.right));
    }

    public void llRotate(AVLNode root) throws Exception {
        if(root == null || root.left == null) {
            throw new Exception("Can't Rotate!");
        } else {
            // root != null && root.left != null
            if(root.parent != null) {
                if(root.parent.left == root)
                    root.parent.left = root.left;
                else 
                    root.parent.right = root.left;
            } else {
                this.root = root.left;
                this.root.parent = null;
            }

            AVLNode tmp = root.left;
            root.parent = tmp;
            root.left = root.left.right;
            if(root.left != null)
                root.left.parent = root;
            tmp.right = root;
        }
    }

    public void rrRotate(AVLNode root) throws Exception {
        if(root == null || root.right == null) {
            throw new Exception("Can't Rotate!");
        } else {
            // root != null && root.right != null
            if(root.parent != null) {
                if(root.parent.right == root)
                    root.parent.right = root.right;
                else 
                    root.parent.left = root.right;
            } else {
                this.root = root.right;
                this.root.parent = null;
            }

            AVLNode tmp = root.right;
            root.parent = tmp;
            root.right = root.right.left;
            if(root.right != null)
                root.right.parent = root;
            tmp.left = root;
        }
    }

    public void lrRotate(AVLNode root) throws Exception {
    }

    public String toString() {
        if(root == null) 
            return "[]";
        else
            return root.toString();
    }

    public static void main(String[] args) throws Exception {
        AVL avl = new AVL();
        System.out.println(avl.toString());
        avl.insert(5);
        avl.insert(3);
        avl.insert(2);
        avl.insert(4);
        avl.insert(6);
        System.out.println(avl.toString());
        avl.llRotate(avl.getRoot());
        System.out.println(avl.toString());
        avl.llRotate(avl.getRoot());
        System.out.println(avl.toString());
        avl.rrRotate(avl.getRoot());
        System.out.println(avl.toString());
        avl.rrRotate(avl.getRoot());
        System.out.println(avl.toString());
    }
}
