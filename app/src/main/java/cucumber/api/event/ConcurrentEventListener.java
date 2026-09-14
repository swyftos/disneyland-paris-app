package cucumber.api.event;

import cucumber.api.Plugin;

/* JADX INFO: loaded from: classes5.dex */
public interface ConcurrentEventListener extends Plugin {
    void setEventPublisher(EventPublisher eventPublisher);
}
