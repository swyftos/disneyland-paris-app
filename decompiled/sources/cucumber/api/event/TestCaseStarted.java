package cucumber.api.event;

import cucumber.api.TestCase;

/* loaded from: classes5.dex */
public final class TestCaseStarted extends TestCaseEvent {
    public final TestCase testCase;

    @Deprecated
    public TestCaseStarted(Long l, TestCase testCase) {
        this(l, 0L, testCase);
    }

    public TestCaseStarted(Long l, long j, TestCase testCase) {
        super(l, j, testCase);
        this.testCase = testCase;
    }
}
