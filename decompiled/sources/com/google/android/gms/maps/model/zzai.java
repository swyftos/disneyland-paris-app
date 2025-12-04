package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzay;

/* loaded from: classes4.dex */
final class zzai extends zzay {
    final /* synthetic */ TileProvider zza;

    zzai(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzaz
    public final Tile zzb(int i, int i2, int i3) {
        return this.zza.getTile(i, i2, i3);
    }
}
