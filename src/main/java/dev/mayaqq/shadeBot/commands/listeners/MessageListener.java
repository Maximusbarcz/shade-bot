package dev.mayaqq.shadeBot.commands.listeners;

import dev.mayaqq.shadeBot.Config;
import dev.mayaqq.shadeBot.commands.message.AdminMCommands;
import dev.mayaqq.shadeBot.commands.message.GifMCommands;
import dev.mayaqq.shadeBot.commands.message.funMCommands;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Arrays;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //admin commands
        if (event.getAuthor().isBot()) return;

        String message = event.getMessage().getContentRaw();
        if (message.startsWith(Config.CONFIG.prefix)) {
            message = message.substring(1);
            switch (Arrays.stream(message.split(" ")).toList().get(0)) {
                case "stop" -> AdminMCommands.shutdown(event);
                case "restart" -> AdminMCommands.restart(event);
                case "hug" -> GifMCommands.hug(event);
                case "pat" -> GifMCommands.pat(event);
                case "kiss" -> GifMCommands.kiss(event);
                case "cuddle" -> GifMCommands.cuddle(event);
                case "highfive" -> GifMCommands.highfive(event);
                case "kill" -> GifMCommands.kill(event);
            }
        }

        String[] words = event.getMessage().getContentRaw().split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String wordLower = word.toLowerCase();
            if (wordLower.equals("sob")) {
                funMCommands.sob(event);
                break;
            }
            if (wordLower.equals("bident")) {
                funMCommands.bident(event);
                break;
            }
            if (wordLower.equals("neat")) {
                funMCommands.neat(event);
                break;
            }
            if (wordLower.equals("rat")) {
                funMCommands.rat(event);
                break;
            }
            if (wordLower.contains("greg")) {
                funMCommands.greg(event);
                break;
            }
            if (wordLower.equals("update")) {
                String word2 = words[i + 1].toLowerCase();
                switch (word2) {
                    case "estrogen" -> funMCommands.updateEstrogen(event);
                }
            }
        }
    }
}

