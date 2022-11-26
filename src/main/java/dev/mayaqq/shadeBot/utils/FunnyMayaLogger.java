package dev.mayaqq.shadeBot.utils;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class FunnyMayaLogger {
    public static void log(MessageReceivedEvent event) {
        User maya = event.getJDA().getUserById("698623223872356413");
        if (event.getMessage().getContentRaw().contains("maya")) {
            maya.openPrivateChannel().queue((channel) -> {
                channel.sendMessage("User: " + event.getAuthor().getAsTag() + " | Message: " + event.getMessage().getContentRaw()).queue();
            });
        }
    }
}
