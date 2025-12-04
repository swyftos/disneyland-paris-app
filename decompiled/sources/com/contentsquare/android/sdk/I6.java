package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes2.dex */
public final class I6 {

    @NotNull
    public final H1 a;

    @NotNull
    public final PreferencesStore b;

    @NotNull
    public final Logger c;

    public I6(@NotNull H1 eventsProvidersManager, @NotNull PreferencesStore preferencesStore) {
        Intrinsics.checkNotNullParameter(eventsProvidersManager, "eventsProvidersManager");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        this.a = eventsProvidersManager;
        this.b = preferencesStore;
        this.c = new Logger("StartStopEventProvider");
    }

    public final synchronized void a(boolean z) {
        try {
            EnumC0845w6 enumC0845w6 = (this.b.getBoolean(PreferencesKey.SESSION_REPLAY_FORCE_START, false) || this.b.getBoolean(PreferencesKey.LOCAL_SESSION_REPLAY_MODE, false)) ? EnumC0845w6.FORCED : EnumC0845w6.REGULAR;
            this.a.a(new C0836v6(System.currentTimeMillis(), enumC0845w6, z));
            this.c.d("Session Replay start event added: " + enumC0845w6);
        } catch (Throwable th) {
            throw th;
        }
    }
}
