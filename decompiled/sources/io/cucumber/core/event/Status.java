package io.cucumber.core.event;

/* loaded from: classes5.dex */
public enum Status {
    PASSED,
    SKIPPED,
    PENDING,
    UNDEFINED,
    AMBIGUOUS,
    FAILED,
    UNUSED;

    public boolean is(Status status) {
        return this == status;
    }

    public boolean isOk(boolean z) {
        return hasAlwaysOkStatus() || (!z && hasOkWhenNotStrictStatus());
    }

    private boolean hasAlwaysOkStatus() {
        return is(PASSED) || is(SKIPPED);
    }

    private boolean hasOkWhenNotStrictStatus() {
        return is(UNDEFINED) || is(PENDING);
    }
}
