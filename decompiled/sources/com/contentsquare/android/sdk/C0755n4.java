package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.features.preferences.PreferencesStore;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.math.MathKt;

/* renamed from: com.contentsquare.android.sdk.n4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0755n4 extends Lambda implements Function0<L4> {
    public final /* synthetic */ PreferencesStore a;
    public final /* synthetic */ D5 b;
    public final /* synthetic */ C0745m4 c;
    public final /* synthetic */ O4 d;
    public final /* synthetic */ boolean e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0755n4(PreferencesStore preferencesStore, D5 d5, C0745m4 c0745m4, O4 o4, boolean z) {
        super(0);
        this.a = preferencesStore;
        this.b = d5;
        this.c = c0745m4;
        this.d = o4;
        this.e = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final L4 invoke() {
        boolean zA;
        JsonConfig.SessionReplay sessionReplay;
        PreferencesStore preferencesStore = this.a;
        D5 d5 = this.b;
        C0745m4 c0745m4 = this.c;
        O4 o4 = this.d;
        boolean z = this.e;
        JsonConfig.ProjectConfiguration projectConfig = d5.b.getProjectConfig();
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
            c0745m4.getClass();
            iNextInt = C0745m4.a.nextInt(100);
            preferencesStore.putInt(preferencesKey2, iNextInt);
        }
        boolean z2 = true;
        boolean z3 = iNextInt < iRoundToInt;
        if (z3) {
            o4.a = N4.RANDOM_SAMPLING;
        } else {
            PreferencesStore preferencesStore2 = d5.a;
            PreferencesKey preferencesKey3 = PreferencesKey.SESSION_REPLAY_ETR_ENABLED;
            if (!preferencesStore2.contains(preferencesKey3) || z) {
                d5.a.putBoolean(preferencesKey3, d5.a());
                zA = d5.a();
            } else {
                zA = d5.a.getBoolean(preferencesKey3, false);
            }
            if (zA) {
                o4.a = N4.ETR_SAMPLING;
            } else {
                z2 = false;
            }
        }
        C0765o4.a.d("recordingRate = " + iRoundToInt + ", randomSegmentSample = " + iNextInt + ", isRandomlyDrawnForRecording = " + z3 + ", samplingMode = " + o4.a.name() + "isDrawnForRecording = " + z2);
        return z2 ? L4.PROPAGATE_START : L4.PROPAGATE_STOP;
    }
}
