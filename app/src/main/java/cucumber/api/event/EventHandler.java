package cucumber.api.event;

import cucumber.api.event.Event;

/* JADX INFO: loaded from: classes5.dex */
public interface EventHandler<T extends Event> {
    void receive(T t);
}
