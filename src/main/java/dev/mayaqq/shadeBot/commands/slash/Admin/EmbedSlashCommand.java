package dev.mayaqq.shadeBot.commands.slash.Admin;

import dev.mayaqq.shadeBot.utils.ColorUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class EmbedSlashCommand {
    public static void embed(SlashCommandInteractionEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.clear();
        String embedMessage = event.getOption("message").getAsString();
        String embedTitle = event.getOption("title").getAsString();
        eb.setTitle(embedTitle);
        eb.setDescription(embedMessage);
        if (event.getOption("color") != null) {
            eb.setColor(Color.decode(event.getOption("color").getAsString()));
        } else {
            eb.setColor(ColorUtils.nextColor());
        }
        event.getChannel().sendMessageEmbeds(eb.build()).queue();
    }
}