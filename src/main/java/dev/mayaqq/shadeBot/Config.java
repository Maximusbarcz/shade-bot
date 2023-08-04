package dev.mayaqq.shadeBot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.*;
import java.io.*;
import java.net.URISyntaxException;
import java.security.CodeSource;

public class Config {
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static CodeSource codeSource = Shade.class.getProtectionDomain().getCodeSource();
    static File jarFile;
    static boolean isJar = codeSource.getLocation().getPath().endsWith(".jar");
    static File conf;

    static {
        try {
            jarFile = new File(codeSource.getLocation().toURI().getPath());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    static String jarDir = jarFile.getParentFile().getPath();

    public static Conf CONFIG = new Conf();

    public static void load() {

        conf = isJar ? new File(jarDir, "conf.json") : new File("conf.json");

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
        public String prefix = "*";
        public String tenorKey = "LIVDSRZULELA";

        public Conf() {}
    }
}
