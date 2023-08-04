package dev.mayaqq.shadeBot.utils;

import dev.mayaqq.shadeBot.Shade;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

public class BotUtils {
    public static EmbedBuilder shadeEmbed(SlashCommandInteractionEvent event) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(event.getMember().getColor());
        eb.setFooter("shade-bot | " + event.getName(), avatarUrl());
        return eb;
    }

    public static EmbedBuilder shadeEmbed(MessageReceivedEvent event, String eventName) {
        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(event.getMember().getColor());
        eb.setFooter("shade-bot | " + eventName, avatarUrl());
        return eb;
    }

    public static boolean isEphemeral(SlashCommandInteractionEvent event) {
        OptionMapping ephemeral = event.getOption("ephemeral");
        return ephemeral != null && ephemeral.getAsBoolean();
    }

    public static String avatarUrl() {
        return Shade.BOT_INSTANCE.getSelfUser().getAvatarUrl();
    }
}
