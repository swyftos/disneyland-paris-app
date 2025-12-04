package com.contentsquare.android.sdk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;

/* renamed from: com.contentsquare.android.sdk.x5, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0853x5 implements InterfaceC0859y2, PreferencesStore.PreferencesStoreListener {

    @NonNull
    public final Logger a = new Logger("SdkManager");

    @NonNull
    public final Configuration b;

    @NonNull
    public final C0868z2 c;

    @NonNull
    public final PreferencesStore d;

    @Nullable
    public a e;
    public boolean f;

    /* renamed from: com.contentsquare.android.sdk.x5$a */
    public interface a {
    }

    public C0853x5(@NonNull Configuration configuration, @NonNull C0868z2 c0868z2, @NonNull PreferencesStore preferencesStore) {
        this.b = configuration;
        this.c = c0868z2;
        this.d = preferencesStore;
        preferencesStore.registerOnChangedListener(this);
        a();
    }

    public final void a(boolean z) {
        a aVar = this.e;
        if (aVar == null) {
            return;
        }
        L2 l2 = (L2) aVar;
        if (z) {
            l2.a();
        } else {
            l2.b();
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NonNull PreferencesKey preferencesKey) {
        if (preferencesKey == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            a();
        }
    }

    public final void a() {
        Logger logger;
        String str;
        JsonConfig.ProjectConfiguration projectConfig = this.b.getProjectConfig();
        if (projectConfig != null) {
            if (!projectConfig.getOptOutByDefault() || this.d.contains(PreferencesKey.IS_OPT_OUT)) {
                PreferencesStore preferencesStore = this.d;
                PreferencesKey preferencesKey = PreferencesKey.IS_OPT_OUT;
                if (preferencesStore.getBoolean(preferencesKey, false)) {
                    this.a.i("User consent status: Opted-out");
                } else if (projectConfig.getTrackingEnabled()) {
                    if (this.d.contains(preferencesKey)) {
                        logger = this.a;
                        str = "User consent status: Opted-in";
                    } else {
                        logger = this.a;
                        str = "User consent status: Opted-in by default";
                    }
                    logger.i(str);
                    if (this.d.getBoolean(PreferencesKey.PAUSE_TRACKING, false)) {
                        this.a.i("Data collection has been paused with Contentsquare.stopTracking(). You can resume data collection by calling Contentsquare.resumeTracking()");
                    } else if (this.d.getBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false)) {
                        this.a.i("User is drawn for tracking: true (forced because CS InApp enabled)");
                        z = true;
                    } else {
                        double sample = projectConfig.getSample();
                        C0868z2 c0868z2 = this.c;
                        int i = (int) (sample * 100);
                        PreferencesStore preferencesStore2 = c0868z2.a;
                        PreferencesKey preferencesKey2 = PreferencesKey.LAST_SEGMENT;
                        if (preferencesStore2.getInt(preferencesKey2, -1) != i) {
                            c0868z2.c.getClass();
                            int iNextInt = C0745m4.a.nextInt(100);
                            c0868z2.a.putInt(preferencesKey2, i);
                            c0868z2.a.putBoolean(PreferencesKey.IS_TRACKABLE, iNextInt < i);
                        }
                        z = c0868z2.a.getBoolean(PreferencesKey.IS_TRACKABLE, true);
                        c0868z2.b.d("segmentSize = " + i + ", isInAudience = " + z);
                        Logger logger2 = this.a;
                        StringBuilder sb = new StringBuilder("User is drawn for tracking: ");
                        sb.append(z);
                        logger2.p(sb.toString());
                    }
                }
            } else {
                this.a.i("User consent status: Waiting for opt-in");
            }
            this.f = z;
            a(z);
            this.d.putBoolean(PreferencesKey.TRACKING_ENABLE, this.f);
        }
    }
}
