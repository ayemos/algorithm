import java.util.*;
class A{
    public static void main(String[] a){
        int[]b;char c;int n=0;int m=0;
        try{
            while((c=(char)System.in.read())!='\n')
                m+=m*9+(c-'0');
            b=new int[m];
            for(;m>0;m--){
                while((c=(char)System.in.read())!='\n')
                    b[n]+=b[n]*9+(c-'0');
                n++;
            }
            Arrays.sort(b);
            System.out.println(b[n/2]);
        }catch(Exception e){}
    }
}
