package dev.mayaqq.shadeBot;

import dev.mayaqq.shadeBot.utils.Tenor;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        //admin commands
        EmbedBuilder eb = new EmbedBuilder();
        if (event.getAuthor().isBot()) return;

        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "stop") && event.getAuthor().getId().equals("698623223872356413")) {
            event.getChannel().sendMessage("Shutting down...").queue();
            event.getJDA().shutdown();
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "restart") && event.getAuthor().getId().equals("698623223872356413")) {
            event.getChannel().sendMessage("Restarting...").queue();
            event.getJDA().shutdown();
            try {
                Bot.main(null);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "hug ")) {
            String huggedId = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "hug <@", "").replace(">", "");
            Member huggedMember = event.getGuild().getMemberById(huggedId);
            eb.setColor(event.getMember().getColor());
            if (huggedId.equals(event.getAuthor().getId())) {
                eb.setTitle("You can't hug yourself!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            } else if (huggedMember == null) {
                eb.setTitle("That user doesnt exist!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            } else {
                eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is hugging <@" + huggedId + ">!", true);
                String tenorUrl = Tenor.returnRandomGIF("anime_hug", 30);
                eb.setImage(tenorUrl);
                eb.setColor(huggedMember.getColor());
                event.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "pat ")) {
            String pattedId = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "pat <@", "").replace(">", "");
            Member pattedMember = event.getGuild().getMemberById(pattedId);
            eb.setColor(event.getMember().getColor());
            if (pattedId.equals(event.getAuthor().getId())) {
                eb.setTitle("You can't pat yourself!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            } else if (pattedMember == null) {
                eb.setTitle("That user doesnt exist!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            } else {
                eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is patting <@" + pattedId + ">!", true);
                String tenorUrl = Tenor.returnRandomGIF("anime_pat", 30);
                eb.setImage(tenorUrl);
                eb.setColor(pattedMember.getColor());
                event.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
        }
        if (event.getMessage().getContentRaw().startsWith(Config.CONFIG.prefix + "kiss ")) {
            String kissedId = event.getMessage().getContentRaw().replace(Config.CONFIG.prefix + "kiss <@", "").replace(">", "");
            Member kissedMember = event.getGuild().getMemberById(kissedId);
            eb.setColor(event.getMember().getColor());
            if (kissedMember.equals(event.getAuthor().getId())) {
                eb.setTitle("You can't kiss yourself!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            } else if (kissedMember == null) {
                eb.setTitle("That user doesnt exist!");
                event.getMessage().replyEmbeds(eb.build()).queue();
            } else {
                eb.addField("Cute!", "Awww, how cute! <@" + event.getAuthor().getId() + "> is kissing <@" + kissedId + ">!", true);
                String tenorUrl = Tenor.returnRandomGIF("anime_kiss", 30);
                eb.setImage(tenorUrl);
                eb.setColor(kissedMember.getColor());
                event.getChannel().sendMessageEmbeds(eb.build()).queue();
            }
        }
    }
}

