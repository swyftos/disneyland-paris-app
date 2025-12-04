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

/* loaded from: classes2.dex */
public final class J5 implements PreferencesStore.PreferencesStoreListener, ComponentCallbacks, ComponentCallbacks2 {

    @NotNull
    public final PreferencesStore a;

    @NotNull
    public final H5 b;

    @NotNull
    public final Logger c;
    public boolean d;
    public final int e;
    public final int f;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

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
            a = iArr;
        }
    }

    public J5(@NotNull Application application, @NotNull PreferencesStore preferencesStore, @NotNull H5 startStopRules) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(preferencesStore, "preferencesStore");
        Intrinsics.checkNotNullParameter(startStopRules, "startStopRules");
        this.a = preferencesStore;
        this.b = startStopRules;
        this.c = new Logger("SessionReplayStartStopController");
        this.e = preferencesStore.getInt(PreferencesKey.SESSION_ID, 0);
        this.f = preferencesStore.getInt(PreferencesKey.SCREEN_NUMBER, 0);
        application.registerComponentCallbacks(this);
        preferencesStore.registerOnChangedListener(this);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        this.c.i("Low Memory Detected");
        Telemetry.INSTANCE.collect$library_release("sr.low_memory", Boolean.TRUE);
        this.d = true;
        this.b.a(false, false, true);
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NotNull PreferencesKey key) {
        Intrinsics.checkNotNullParameter(key, "key");
        switch (a.a[key.ordinal()]) {
            case 1:
                this.b.a(false, false, this.d);
                break;
            case 2:
                boolean z = this.a.getInt(PreferencesKey.PAUSED_SESSION_ID, -1) != -1;
                int i = this.a.getInt(PreferencesKey.SESSION_ID, 0);
                int i2 = this.a.getInt(PreferencesKey.SCREEN_NUMBER, 0);
                int i3 = this.e;
                boolean z2 = i != i3 && i2 == 1;
                boolean z3 = i == i3 && i2 == this.f + 1;
                boolean z4 = z || z2 || z3;
                if (z2) {
                    this.c.d("New session detected. New session/screen: " + i + '/' + i2 + ". Started with: " + this.e + '/' + this.f);
                }
                if (z3) {
                    this.c.d("Session resumed. Session/screen: " + i + '/' + i2 + ". Started with: " + this.e + '/' + this.f);
                }
                this.b.a(z4, z2, this.d);
                break;
            case 3:
                this.b.a(true, false, this.d);
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                this.b.a(true, true, this.d);
                break;
        }
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 15) {
            this.c.i("Low Memory Detected");
            Telemetry.INSTANCE.collect$library_release("sr.trim_memory", Boolean.TRUE);
            this.d = true;
            this.b.a(false, false, true);
        }
    }
}
