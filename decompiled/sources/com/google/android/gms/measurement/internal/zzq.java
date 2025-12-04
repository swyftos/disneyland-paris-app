package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcb;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzq {
    private String zza;
    private boolean zzb;
    private zzcb.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map zzf;
    private Map zzg;
    private final /* synthetic */ zzo zzh;

    private zzq(zzo zzoVar, String str) {
        this.zzh = zzoVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new ArrayMap();
        this.zzg = new ArrayMap();
    }

    private zzq(zzo zzoVar, String str, zzcb.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2) {
        this.zzh = zzoVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new ArrayMap();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add((Long) map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zziVar;
    }

    final void zza(zzv zzvVar) {
        int iZza = zzvVar.zza();
        Boolean bool = zzvVar.zzc;
        if (bool != null) {
            this.zze.set(iZza, bool.booleanValue());
        }
        Boolean bool2 = zzvVar.zzd;
        if (bool2 != null) {
            this.zzd.set(iZza, bool2.booleanValue());
        }
        if (zzvVar.zze != null) {
            Long l = (Long) this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zzvVar.zze.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zzvVar.zzf != null) {
            List arrayList = (List) this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zzvVar.zzb()) {
                arrayList.clear();
            }
            if (com.google.android.gms.internal.measurement.zzki.zzb() && this.zzh.zzt().zzd(this.zza, zzaq.zzbf) && zzvVar.zzc()) {
                arrayList.clear();
            }
            if (com.google.android.gms.internal.measurement.zzki.zzb() && this.zzh.zzt().zzd(this.zza, zzaq.zzbf)) {
                long jLongValue2 = zzvVar.zzf.longValue() / 1000;
                if (arrayList.contains(Long.valueOf(jLongValue2))) {
                    return;
                }
                arrayList.add(Long.valueOf(jLongValue2));
                return;
            }
            arrayList.add(Long.valueOf(zzvVar.zzf.longValue() / 1000));
        }
    }

    final zzcb.zza zza(int i) {
        ArrayList arrayList;
        List listEmptyList;
        zzcb.zza.C0065zza c0065zzaZzh = zzcb.zza.zzh();
        c0065zzaZzh.zza(i);
        c0065zzaZzh.zza(this.zzb);
        zzcb.zzi zziVar = this.zzc;
        if (zziVar != null) {
            c0065zzaZzh.zza(zziVar);
        }
        zzcb.zzi.zza zzaVarZza = zzcb.zzi.zzi().zzb(zzkn.zza(this.zzd)).zza(zzkn.zza(this.zze));
        if (this.zzf == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.zzf.size());
            for (Integer num : this.zzf.keySet()) {
                arrayList.add((zzcb.zzb) ((com.google.android.gms.internal.measurement.zzfo) zzcb.zzb.zze().zza(num.intValue()).zza(((Long) this.zzf.get(num)).longValue()).zzv()));
            }
        }
        zzaVarZza.zzc(arrayList);
        if (this.zzg == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList2 = new ArrayList(this.zzg.size());
            for (Integer num2 : this.zzg.keySet()) {
                zzcb.zzj.zza zzaVarZza2 = zzcb.zzj.zze().zza(num2.intValue());
                List list = (List) this.zzg.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza2.zza(list);
                }
                arrayList2.add((zzcb.zzj) ((com.google.android.gms.internal.measurement.zzfo) zzaVarZza2.zzv()));
            }
            listEmptyList = arrayList2;
        }
        zzaVarZza.zzd(listEmptyList);
        c0065zzaZzh.zza(zzaVarZza);
        return (zzcb.zza) ((com.google.android.gms.internal.measurement.zzfo) c0065zzaZzh.zzv());
    }

    /* synthetic */ zzq(zzo zzoVar, String str, zzcb.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzr zzrVar) {
        this(zzoVar, str, zziVar, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzq(zzo zzoVar, String str, zzr zzrVar) {
        this(zzoVar, str);
    }
}
