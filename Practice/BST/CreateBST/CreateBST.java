public class CreateBST {
    class BSTNode {
        BSTNode left, right;
        int value;

        public String toString() {
            String left = this.left != null ? this.left.toString() : "";
            String right = this.right != null ? this.right.toString() : "";
            return "value: " + value + "\nleft:\n " + left + "\nright:\n " + right;
        }
    }

    BSTNode createBST(int[] arr, int start, int end) {
        if(start > end) 
            return null;

        int mid = (start + end + 1) / 2;

        BSTNode node = new BSTNode();
        node.value = arr[mid];
        node.left = createBST(arr, start, mid - 1);
        node.right = createBST(arr, mid+1, end);

        return node;
    }
    

    public static void main(String[] args) throws Exception {
        CreateBST c = new CreateBST();
        int[] arr = {1, 2, 3, 4, 5, 6};

        System.out.println(c.createBST(arr, 0, arr.length - 1));
    }
}




