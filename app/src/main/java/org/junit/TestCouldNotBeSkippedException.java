package org.junit;

/* JADX INFO: loaded from: classes.dex */
public class TestCouldNotBeSkippedException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public TestCouldNotBeSkippedException(org.junit.internal.AssumptionViolatedException assumptionViolatedException) {
        super("Test could not be skipped due to other failures", assumptionViolatedException);
    }
}
