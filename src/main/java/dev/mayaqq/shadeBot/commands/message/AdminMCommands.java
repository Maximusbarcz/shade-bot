package dev.mayaqq.shadeBot.commands.message;

import dev.mayaqq.shadeBot.Shade;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class AdminMCommands {

    public static void shutdown(MessageReceivedEvent event) {
        if (isMaya(event)) {
            event.getChannel().sendMessage("Shutting down...").queue();
            event.getJDA().shutdown();
            System.exit(0);
        }
    }
    public static void restart(MessageReceivedEvent event) {
        if (isMaya(event)) {
            event.getMessage().reply("Restarting...").queue();
            event.getJDA().shutdown();
            try {
                Shade.main(null);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static boolean isMaya(MessageReceivedEvent event) {
        return event.getAuthor().getId().equals("698623223872356413");
    }
}
