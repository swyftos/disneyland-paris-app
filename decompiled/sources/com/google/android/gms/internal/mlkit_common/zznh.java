package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* loaded from: classes3.dex */
public final class zznh {
    private final String zza;
    private final zznf zzc;
    private final String zze;
    private final zzne zzf;
    private final String zzb = null;
    private final String zzd = null;
    private final Long zzg = null;
    private final Boolean zzh = null;
    private final Boolean zzi = null;

    /* synthetic */ zznh(zznd zzndVar, zzng zzngVar) {
        this.zza = zzndVar.zza;
        this.zzc = zzndVar.zzb;
        this.zze = zzndVar.zzc;
        this.zzf = zzndVar.zzd;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zznh)) {
            return false;
        }
        zznh zznhVar = (zznh) obj;
        return Objects.equal(this.zza, zznhVar.zza) && Objects.equal(null, null) && Objects.equal(this.zzc, zznhVar.zzc) && Objects.equal(null, null) && Objects.equal(this.zze, zznhVar.zze) && Objects.equal(this.zzf, zznhVar.zzf) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, this.zzc, null, this.zze, this.zzf, null, null, null);
    }

    @Nullable
    @zzbc(zza = 6)
    public final zzne zza() {
        return this.zzf;
    }

    @Nullable
    @zzbc(zza = 3)
    public final zznf zzb() {
        return this.zzc;
    }

    @Nullable
    @zzbc(zza = 5)
    public final String zzc() {
        return this.zze;
    }

    @Nullable
    @zzbc(zza = 1)
    public final String zzd() {
        return this.zza;
    }
}
