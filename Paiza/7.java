import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int h = Integer.parseInt(nums[0]);
        int w = Integer.parseInt(nums[1]);

        char[][] room = new char[w][h];
        

        for(int i = 0; i < h; i++) {
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < w; j++) 
                room[j][i] = line[j];
        }

        int x = 0;
        int y = 0;
        int n = 0;
        int dir = 0; // r, d, l, u => 0, 1, 2, 3

        while(x >= 0 && x < w && y >= 0 && y < h) {
            switch(room[x][y]) {
                case '_':
                    break;
                case '/':
                    dir = 3 - dir;
                    break;
                case '\\':
                    switch(dir) {
                        case 0:
                            dir = 1;
                            break;
                        case 1:
                            dir = 0;
                            break;
                        case 2:
                            dir = 3;
                            break;
                        case 3:
                            dir = 2;
                            break;
                    }
                    break;
            }

            switch(dir) {
                case 0:
                    x++;
                    break;
                case 1:
                    y++;
                    break;
                case 2:
                    x--;
                    break;
                case 3:
                    y--;
                    break;
            }

            n++;
        }
        System.out.println(n);
    }
}

