package dev.mayaqq.shadeBot.slashCommands;

import dev.mayaqq.shadeBot.utils.Modrinth;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.HashMap;

public class UserSlashCommand {
    public static void user(SlashCommandInteractionEvent event) {
        event.deferReply().queue();
        EmbedBuilder eb = new EmbedBuilder();
        HashMap<String, String> data = Modrinth.usrDat(event.getOption("userid").getAsString());
        eb.setTitle(data.get("username"), "https://modrinth.com/user/" + data.get("username"));
        eb.setThumbnail(data.get("avatar"));
        eb.addField("Bio", data.get("bio"), false);
        eb.addField("ID", data.get("id"), true);
        eb.addField("Downloads", data.get("downloads"), true);
        eb.addField("Role", data.get("role"), true);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Modrinth.getProjects(data.get("id")).size(); i++) {
            if (i == Modrinth.getProjects(data.get("id")).size() - 1) {
                sb.append(Modrinth.getProjects(data.get("id")).get(i));
            } else {
                sb.append(Modrinth.getProjects(data.get("id")).get(i)).append(", ");
            }
        }
        eb.addField("Projects", sb.toString(), false);
        eb.setColor(event.getMember().getColor());
        event.getHook().sendMessageEmbeds(eb.build()).queue();
    }
}
