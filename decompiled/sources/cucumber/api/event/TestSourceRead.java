package cucumber.api.event;

/* loaded from: classes5.dex */
public final class TestSourceRead extends TimeStampedEvent {
    public final String source;
    public final String uri;

    @Override // cucumber.api.event.TimeStampedEvent, cucumber.api.event.Event
    public /* bridge */ /* synthetic */ Long getTimeStamp() {
        return super.getTimeStamp();
    }

    @Override // cucumber.api.event.TimeStampedEvent
    public /* bridge */ /* synthetic */ long getTimeStampMillis() {
        return super.getTimeStampMillis();
    }

    @Deprecated
    public TestSourceRead(Long l, String str, String str2) {
        this(l, 0L, str, str2);
    }

    public TestSourceRead(Long l, long j, String str, String str2) {
        super(l, Long.valueOf(j));
        this.uri = str;
        this.source = str2;
    }
}
