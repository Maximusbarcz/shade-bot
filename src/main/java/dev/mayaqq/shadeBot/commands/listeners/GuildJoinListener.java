package dev.mayaqq.shadeBot.commands.listeners;

import dev.mayaqq.shadeBot.Shade;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class GuildJoinListener extends ListenerAdapter {
    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Shade.updatePresence();
    }
    @Override
    public void onGuildLeave(@NotNull GuildLeaveEvent event) {
        Shade.updatePresence();
    }

}
