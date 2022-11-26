package dev.mayaqq.shadeBot.slashCommands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class LinkSlashCommand {
    public static void link(SlashCommandInteractionEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        String linkTitle = event.getOption("title").getAsString();
        String linkUrl = null;
        eb.setColor(event.getMember().getColor());
        if (event.getOption("url").getAsString().startsWith("https://") || event.getOption("url").getAsString().startsWith("http://")) {
            linkUrl = event.getOption("url").getAsString();
        } else {
            linkUrl = "https://" + event.getOption("url").getAsString();
        } try {
            eb.setTitle(linkTitle, linkUrl);
            event.replyEmbeds(eb.build()).queue();
        } catch (IllegalArgumentException e) {
            event.reply("Invalid URL!").setEphemeral(true).queue();
        }
    }
}
