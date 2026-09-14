package com.facebook.react.modules.devtoolsruntimesettings;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, m1836d2 = {"Lcom/facebook/react/modules/devtoolsruntimesettings/Settings;", "", "<init>", "()V", "shouldReloadAndProfile", "", "getShouldReloadAndProfile", "()Z", "setShouldReloadAndProfile", "(Z)V", "recordChangeDescriptions", "getRecordChangeDescriptions", "setRecordChangeDescriptions", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
final class Settings {
    private boolean recordChangeDescriptions;
    private boolean shouldReloadAndProfile;

    public final boolean getShouldReloadAndProfile() {
        return this.shouldReloadAndProfile;
    }

    public final void setShouldReloadAndProfile(boolean z) {
        this.shouldReloadAndProfile = z;
    }

    public final boolean getRecordChangeDescriptions() {
        return this.recordChangeDescriptions;
    }

    public final void setRecordChangeDescriptions(boolean z) {
        this.recordChangeDescriptions = z;
    }
}
