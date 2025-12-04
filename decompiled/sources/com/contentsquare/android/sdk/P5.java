package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class P5 implements PreferencesStore.PreferencesStoreListener {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final Logger b;

    @NotNull
    public N5 c;

    @Nullable
    public O5 d;

    public P5(PreferencesStore preferencesStore) {
        Logger logger = new Logger("SessionStateManager");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.a = preferencesStore;
        this.b = logger;
        this.c = new N5(1L, 1L, 0);
        preferencesStore.registerOnChangedListener(this);
        this.c = new N5(preferencesStore.getInt(PreferencesKey.SESSION_ID, 1), preferencesStore.getInt(PreferencesKey.SCREEN_NUMBER, 0), 0);
        logger.d("Updated state: sessionId = " + this.c.a + ", screenNumber = " + this.c.b);
    }

    @NotNull
    public final synchronized N5 a() {
        N5 n5;
        n5 = this.c;
        return new N5(n5.a, n5.b, n5.c);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreferencesKey preferencesKey = PreferencesKey.SCREEN_NUMBER;
        if (key == preferencesKey) {
            synchronized (this) {
                try {
                    long j = this.a.getInt(preferencesKey, 0);
                    if (j > 0) {
                        N5 n5 = this.c;
                        long j2 = n5.b;
                        if (j != j2) {
                            N5 n52 = new N5(n5.a, j2, 1);
                            O5 o5 = this.d;
                            if (o5 != null) {
                                o5.onPreScreenNumberChange(n52);
                            }
                            this.c = new N5(this.c.a, j, 0);
                            this.b.d("Updated state: sessionId = " + this.c.a + ", screenNumber = " + this.c.b);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
