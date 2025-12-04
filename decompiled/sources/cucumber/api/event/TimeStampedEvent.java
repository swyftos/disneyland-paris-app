package cucumber.api.event;

/* loaded from: classes5.dex */
abstract class TimeStampedEvent implements Event {
    private final Long timeStamp;
    private final long timeStampMillis;

    TimeStampedEvent(Long l, Long l2) {
        this.timeStamp = l;
        this.timeStampMillis = l2.longValue();
    }

    @Override // cucumber.api.event.Event
    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public long getTimeStampMillis() {
        return this.timeStampMillis;
    }
}
