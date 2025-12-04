package ch.qos.logback.core.status;

import java.util.List;

/* loaded from: classes2.dex */
public interface StatusManager {
    void add(Status status);

    boolean add(StatusListener statusListener);

    boolean addUniquely(StatusListener statusListener, Object obj);

    void clear();

    List<Status> getCopyOfStatusList();

    List<StatusListener> getCopyOfStatusListenerList();

    int getCount();

    void remove(StatusListener statusListener);
}
