package io.cucumber.junit;

/* loaded from: classes5.dex */
final class JUnitOptionsBuilder {
    private Boolean strict = null;
    private Boolean filenameCompatibleNames = null;
    private Boolean stepNotifications = null;

    JUnitOptionsBuilder() {
    }

    JUnitOptions build() {
        return build(new JUnitOptions());
    }

    JUnitOptions build(JUnitOptions jUnitOptions) {
        Boolean bool = this.strict;
        if (bool != null) {
            jUnitOptions.setStrict(bool.booleanValue());
        }
        Boolean bool2 = this.filenameCompatibleNames;
        if (bool2 != null) {
            jUnitOptions.setFilenameCompatibleNames(bool2.booleanValue());
        }
        Boolean bool3 = this.stepNotifications;
        if (bool3 != null) {
            jUnitOptions.setStepNotifications(bool3.booleanValue());
        }
        return jUnitOptions;
    }

    JUnitOptionsBuilder setStrict(boolean z) {
        this.strict = Boolean.valueOf(z);
        return this;
    }

    JUnitOptionsBuilder setFilenameCompatibleNames(boolean z) {
        this.filenameCompatibleNames = Boolean.valueOf(z);
        return this;
    }

    JUnitOptionsBuilder setStepNotifications(boolean z) {
        this.stepNotifications = Boolean.valueOf(z);
        return this;
    }
}
