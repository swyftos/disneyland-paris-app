package com.contentsquare.android.core.communication;

import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/contentsquare/android/core/communication/ScreenViewTracker;", "", "preferenceStore", "Lcom/contentsquare/android/core/features/preferences/PreferencesStore;", "(Lcom/contentsquare/android/core/features/preferences/PreferencesStore;)V", "currentScreenNumber", "", "getCurrentScreenNumber", "()I", "currentScreenTimestamp", "", "getCurrentScreenTimestamp", "()J", "isScreenNumberChanged", "", "()Z", "isSentBeforeFirstScreen", "lastScreenNumber", "updateLastScreenNumber", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ScreenViewTracker {
    private int lastScreenNumber;

    @NotNull
    private final PreferencesStore preferenceStore;

    public ScreenViewTracker(PreferencesStore preferenceStore) {
        Intrinsics.checkNotNullParameter(preferenceStore, "preferenceStore");
        this.preferenceStore = preferenceStore;
    }

    public final int getCurrentScreenNumber() {
        return this.preferenceStore.getInt(PreferencesKey.SCREEN_NUMBER, 0);
    }

    public final long getCurrentScreenTimestamp() {
        return this.preferenceStore.getLong(PreferencesKey.SCREEN_TIMESTAMP, 0L);
    }

    public final boolean isScreenNumberChanged() {
        return getCurrentScreenNumber() != this.lastScreenNumber;
    }

    public final boolean isSentBeforeFirstScreen() {
        return this.preferenceStore.getInt(PreferencesKey.SCREEN_NUMBER, 0) == 0;
    }

    public final void updateLastScreenNumber() {
        this.lastScreenNumber = getCurrentScreenNumber();
    }
}
