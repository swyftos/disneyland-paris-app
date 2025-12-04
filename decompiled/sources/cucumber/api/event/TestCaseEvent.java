package cucumber.api.event;

import cucumber.api.TestCase;

/* loaded from: classes5.dex */
public abstract class TestCaseEvent extends TimeStampedEvent {
    private final TestCase testCase;

    @Override // cucumber.api.event.TimeStampedEvent, cucumber.api.event.Event
    public /* bridge */ /* synthetic */ Long getTimeStamp() {
        return super.getTimeStamp();
    }

    @Override // cucumber.api.event.TimeStampedEvent
    public /* bridge */ /* synthetic */ long getTimeStampMillis() {
        return super.getTimeStampMillis();
    }

    TestCaseEvent(Long l, long j, TestCase testCase) {
        super(l, Long.valueOf(j));
        this.testCase = testCase;
    }

    public TestCase getTestCase() {
        return this.testCase;
    }
}
