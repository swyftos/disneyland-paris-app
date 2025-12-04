package cucumber.api.event;

/* loaded from: classes5.dex */
public interface EventPublisher {
    <T extends Event> void registerHandlerFor(Class<T> cls, EventHandler<T> eventHandler);

    <T extends Event> void removeHandlerFor(Class<T> cls, EventHandler<T> eventHandler);
}
