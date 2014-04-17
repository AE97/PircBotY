package net.ae97.pircboty.hooks.events;

import net.ae97.pircboty.Channel;
import net.ae97.pircboty.PircBotY;
import net.ae97.pircboty.User;
import net.ae97.pircboty.hooks.Event;
import net.ae97.pircboty.hooks.types.GenericChannelUserEvent;
import net.ae97.pircboty.hooks.types.GenericMessageEvent;

public class ActionEvent<T extends PircBotY> extends Event<T> implements GenericMessageEvent<T>, GenericChannelUserEvent<T> {

    private final User user;
    private final Channel channel;
    private final String action;

    public ActionEvent(T bot, User user, Channel channel, String action) {
        super(bot);
        this.user = user;
        this.channel = channel;
        this.action = action;
    }

    @Override
    public String getMessage() {
        return action;
    }

    @Override
    public void respond(String response) {
        if (getChannel() == null) {
            getUser().send().action(response);
        } else {
            getChannel().send().action(response);
        }
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public Channel getChannel() {
        return channel;
    }
}
