package dev.mayaqq.shadeBot.messageCommands;

import dev.mayaqq.shadeBot.Bot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AdminMCommands {
    public static void shutdown(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Shutting down...").queue();
        event.getJDA().shutdown();
        System.exit(0);
    }
    public static void restart(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Restarting...").queue();
        event.getJDA().shutdown();
        try {
            Bot.main(null);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
