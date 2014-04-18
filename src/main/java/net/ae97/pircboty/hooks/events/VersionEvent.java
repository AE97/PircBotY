package net.ae97.pircboty.hooks.events;

import net.ae97.pircboty.Channel;
import net.ae97.pircboty.PircBotY;
import net.ae97.pircboty.User;
import net.ae97.pircboty.hooks.Event;
import net.ae97.pircboty.hooks.types.GenericCTCPEvent;
import net.ae97.pircboty.hooks.types.GenericChannelEvent;

public class VersionEvent extends Event implements GenericCTCPEvent, GenericChannelEvent {

    private final User user;
    private final Channel channel;

    public VersionEvent(PircBotY bot, User user, Channel channel) {
        super(bot);
        this.user = user;
        this.channel = channel;
    }

    @Override
    public void respond(String response) {
        getUser().send().ctcpResponse(response);
    }

    @Override
    public Channel getChannel() {
        return channel;
    }

    @Override
    public User getUser() {
        return user;
    }
}
