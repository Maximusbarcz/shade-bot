package dev.mayaqq.shadeBot.commands.slash;

import dev.mayaqq.shadeBot.utils.BotUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class ServerSlashCommand {
    public static void serverSlashCommand(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();
        EmbedBuilder eb = BotUtils.shadeEmbed(event);
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
    }
}