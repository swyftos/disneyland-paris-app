package cucumber.runner;

import cucumber.api.event.Event;

/* loaded from: classes5.dex */
public final class TimeServiceEventBus extends AbstractEventBus {
    private final TimeService stopWatch;

    @Override // cucumber.runner.AbstractEventBus, cucumber.runner.AbstractEventPublisher, cucumber.runner.EventBus
    public /* bridge */ /* synthetic */ void send(Event event) {
        super.send(event);
    }

    @Override // cucumber.runner.AbstractEventBus, cucumber.runner.AbstractEventPublisher, cucumber.runner.EventBus
    public /* bridge */ /* synthetic */ void sendAll(Iterable iterable) {
        super.sendAll(iterable);
    }

    public TimeServiceEventBus(TimeService timeService) {
        this.stopWatch = timeService;
    }

    @Override // cucumber.runner.EventBus
    public Long getTime() {
        return Long.valueOf(this.stopWatch.time());
    }

    @Override // cucumber.runner.EventBus
    public Long getTimeMillis() {
        return Long.valueOf(this.stopWatch.timeMillis());
    }
}
