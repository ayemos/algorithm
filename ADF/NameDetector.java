import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class NameDetector {
    private static final String INITIAL_NAME = "ICHIRO";
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final List<String> names = new ArrayList<String>();

    public void run() throws IOException {
        String name = INITIAL_NAME;

        String ns = "Akifumi Imanishi, Akihiro Tamada, Akira Saso, Akiyoshi Otani, Daichi Takehara, Daisuke Ito, Daisuke Kobayashi, Dashdemberel Batchunag, Davaajargal Orgil, Hakusen To, Hirokazu Miyahara, Hiroto Takahashi, Hitoshi Togasaki, Ichiki Sato, Ichiro Shoda, Ippei Nawate, Jumpei Matsuda, Jun Maruyama, Kazuki Bandai, Kazumasa Fujita, Kazuyuki Hiroshiba, Keitaro Wakabayashi, Kenkou Nakamura, Kenta Utsunomiya, Kento Haneda, Kodai Ito, Koji Misaki, Koji Nishikiori, Koki Nakamura, Kunihiro Takeoka, Mamoru Uehara, Masahiko Nishida, Masaki Ono, Masayoshi Wada, Mashiho Iida, Noboru Kano, Noriyuki Matsuoka, Riku Asayama, Ryo Yamaguchi, Ryohei Tokuda, Ryoya Ino, Sayoko Harada, Shogo Okamuro, Shohei Yasutake, Shota Toguchi, Shoya Ishimaru, Shoya Tanaka, Shuhei Takeda, Shun Ohmatsu, Souhei Hirai, Subaru Kondo, Taishi Saito, Takamasa Mizukami, Takenori Nakagawa, Takeshi Ihara, Takuya Tsunekawa, Tomohiro Yanagi, Tsuyoshi Sone, Yasuaki Goto, Yasuaki Hatakeyama, Yasuhiro Mitsuno, Yasunari Kondo, Yoshiaki Kadono, Yoshitomo Matsubara, Yosuke Egashira, Yu Kadowaki, Yuichiro Kikura, Yuichiro Someya, Yuki Ogasawara, Yusuke Miyazaki, Yusuke Yamada, Yuta Tasaka, Yutaro Fujii, shuhei morifuji, taisei igarashi";

        for(String s : ns.split(",")) 
            names.add(s.trim());

        find();
    }

    private void find() throws IOException {
        int mid = names.size() / 2;
        int low = 0;
        int high = names.size();
        while(true) {
            ask(names.get(mid));

            String line;
            line = br.readLine();
            try {
                int i = Integer.parseInt(line);
                if(i < 1 || i > 3) 
                    System.out.println("1から3の数字を入力して下さい。");

                switch(i) {
                    case 1:
                        System.out.println("よかったね。");
                        return;
                    case 2:
                        high = mid;
                        mid = (high + low) / 2;
                        break;
                    case 3:
                        low = mid;
                        mid = (high + low) / 2;
                        break;
                }
            } catch (NumberFormatException nfe) {
                System.out.println("数字を入力してください。");
            }
        }
    }

    private void ask(String name) {
        System.out.println("あなたの名前は " + name + "？");
        System.out.println("1: その通り！");
        System.out.println("2: 違う(辞書順でもっと上(a側))");
        System.out.println("3: 違う(辞書順でもっと下(z側))");
    }

    public static void main(String[] args) throws IOException {
        try {
            new NameDetector().run();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Fatal IO error. Exit Program.");
            System.exit(1);
        }
    }
}




