import java.util.Scanner;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        while(sc.hasNext()) {
            String str = sc.next();
            String sorted = sortStr(str);

            if(map.containsKey(sorted)) {
                List<String> list = map.get(sorted);
                list.add(str);
            } else {
                List<String> list = new LinkedList<String>();
                list.add(str);
                map.put(sorted, list);
            }
        }

        for(List<String> list : map.values()) 
            for(String s : list) 
                System.out.println(s);
    }

    static String sortStr(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}
