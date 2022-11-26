package dev.mayaqq.shadeBot.messageCommands;

import dev.mayaqq.shadeBot.Config;
import dev.mayaqq.shadeBot.utils.Tenor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class GifMCommands {
    static EmbedBuilder eb = new EmbedBuilder();
    public static void hug(MessageReceivedEvent event) {
        String id = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "hug <@", "").replace(">", "");
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getAuthor().getId())) {
            eb.setTitle("You can't hug yourself!");
            event.getMessage().replyEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is hugging <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_hug", 30);
            eb.setImage(tenorUrl);
            //eb.setColor(huggedMember.getColor());
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void kiss(MessageReceivedEvent event) {
        String id = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "kiss <@", "").replace(">", "");
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getAuthor().getId())) {
            eb.setTitle("You can't kiss yourself!");
            event.getMessage().replyEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is kissing <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_kiss", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void pat(MessageReceivedEvent event) {
        String id = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "pat <@", "").replace(">", "");
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getAuthor().getId())) {
            eb.setTitle("You can't pat yourself!");
            event.getMessage().replyEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is patting <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_pat", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void cuddle(MessageReceivedEvent event) {
        String id = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "cuddle <@", "").replace(">", "");
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getAuthor().getId())) {
            eb.setTitle("You can't cuddle yourself!");
            event.getMessage().replyEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is cuddling <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_cuddle", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void highfive(MessageReceivedEvent event) {
        String id = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "highfive <@", "").replace(">", "");
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getAuthor().getId())) {
            eb.setTitle("You can't highfive yourself!");
            event.getMessage().replyEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is highfiving <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_highfive", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
}
