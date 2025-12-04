package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
final class zzo extends zzkg {
    private String zzb;
    private Set zzc;
    private Map zzd;
    private Long zze;
    private Long zzf;

    zzo(zzkj zzkjVar) {
        super(zzkjVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzkg
    protected final boolean zze() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:217:0x05fe, code lost:
    
        r7 = zzr().zzi();
        r8 = com.google.android.gms.measurement.internal.zzeu.zza(r45.zzb);
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x0610, code lost:
    
        if (r9.zza() == false) goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0612, code lost:
    
        r9 = java.lang.Integer.valueOf(r9.zzb());
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x061b, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x061c, code lost:
    
        r7.zza("Invalid property filter ID. appId, id", r8, java.lang.String.valueOf(r9));
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List zza(java.lang.String r46, java.util.List r47, java.util.List r48, java.lang.Long r49, java.lang.Long r50) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1740
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzo.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    private final zzq zza(int i) {
        if (this.zzd.containsKey(Integer.valueOf(i))) {
            return (zzq) this.zzd.get(Integer.valueOf(i));
        }
        zzq zzqVar = new zzq(this, this.zzb, null);
        this.zzd.put(Integer.valueOf(i), zzqVar);
        return zzqVar;
    }

    private final boolean zza(int i, int i2) {
        if (this.zzd.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return ((zzq) this.zzd.get(Integer.valueOf(i))).zzd.get(i2);
    }
}
