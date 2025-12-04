package ch.qos.logback.classic.spi;

import ch.qos.logback.classic.Logger;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes2.dex */
public class LoggerComparator implements Comparator<Logger>, Serializable {
    private static final long serialVersionUID = 1;

    @Override // java.util.Comparator
    public int compare(Logger logger, Logger logger2) {
        if (logger.getName().equals(logger2.getName())) {
            return 0;
        }
        if (logger.getName().equals(org.slf4j.Logger.ROOT_LOGGER_NAME)) {
            return -1;
        }
        if (logger2.getName().equals(org.slf4j.Logger.ROOT_LOGGER_NAME)) {
            return 1;
        }
        return logger.getName().compareTo(logger2.getName());
    }
}
