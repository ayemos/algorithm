class A{
    public static void main(String[] a){
        int b=0;char s;
        try{
            while((s=(char)System.in.read())!='\n')
                b+=b*9+(s-'0');int c=0;
            for(int i = 2;i <= b;i++)
                for(int j=2; j<=i;j++){
                    if(j==i)c++;
                    if(i%j==0)break;
                }
            System.out.println(c);
        }catch(Exception e){}}}
