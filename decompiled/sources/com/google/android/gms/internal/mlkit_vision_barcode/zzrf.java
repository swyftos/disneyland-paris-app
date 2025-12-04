package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.annotation.Nullable;
import com.google.firebase.encoders.annotations.Encodable;
import org.bouncycastle.bcpg.PublicKeyAlgorithmTags;

@Encodable
/* loaded from: classes3.dex */
public final class zzrf {
    private final zzvd zza;
    private final zzrc zzb;
    private final zzra zzc;
    private final zzrr zzd;
    private final zzru zze;
    private final zzfv zzf;
    private final zzut zzg;

    /* synthetic */ zzrf(zzrd zzrdVar, zzre zzreVar) {
        this.zza = zzrdVar.zza;
        this.zzb = zzrdVar.zzb;
        this.zzc = zzrdVar.zzc;
        this.zzd = zzrdVar.zzd;
        this.zze = zzrdVar.zze;
        this.zzf = zzrdVar.zzf;
        this.zzg = zzrdVar.zzg;
    }

    @Nullable
    @zzfe(zza = 33)
    public final zzfv zza() {
        return this.zzf;
    }

    @Nullable
    @zzfe(zza = 61)
    public final zzra zzb() {
        return this.zzc;
    }

    @Nullable
    @zzfe(zza = 2)
    public final zzrc zzc() {
        return this.zzb;
    }

    @Nullable
    @zzfe(zza = 7)
    public final zzrr zzd() {
        return this.zzd;
    }

    @Nullable
    @zzfe(zza = 58)
    public final zzru zze() {
        return this.zze;
    }

    @Nullable
    @zzfe(zza = PublicKeyAlgorithmTags.EXPERIMENTAL_7)
    public final zzut zzf() {
        return this.zzg;
    }

    @Nullable
    @zzfe(zza = 1)
    public final zzvd zzg() {
        return this.zza;
    }
}
