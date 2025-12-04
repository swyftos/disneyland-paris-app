package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class zzhr {
    private static final Class zza = zzd();
    private static final zzih zzb = zza(false);
    private static final zzih zzc = zza(true);
    private static final zzih zzd = new zzij();

    public static void zza(Class cls) {
        Class cls2;
        if (!zzfo.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzg(i, list, z);
    }

    public static void zzb(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzf(i, list, z);
    }

    public static void zzc(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzc(i, list, z);
    }

    public static void zzd(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzd(i, list, z);
    }

    public static void zze(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzn(i, list, z);
    }

    public static void zzf(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zze(i, list, z);
    }

    public static void zzg(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzl(i, list, z);
    }

    public static void zzh(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zza(i, list, z);
    }

    public static void zzi(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzj(i, list, z);
    }

    public static void zzj(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzm(i, list, z);
    }

    public static void zzk(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzb(i, list, z);
    }

    public static void zzl(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzk(i, list, z);
    }

    public static void zzm(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzh(i, list, z);
    }

    public static void zzn(int i, List list, zzja zzjaVar, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzi(i, list, z);
    }

    public static void zza(int i, List list, zzja zzjaVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zza(i, list);
    }

    public static void zzb(int i, List list, zzja zzjaVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzb(i, list);
    }

    public static void zza(int i, List list, zzja zzjaVar, zzhp zzhpVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zza(i, list, zzhpVar);
    }

    public static void zzb(int i, List list, zzja zzjaVar, zzhp zzhpVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzjaVar.zzb(i, list, zzhpVar);
    }

    static int zza(List list) {
        int iZzd;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            iZzd = 0;
            while (i < size) {
                iZzd += zzev.zzd(zzgkVar.zzb(i));
                i++;
            }
        } else {
            iZzd = 0;
            while (i < size) {
                iZzd += zzev.zzd(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzd;
    }

    static int zza(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzev.zze(i));
    }

    static int zzb(List list) {
        int iZze;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            iZze = 0;
            while (i < size) {
                iZze += zzev.zze(zzgkVar.zzb(i));
                i++;
            }
        } else {
            iZze = 0;
            while (i < size) {
                iZze += zzev.zze(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZze;
    }

    static int zzb(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzev.zze(i));
    }

    static int zzc(List list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgk) {
            zzgk zzgkVar = (zzgk) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzev.zzf(zzgkVar.zzb(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzev.zzf(((Long) list.get(i)).longValue());
                i++;
            }
        }
        return iZzf;
    }

    static int zzc(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzev.zze(i));
    }

    static int zzd(List list) {
        int iZzk;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            iZzk = 0;
            while (i < size) {
                iZzk += zzev.zzk(zzfpVar.zzc(i));
                i++;
            }
        } else {
            iZzk = 0;
            while (i < size) {
                iZzk += zzev.zzk(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzk;
    }

    static int zzd(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzev.zze(i));
    }

    static int zze(List list) {
        int iZzf;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            iZzf = 0;
            while (i < size) {
                iZzf += zzev.zzf(zzfpVar.zzc(i));
                i++;
            }
        } else {
            iZzf = 0;
            while (i < size) {
                iZzf += zzev.zzf(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzf;
    }

    static int zze(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzev.zze(i));
    }

    static int zzf(List list) {
        int iZzg;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            iZzg = 0;
            while (i < size) {
                iZzg += zzev.zzg(zzfpVar.zzc(i));
                i++;
            }
        } else {
            iZzg = 0;
            while (i < size) {
                iZzg += zzev.zzg(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzg;
    }

    static int zzf(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzev.zze(i));
    }

    static int zzg(List list) {
        int iZzh;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfp) {
            zzfp zzfpVar = (zzfp) list;
            iZzh = 0;
            while (i < size) {
                iZzh += zzev.zzh(zzfpVar.zzc(i));
                i++;
            }
        } else {
            iZzh = 0;
            while (i < size) {
                iZzh += zzev.zzh(((Integer) list.get(i)).intValue());
                i++;
            }
        }
        return iZzh;
    }

    static int zzg(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzev.zze(i));
    }

    static int zzh(List list) {
        return list.size() << 2;
    }

    static int zzh(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.zzi(i, 0);
    }

    static int zzi(List list) {
        return list.size() << 3;
    }

    static int zzi(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.zzg(i, 0L);
    }

    static int zzj(List list) {
        return list.size();
    }

    static int zzj(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzev.zzb(i, true);
    }

    static int zza(int i, List list) {
        int iZzb;
        int iZzb2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZze = zzev.zze(i) * size;
        if (list instanceof zzgh) {
            zzgh zzghVar = (zzgh) list;
            while (i2 < size) {
                Object objZzb = zzghVar.zzb(i2);
                if (objZzb instanceof zzeg) {
                    iZzb2 = zzev.zzb((zzeg) objZzb);
                } else {
                    iZzb2 = zzev.zzb((String) objZzb);
                }
                iZze += iZzb2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzeg) {
                    iZzb = zzev.zzb((zzeg) obj);
                } else {
                    iZzb = zzev.zzb((String) obj);
                }
                iZze += iZzb;
                i2++;
            }
        }
        return iZze;
    }

    static int zza(int i, Object obj, zzhp zzhpVar) {
        if (obj instanceof zzgf) {
            return zzev.zza(i, (zzgf) obj);
        }
        return zzev.zzb(i, (zzgw) obj, zzhpVar);
    }

    static int zza(int i, List list, zzhp zzhpVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = zzev.zze(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzgf) {
                iZza = zzev.zza((zzgf) obj);
            } else {
                iZza = zzev.zza((zzgw) obj, zzhpVar);
            }
            iZze += iZza;
        }
        return iZze;
    }

    static int zzb(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZze = size * zzev.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZze += zzev.zzb((zzeg) list.get(i2));
        }
        return iZze;
    }

    static int zzb(int i, List list, zzhp zzhpVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzev.zzc(i, (zzgw) list.get(i2), zzhpVar);
        }
        return iZzc;
    }

    public static zzih zza() {
        return zzb;
    }

    public static zzih zzb() {
        return zzc;
    }

    public static zzih zzc() {
        return zzd;
    }

    private static zzih zza(boolean z) {
        try {
            Class clsZze = zze();
            if (clsZze == null) {
                return null;
            }
            return (zzih) clsZze.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static void zza(zzgt zzgtVar, Object obj, Object obj2, long j) {
        zzin.zza(obj, j, zzgtVar.zza(zzin.zzf(obj, j), zzin.zzf(obj2, j)));
    }

    static void zza(zzfd zzfdVar, Object obj, Object obj2) {
        zzfe zzfeVarZza = zzfdVar.zza(obj2);
        if (zzfeVarZza.zza.isEmpty()) {
            return;
        }
        zzfdVar.zzb(obj).zza(zzfeVarZza);
    }

    static void zza(zzih zzihVar, Object obj, Object obj2) {
        zzihVar.zza(obj, zzihVar.zzc(zzihVar.zzb(obj), zzihVar.zzb(obj2)));
    }

    static Object zza(int i, List list, zzfs zzfsVar, Object obj, zzih zzihVar) {
        if (zzfsVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int iIntValue = num.intValue();
                if (zzfsVar.zza(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = zza(i, iIntValue, obj, zzihVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = ((Integer) it.next()).intValue();
                if (!zzfsVar.zza(iIntValue2)) {
                    obj = zza(i, iIntValue2, obj, zzihVar);
                    it.remove();
                }
            }
        }
        return obj;
    }

    static Object zza(int i, int i2, Object obj, zzih zzihVar) {
        if (obj == null) {
            obj = zzihVar.zza();
        }
        zzihVar.zza(obj, i, i2);
        return obj;
    }
}
