import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static class Node {
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x; this.y = y; 
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int w = Integer.parseInt(nums[0]);
        int h = Integer.parseInt(nums[1]);

        char map[][] = new char[w][h];
        int dist[][] = new int[w][h];

        Queue<Node> q = new LinkedList<Node>();

        for(int j = 0; j < h; j++) {
            String[] row = br.readLine().split(" ");

            for(int i = 0; i < w; i++) {
                if (row[i].equals("s")) {
                    q.offer(new Node(i, j));
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
                map[i][j] = row[i].toCharArray()[0];
            }
        }
        
        while(!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int[] dxs = {1, 0, -1,  0}; 
            int[] dys = {0, 1,  0, -1};

            for(int k = 0; k < 4; k++){
                int dx = dxs[k];
                int dy = dys[k];
                int tx = x + dx; int ty = y + dy;

                if(tx >= 0 && tx < w && ty >= 0 && ty < h) {
                    if(map[tx][ty] == 'g') {
                        System.out.println(dist[x][y]+1);
                        return;
                    } else if(map[tx][ty] != '1' && 
                            dist[tx][ty] > dist[x][y]) {
                        q.offer(new Node(tx, ty));
                        dist[tx][ty] = dist[x][y]+1;
                            }
                }
            }
        }

        System.out.println("Fail");
    }

    public static void dumpdist(int dist[][], int w, int h) {
        for(int j = 0; j < h; j++) {
            for(int i = 0; i < w; i++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void dumpmap(char map[][], int w, int h) {
        for(int j = 0; j < h; j++) {
            for(int i = 0; i < w; i++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

