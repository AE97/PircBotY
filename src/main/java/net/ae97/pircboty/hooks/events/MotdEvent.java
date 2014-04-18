package net.ae97.pircboty.hooks.events;

import net.ae97.pircboty.PircBotY;
import net.ae97.pircboty.hooks.Event;

public class MotdEvent extends Event {

    private final String motd;

    public MotdEvent(PircBotY bot, String motd) {
        super(bot);
        this.motd = motd;
    }

    @Override
    public void respond(String response) {
        getBot().sendRaw().rawLine(response);
    }

    public String getMotd() {
        return motd;
    }
}
