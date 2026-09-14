package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* JADX INFO: renamed from: com.contentsquare.android.sdk.n4 */
/* JADX INFO: loaded from: classes2.dex */
public final class C2825n4 extends Lambda implements Function0<EnumC2551L4> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ PreferencesStore f2910a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C2472D5 f2911b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C2815m4 f2912c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C2581O4 f2913d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ boolean f2914e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2825n4(PreferencesStore preferencesStore, C2472D5 c2472d5, C2815m4 c2815m4, C2581O4 c2581o4, boolean z) {
        super(0);
        this.f2910a = preferencesStore;
        this.f2911b = c2472d5;
        this.f2912c = c2815m4;
        this.f2913d = c2581o4;
        this.f2914e = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final EnumC2551L4 invoke() {
        boolean zM898a;
        JsonConfig.SessionReplay sessionReplay;
        PreferencesStore preferencesStore = this.f2910a;
        C2472D5 c2472d5 = this.f2911b;
        C2815m4 c2815m4 = this.f2912c;
        C2581O4 c2581o4 = this.f2913d;
        boolean z = this.f2914e;
        JsonConfig.ProjectConfiguration projectConfig = c2472d5.f1520b.getProjectConfig();
        float recordingRate = (projectConfig == null || (sessionReplay = projectConfig.getSessionReplay()) == null) ? 0.0f : sessionReplay.getRecordingRate();
        PreferencesKey preferencesKey = PreferencesKey.RECORDING_RATE_CONFIG;
        float f = preferencesStore.getFloat(preferencesKey, -1.0f);
        if (recordingRate == BitmapDescriptorFactory.HUE_RED || f == -1.0f || z) {
            preferencesStore.putFloat(preferencesKey, recordingRate);
        } else {
            recordingRate = f;
        }
        int iRoundToInt = MathKt.roundToInt(recordingRate * 100);
        PreferencesKey preferencesKey2 = PreferencesKey.RECORDING_SEGMENT_SAMPLE;
        int iNextInt = preferencesStore.getInt(preferencesKey2, -1);
        if (iNextInt == -1 || z) {
            c2815m4.getClass();
            iNextInt = C2815m4.f2883a.nextInt(100);
            preferencesStore.putInt(preferencesKey2, iNextInt);
        }
        boolean z2 = true;
        boolean z3 = iNextInt < iRoundToInt;
        if (z3) {
            c2581o4.f1944a = EnumC2571N4.RANDOM_SAMPLING;
        } else {
            PreferencesStore preferencesStore2 = c2472d5.f1519a;
            PreferencesKey preferencesKey3 = PreferencesKey.SESSION_REPLAY_ETR_ENABLED;
            if (!preferencesStore2.contains(preferencesKey3) || z) {
                c2472d5.f1519a.putBoolean(preferencesKey3, c2472d5.m898a());
                zM898a = c2472d5.m898a();
            } else {
                zM898a = c2472d5.f1519a.getBoolean(preferencesKey3, false);
            }
            if (zM898a) {
                c2581o4.f1944a = EnumC2571N4.ETR_SAMPLING;
            } else {
                z2 = false;
            }
        }
        C2835o4.f2938a.m827d("recordingRate = " + iRoundToInt + ", randomSegmentSample = " + iNextInt + ", isRandomlyDrawnForRecording = " + z3 + ", samplingMode = " + c2581o4.f1944a.name() + "isDrawnForRecording = " + z2);
        return z2 ? EnumC2551L4.PROPAGATE_START : EnumC2551L4.PROPAGATE_STOP;
    }
}
