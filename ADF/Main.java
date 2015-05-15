import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;

@SuppressWarnings("deprecation")
public class Main {
        public static void main(String args[]) {
            StringBuilder builder = new StringBuilder();
            try {
                JSONArray jsonArray = new JSONArray(builder.toString());
                System.out.println("Number of entries " + jsonArray.length());
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    System.out.println(i);
                    System.out.println("投稿日："+jsonObject.getString("created_at"));
                    System.out.println("ツイート内容："+jsonObject.getString("text"));
                    System.out.println("ユーザー自己紹介："+jsonObject.getJSONObject("user").getString("description"));             
                    System.out.println();//改行
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
