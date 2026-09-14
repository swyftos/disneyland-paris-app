package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzdx {
    private static final zzdx zzb = new zzdx(true);
    final zzgo zza = new zzgh();
    private boolean zzc;
    private boolean zzd;

    private zzdx() {
    }

    public static int zza(zzdw zzdwVar, Object obj) {
        int iZzd;
        int iZzA;
        zzhf zzhfVarZzd = zzdwVar.zzd();
        int iZza = zzdwVar.zza();
        zzdwVar.zzg();
        int iZzA2 = zzdn.zzA(iZza << 3);
        if (zzhfVarZzd == zzhf.zzj) {
            byte[] bArr = zzep.zzb;
            if (((zzfm) obj) instanceof zzcr) {
                throw null;
            }
            iZzA2 += iZzA2;
        }
        zzhg zzhgVar = zzhg.INT;
        int iZzB = 4;
        switch (zzhfVarZzd.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                iZzB = 8;
                return iZzA2 + iZzB;
            case 1:
                ((Float) obj).floatValue();
                return iZzA2 + iZzB;
            case 2:
                iZzB = zzdn.zzB(((Long) obj).longValue());
                return iZzA2 + iZzB;
            case 3:
                iZzB = zzdn.zzB(((Long) obj).longValue());
                return iZzA2 + iZzB;
            case 4:
                iZzB = zzdn.zzB(((Integer) obj).intValue());
                return iZzA2 + iZzB;
            case 5:
                ((Long) obj).longValue();
                iZzB = 8;
                return iZzA2 + iZzB;
            case 6:
                ((Integer) obj).intValue();
                return iZzA2 + iZzB;
            case 7:
                ((Boolean) obj).booleanValue();
                iZzB = 1;
                return iZzA2 + iZzB;
            case 8:
                if (obj instanceof zzdf) {
                    iZzd = ((zzdf) obj).zzd();
                    iZzA = zzdn.zzA(iZzd);
                    iZzB = iZzA + iZzd;
                } else {
                    iZzB = zzdn.zzz((String) obj);
                }
                return iZzA2 + iZzB;
            case 9:
                iZzB = ((zzfm) obj).zzF();
                return iZzA2 + iZzB;
            case 10:
                if (obj instanceof zzew) {
                    iZzd = ((zzew) obj).zza();
                    iZzA = zzdn.zzA(iZzd);
                    iZzB = iZzA + iZzd;
                } else {
                    iZzB = zzdn.zzx((zzfm) obj);
                }
                return iZzA2 + iZzB;
            case 11:
                if (obj instanceof zzdf) {
                    iZzd = ((zzdf) obj).zzd();
                    iZzA = zzdn.zzA(iZzd);
                } else {
                    iZzd = ((byte[]) obj).length;
                    iZzA = zzdn.zzA(iZzd);
                }
                iZzB = iZzA + iZzd;
                return iZzA2 + iZzB;
            case 12:
                iZzB = zzdn.zzA(((Integer) obj).intValue());
                return iZzA2 + iZzB;
            case 13:
                iZzB = obj instanceof zzej ? zzdn.zzB(((zzej) obj).zza()) : zzdn.zzB(((Integer) obj).intValue());
                return iZzA2 + iZzB;
            case 14:
                ((Integer) obj).intValue();
                return iZzA2 + iZzB;
            case 15:
                ((Long) obj).longValue();
                iZzB = 8;
                return iZzA2 + iZzB;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iZzB = zzdn.zzA((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iZzA2 + iZzB;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iZzB = zzdn.zzB((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iZzA2 + iZzB;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static zzdx zzd() {
        return zzb;
    }

    private static Object zzl(Object obj) {
        if (obj instanceof zzfr) {
            return ((zzfr) obj).zzc();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    private final void zzm(Map.Entry entry) {
        zzdw zzdwVar = (zzdw) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof zzew;
        zzdwVar.zzg();
        if (zzdwVar.zze() != zzhg.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            this.zza.put(zzdwVar, zzl(value));
            return;
        }
        Object objZze = zze(zzdwVar);
        if (objZze != null) {
            if (z) {
                throw null;
            }
            this.zza.put(zzdwVar, objZze instanceof zzfr ? zzdwVar.zzc((zzfr) objZze, (zzfr) value) : zzdwVar.zzb(((zzfm) objZze).zzaa(), (zzfm) value).zzj());
        } else {
            this.zza.put(zzdwVar, zzl(value));
            if (z) {
                this.zzd = true;
            }
        }
    }

    private static boolean zzn(Map.Entry entry) {
        zzdw zzdwVar = (zzdw) entry.getKey();
        if (zzdwVar.zze() != zzhg.MESSAGE) {
            return true;
        }
        zzdwVar.zzg();
        Object value = entry.getValue();
        if (value instanceof zzfn) {
            return ((zzfn) value).zzad();
        }
        if (value instanceof zzew) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static final int zzo(Map.Entry entry) {
        int i;
        int iZzA;
        int iZzA2;
        zzdw zzdwVar = (zzdw) entry.getKey();
        Object value = entry.getValue();
        if (zzdwVar.zze() != zzhg.MESSAGE) {
            return zza(zzdwVar, value);
        }
        zzdwVar.zzg();
        zzdwVar.zzf();
        if (value instanceof zzew) {
            int iZza = ((zzdw) entry.getKey()).zza();
            int iZzA3 = zzdn.zzA(8);
            i = iZzA3 + iZzA3;
            iZzA = zzdn.zzA(16) + zzdn.zzA(iZza);
            int iZzA4 = zzdn.zzA(24);
            int iZza2 = ((zzew) value).zza();
            iZzA2 = iZzA4 + zzdn.zzA(iZza2) + iZza2;
        } else {
            int iZza3 = ((zzdw) entry.getKey()).zza();
            int iZzA5 = zzdn.zzA(8);
            i = iZzA5 + iZzA5;
            iZzA = zzdn.zzA(16) + zzdn.zzA(iZza3);
            iZzA2 = zzdn.zzA(24) + zzdn.zzx((zzfm) value);
        }
        return i + iZzA + iZzA2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzdx) {
            return this.zza.equals(((zzdx) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final int zzb() {
        int iZzc = this.zza.zzc();
        int iZzo = 0;
        for (int i = 0; i < iZzc; i++) {
            iZzo += zzo(this.zza.zzg(i));
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            iZzo += zzo((Map.Entry) it.next());
        }
        return iZzo;
    }

    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final zzdx clone() {
        zzdx zzdxVar = new zzdx();
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            zzdxVar.zzi((zzdw) ((zzgi) entryZzg).zza(), entryZzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzd()) {
            zzdxVar.zzi((zzdw) entry.getKey(), entry.getValue());
        }
        zzdxVar.zzd = this.zzd;
        return zzdxVar;
    }

    public final Object zze(zzdw zzdwVar) {
        Object obj = this.zza.get(zzdwVar);
        if (obj instanceof zzew) {
            throw null;
        }
        return obj;
    }

    public final Iterator zzf() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzd ? new zzev(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if (this.zzc) {
            return;
        }
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            Map.Entry entryZzg = this.zza.zzg(i);
            if (entryZzg.getValue() instanceof zzeh) {
                ((zzeh) entryZzg.getValue()).zzT();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzh(zzdx zzdxVar) {
        int iZzc = zzdxVar.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            zzm(zzdxVar.zza.zzg(i));
        }
        Iterator it = zzdxVar.zza.zzd().iterator();
        while (it.hasNext()) {
            zzm((Map.Entry) it.next());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:29:0x004e  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzej) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0048, code lost:
    
        if (r0 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzew) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzi(zzdw zzdwVar, Object obj) {
        boolean z;
        zzdwVar.zzg();
        zzdwVar.zzd();
        byte[] bArr = zzep.zzb;
        obj.getClass();
        zzhf zzhfVar = zzhf.zza;
        zzhg zzhgVar = zzhg.INT;
        switch (r0.zza()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof zzdf)) {
                    break;
                }
                if (obj instanceof zzew) {
                    this.zzd = true;
                }
                this.zza.put(zzdwVar, obj);
                return;
            case ENUM:
                if (!(obj instanceof Integer)) {
                    break;
                }
                if (obj instanceof zzew) {
                    this.zzd = true;
                }
                this.zza.put(zzdwVar, obj);
                return;
            case MESSAGE:
                if (!(obj instanceof zzfm)) {
                    break;
                }
                if (obj instanceof zzew) {
                    this.zzd = true;
                }
                this.zza.put(zzdwVar, obj);
                return;
            default:
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(zzdwVar.zza()), zzdwVar.zzd().zza(), obj.getClass().getName()));
        }
    }

    public final boolean zzj() {
        return this.zzc;
    }

    public final boolean zzk() {
        int iZzc = this.zza.zzc();
        for (int i = 0; i < iZzc; i++) {
            if (!zzn(this.zza.zzg(i))) {
                return false;
            }
        }
        Iterator it = this.zza.zzd().iterator();
        while (it.hasNext()) {
            if (!zzn((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzdx(boolean z) {
        zzg();
        zzg();
    }
}
