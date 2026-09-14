package io.cucumber.core.event;

/* JADX INFO: loaded from: classes5.dex */
public enum Status {
    PASSED,
    SKIPPED,
    PENDING,
    UNDEFINED,
    AMBIGUOUS,
    FAILED,
    UNUSED;

    /* JADX INFO: renamed from: is */
    public boolean m1808is(Status status) {
        return this == status;
    }

    public boolean isOk(boolean z) {
        return hasAlwaysOkStatus() || (!z && hasOkWhenNotStrictStatus());
    }

    private boolean hasAlwaysOkStatus() {
        return m1808is(PASSED) || m1808is(SKIPPED);
    }

    private boolean hasOkWhenNotStrictStatus() {
        return m1808is(UNDEFINED) || m1808is(PENDING);
    }
}
