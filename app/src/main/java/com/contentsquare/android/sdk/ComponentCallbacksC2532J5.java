package com.contentsquare.android.sdk;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.J5 */
/* JADX INFO: loaded from: classes2.dex */
public final class ComponentCallbacksC2532J5 implements PreferencesStore.PreferencesStoreListener, ComponentCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: a */
    @NotNull
    public final PreferencesStore f1751a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final C2512H5 f1752b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final Logger f1753c;

    /* JADX INFO: renamed from: d */
    public boolean f1754d;

    /* JADX INFO: renamed from: e */
    public final int f1755e;

    /* JADX INFO: renamed from: f */
    public final int f1756f;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.J5$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ int[] f1757a;

        static {
            int[] iArr = new int[PreferencesKey.values().length];
            try {
                iArr[PreferencesKey.SESSION_REPLAY_FORCE_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreferencesKey.SCREEN_NUMBER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PreferencesKey.RAW_CONFIGURATION_AS_JSON.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PreferencesKey.TRACKING_ENABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PreferencesKey.FORGET_ME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PreferencesKey.PAUSE_TRACKING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PreferencesKey.LOCAL_SESSION_REPLAY_MODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f1757a = iArr;
        }
    }

    public ComponentCallbacksC2532J5(@NotNull Application application, @NotNull PreferencesStore preferencesStore, @NotNull C2512H5 startStopRules) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(startStopRules, "startStopRules");
        this.f1751a = preferencesStore;
        this.f1752b = startStopRules;
        this.f1753c = new Logger("SessionReplayStartStopController");
        this.f1755e = preferencesStore.getInt(PreferencesKey.SESSION_ID, 0);
        this.f1756f = preferencesStore.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        application.registerComponentCallbacks(this);
        preferencesStore.registerOnChangedListener(this);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.f1753c.m831i("Low Memory Detected");
        Telemetry.INSTANCE.collect$library_release("sr.low_memory", Boolean.TRUE);
        this.f1754d = true;
        this.f1752b.m932a(false, false, true);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        switch (a.f1757a[key.ordinal()]) {
            case 1:
                this.f1752b.m932a(false, false, this.f1754d);
                break;
            case 2:
                boolean z = this.f1751a.getInt(PreferencesKey.PAUSED_SESSION_ID, -1) != -1;
                int i = this.f1751a.getInt(PreferencesKey.SESSION_ID, 0);
                int i2 = this.f1751a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
                int i3 = this.f1755e;
                boolean z2 = i != i3 && i2 == 1;
                boolean z3 = i == i3 && i2 == this.f1756f + 1;
                boolean z4 = z || z2 || z3;
                if (z2) {
                    this.f1753c.m827d("New session detected. New session/screen: " + i + '/' + i2 + ". Started with: " + this.f1755e + '/' + this.f1756f);
                }
                if (z3) {
                    this.f1753c.m827d("Session resumed. Session/screen: " + i + '/' + i2 + ". Started with: " + this.f1755e + '/' + this.f1756f);
                }
                this.f1752b.m932a(z4, z2, this.f1754d);
                break;
            case 3:
                this.f1752b.m932a(true, false, this.f1754d);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                this.f1752b.m932a(true, true, this.f1754d);
                break;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 15) {
            this.f1753c.m831i("Low Memory Detected");
            Telemetry.INSTANCE.collect$library_release("sr.trim_memory", Boolean.TRUE);
            this.f1754d = true;
            this.f1752b.m932a(false, false, true);
        }
    }
}
