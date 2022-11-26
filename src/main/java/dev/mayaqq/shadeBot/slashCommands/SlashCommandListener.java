package dev.mayaqq.shadeBot.slashCommands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "info" -> InfoSlashCommand.info(event);
            case "embed" -> EmbedSlashCommand.embed(event);
            case "link" -> LinkSlashCommand.link(event);
            case "tracker" -> TrackerSlashCommand.tracker(event);
            case "hug" -> GifCommands.hug(event);
            case "kiss" -> GifCommands.kiss(event);
            case "pat" -> GifCommands.pat(event);
            case "cuddle" -> GifCommands.cuddle(event);
            case "highfive" -> GifCommands.highfive(event);
            case "randommod" -> RandomModSlashCommand.randomMod(event);
            case "mod" -> ModSlashCommand.mod(event);
            case "user" -> UserSlashCommand.user(event);
        }
    }
}

