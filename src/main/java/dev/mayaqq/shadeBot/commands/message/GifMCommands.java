package dev.mayaqq.shadeBot.commands.message;

import dev.mayaqq.shadeBot.commands.common.GifCommands;
import dev.mayaqq.shadeBot.utils.BotUtils;
import dev.mayaqq.shadeBot.utils.Tenor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GifMCommands {
    public static void hug(MessageReceivedEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.HUG);
    }
    public static void kiss(MessageReceivedEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.KISS);
    }
    public static void pat(MessageReceivedEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.PAT);
    }
    public static void cuddle(MessageReceivedEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.CUDDLE);
    }
    public static void highfive(MessageReceivedEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.HIGHFIVE);
    }
    public static void kill(MessageReceivedEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.KILL);
    }

    private static void sendFunCommandEmbed(MessageReceivedEvent event, GifCommands.GifType type) {
        EmbedBuilder eb = BotUtils.shadeEmbed(event, type.name().toLowerCase());
        String mention;
        try {
            mention = event.getMessage().getMentions().getMentions(Message.MentionType.USER).get(0).getAsMention();
        } catch (IndexOutOfBoundsException e) {
            eb.setTitle(type.getFailedMessage());
            event.getMessage().replyEmbeds(eb.build()).queue();
            return;
        }
        if (mention.equals(event.getAuthor().getAsMention())) {
            eb.setTitle(type.getFailedMessage());
            event.getMessage().replyEmbeds(eb.build()).queue();
            return;
        }
        eb.addField(type.getTitle(), type.getMessage().replace("%sender%", event.getAuthor().getAsMention()).replace("%target%", mention), true);
        String tenorUrl = Tenor.randomGIF(type.getTenorSearch(), 30);
        eb.setImage(tenorUrl);
        event.getChannel().sendMessageEmbeds(eb.build()).queue();
    }
}
