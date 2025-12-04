package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzcb;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class zzt {
    private zzcb.zzc zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzo zzd;

    private zzt(zzo zzoVar) {
        this.zzd = zzoVar;
    }

    final zzcb.zzc zza(String str, zzcb.zzc zzcVar) {
        Object obj;
        String strZzc = zzcVar.zzc();
        List<zzcb.zze> listZza = zzcVar.zza();
        Long l = (Long) this.zzd.zzg().zzb(zzcVar, "_eid");
        boolean z = l != null;
        if (z && strZzc.equals("_ep")) {
            strZzc = (String) this.zzd.zzg().zzb(zzcVar, "_en");
            if (TextUtils.isEmpty(strZzc)) {
                this.zzd.zzr().zzg().zza("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.zza == null || this.zzb == null || l.longValue() != this.zzb.longValue()) {
                Pair pairZza = this.zzd.zzi().zza(str, l);
                if (pairZza == null || (obj = pairZza.first) == null) {
                    this.zzd.zzr().zzg().zza("Extra parameter without existing main event. eventName, eventId", strZzc, l);
                    return null;
                }
                this.zza = (zzcb.zzc) obj;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzb = (Long) this.zzd.zzg().zzb(this.zza, "_eid");
            }
            long j = this.zzc - 1;
            this.zzc = j;
            if (j <= 0) {
                zzad zzadVarZzi = this.zzd.zzi();
                zzadVarZzi.zzd();
                zzadVarZzi.zzr().zzx().zza("Clearing complex main event info. appId", str);
                try {
                    zzadVarZzi.c_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    zzadVarZzi.zzr().zzf().zza("Error clearing complex main event", e);
                }
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzcb.zze zzeVar : this.zza.zza()) {
                this.zzd.zzg();
                if (zzkn.zza(zzcVar, zzeVar.zzb()) == null) {
                    arrayList.add(zzeVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzr().zzg().zza("No unique parameters in main event. eventName", strZzc);
            } else {
                arrayList.addAll(listZza);
                listZza = arrayList;
            }
        } else if (z) {
            this.zzb = l;
            this.zza = zzcVar;
            Object objZzb = this.zzd.zzg().zzb(zzcVar, "_epc");
            long jLongValue = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue <= 0) {
                this.zzd.zzr().zzg().zza("Complex event with zero extra param count. eventName", strZzc);
            } else {
                this.zzd.zzi().zza(str, l, this.zzc, zzcVar);
            }
        }
        return (zzcb.zzc) ((com.google.android.gms.internal.measurement.zzfo) zzcVar.zzbl().zza(strZzc).zzc().zza(listZza).zzv());
    }

    /* synthetic */ zzt(zzo zzoVar, zzr zzrVar) {
        this(zzoVar);
    }
}
