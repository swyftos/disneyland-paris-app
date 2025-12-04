package com.google.android.gms.internal.mlkit_vision_barcode;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes3.dex */
public final class zzft {
    private final zzrb zza;
    private final Boolean zzc;
    private final zzvz zze;
    private final zzcs zzf;
    private final zzcs zzg;
    private final Boolean zzb = null;
    private final zzqk zzd = null;

    /* synthetic */ zzft(zzfr zzfrVar, zzfs zzfsVar) {
        this.zza = zzfrVar.zza;
        this.zzc = zzfrVar.zzb;
        this.zze = zzfrVar.zzc;
        this.zzf = zzfrVar.zzd;
        this.zzg = zzfrVar.zze;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        return Objects.equal(this.zza, zzftVar.zza) && Objects.equal(null, null) && Objects.equal(this.zzc, zzftVar.zzc) && Objects.equal(null, null) && Objects.equal(this.zze, zzftVar.zze) && Objects.equal(this.zzf, zzftVar.zzf) && Objects.equal(this.zzg, zzftVar.zzg);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, this.zzg);
    }

    @Nullable
    @zzfe(zza = 6)
    public final zzcs zza() {
        return this.zzf;
    }

    @Nullable
    @zzfe(zza = 7)
    public final zzcs zzb() {
        return this.zzg;
    }

    @Nullable
    @zzfe(zza = 1)
    public final zzrb zzc() {
        return this.zza;
    }

    @Nullable
    @zzfe(zza = 5)
    public final zzvz zzd() {
        return this.zze;
    }

    @Nullable
    @zzfe(zza = 3)
    public final Boolean zze() {
        return this.zzc;
    }
}
