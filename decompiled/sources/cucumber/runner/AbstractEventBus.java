package cucumber.runner;

import cucumber.api.event.Event;

/* loaded from: classes5.dex */
abstract class AbstractEventBus extends AbstractEventPublisher implements EventBus {
    AbstractEventBus() {
    }

    @Override // cucumber.runner.AbstractEventPublisher, cucumber.runner.EventBus
    public void send(Event event) {
        super.send(event);
    }

    @Override // cucumber.runner.AbstractEventPublisher, cucumber.runner.EventBus
    public void sendAll(Iterable iterable) {
        super.sendAll(iterable);
    }
}
