package dev.mayaqq.shadeBot.commands.message;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class funMCommands {
    static EmbedBuilder eb = new EmbedBuilder();
    public static void neat(MessageReceivedEvent event) {
        eb.addField("Neat", "Neat is a mod by Vazkii", false);
        event.getMessage().replyEmbeds(eb.build()).queue();
        eb.clear();
    }
    public static void rat(MessageReceivedEvent event) {
        eb.addField("Rat", "Hello darkness, my old friend...\n" +
                "I've come to talk with you again...\n" +
                "Because a vision softly cre-eeping,\n" +
                "Left its seeds while I was sle-eeping,\n" +
                "And the rat, that was planted, in my brain\n" +
                "Still remains...\n" +
                "Within the sound, of silence", false);
        event.getMessage().replyEmbeds(eb.build()).queue();
        eb.clear();
    }
    public static void greg(MessageReceivedEvent event) {
        eb.addField("Greg", "STOP POSTING ABOUT GREGTECH, I'M TIRED OF SEEING IT! My friends on reddit send me memes, on discord it's fucking memes - I was in a subreddit, right? and ALLLLLLLLL of the POSTS are just GregTech stuff. I- I showed my Champion underwear to my girlfriend, and the logo I flipped it and I said, \"Hey babe: When the underwear greg \uD83D\uDE02 \uD83D\uDE02 \uD83D\uDE02\"", false);
        event.getMessage().replyEmbeds(eb.build()).queue();
        eb.clear();
    }
    public static void updateEstrogen(MessageReceivedEvent event) {
        eb.addField("Update Estrogen", "NO I WONT UPDATE ESTROGEN! I will update it once I feel like it ok? If you are so \"desperate\" to get it updated... why don't you update it yourself? Not so \"easy\" now is it... STUPID LIBERAL!!!", false);
        event.getMessage().replyEmbeds(eb.build()).queue();
        eb.clear();
    }
    public static void bident(MessageReceivedEvent event) {
        eb.setTitle("Bident Blast");
        eb.setImage("https://media.discordapp.net/stickers/1135178236272328838.webp?size=240");
        event.getMessage().replyEmbeds(eb.build()).queue();
        eb.clear();
    }

    public static void sob(MessageReceivedEvent event) {
        event.getMessage().addReaction(Emoji.fromUnicode("\uD83D\uDE2D")).queue();
    }
}

