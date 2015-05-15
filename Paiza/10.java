import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static class Person {
        public int id;
        public List<Integer> suspects = new ArrayList<Integer>();
        public List<Integer> honests = new ArrayList<Integer>();

        public Person(int id) {
            this.id = id;
        }

        public int addEvid(Person to, EvidType type, int c) {
            if(to.id == this.id && type == EvidType.LIAR)
                return -1;

            if (type == EvidType.HONEST) {
                // add all honests/suspects to target's honests/suspects
                for(int id : honests) 
                    if (to.suspects.contains(id)) 
                        return -1;
                    else
                        to.honests.add(id);
                for(int id : suspects)
                    if (to.honests.contains(id))
                        return -1;
                    else 
                        to.suspects.add(id);

                if (honests.contains(to.id))
                    return c;
                
                if (suspects.contains(this.id)) 
                    return -1;
                else
                    honests.add(to.id);

                if (to.suspects.contains(this.id))
                    return -1;
                else
                    to.honests.add(this.id);
            } else {
                // add all honests/suspects to target's suspects/honests
                for(int id : honests) 
                    if (to.honests.contains(id)) 
                        return -1;
                    else
                        to.suspects.add(id);
                for(int id : suspects)
                    if (to.suspects.contains(id))
                        return -1;
                    else 
                        to.honests.add(id);

                if (suspects.contains(to.id))
                    return c;

                if (honests.contains(id)) {
                    return -1;
                } else {
                    suspects.add(to.id);
                }

                if (to.honests.contains(id))
                    return -1;
                else
                    to.suspects.add(this.id);
            }

            return c - 1;
        }
    }

    static enum EvidType {
        HONEST,
        LIAR
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]); // # of people 1 ~ 1000
        int m = Integer.parseInt(nums[1]); // # of testimony 0 ~ 100000
            
        List<Person> persons = new ArrayList<Person>();

        for(int i = 0; i < n; i++) 
            persons.add(new Person(i));

        int c = n;
        for(int j = 0; j < m; j++) {
            String[] evid = br.readLine().split(" ");
            Person from = persons.get(Integer.parseInt(evid[0]) - 1);
            Person to = persons.get(Integer.parseInt(evid[2]) - 1);
            EvidType type = evid[5].equals("honest") ? EvidType.HONEST : EvidType.LIAR;
            c = from.addEvid(to, type, c);

            if(c == -1) {
                System.out.println("-1");
                return;
            }
            //dumppersons(persons);
        }

        System.out.println(c+1);
    }

    public static void dumppersons(List<Person> persons) {
        System.out.println("---------------------------");
        for(Person p : persons) {
            System.out.println("Person (" + p.id + ") :");
            System.out.print("    suspects (");
            System.out.println(p.suspects + ")");
            System.out.print("    honests (");
            System.out.println(p.honests + ")");
        }
        System.out.println("---------------------------");
    }
}

