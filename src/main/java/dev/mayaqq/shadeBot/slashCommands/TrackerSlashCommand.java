package dev.mayaqq.shadeBot.slashCommands;

import dev.mayaqq.shadeBot.utils.Modrinth;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class TrackerSlashCommand {
    public static void tracker(SlashCommandInteractionEvent event) {
        Guild guild = event.getGuild();
        Integer TotalDownloads = Modrinth.getDownloads(event.getOption("userid").getAsString());
        String ChannelName = "Total Downloads: " + TotalDownloads;
        guild.createTextChannel(ChannelName).setTopic("Download Tracker: " + event.getOption("userid").getAsString()).queue();
        event.reply("Channel created/updated").setEphemeral(true).queue();
    }
}
