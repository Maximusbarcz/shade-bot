package dev.mayaqq.shadeBot.slashCommands;

import dev.mayaqq.shadeBot.utils.Modrinth;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class ModSlashCommand {
    public static void mod(SlashCommandInteractionEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        HashMap<String, String> mod = Modrinth.getProjectInfo(event.getOption("slug").getAsString());
        eb.setTitle(mod.get("title"), "https://modrinth.com/mod/" + mod.get("slug"));
        eb.setDescription(mod.get("description"));
        eb.addField("Downloads", mod.get("downloads"), true);
        eb.addField("Followers", mod.get("followers"), true);
        eb.setThumbnail(mod.get("icon"));
        ArrayList authors = Modrinth.getTeamMembers(mod.get("slug"));
        StringBuilder team = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            team.append(authors.get(i) + "\n");
        }
        eb.addField("Team", team.toString(), true);
        eb.addField("License", mod.get("license"), true);
        eb.setColor(event.getMember().getColor());
        try {
            if (event.getOption("ephemeral").getAsBoolean()) {
                event.replyEmbeds(eb.build()).setEphemeral(true).queue();
            } else {
                event.replyEmbeds(eb.build()).queue();
            }
        } catch (Exception e) {
            event.replyEmbeds(eb.build()).queue();
        }
    }
}
