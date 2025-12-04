package com.google.mlkit.vision.common;

import android.media.Image;

/* loaded from: classes4.dex */
final class zzb {
    private final Image zza;

    zzb(Image image) {
        this.zza = image;
    }

    final Image zza() {
        return this.zza;
    }

    final Image.Plane[] zzb() {
        return this.zza.getPlanes();
    }
}
