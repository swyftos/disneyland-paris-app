package cucumber.api.event;

/* loaded from: classes5.dex */
public final class TestRunStarted extends TimeStampedEvent {
    @Override // cucumber.api.event.TimeStampedEvent, cucumber.api.event.Event
    public /* bridge */ /* synthetic */ Long getTimeStamp() {
        return super.getTimeStamp();
    }

    @Override // cucumber.api.event.TimeStampedEvent
    public /* bridge */ /* synthetic */ long getTimeStampMillis() {
        return super.getTimeStampMillis();
    }

    @Deprecated
    public TestRunStarted(Long l) {
        this(l, 0L);
    }

    public TestRunStarted(Long l, long j) {
        super(l, Long.valueOf(j));
    }
}
