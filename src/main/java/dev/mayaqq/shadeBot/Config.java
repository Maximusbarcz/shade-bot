package dev.mayaqq.shadeBot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Map;

public class Config {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static File conf = new File("conf.json");

    public static void create() throws IOException {
        if (!conf.exists()) {
            conf.createNewFile();
            try (FileWriter writer = new FileWriter(conf)) {
                gson.toJson(new Conf(), writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String getToken() throws FileNotFoundException {
        Map map = gson.fromJson(new FileReader(conf), Map.class);
        return (map.get("token").toString());
    }


    public static class Conf {
        static String token = "YOUR BOT TOKEN HERE";
    }
}
