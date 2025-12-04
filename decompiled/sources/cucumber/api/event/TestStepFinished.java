package cucumber.api.event;

import cucumber.api.Result;
import cucumber.api.TestCase;
import cucumber.api.TestStep;

/* loaded from: classes5.dex */
public final class TestStepFinished extends TestCaseEvent {
    public final Result result;
    public final TestStep testStep;

    @Deprecated
    public TestStepFinished(Long l, TestCase testCase, TestStep testStep, Result result) {
        this(l, 0L, testCase, testStep, result);
    }

    public TestStepFinished(Long l, long j, TestCase testCase, TestStep testStep, Result result) {
        super(l, j, testCase);
        this.testStep = testStep;
        this.result = result;
    }
}
