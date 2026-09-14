package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.I6 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2523I6 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final C2508H1 f1707a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final PreferencesStore f1708b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1709c;

    public C2523I6(@NotNull C2508H1 eventsProvidersManager, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.f1707a = eventsProvidersManager;
        this.f1708b = preferencesStore;
        this.f1709c = new Logger("StartStopEventProvider");
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m944a(boolean z) {
        try {
            EnumC2917w6 enumC2917w6 = (this.f1708b.getBoolean(PreferencesKey.SESSION_REPLAY_FORCE_START, false) || this.f1708b.getBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, false)) ? EnumC2917w6.FORCED : EnumC2917w6.REGULAR;
            this.f1707a.m930a(new C2907v6(System.currentTimeMillis(), enumC2917w6, z));
            this.f1709c.m827d("Session Replay start event added: " + enumC2917w6);
        } catch (Throwable th) {
            throw th;
        }
    }
}
