package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzgs implements zzgt {
    zzgs() {
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final Map zza(Object obj) {
        return (zzgq) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final zzgr zzb(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final Map zzc(Object obj) {
        return (zzgq) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final boolean zzd(Object obj) {
        return !((zzgq) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final Object zze(Object obj) {
        ((zzgq) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final Object zzf(Object obj) {
        return zzgq.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final Object zza(Object obj, Object obj2) {
        zzgq zzgqVarZzb = (zzgq) obj;
        zzgq zzgqVar = (zzgq) obj2;
        if (!zzgqVar.isEmpty()) {
            if (!zzgqVarZzb.zzd()) {
                zzgqVarZzb = zzgqVarZzb.zzb();
            }
            zzgqVarZzb.zza(zzgqVar);
        }
        return zzgqVarZzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzgt
    public final int zza(int i, Object obj, Object obj2) {
        zzgq zzgqVar = (zzgq) obj;
        if (zzgqVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzgqVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
