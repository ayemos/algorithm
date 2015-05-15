import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final String LINE_SPR = System.getProperty("line.separator");
    final char[] VOWELS = {'a', 'e', 'i', 'o' ,'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y'};

    public  class Customer {
        String name;
        int vowels;
        int consos;
        int length;

        public Customer(String name) {
            int v = 0;
            for(int i = 0; i < name.length(); i++) 
                for(char vowel : VOWELS) 
                    if(name.charAt(i) == vowel) {
                        v++;
                        break;
                    }

            this.name = name;
            this.vowels = v;
            this.length = name.length() - (name.split(" ").length - 1);
            this.consos = this.length - this.vowels;
        }

        public String toString() {
            return "Customer(" + name + ") : \nvowels(" + vowels + 
                                             ") : \nconsos(" + consos + 
                                                  ") : \nlength(" + length + ")\n";
        }
    }

    void run() throws Exception {
        String line;
        while((line = br.readLine()) != null) {
            line = line.trim();
            List<Customer> customers = new ArrayList<Customer>();

            String[] ws = line.split(";");
            for(String name : ws[0].split(",")) 
                customers.add(new Customer(name.trim()));
            List<String> goods = Arrays.asList(ws[1].split(","));
            double res = solve(customers, goods, 0.0);
            /*
            for(int i = 0; i < goods.size(); i++) {
                System.out.println("Customer : " + customers.get(i));
                System.out.println("Goods : " + goods.get(i));
            }
            */

            System.out.println(res);
        }
    }

    double solve(List<Customer> customers, List<String> goods, double score) {
        /*
        System.out.println("_______________________________");
        System.out.println(customers);
        System.out.println(goods);
        System.out.println("_______________________________");
        */
        if(customers.size() == 1 && goods.size() == 1)  {
            double res = score + calc(customers.get(0), goods.get(0));
            return res;
        }

        double max = 0.0;
        for(Customer customer: customers) {
            for(String good : goods) {
                List<Customer> tmpCustomers = new ArrayList<Customer>(customers);
                List<String> tmpGoods = new ArrayList<String>(goods);
                tmpCustomers.remove(customer);
                tmpGoods.remove(good);
                double tmp =  solve(tmpCustomers, tmpGoods, score+calc(customer, good));
                if(tmp > max)
                    max = tmp;
            }
        }

        return max;
    }

    double calc(Customer customer, String goods) {
        double score = 0.0;
        goods = goods.trim();
        int len = goods.length() - goods.split(" ").length + 1;
        if(len % 2 == 0) 
            score = customer.vowels * 1.5;
        else 
            score = customer.consos;

        double res = shareFactor(len, customer.name.length()) 
            ? score : score * 1.5;

        return res;
    }

    boolean shareFactor(int a, int b) {
        for(int i = 2; i <= a; i++) 
            if(a % i == 0 && b % i == 0)
                return true;
        return false;
    }

    /*
     * Templates
     */
    void dumpArray1(Object[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if(i < n - 1)
                System.out.print(" ");
        }
    }

    void dumpArray2(Object[][] arr, int m, int n) {
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) { 
                System.out.print(arr[i][j]);
                if (i < m - 1) 
                    System.out.print(" ");
            }

            System.out.println(" ");
        }
    }

    boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    int getPrime(int n) {
          List<Integer> primes = new ArrayList<Integer>();
          primes.add(2);
          int count = 1;

          int x = 1;
          while(primes.size() < n) {
              x+=2;
              int m = (int)Math.sqrt(x);
              for(int p : primes) {
                  if(p > m) {
                      primes.add(x);
                      break;
                  }

                  if(x % p == 0) 
                      break;
              }
          }

          return primes.get(primes.size() - 1);
    }


    public static void main(String[] args) throws Exception {
        new Main().run();
    }
}


