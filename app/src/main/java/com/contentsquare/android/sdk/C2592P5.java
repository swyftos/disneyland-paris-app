package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.P5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2592P5 implements PreferencesStore.PreferencesStoreListener {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1962a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final Logger f1963b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public C2572N5 f1964c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public InterfaceC2582O5 f1965d;

    public C2592P5(PreferencesStore preferencesStore) {
        Logger logger = new Logger("SessionStateManager");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f1962a = preferencesStore;
        this.f1963b = logger;
        this.f1964c = new C2572N5(1L, 1L, 0);
        preferencesStore.registerOnChangedListener(this);
        this.f1964c = new C2572N5(preferencesStore.getInt(PreferencesKey.SESSION_ID, 1), preferencesStore.getInt(PreferencesKey.SCREEN_NUMBER, 0), 0);
        logger.m827d("Updated state: sessionId = " + this.f1964c.f1887a + ", screenNumber = " + this.f1964c.f1888b);
    }

    @NotNull
    /* JADX INFO: renamed from: a */
    public final synchronized C2572N5 m1003a() {
        C2572N5 c2572n5;
        c2572n5 = this.f1964c;
        return new C2572N5(c2572n5.f1887a, c2572n5.f1888b, c2572n5.f1889c);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        PreferencesKey preferencesKey = PreferencesKey.SCREEN_NUMBER;
        if (key == preferencesKey) {
            synchronized (this) {
                try {
                    long j = this.f1962a.getInt(preferencesKey, 0);
                    if (j > 0) {
                        C2572N5 c2572n5 = this.f1964c;
                        long j2 = c2572n5.f1888b;
                        if (j != j2) {
                            C2572N5 c2572n6 = new C2572N5(c2572n5.f1887a, j2, 1);
                            InterfaceC2582O5 interfaceC2582O5 = this.f1965d;
                            if (interfaceC2582O5 != null) {
                                interfaceC2582O5.onPreScreenNumberChange(c2572n6);
                            }
                            this.f1964c = new C2572N5(this.f1964c.f1887a, j, 0);
                            this.f1963b.m827d("Updated state: sessionId = " + this.f1964c.f1887a + ", screenNumber = " + this.f1964c.f1888b);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
