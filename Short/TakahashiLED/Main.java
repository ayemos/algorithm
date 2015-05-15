class Main {
    public static void main(String[] a){
        String[] s={"□■■■□", 
            "■□□□■",
            "□□□□□",
            "□□□□■",
            "■□□□□"};
        String[] d={"0112110","2332332","0330440","0330330","2110332","0440330","0440110","0332332","0110110","0110330"};
        int[] f={112110,2332332,440330,330330,2330112,330440,110440,233233,110110,330110};
        try {
        int k=(System.in.read()-'0');
        for(int i=-1;i++<7;System.out.println(s[f[k]%10])){
            System.out.println(f[k]%10);
            f[k]/=10;
        }
        }catch(Exception e){}
    }

}
