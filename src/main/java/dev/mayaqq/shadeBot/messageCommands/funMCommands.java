package dev.mayaqq.shadeBot.messageCommands;

import net.dv8tion.jda.api.EmbedBuilder;
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
}

