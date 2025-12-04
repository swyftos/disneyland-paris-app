package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

/* loaded from: classes3.dex */
public class zzex {
    protected volatile zzfm zza;
    private volatile zzdf zzb;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzex)) {
            return false;
        }
        zzex zzexVar = (zzex) obj;
        zzfm zzfmVar = this.zza;
        zzfm zzfmVar2 = zzexVar.zza;
        if (zzfmVar == null && zzfmVar2 == null) {
            return zzb().equals(zzexVar.zzb());
        }
        if (zzfmVar != null && zzfmVar2 != null) {
            return zzfmVar.equals(zzfmVar2);
        }
        if (zzfmVar != null) {
            zzexVar.zzd(zzfmVar.zzac());
            return zzfmVar.equals(zzexVar.zza);
        }
        zzd(zzfmVar2.zzac());
        return this.zza.equals(zzfmVar2);
    }

    public int hashCode() {
        return 1;
    }

    public final int zza() {
        if (this.zzb != null) {
            return ((zzde) this.zzb).zza.length;
        }
        if (this.zza != null) {
            return this.zza.zzF();
        }
        return 0;
    }

    public final zzdf zzb() {
        if (this.zzb != null) {
            return this.zzb;
        }
        synchronized (this) {
            try {
                if (this.zzb != null) {
                    return this.zzb;
                }
                if (this.zza == null) {
                    this.zzb = zzdf.zzb;
                } else {
                    this.zzb = this.zza.zzC();
                }
                return this.zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzfm zzc(zzfm zzfmVar) {
        zzfm zzfmVar2 = this.zza;
        this.zzb = null;
        this.zza = zzfmVar;
        return zzfmVar2;
    }

    protected final void zzd(zzfm zzfmVar) {
        if (this.zza != null) {
            return;
        }
        synchronized (this) {
            if (this.zza != null) {
                return;
            }
            try {
                this.zza = zzfmVar;
                this.zzb = zzdf.zzb;
            } catch (zzer unused) {
                this.zza = zzfmVar;
                this.zzb = zzdf.zzb;
            }
        }
    }
}
