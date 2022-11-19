package dev.mayaqq.shadeBot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class Config {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static CodeSource codeSource = Bot.class.getProtectionDomain().getCodeSource();
    static File jarFile;

    static {
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static String jarDir = jarFile.getParentFile().getPath();
    static File conf = new File("conf.json");
    //static File conf = new File(jarDir, "conf.json");

    public static Conf CONFIG = new Conf();

    public Config() throws URISyntaxException {
    }

    public static void load() {
        if (!conf.exists()) {
            try {
                conf.createNewFile();
                saveConfig();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                CONFIG = gson.fromJson(new FileReader(conf), Conf.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void saveConfig() throws IOException {
        //Write some info into the file under here
        FileWriter writer = new FileWriter(conf);
        writer.write(gson.toJson(CONFIG));
        writer.close();
    }


    public static class Conf {
        String token = "YOUR BOT TOKEN HERE";
        String prefix = "*";

        public Conf() {}
    }
}
