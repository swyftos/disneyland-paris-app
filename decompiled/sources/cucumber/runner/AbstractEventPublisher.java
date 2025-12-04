package cucumber.runner;

import cucumber.api.event.Event;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
abstract class AbstractEventPublisher implements EventPublisher {
    protected Map<Class<? extends Event>, List<EventHandler>> handlers = new HashMap();

    AbstractEventPublisher() {
    }

    @Override // cucumber.api.event.EventPublisher
    public final <T extends Event> void registerHandlerFor(Class<T> cls, EventHandler<T> eventHandler) {
        if (this.handlers.containsKey(cls)) {
            this.handlers.get(cls).add(eventHandler);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(eventHandler);
        this.handlers.put(cls, arrayList);
    }

    @Override // cucumber.api.event.EventPublisher
    public final <T extends Event> void removeHandlerFor(Class<T> cls, EventHandler<T> eventHandler) {
        if (this.handlers.containsKey(cls)) {
            this.handlers.get(cls).remove(eventHandler);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void send(Event event) {
        if (this.handlers.containsKey(Event.class)) {
            Iterator<EventHandler> it = this.handlers.get(Event.class).iterator();
            while (it.hasNext()) {
                it.next().receive(event);
            }
        }
        if (this.handlers.containsKey(event.getClass())) {
            Iterator<EventHandler> it2 = this.handlers.get(event.getClass()).iterator();
            while (it2.hasNext()) {
                it2.next().receive(event);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendAll(Iterable<Event> iterable) {
        Iterator<Event> it = iterable.iterator();
        while (it.hasNext()) {
            send(it.next());
        }
    }
}
