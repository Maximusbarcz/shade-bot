package dev.mayaqq.shadeBot.utils;

import dev.mayaqq.shadeBot.Config;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Tenor {
    public static String apiKey = Config.CONFIG.tenorKey;
    static OkHttpClient client = new OkHttpClient().newBuilder()
            .build();

    public static String randomGIF(String searchTerm, int maxResults) {
        Request request = new Request.Builder()
                .url(String.format("https://api.tenor.com/v1/search?q=%1$s&key=%2$s&limit=%3$s", searchTerm, apiKey, maxResults))
                .method("GET", null)
                .build();
        try {
            Response response = client.newCall(request).execute();
            Random rand = new Random();
            ArrayList<String> list = new ArrayList<>();
            JSONObject jsonObject = new JSONObject(response.body().string());
            JSONArray jsonArray = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getJSONObject(i).getJSONArray("media").getJSONObject(0).getJSONObject("gif").getString("url"));
            }
            return list.get(rand.nextInt(list.size()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}