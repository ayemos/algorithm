/* 
 * 親配列を使ったグラフの表現とその問題
 */

public class ParentArray {
    private int[] graph;
    private int[] memo;

    public int maxdep(int[] graph, int n) {
        this.graph = graph;
        this.memo = new int[n];

        int max = 0;
        int dep;
        for(int i = 0; i < n; i++) {
            dep = depth(i);
            if(dep > max)
                max = dep;
        }

        return max;
    }

    private int depth(int cur) {
        if(memo[cur] > 0)
            return memo[cur];

        if(graph[cur] == -1) {
            return 0;
        } else {
            int res = depth(graph[cur]) + 1;
            memo[cur] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] graph = {-1, 0, 1, 6, 6, 0, 0, 2, 7};
        System.out.println(new ParentArray().maxdep(graph, 9));
    }
}




