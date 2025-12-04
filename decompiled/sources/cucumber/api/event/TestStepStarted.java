package cucumber.api.event;

import cucumber.api.TestCase;
import cucumber.api.TestStep;

/* loaded from: classes5.dex */
public final class TestStepStarted extends TestCaseEvent {
    public final TestStep testStep;

    @Deprecated
    public TestStepStarted(Long l, TestCase testCase, TestStep testStep) {
        this(l, 0L, testCase, testStep);
    }

    public TestStepStarted(Long l, long j, TestCase testCase, TestStep testStep) {
        super(l, j, testCase);
        this.testStep = testStep;
    }
}
