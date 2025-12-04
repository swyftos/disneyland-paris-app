package io.cucumber.junit;

/* loaded from: classes5.dex */
final class JUnitOptions {
    private boolean filenameCompatibleNames = false;
    private boolean stepNotifications = false;
    private boolean strict;

    JUnitOptions() {
    }

    boolean filenameCompatibleNames() {
        return this.filenameCompatibleNames;
    }

    boolean stepNotifications() {
        return this.stepNotifications;
    }

    boolean isStrict() {
        return this.strict;
    }

    void setStrict(boolean z) {
        this.strict = z;
    }

    void setFilenameCompatibleNames(boolean z) {
        this.filenameCompatibleNames = z;
    }

    void setStepNotifications(boolean z) {
        this.stepNotifications = z;
    }
}
