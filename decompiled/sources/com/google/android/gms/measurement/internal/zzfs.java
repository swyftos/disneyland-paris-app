package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzby;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzfs extends zzkg implements zzaa {
    private static int zzb = 65535;
    private static int zzc = 2;
    private final Map zzd;
    private final Map zze;
    private final Map zzf;
    private final Map zzg;
    private final Map zzh;
    private final Map zzi;

    zzfs(zzkj zzkjVar) {
        super(zzkjVar);
        this.zzd = new ArrayMap();
        this.zze = new ArrayMap();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
        this.zzi = new ArrayMap();
        this.zzh = new ArrayMap();
    }

    @Override // com.google.android.gms.measurement.internal.zzkg
    protected final boolean zze() {
        return false;
    }

    private final void zzi(String str) throws Throwable {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        if (this.zzg.get(str) == null) {
            byte[] bArrZzd = zzi().zzd(str);
            if (bArrZzd == null) {
                this.zzd.put(str, null);
                this.zze.put(str, null);
                this.zzf.put(str, null);
                this.zzg.put(str, null);
                this.zzi.put(str, null);
                this.zzh.put(str, null);
                return;
            }
            zzby.zzb.zza zzaVarZzbl = zza(str, bArrZzd).zzbl();
            zza(str, zzaVarZzbl);
            this.zzd.put(str, zza((zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZzbl.zzv())));
            this.zzg.put(str, (zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZzbl.zzv()));
            this.zzi.put(str, null);
        }
    }

    @WorkerThread
    protected final zzby.zzb zza(String str) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzi(str);
        return (zzby.zzb) this.zzg.get(str);
    }

    @WorkerThread
    protected final String zzb(String str) {
        zzd();
        return (String) this.zzi.get(str);
    }

    @WorkerThread
    protected final void zzc(String str) {
        zzd();
        this.zzi.put(str, null);
    }

    final void zzd(String str) {
        zzd();
        this.zzg.remove(str);
    }

    final boolean zze(String str) {
        zzd();
        zzby.zzb zzbVarZza = zza(str);
        if (zzbVarZza == null) {
            return false;
        }
        return zzbVarZza.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzaa
    @WorkerThread
    public final String zza(String str, String str2) throws Throwable {
        zzd();
        zzi(str);
        Map map = (Map) this.zzd.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    private static Map zza(zzby.zzb zzbVar) {
        ArrayMap arrayMap = new ArrayMap();
        if (zzbVar != null) {
            for (zzby.zzc zzcVar : zzbVar.zze()) {
                arrayMap.put(zzcVar.zza(), zzcVar.zzb());
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzby.zzb.zza zzaVar) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (zzaVar != null) {
            for (int i = 0; i < zzaVar.zza(); i++) {
                zzby.zza.C0064zza c0064zzaZzbl = zzaVar.zza(i).zzbl();
                if (TextUtils.isEmpty(c0064zzaZzbl.zza())) {
                    zzr().zzi().zza("EventConfig contained null event name");
                } else {
                    String strZzb = zzgw.zzb(c0064zzaZzbl.zza());
                    if (!TextUtils.isEmpty(strZzb)) {
                        c0064zzaZzbl = c0064zzaZzbl.zza(strZzb);
                        zzaVar.zza(i, c0064zzaZzbl);
                    }
                    arrayMap.put(c0064zzaZzbl.zza(), Boolean.valueOf(c0064zzaZzbl.zzb()));
                    arrayMap2.put(c0064zzaZzbl.zza(), Boolean.valueOf(c0064zzaZzbl.zzc()));
                    if (c0064zzaZzbl.zzd()) {
                        if (c0064zzaZzbl.zze() < zzc || c0064zzaZzbl.zze() > zzb) {
                            zzr().zzi().zza("Invalid sampling rate. Event name, sample rate", c0064zzaZzbl.zza(), Integer.valueOf(c0064zzaZzbl.zze()));
                        } else {
                            arrayMap3.put(c0064zzaZzbl.zza(), Integer.valueOf(c0064zzaZzbl.zze()));
                        }
                    }
                }
            }
        }
        this.zze.put(str, arrayMap);
        this.zzf.put(str, arrayMap2);
        this.zzh.put(str, arrayMap3);
    }

    @WorkerThread
    protected final boolean zza(String str, byte[] bArr, String str2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        zzby.zzb.zza zzaVarZzbl = zza(str, bArr).zzbl();
        if (zzaVarZzbl == null) {
            return false;
        }
        zza(str, zzaVarZzbl);
        this.zzg.put(str, (zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZzbl.zzv()));
        this.zzi.put(str, str2);
        this.zzd.put(str, zza((zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZzbl.zzv())));
        zzi().zza(str, new ArrayList(zzaVarZzbl.zzb()));
        try {
            zzaVarZzbl.zzc();
            bArr = ((zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZzbl.zzv())).zzbi();
        } catch (RuntimeException e) {
            zzr().zzi().zza("Unable to serialize reduced-size config. Storing full config instead. appId", zzeu.zza(str), e);
        }
        zzad zzadVarZzi = zzi();
        Preconditions.checkNotEmpty(str);
        zzadVarZzi.zzd();
        zzadVarZzi.zzak();
        new ContentValues().put("remote_config", bArr);
        try {
            if (zzadVarZzi.c_().update("apps", r1, "app_id = ?", new String[]{str}) == 0) {
                zzadVarZzi.zzr().zzf().zza("Failed to update remote config (got 0). appId", zzeu.zza(str));
            }
        } catch (SQLiteException e2) {
            zzadVarZzi.zzr().zzf().zza("Error storing remote config. appId", zzeu.zza(str), e2);
        }
        this.zzg.put(str, (zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZzbl.zzv()));
        return true;
    }

    final boolean zzb(String str, String str2) throws Throwable {
        Boolean bool;
        zzd();
        zzi(str);
        if (zzg(str) && zzkr.zze(str2)) {
            return true;
        }
        if (zzh(str) && zzkr.zza(str2)) {
            return true;
        }
        Map map = (Map) this.zze.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final boolean zzc(String str, String str2) throws Throwable {
        Boolean bool;
        zzd();
        zzi(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        if (com.google.android.gms.internal.measurement.zzjw.zzb() && zzt().zza(zzaq.zzci) && (FirebaseAnalytics.Event.PURCHASE.equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2))) {
            return true;
        }
        Map map = (Map) this.zzf.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    final int zzd(String str, String str2) {
        Integer num;
        zzd();
        zzi(str);
        Map map = (Map) this.zzh.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    final long zzf(String str) throws Throwable {
        String strZza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strZza)) {
            return 0L;
        }
        try {
            return Long.parseLong(strZza);
        } catch (NumberFormatException e) {
            this.zzr().zzi().zza("Unable to parse timezone offset. appId", zzeu.zza(str), e);
            return 0L;
        }
    }

    private final zzby.zzb zza(String str, byte[] bArr) {
        if (bArr == null) {
            return zzby.zzb.zzj();
        }
        try {
            zzby.zzb zzbVar = (zzby.zzb) ((com.google.android.gms.internal.measurement.zzfo) ((zzby.zzb.zza) zzkn.zza(zzby.zzb.zzi(), bArr)).zzv());
            zzr().zzx().zza("Parsed config. version, gmp_app_id", zzbVar.zza() ? Long.valueOf(zzbVar.zzb()) : null, zzbVar.zzc() ? zzbVar.zzd() : null);
            return zzbVar;
        } catch (com.google.android.gms.internal.measurement.zzfw e) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzeu.zza(str), e);
            return zzby.zzb.zzj();
        } catch (RuntimeException e2) {
            zzr().zzi().zza("Unable to merge remote config. appId", zzeu.zza(str), e2);
            return zzby.zzb.zzj();
        }
    }

    final boolean zzg(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    final boolean zzh(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzkn zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzo e_() {
        return super.e_();
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzad zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzkh
    public final /* bridge */ /* synthetic */ zzfs zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    @Override // com.google.android.gms.measurement.internal.zzgs
    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
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
