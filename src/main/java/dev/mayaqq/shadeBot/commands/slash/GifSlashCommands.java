package dev.mayaqq.shadeBot.commands.slash;

import dev.mayaqq.shadeBot.commands.common.GifCommands;
import dev.mayaqq.shadeBot.utils.BotUtils;
import dev.mayaqq.shadeBot.utils.Tenor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GifSlashCommands {
    public static void hug(SlashCommandInteractionEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.HUG);
    }
    public static void kiss(SlashCommandInteractionEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.KISS);
    }
    public static void pat(SlashCommandInteractionEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.PAT);
    }
    public static void cuddle(SlashCommandInteractionEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.CUDDLE);
    }
    public static void highfive(SlashCommandInteractionEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.HIGHFIVE);
    }
    public static void kill(SlashCommandInteractionEvent event) {
        sendFunCommandEmbed(event, GifCommands.GifType.KILL);
    }

    private static void sendFunCommandEmbed(SlashCommandInteractionEvent event, GifCommands.GifType type) {
        EmbedBuilder eb = BotUtils.shadeEmbed(event);
        User user = event.getOption("user").getAsUser();
        if (user == event.getUser()) {
            eb.setTitle(type.getFailedMessage());
            event.replyEmbeds(eb.build()).queue();
            return;
        }
        eb.addField(type.getTitle(), type.getMessage().replace("%sender%", event.getUser().getAsMention()).replace("%target%", user.getAsMention()), true);
        String tenorUrl = Tenor.randomGIF(type.getTenorSearch(), 30);
        eb.setImage(tenorUrl);
        event.getChannel().sendMessageEmbeds(eb.build()).queue();
    }
}