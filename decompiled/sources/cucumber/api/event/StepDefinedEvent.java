package cucumber.api.event;

import cucumber.runtime.StepDefinition;

/* loaded from: classes5.dex */
public class StepDefinedEvent extends TimeStampedEvent {
    public final StepDefinition stepDefinition;

    @Override // cucumber.api.event.TimeStampedEvent, cucumber.api.event.Event
    public /* bridge */ /* synthetic */ Long getTimeStamp() {
        return super.getTimeStamp();
    }

    @Override // cucumber.api.event.TimeStampedEvent
    public /* bridge */ /* synthetic */ long getTimeStampMillis() {
        return super.getTimeStampMillis();
    }

    public StepDefinedEvent(Long l, Long l2, StepDefinition stepDefinition) {
        super(l, l2);
        this.stepDefinition = stepDefinition;
    }
}
