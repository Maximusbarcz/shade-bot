package dev.mayaqq.shadeBot.messageCommands;

import dev.mayaqq.shadeBot.Config;
import dev.mayaqq.shadeBot.utils.FunnyMayaLogger;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        FunnyMayaLogger.log(event);
        //admin commands
        if (event.getAuthor().isBot()) return;

        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "stop") && event.getAuthor().getId().equals("698623223872356413")) {
            AdminMCommands.shutdown(event);
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "restart") && event.getAuthor().getId().equals("698623223872356413")) {
            AdminMCommands.restart(event);
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "hug ")) {
            GifMCommands.hug(event);
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "pat ")) {
            GifMCommands.pat(event);
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "kiss ")) {
            GifMCommands.kiss(event);
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "cuddle ")) {
            GifMCommands.cuddle(event);
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "highfive ")) {
            GifMCommands.highfive(event);
        }
        for (String word : event.getMessage().getContentRaw().split(" ")) {
            String wordLower = word.toLowerCase();
            if (wordLower.equals("neat")) {
                funMCommands.neat(event);
            }
            if (wordLower.equals("rat")) {
                funMCommands.rat(event);
            }
            if (wordLower.contains("greg")) {
                funMCommands.greg(event);
            }
        }
    }
}

