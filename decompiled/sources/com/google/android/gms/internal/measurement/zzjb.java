package com.google.android.gms.internal.measurement;

import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes3.dex */
public enum zzjb {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
    DOUBLE(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)),
    BOOLEAN(Boolean.FALSE),
    STRING(""),
    BYTE_STRING(zzeg.zza),
    ENUM(null),
    MESSAGE(null);

    private final Object zzj;

    zzjb(Object obj) {
        this.zzj = obj;
    }
}
