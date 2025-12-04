package ch.qos.logback.core.spi;

import ch.qos.logback.core.Appender;
import java.util.Iterator;

/* loaded from: classes2.dex */
public interface AppenderAttachable<E> {
    void addAppender(Appender<E> appender);

    void detachAndStopAllAppenders();

    boolean detachAppender(Appender<E> appender);

    boolean detachAppender(String str);

    Appender<E> getAppender(String str);

    boolean isAttached(Appender<E> appender);

    Iterator<Appender<E>> iteratorForAppenders();
}
