public class UnionFind {
    private int[] tree;

    public UnionFind(int n) {
        this.tree = new int[n];
        for(int i = 0; i < n; i++) 
            tree[i] = -1;
    }
    public int find(int p) {
        if(tree[p] < 0) 
            return p;
        else 
            return tree[p] = find(tree[p]);
    }

    public void uni(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a < b) {
                // a の方が大きい
                tree[a] += tree[b];
                tree[b] = a;
            } else {
                tree[b] += tree[a];
                tree[a] = b;
            }
        }
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for(int i = 0; i < tree.length; i++)
            sb.append(tree[i] + ", ");
        if(sb.length() > 2)
            sb.setLength(sb.length() - 2);
        sb.append("]");
        
        return sb.toString();
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        System.out.println(uf);
        uf.uni(1, 3);
        uf.uni(2, 5);
        uf.uni(3, 4);
        uf.uni(6, 2);
        System.out.println(uf);
    }
}
