package dev.mayaqq.shadeBot;

import dev.mayaqq.shadeBot.commands.listeners.GuildJoinListener;
import dev.mayaqq.shadeBot.commands.listeners.MessageListener;
import dev.mayaqq.shadeBot.commands.listeners.ReactionListener;
import dev.mayaqq.shadeBot.commands.listeners.SlashCommandListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

public class Shade {
    public static JDA BOT_INSTANCE;

    public static void main(String[] args) throws InterruptedException {
        Config.load();

        System.out.println("Starting ShadeBot...");
        System.out.println("Token: " + Config.CONFIG.token);

        JDABuilder botBuilder = JDABuilder.createDefault(
                Config.CONFIG.token,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_EMOJIS_AND_STICKERS
        );

        botBuilder.addEventListeners(
                new ReactionListener(),
                new SlashCommandListener(),
                new MessageListener(),
                new GuildJoinListener()
        );
        botBuilder.disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOJI, CacheFlag.STICKER, CacheFlag.SCHEDULED_EVENTS);

        JDA shadeBot = botBuilder.build();

        BOT_INSTANCE = shadeBot;

        shadeBot.updateCommands().addCommands(
                Commands.slash("server", "Tells you general info about this server."),
                Commands.slash("embed", "Sends an embed with the given message.")
                        .addOption(OptionType.STRING, "title", "The title of the embed.", true)
                        .addOption(OptionType.STRING, "message", "The message of the embed.", true)
                        .addOption(OptionType.STRING, "color", "The color of the embed.", false)
                        .setDefaultPermissions(DefaultMemberPermissions.enabledFor(Permission.MANAGE_CHANNEL, Permission.MODERATE_MEMBERS)),
                Commands.slash("modrinth", "Modrinth Utilities")
                        .addSubcommands(
                                new SubcommandData("mod", "Get info about a mod!")
                                        .addOption(OptionType.STRING, "slug", "The modrinth mod slug", true)
                                        .addOption(OptionType.BOOLEAN, "ephemeral", "Should the response be ephemeral?", false),
                                new SubcommandData("user", "Get info about a user!")
                                        .addOption(OptionType.STRING, "userid", "The modrinth user id", true)
                                        .addOption(OptionType.BOOLEAN, "ephemeral", "Should the response be ephemeral?", false),
                                new SubcommandData("randommod", "Get a random mod!")
                                        .addOption(OptionType.BOOLEAN, "ephemeral", "Should the response be ephemeral?", false)
                        ),
                Commands.slash("hug", "Hug someone!")
                        .addOption(OptionType.USER, "user", "The user to hug", true),
                Commands.slash("pat", "Pat someone!")
                        .addOption(OptionType.USER, "user", "The user to pat", true),
                Commands.slash("kiss", "Kiss someone!")
                        .addOption(OptionType.USER, "user", "The user to kiss", true),
                Commands.slash("cuddle", "Cuddle someone!")
                        .addOption(OptionType.USER, "user", "The user to cuddle", true),
                Commands.slash("highfive", "highfive someone!")
                        .addOption(OptionType.USER, "user", "The user to highfive", true),
                Commands.slash("kill", "kill someone!")
                        .addOption(OptionType.USER, "user", "The user to kill", true)
        ).queue();

        shadeBot.awaitReady();
        updatePresence();
    }

    public static void updatePresence() {
        BOT_INSTANCE.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("over " + BOT_INSTANCE.getGuilds().size() + " servers!"));
    }
}
