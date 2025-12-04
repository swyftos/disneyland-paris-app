package com.google.android.odml.image;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
final class zze implements zzg {
    private final Bitmap zza;
    private final ImageProperties zzb;

    public zze(Bitmap bitmap) {
        this.zza = bitmap;
        zzb zzbVar = new zzb();
        int i = zzd.zza[bitmap.getConfig().ordinal()];
        zzbVar.zza(i != 1 ? i != 2 ? 0 : 1 : 8);
        zzbVar.zzb(1);
        this.zzb = zzbVar.zzc();
    }

    public final Bitmap zza() {
        return this.zza;
    }

    @Override // com.google.android.odml.image.zzg
    public final ImageProperties zzb() {
        return this.zzb;
    }

    @Override // com.google.android.odml.image.zzg
    public final void zzc() {
        this.zza.recycle();
    }
}
