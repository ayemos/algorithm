import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.awt.Point;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int l = Integer.parseInt(nums[0]);
        int n = Integer.parseInt(nums[1]);
        int m = Integer.parseInt(nums[2]);

        Map<Point, Point> points = 
            new HashMap<Point, Point>();

        for(int i = 0; i < m; i++) {
            String[] ls = br.readLine().split(" ");
            int x = Integer.parseInt(ls[0]);
            points.put(new Point(x, Integer.parseInt(ls[1])), 
                    new Point(x + 1, Integer.parseInt(ls[2])));
            points.put(new Point(x + 1, Integer.parseInt(ls[2])),
                    new Point(x, Integer.parseInt(ls[1])));
        }

        int x = 1;
        int y = l;
        while(y > 1) {
            System.out.println("X:Y => " + x + ":" + y);
            Point p = new Point(x, y);
            if(points.containsKey(p)){
                Point pt = points.get(p);
                x = pt.x;
                y = pt.y;
            } 

            y--;
        }

        System.out.println(x);
    }
}

