package cucumber.api.event;

import cucumber.api.TestCase;

/* loaded from: classes5.dex */
public final class WriteEvent extends TestCaseEvent {
    public final String text;

    @Deprecated
    public WriteEvent(Long l, TestCase testCase, String str) {
        this(l, 0L, testCase, str);
    }

    public WriteEvent(Long l, long j, TestCase testCase, String str) {
        super(l, j, testCase);
        this.text = str;
    }
}
