package net.ae97.pokebot.logger;

import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class PrefixLogger extends Logger {

    private final String prefix;

    public PrefixLogger(String name) {
        super(name, null);
        prefix = "[" + name + "]";
    }

    public PrefixLogger(String name, Logger logger) {
        this(name);
        setParent(logger);
    }

    @Override
    public final void setParent(Logger parent) {
        super.setParent(parent);
    }

    @Override
    public void log(LogRecord logRecord) {
        logRecord.setMessage(prefix + " " + logRecord.getMessage());
        super.log(logRecord);
    }
}
