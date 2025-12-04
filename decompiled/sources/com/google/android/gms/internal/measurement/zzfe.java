package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzfe {
    private static final zzfe zzd = new zzfe(true);
    final zzhq zza;
    private boolean zzb;
    private boolean zzc;

    private zzfe() {
        this.zza = zzhq.zza(16);
    }

    private zzfe(boolean z) {
        this(zzhq.zza(0));
        zzb();
    }

    private zzfe(zzhq zzhqVar) {
        this.zza = zzhqVar;
        zzb();
    }

    public static zzfe zza() {
        return zzd;
    }

    public final void zzb() {
        if (this.zzb) {
            return;
        }
        this.zza.zza();
        this.zzb = true;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzfe) {
            return this.zza.equals(((zzfe) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator zzd() {
        if (this.zzc) {
            return new zzgc(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    final Iterator zze() {
        if (this.zzc) {
            return new zzgc(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(zzfg zzfgVar) {
        Object obj = this.zza.get(zzfgVar);
        return obj instanceof zzgb ? zzgb.zza() : obj;
    }

    private final void zzb(zzfg zzfgVar, Object obj) {
        if (zzfgVar.zzd()) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList.get(i);
                i++;
                zza(zzfgVar.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            zza(zzfgVar.zzb(), obj);
        }
        if (obj instanceof zzgb) {
            this.zzc = true;
        }
        this.zza.put(zzfgVar, obj);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zza(com.google.android.gms.internal.measurement.zziu r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzfr.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzfh.zza
            com.google.android.gms.internal.measurement.zzjb r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = r1
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgw
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgb
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfq
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzeg
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfe.zza(com.google.android.gms.internal.measurement.zziu, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zza((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean zza(Map.Entry entry) {
        zzfg zzfgVar = (zzfg) entry.getKey();
        if (zzfgVar.zzc() == zzjb.MESSAGE) {
            if (zzfgVar.zzd()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgw) it.next()).g_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgw) {
                    if (!((zzgw) value).g_()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzgb) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzfe zzfeVar) {
        for (int i = 0; i < zzfeVar.zza.zzc(); i++) {
            zzb(zzfeVar.zza.zzb(i));
        }
        Iterator it = zzfeVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzb((Map.Entry) it.next());
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzhf) {
            return ((zzhf) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry entry) {
        zzgw zzgwVarZzv;
        zzfg zzfgVar = (zzfg) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzgb) {
            value = zzgb.zza();
        }
        if (zzfgVar.zzd()) {
            Object objZza = zza(zzfgVar);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zza(it.next()));
            }
            this.zza.put(zzfgVar, objZza);
            return;
        }
        if (zzfgVar.zzc() == zzjb.MESSAGE) {
            Object objZza2 = zza(zzfgVar);
            if (objZza2 == null) {
                this.zza.put(zzfgVar, zza(value));
                return;
            }
            if (objZza2 instanceof zzhf) {
                zzgwVarZzv = zzfgVar.zza((zzhf) objZza2, (zzhf) value);
            } else {
                zzgwVarZzv = zzfgVar.zza(((zzgw) objZza2).zzbq(), (zzgw) value).zzv();
            }
            this.zza.put(zzfgVar, zzgwVarZzv);
            return;
        }
        this.zza.put(zzfgVar, zza(value));
    }

    public final int zzg() {
        int iZzc = 0;
        for (int i = 0; i < this.zza.zzc(); i++) {
            iZzc += zzc(this.zza.zzb(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzc += zzc((Map.Entry) it.next());
        }
        return iZzc;
    }

    private static int zzc(Map.Entry entry) {
        zzfg zzfgVar = (zzfg) entry.getKey();
        Object value = entry.getValue();
        if (zzfgVar.zzc() == zzjb.MESSAGE && !zzfgVar.zzd() && !zzfgVar.zze()) {
            if (value instanceof zzgb) {
                return zzev.zzb(((zzfg) entry.getKey()).zza(), (zzgb) value);
            }
            return zzev.zzb(((zzfg) entry.getKey()).zza(), (zzgw) value);
        }
        return zza(zzfgVar, value);
    }

    static int zza(zziu zziuVar, int i, Object obj) {
        int iZze = zzev.zze(i);
        if (zziuVar == zziu.zzj) {
            zzfr.zza((zzgw) obj);
            iZze <<= 1;
        }
        return iZze + zzb(zziuVar, obj);
    }

    private static int zzb(zziu zziuVar, Object obj) {
        switch (zzfh.zzb[zziuVar.ordinal()]) {
            case 1:
                return zzev.zzb(((Double) obj).doubleValue());
            case 2:
                return zzev.zzb(((Float) obj).floatValue());
            case 3:
                return zzev.zzd(((Long) obj).longValue());
            case 4:
                return zzev.zze(((Long) obj).longValue());
            case 5:
                return zzev.zzf(((Integer) obj).intValue());
            case 6:
                return zzev.zzg(((Long) obj).longValue());
            case 7:
                return zzev.zzi(((Integer) obj).intValue());
            case 8:
                return zzev.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzev.zzc((zzgw) obj);
            case 10:
                if (obj instanceof zzgb) {
                    return zzev.zza((zzgb) obj);
                }
                return zzev.zzb((zzgw) obj);
            case 11:
                if (obj instanceof zzeg) {
                    return zzev.zzb((zzeg) obj);
                }
                return zzev.zzb((String) obj);
            case 12:
                if (obj instanceof zzeg) {
                    return zzev.zzb((zzeg) obj);
                }
                return zzev.zzb((byte[]) obj);
            case 13:
                return zzev.zzg(((Integer) obj).intValue());
            case 14:
                return zzev.zzj(((Integer) obj).intValue());
            case 15:
                return zzev.zzh(((Long) obj).longValue());
            case 16:
                return zzev.zzh(((Integer) obj).intValue());
            case 17:
                return zzev.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfq) {
                    return zzev.zzk(((zzfq) obj).zza());
                }
                return zzev.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzfg zzfgVar, Object obj) {
        zziu zziuVarZzb = zzfgVar.zzb();
        int iZza = zzfgVar.zza();
        if (zzfgVar.zzd()) {
            int iZza2 = 0;
            if (zzfgVar.zze()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza2 += zzb(zziuVarZzb, it.next());
                }
                return zzev.zze(iZza) + iZza2 + zzev.zzl(iZza2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza2 += zza(zziuVarZzb, iZza, it2.next());
            }
            return iZza2;
        }
        return zza(zziuVarZzb, iZza, obj);
    }

    public final /* synthetic */ Object clone() {
        zzfe zzfeVar = new zzfe();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry entryZzb = this.zza.zzb(i);
            zzfeVar.zzb((zzfg) entryZzb.getKey(), entryZzb.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzfeVar.zzb((zzfg) entry.getKey(), entry.getValue());
        }
        zzfeVar.zzc = this.zzc;
        return zzfeVar;
    }
}
