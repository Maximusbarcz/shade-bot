package dev.mayaqq.shadeBot.commands.listeners;

import dev.mayaqq.shadeBot.Shade;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageReaction;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {
    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        User user = event.getUser();
        Message message = event.getChannel().retrieveMessageById(event.getMessageId()).complete();
        MessageReaction reaction = event.getReaction();
        User author = message.getAuthor();
        User replyUser;
        try {
            replyUser = message.getMentions().getUsers().get(0);
        } catch (IndexOutOfBoundsException e) {
            return;
        }
        if (author != Shade.BOT_INSTANCE.getSelfUser() || (replyUser != user || !user.getId().equals("698623223872356413")) || !reaction.getEmoji().getType().equals(Emoji.Type.UNICODE)) return;
        if (reaction.getEmoji().asUnicode().getName().equals("❌")) {
            message.delete().queue();
        }
    }
}