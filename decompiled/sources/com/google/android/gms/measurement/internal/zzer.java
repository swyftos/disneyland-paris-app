package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzlm;
import com.google.android.gms.internal.measurement.zznh;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzer extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzer(zzfy zzfyVar, long j) {
        super(zzfyVar);
        this.zzg = j;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean zzz() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|2|(1:4)(27:119|6|(1:10)(2:11|(1:13))|117|14|(4:16|(1:18)(1:20)|121|21)|26|(1:31)(1:30)|32|(1:37)(1:36)|38|(1:(1:41)(1:42))|(3:44|45|(1:57))(0)|58|(1:60)|123|61|(1:68)(1:65)|69|(1:71)(1:72)|73|74|(2:87|(1:89))(4:78|(1:80)(1:81)|82|(1:86))|(3:91|(1:93)(1:94)|95)|98|(2:100|(1:111)(2:102|(1:104)(4:105|(3:108|(1:126)(1:127)|106)|125|111)))|(2:113|114)(2:115|116))|5|26|(2:28|31)(0)|32|(2:34|37)(0)|38|(0)|(0)(0)|58|(0)|123|61|(7:63|68|69|(0)(0)|73|74|(4:76|87|(0)|(0))(0))(0)|98|(0)|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01cb, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0251, code lost:
    
        zzr().zzf().zza("Fetching Google App Id failed with exception. appId", com.google.android.gms.measurement.internal.zzeu.zza(r0), r3);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01af A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:61:0x01a9, B:63:0x01af, B:65:0x01bb, B:69:0x01d2, B:73:0x01db, B:76:0x01e5, B:78:0x01f1, B:82:0x0208, B:84:0x0210, B:91:0x0234, B:93:0x0248, B:95:0x024d, B:94:0x024b, B:86:0x0216, B:87:0x021d, B:89:0x0223, B:68:0x01ce), top: B:123:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01ce A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:61:0x01a9, B:63:0x01af, B:65:0x01bb, B:69:0x01d2, B:73:0x01db, B:76:0x01e5, B:78:0x01f1, B:82:0x0208, B:84:0x0210, B:91:0x0234, B:93:0x0248, B:95:0x024d, B:94:0x024b, B:86:0x0216, B:87:0x021d, B:89:0x0223, B:68:0x01ce), top: B:123:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x021d A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:61:0x01a9, B:63:0x01af, B:65:0x01bb, B:69:0x01d2, B:73:0x01db, B:76:0x01e5, B:78:0x01f1, B:82:0x0208, B:84:0x0210, B:91:0x0234, B:93:0x0248, B:95:0x024d, B:94:0x024b, B:86:0x0216, B:87:0x021d, B:89:0x0223, B:68:0x01ce), top: B:123:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0223 A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:61:0x01a9, B:63:0x01af, B:65:0x01bb, B:69:0x01d2, B:73:0x01db, B:76:0x01e5, B:78:0x01f1, B:82:0x0208, B:84:0x0210, B:91:0x0234, B:93:0x0248, B:95:0x024d, B:94:0x024b, B:86:0x0216, B:87:0x021d, B:89:0x0223, B:68:0x01ce), top: B:123:0x01a9 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0234 A[Catch: IllegalStateException -> 0x01cb, TryCatch #3 {IllegalStateException -> 0x01cb, blocks: (B:61:0x01a9, B:63:0x01af, B:65:0x01bb, B:69:0x01d2, B:73:0x01db, B:76:0x01e5, B:78:0x01f1, B:82:0x0208, B:84:0x0210, B:91:0x0234, B:93:0x0248, B:95:0x024d, B:94:0x024b, B:86:0x0216, B:87:0x021d, B:89:0x0223, B:68:0x01ce), top: B:123:0x01a9 }] */
    @Override // com.google.android.gms.measurement.internal.zzg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void zzaa() throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzer.zzaa():void");
    }

    final zzn zza(String str) {
        boolean z;
        long jMin;
        zzd();
        zzb();
        String strZzab = zzab();
        String strZzac = zzac();
        zzw();
        String str2 = this.zzb;
        long jZzaf = zzaf();
        zzw();
        String str3 = this.zzd;
        long jZzf = zzt().zzf();
        zzw();
        zzd();
        if (this.zzf == 0) {
            this.zzf = this.zzy.zzi().zza(zzn(), zzn().getPackageName());
        }
        long j = this.zzf;
        boolean zZzab = this.zzy.zzab();
        boolean z2 = !zzs().zzq;
        zzd();
        zzb();
        String strZzai = !this.zzy.zzab() ? null : zzai();
        zzfy zzfyVar = this.zzy;
        long jZza = zzfyVar.zzc().zzh.zza();
        if (jZza == 0) {
            jMin = zzfyVar.zza;
            z = z2;
        } else {
            z = z2;
            jMin = Math.min(zzfyVar.zza, jZza);
        }
        int iZzag = zzag();
        boolean zBooleanValue = zzt().zzi().booleanValue();
        zzy zzyVarZzt = zzt();
        zzyVarZzt.zzb();
        Boolean boolZze = zzyVarZzt.zze("google_analytics_ssaid_collection_enabled");
        boolean z3 = boolZze == null || boolZze.booleanValue();
        zzfg zzfgVarZzs = zzs();
        zzfgVarZzs.zzd();
        return new zzn(strZzab, strZzac, str2, jZzaf, str3, jZzf, j, str, zZzab, z, strZzai, 0L, jMin, iZzag, zBooleanValue, z3, zzfgVarZzs.zzg().getBoolean("deferred_analytics_collection", false), zzad(), zzt().zze("google_analytics_default_allow_ad_personalization_signals") == null ? null : Boolean.valueOf(!r11.booleanValue()), this.zzg, zzt().zza(zzaq.zzbb) ? this.zzh : null, (zzlm.zzb() && zzt().zza(zzaq.zzbn)) ? zzae() : null);
    }

    private final String zzai() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (zznh.zzb() && zzt().zza(zzaq.zzbq)) {
            zzr().zzx().zza("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> clsLoadClass = zzn().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (clsLoadClass == null) {
                return null;
            }
            try {
                Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, zzn());
                if (objInvoke == null) {
                    return null;
                }
                try {
                    return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(objInvoke, new Object[0]);
                } catch (Exception unused) {
                    zzr().zzk().zza("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                zzr().zzj().zza("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
        }
    }

    final String zzab() {
        zzw();
        return this.zza;
    }

    final String zzac() {
        zzw();
        return this.zzj;
    }

    final String zzad() {
        zzw();
        return this.zzk;
    }

    final String zzae() {
        zzw();
        return this.zzl;
    }

    final int zzaf() {
        zzw();
        return this.zzc;
    }

    final int zzag() {
        zzw();
        return this.zzi;
    }

    final List zzah() {
        return this.zzh;
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzd, com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zza zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzhc zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzer zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzir zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzii zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzeq zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzd
    public final /* bridge */ /* synthetic */ zzjv zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzes zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzkr zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzfv zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzeu zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzfg zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs, com.google.android.gms.measurement.internal.zzgu
    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }
}
