package dev.mayaqq.shadeBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();
        if (event.getName().equals("info")) {
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.GREEN);
            eb.setTitle("Hue");
            eb.addField("Description", "A casual hangout place and also the home to " + guild.getOwner().getNickname()  + "'s creations.", false);
            eb.addField("Members", String.valueOf(guild.getMembers().size()), true);
            eb.addField("Channels", String.valueOf(guild.getChannels().size()), true);
            eb.addField("Roles", String.valueOf(guild.getRoles().size()), true);
            eb.setThumbnail(guild.getIconUrl()+ "?size=1024");
            event.replyEmbeds(eb.build()).queue();
        }
    }
}

