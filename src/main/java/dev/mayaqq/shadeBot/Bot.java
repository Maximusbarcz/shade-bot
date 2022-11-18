package dev.mayaqq.shadeBot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Bot {
    public static void main(String[] args) throws InterruptedException, IOException {
        Config.create();
        JDABuilder jdaBotBuilder = JDABuilder.createDefault(Config.getToken());

        jdaBotBuilder.setActivity(Activity.watching("colors"));

        jdaBotBuilder.addEventListeners(new SlashCommandListener());

        JDA shadeBot = jdaBotBuilder.build();

        shadeBot.updateCommands().addCommands(
                Commands.slash("info", "Tells you general info about this server.")
        ).queue();


        shadeBot.awaitReady();
    }
}
