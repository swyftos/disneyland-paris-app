package com.contentsquare.android.sdk;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.x5 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2926x5 implements InterfaceC2933y2, PreferencesStore.PreferencesStoreListener {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final Logger f3229a = new Logger("SdkManager");

    /* JADX INFO: renamed from: b */
    @NonNull
    public final Configuration f3230b;

    /* JADX INFO: renamed from: c */
    @NonNull
    public final C2943z2 f3231c;

    /* JADX INFO: renamed from: d */
    @NonNull
    public final PreferencesStore f3232d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public a f3233e;

    /* JADX INFO: renamed from: f */
    public boolean f3234f;

    /* JADX INFO: renamed from: com.contentsquare.android.sdk.x5$a */
    public interface a {
    }

    public C2926x5(@NonNull Configuration configuration, @NonNull C2943z2 c2943z2, @NonNull PreferencesStore preferencesStore) {
        this.f3230b = configuration;
        this.f3231c = c2943z2;
        this.f3232d = preferencesStore;
        preferencesStore.registerOnChangedListener(this);
        m1232a();
    }

    /* JADX INFO: renamed from: a */
    public final void m1233a(boolean z) {
        a aVar = this.f3233e;
        if (aVar == null) {
            return;
        }
        C2549L2 c2549l2 = (C2549L2) aVar;
        if (z) {
            c2549l2.m977a();
        } else {
            c2549l2.m978b();
        }
    }

    @Override // com.contentsquare.android.core.features.preferences.PreferencesStore.PreferencesStoreListener
    public final void onPreferenceChanged(@NonNull PreferencesKey preferencesKey) {
        if (preferencesKey == PreferencesKey.RAW_CONFIGURATION_AS_JSON) {
            m1232a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1232a() {
        Logger logger;
        String str;
        JsonConfig.ProjectConfiguration projectConfig = this.f3230b.getProjectConfig();
        if (projectConfig != null) {
            boolean z = false;
            if (!projectConfig.getOptOutByDefault() || this.f3232d.contains(PreferencesKey.IS_OPT_OUT)) {
                PreferencesStore preferencesStore = this.f3232d;
                PreferencesKey preferencesKey = PreferencesKey.IS_OPT_OUT;
                if (preferencesStore.getBoolean(preferencesKey, false)) {
                    this.f3229a.m831i("User consent status: Opted-out");
                } else if (projectConfig.getTrackingEnabled()) {
                    if (this.f3232d.contains(preferencesKey)) {
                        logger = this.f3229a;
                        str = "User consent status: Opted-in";
                    } else {
                        logger = this.f3229a;
                        str = "User consent status: Opted-in by default";
                    }
                    logger.m831i(str);
                    if (this.f3232d.getBoolean(PreferencesKey.PAUSE_TRACKING, false)) {
                        this.f3229a.m831i("Data collection has been paused with Contentsquare.stopTracking(). You can resume data collection by calling Contentsquare.resumeTracking()");
                    } else if (this.f3232d.getBoolean(PreferencesKey.CLIENT_MODE_ACTIVATION_STATE, false)) {
                        this.f3229a.m831i("User is drawn for tracking: true (forced because CS InApp enabled)");
                        z = true;
                    } else {
                        double sample = projectConfig.getSample();
                        C2943z2 c2943z2 = this.f3231c;
                        int i = (int) (sample * ((double) 100));
                        PreferencesStore preferencesStore2 = c2943z2.f3306a;
                        PreferencesKey preferencesKey2 = PreferencesKey.LAST_SEGMENT;
                        if (preferencesStore2.getInt(preferencesKey2, -1) != i) {
                            c2943z2.f3308c.getClass();
                            int iNextInt = C2815m4.f2883a.nextInt(100);
                            c2943z2.f3306a.putInt(preferencesKey2, i);
                            c2943z2.f3306a.putBoolean(PreferencesKey.IS_TRACKABLE, iNextInt < i);
                        }
                        z = c2943z2.f3306a.getBoolean(PreferencesKey.IS_TRACKABLE, true);
                        c2943z2.f3307b.m827d("segmentSize = " + i + ", isInAudience = " + z);
                        Logger logger2 = this.f3229a;
                        StringBuilder sb = new StringBuilder("User is drawn for tracking: ");
                        sb.append(z);
                        logger2.m833p(sb.toString());
                    }
                }
            } else {
                this.f3229a.m831i("User consent status: Waiting for opt-in");
            }
            this.f3234f = z;
            m1233a(z);
            this.f3232d.putBoolean(PreferencesKey.TRACKING_ENABLE, this.f3234f);
        }
    }
}
