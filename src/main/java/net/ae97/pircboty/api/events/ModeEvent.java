package net.ae97.pircboty.api.events;

import java.util.List;
import net.ae97.pircboty.Channel;
import net.ae97.pircboty.PircBotY;
import net.ae97.pircboty.User;
import net.ae97.pircboty.api.Event;
import net.ae97.pircboty.generics.GenericChannelModeEvent;

public class ModeEvent extends Event implements GenericChannelModeEvent {

    private final Channel channel;
    private final User user;
    private final String mode;
    private final List<String> modeParsed;

    public ModeEvent(PircBotY bot, Channel channel, User user, String mode, List<String> modeParsed) {
        super(bot);
        this.channel = channel;
        this.user = user;
        this.mode = mode;
        this.modeParsed = modeParsed;
    }

    @Override
    public void respond(String response) {
        getChannel().send().message(getUser(), response);
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public User getUser() {
        return user;
    }

    public String getMode() {
        return mode;
    }

    public List<String> getModeParsed() {
        return modeParsed;
    }
}
