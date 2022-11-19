package dev.mayaqq.shadeBot;

import dev.mayaqq.shadeBot.utils.RandomColor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();
        EmbedBuilder eb = new EmbedBuilder();

        if (event.getName().equals("info")) {
            eb.setColor(event.getMember().getColor());
            eb.setTitle(guild.getName(), guild.getVanityUrl());
            if (guild.getDescription() != null) {
                eb.addField("Description", guild.getDescription(), false);
            } else {
                eb.addField("Description", "A Discord Server owned by <@" + guild.getOwnerId() + ">", false);
            }
            eb.addField("Owner", "<@" + guild.getOwnerId() + ">", true);
            eb.addField("Members", String.valueOf(guild.getMembers().size()), true);
            eb.addField("Roles", String.valueOf(guild.getRoles().size()), true);
            eb.addField("Text Channels", String.valueOf(guild.getTextChannelCache().size()), true);
            eb.addField("Voice Channels", String.valueOf(guild.getVoiceChannelCache().size()), true);
            eb.setThumbnail(guild.getIconUrl()+ "?size=1024");
            event.replyEmbeds(eb.build()).queue();

        } else if (event.getName().equals("embed")) {
            if (event.getMember().getId().equals("698623223872356413")) {
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

        } else if (event.getName().equals("link")) {
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
}

