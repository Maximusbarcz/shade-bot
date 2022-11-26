package dev.mayaqq.shadeBot.slashCommands;

import dev.mayaqq.shadeBot.utils.RandomColor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class EmbedSlashCommand {
    public static void embed(SlashCommandInteractionEvent event) {
        if (event.getMember().getId().equals("698623223872356413")) {
            EmbedBuilder eb = new EmbedBuilder();
            String embedMessage = event.getOption("message").getAsString();
            String embedTitle = event.getOption("title").getAsString();
            eb.setTitle(embedTitle);
            eb.setDescription(embedMessage);
            if (event.getOption("color") != null) {
                eb.setColor(Color.decode(event.getOption("color").getAsString()));
            } else {
                eb.setColor(RandomColor.RandomColor());
            }
            event.getChannel().sendMessageEmbeds(eb.build()).queue();
            event.reply("Embed send successfully!").setEphemeral(true).queue();
        } else {
            event.reply("You don't have permission to use this command!").setEphemeral(true).queue();
        }
    }
}
