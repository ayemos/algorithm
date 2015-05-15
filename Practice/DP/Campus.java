import java.util.*;

public class Campus {
    class Color {
        int r, g, b;
        public int hashCode() {
            return r * 31 * 31 + g * 31 + b;
        }
        public boolean equals(Object obj) {
            if(obj instanceof Color) {
                Color c = (Color)obj;
                return r == c.r && g == c.g && b == c.b;
            } else {
                return false;
            }
        }
    }

    class Point {
        int x, y;
        public Point(int x, int y) { this.x = x; this.y = y; }
        public boolean equals(Object obj) {
            if(obj instanceof Point) {
                Point p = (Point)obj;
                return x == p.x && y == p.y;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return x * 31 + y;
        }
    }

    private Color[][] campus;
    private int w, h;

    public void colver(int x, int y, Color c) {
        boolean[][] visited = new boolean[w][h];
        Queue<Point> queue = new ArrayDeque<Point>();
        queue.offer(new Point(x, y));

        while(!queue.isEmpty()) {
            Point p = queue.poll();
            if(!visited[p.y][p.x]) {
                visited[p.y][p.x] = true;
                campus[y][x] = c;
                queue.offer(new Point(x + 1, y));
                queue.offer(new Point(x - 1, y));
                queue.offer(new Point(x, y + 1));
                queue.offer(new Point(x, y - 1));
            }
        }
    }

    public Campus(int w, int h) {
        this.campus = new Color[w][h];
    }

}
