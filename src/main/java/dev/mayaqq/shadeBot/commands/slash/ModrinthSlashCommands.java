package dev.mayaqq.shadeBot.commands.slash;

import dev.mayaqq.shadeBot.utils.BotUtils;
import dev.mayaqq.shadeBot.utils.Modrinth;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("DataFlowIssue")
public class ModrinthSlashCommands {

    public static void run(SlashCommandInteractionEvent event) {
        switch (event.getSubcommandName()) {
            case "mod" -> mod(event);
            case "randommod" -> randomMod(event);
            case "user" -> user(event);
        }
    }
    public static void mod(SlashCommandInteractionEvent event) {
        MessageEmbed embed = createModEmbed(event, Modrinth.getProjectInfo(event.getOption("slug").getAsString()));
        event.replyEmbeds(embed).setEphemeral(BotUtils.isEphemeral(event)).queue();
    }

    public static void randomMod(SlashCommandInteractionEvent event) {
        MessageEmbed embed = createModEmbed(event, Modrinth.getRandomProject());
        event.replyEmbeds(embed).setEphemeral(BotUtils.isEphemeral(event)).queue();
    }

    public static void user(SlashCommandInteractionEvent event) {
        event.deferReply().queue();
        EmbedBuilder eb = BotUtils.shadeEmbed(event);
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
        event.getHook().sendMessageEmbeds(eb.build()).queue();
        event.getHook().sendMessageEmbeds(eb.build()).setEphemeral(BotUtils.isEphemeral(event)).queue();
    }

    public static MessageEmbed createModEmbed(SlashCommandInteractionEvent event, HashMap<String, String> mod) {
        EmbedBuilder eb = BotUtils.shadeEmbed(event);
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
        return eb.build();
    }
}
