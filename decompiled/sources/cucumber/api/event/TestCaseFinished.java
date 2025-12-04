package cucumber.api.event;

import cucumber.api.Result;
import cucumber.api.TestCase;

/* loaded from: classes5.dex */
public final class TestCaseFinished extends TestCaseEvent {
    public final Result result;
    public final TestCase testCase;

    @Deprecated
    public TestCaseFinished(Long l, TestCase testCase, Result result) {
        this(l, 0L, testCase, result);
    }

    public TestCaseFinished(Long l, long j, TestCase testCase, Result result) {
        super(l, j, testCase);
        this.testCase = testCase;
        this.result = result;
    }
}
