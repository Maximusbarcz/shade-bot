package dev.mayaqq.shadeBot.commands.listeners;

import dev.mayaqq.shadeBot.commands.slash.*;
import dev.mayaqq.shadeBot.commands.slash.Admin.EmbedSlashCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        switch (event.getName()) {
            case "server" -> ServerSlashCommand.serverSlashCommand(event);
            case "embed" -> EmbedSlashCommand.embed(event);
            case "hug" -> GifSlashCommands.hug(event);
            case "kiss" -> GifSlashCommands.kiss(event);
            case "pat" -> GifSlashCommands.pat(event);
            case "cuddle" -> GifSlashCommands.cuddle(event);
            case "highfive" -> GifSlashCommands.highfive(event);
            case "kill" -> GifSlashCommands.kill(event);
            case "modrinth" -> ModrinthSlashCommands.run(event);
        }
    }
}