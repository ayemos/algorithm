import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static class Node {
        int x, y, z;
        public Node(int x, int y, int z) { this.x = x; this.y = y; this.z = z; }

        public String toString() {
            return "(" + x + ", " + y + ", " + z + ")";
        }
    }

    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            String[] ws = line.split(";");
            int n = Integer.parseInt(ws[0]);
            String cube = ws[1];
            int[] steps = new int[cube.length()];
            for(int i = 0; i < steps.length; i++)
                steps[i] = Integer.MAX_VALUE;

            // find entrance and run solve for each.
            Deque<Node> deque = new LinkedList<Node>();
            for(int j = 0; j < n; j++) {
                if(getCharAt(cube, j, 0, 0, n) != '*'){
                    Node node = new Node(j, 0, 0);
                    setStepAt(steps, node, n, 1); 
                    deque.offer(node);
                }
                if(getCharAt(cube, 0, j, 0, n) != '*'){
                    Node node = new Node(0, j, 0);
                    setStepAt(steps, node, n, 1); 
                    deque.offer(node);
                }
                if(getCharAt(cube, j, n-1, 0, n) != '*') {
                    Node node = new Node(j, n-1, 0);
                    setStepAt(steps, node, n, 1); 
                    deque.offer(node);
                }
                if(getCharAt(cube, n-1, j, 0, n) != '*') {
                    Node node = new Node(n-1, j, 0);
                    setStepAt(steps, node, n, 1); 
                    deque.offer(node);
                }
            }

            int res = 0;
            while(!deque.isEmpty()) {
                Node node = deque.poll();
                int stepHere = getStepAt(steps, node, n);

                // check goal
                if(node.z == n-1 &&
                        (node.x == 0 || node.x == n-1 || node.y == 0 || node.y == n-1) &&
                        getCharAt(cube, node, n) != '*') {
                    res = getStepAt(steps, node, n);
                    break;
                }

                int[] dxs = {1, 0, -1, 0};
                int[] dys = {0, 1, 0, -1};

                for(int i = 0; i < 4; i++) {
                    int dx = dxs[i];
                    int dy = dys[i];
                    Node tmp = new Node(node.x, node.y, node.z);
                    tmp.x += dx; tmp.y += dy;
                    if(tmp.x < 0 || tmp.x >= n || tmp.y < 0 || tmp.y >= n) continue;

                    int stepNext = getStepAt(steps, tmp, n);

                    if(getCharAt(cube, tmp, n) != '*' &&
                            stepNext > stepHere) {
                        setStepAt(steps, tmp, n, stepHere + 1);
                        deque.offer(tmp);
                    }
                }

                // check holes
                if(node.z > 0) {
                    Node below = new Node(node.x, node.y, node.z);
                    below.z -= 1;
                    int stepBelow = getStepAt(steps, below, n);

                    if(getCharAt(cube, below, n) == 'o' &&
                            stepBelow > stepHere) {
                        setStepAt(steps, below, n, stepHere + 1);
                        deque.offer(below);
                    }
                } 
                if(node.z < n - 1) {
                    Node above = new Node(node.x, node.y, node.z);
                    above.z += 1;
                    int stepAbove = getStepAt(steps, above, n);

                    if(getCharAt(cube, above, n) == 'o' &&
                            stepAbove > stepHere) {
                        setStepAt(steps, above, n, stepHere + 1);
                        deque.offer(above);
                    }
                }
            }

            System.out.println(res); 
        }
    }

    /*
     * Utils
     */
    public static char getCharAt(String str, Node no, int n) {
        return getCharAt(str, no.x, no.y, no.z, n);
    }

    public static char getCharAt(String str, int x, int y, int z, int n) {
        return str.charAt(x + y*n + z*n*n);
    }

    public static int getStepAt(int[] steps, Node no, int n) {
        return getStepAt(steps, no.x, no.y, no.z, n);
    }

    public static int getStepAt(int[] steps, int x, int y, int z, int n) {
        return steps[x + y*n + z*n*n];
    }

    public static void setStepAt(int[] steps, Node no, int n, int step) {
        setStepAt(steps, no.x, no.y, no.z, n, step);
    }

    public static void setStepAt(int[] steps, int x, int y, int z, int n, int step) {
        steps[x + y*n + z*n*n] = step;
    }
}
