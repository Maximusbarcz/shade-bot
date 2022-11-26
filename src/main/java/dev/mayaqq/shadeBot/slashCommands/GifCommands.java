package dev.mayaqq.shadeBot.slashCommands;

import dev.mayaqq.shadeBot.utils.Tenor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GifCommands {
    static EmbedBuilder eb = new EmbedBuilder();
    public static void hug(SlashCommandInteractionEvent event) {
        String id = event.getOption("user").getAsUser().getId();
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getUser().getId())) {
            eb.setTitle("You can't hug yourself!");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getUser().getId() + "> is hugging <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_hug", 30);
            eb.setImage(tenorUrl);
            //eb.setColor(huggedMember.getColor());
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void kiss(SlashCommandInteractionEvent event) {
        String id = event.getOption("user").getAsUser().getId();
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getUser().getId())) {
            eb.setTitle("You can't kiss yourself!");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getUser().getId() + "> is kissing <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_kiss", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void pat(SlashCommandInteractionEvent event) {
        String id = event.getOption("user").getAsUser().getId();
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getUser().getId())) {
            eb.setTitle("You can't pat yourself!");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getUser().getId() + "> is patting <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_pat", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void cuddle(SlashCommandInteractionEvent event) {
        String id = event.getOption("user").getAsUser().getId();
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getUser().getId())) {
            eb.setTitle("You can't cuddle yourself!");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getUser().getId() + "> is cuddling <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_cuddle", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
    public static void highfive(SlashCommandInteractionEvent event) {
        String id = event.getOption("user").getAsUser().getId();
        eb.setColor(event.getMember().getColor());
        if (id.equals(event.getUser().getId())) {
            eb.setTitle("You can't highfive yourself!");
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        } else {
            eb.addField("Cute!", "Awww, how cute! <@" + event.getUser().getId() + "> is highfiving <@" + id + ">!", true);
            String tenorUrl = Tenor.randomGIF("anime_highfive", 30);
            eb.setImage(tenorUrl);
            eb.setColor(event.getMember().getColor());
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
        }
    }
}
