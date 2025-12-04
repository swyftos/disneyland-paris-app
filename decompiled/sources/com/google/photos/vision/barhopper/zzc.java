package com.google.photos.vision.barhopper;

import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzco;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzen;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeo;
import com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfn;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzc extends zzeh implements zzfn {
    private static final zzc zzb;
    private byte zzA = 2;
    private int zzd;
    private int zze;
    private zzdf zzf;
    private String zzg;
    private zzad zzh;
    private int zzi;
    private zzp zzj;
    private zzv zzk;
    private zzco zzl;
    private zzah zzm;
    private zzao zzn;
    private zzak zzo;
    private zzz zzp;
    private zzn zzq;
    private zzr zzr;
    private zzj zzs;
    private zzeo zzt;
    private zzen zzu;
    private String zzv;
    private zzeo zzw;
    private boolean zzx;
    private double zzy;
    private zzdf zzz;

    static {
        zzc zzcVar = new zzc();
        zzb = zzcVar;
        zzeh.zzV(zzc.class, zzcVar);
    }

    private zzc() {
        zzdf zzdfVar = zzdf.zzb;
        this.zzf = zzdfVar;
        this.zzg = "";
        this.zzt = zzeh.zzP();
        this.zzu = zzeh.zzO();
        this.zzv = "";
        this.zzw = zzeh.zzP();
        this.zzx = true;
        this.zzz = zzdfVar;
    }

    static /* synthetic */ void zzp(zzc zzcVar, int i, zzaf zzafVar) {
        zzafVar.getClass();
        zzeo zzeoVar = zzcVar.zzt;
        if (!zzeoVar.zzc()) {
            zzcVar.zzt = zzeh.zzQ(zzeoVar);
        }
        zzcVar.zzt.set(i, zzafVar);
    }

    public final int zzA() {
        int iZza = zzg.zza(this.zzi);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    public final int zza() {
        return this.zzt.size();
    }

    public final zzco zzb() {
        zzco zzcoVar = this.zzl;
        return zzcoVar == null ? zzco.zzb() : zzcoVar;
    }

    public final zzn zzd() {
        zzn zznVar = this.zzq;
        return zznVar == null ? zzn.zzd() : zznVar;
    }

    public final zzp zze() {
        zzp zzpVar = this.zzj;
        return zzpVar == null ? zzp.zzc() : zzpVar;
    }

    public final zzr zzf() {
        zzr zzrVar = this.zzr;
        return zzrVar == null ? zzr.zzb() : zzrVar;
    }

    public final zzv zzh() {
        zzv zzvVar = this.zzk;
        return zzvVar == null ? zzv.zzb() : zzvVar;
    }

    public final zzz zzi() {
        zzz zzzVar = this.zzp;
        return zzzVar == null ? zzz.zzd() : zzzVar;
    }

    public final zzah zzj() {
        zzah zzahVar = this.zzm;
        return zzahVar == null ? zzah.zzb() : zzahVar;
    }

    public final zzak zzk() {
        zzak zzakVar = this.zzo;
        return zzakVar == null ? zzak.zzb() : zzakVar;
    }

    public final zzao zzl() {
        zzao zzaoVar = this.zzn;
        return zzaoVar == null ? zzao.zzb() : zzaoVar;
    }

    public final zzdf zzm() {
        return this.zzf;
    }

    public final String zzn() {
        return this.zzg;
    }

    public final List zzo() {
        return this.zzt;
    }

    public final boolean zzq() {
        return (this.zzd & 4096) != 0;
    }

    public final boolean zzr() {
        return (this.zzd & 32) != 0;
    }

    public final boolean zzs() {
        return (this.zzd & 8192) != 0;
    }

    public final boolean zzt() {
        return (this.zzd & 64) != 0;
    }

    public final boolean zzu() {
        return (this.zzd & 2048) != 0;
    }

    public final boolean zzv() {
        return (this.zzd & 128) != 0;
    }

    public final boolean zzw() {
        return (this.zzd & 256) != 0;
    }

    public final boolean zzx() {
        return (this.zzd & 1024) != 0;
    }

    public final boolean zzy() {
        return (this.zzd & 512) != 0;
    }

    public final int zzz() {
        int iZza = zze.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzeh
    protected final Object zzg(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzA);
        }
        if (i2 == 2) {
            return zzeh.zzS(zzb, "\u0004\u0016\u0000\u0001\u0001\u0017\u0016\u0000\u0003\u000b\u0001ᴌ\u0000\u0002ᔊ\u0001\u0003ᔈ\u0002\u0004ᴌ\u0004\u0005ᐉ\u0005\u0006ဉ\u0006\u0007ဉ\u0007\bᐉ\b\tᐉ\t\nᐉ\n\u000bЛ\fဈ\u000f\rЛ\u000eည\u0012\u000fᐉ\u000b\u0010ဉ\f\u0011ဉ\r\u0012\u0016\u0013ဉ\u000e\u0014ဇ\u0010\u0015က\u0011\u0017ဉ\u0003", new Object[]{"zzd", "zze", zzd.zza, "zzf", "zzg", "zzi", zzf.zza, "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzt", zzaf.class, "zzv", "zzw", zzaf.class, "zzz", "zzp", "zzq", "zzr", "zzu", "zzs", "zzx", "zzy", "zzh"});
        }
        if (i2 == 3) {
            return new zzc();
        }
        zza zzaVar = null;
        if (i2 == 4) {
            return new zzb(zzaVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzA = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
