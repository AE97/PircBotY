package net.ae97.pircboty.hooks.managers;

import com.google.common.collect.ImmutableSet;
import net.ae97.pircboty.PircBotY;
import net.ae97.pircboty.hooks.Event;
import net.ae97.pircboty.hooks.Listener;

public interface ListenerManager {

    public void dispatchEvent(Event event);

    public boolean addListener(Listener listener);

    public boolean removeListener(Listener listener);

    public boolean listenerExists(Listener listener);

    public ImmutableSet<Listener> getListeners();

    public void setCurrentId(long currentId);

    public long getCurrentId();

    public long incrementCurrentId();

    public void shutdown(PircBotY bot);
}
