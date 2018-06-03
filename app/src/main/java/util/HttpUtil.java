package util;

import okhttp3.*;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class HttpUtil {
    public static void sendOkHttpRequest(final String address,final String content,final okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8"),content);
        Request request = new Request.Builder()
                .url(address)
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void getImageURLFromJson(){
        String url="http://120.79.36.200:8080/OracleFinalWork_war/getItems/1";//服务器接口地址
        final String[] imgURL = {null};
        sendOkHttpRequest(url, "", new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("失败");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //解析返回值
                String backcode = response.body().string();
                System.out.println("URL-backcode:" + backcode);
                JSONObject jsonObject = null;
                try {
                    jsonObject = new JSONObject(backcode);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println("URL-jsonObject:" + jsonObject);
                try {
                    String imgurl = jsonObject.getString("imgurl");
                    imgURL[0] = imgurl;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        //生成图片文件 然后把图片URL设置成ImageView的background

    }
}
