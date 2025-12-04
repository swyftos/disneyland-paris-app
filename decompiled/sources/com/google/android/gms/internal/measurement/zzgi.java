package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class zzgi extends zzgg {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgi() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final List zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzin.zzf(obj, j);
        if (list instanceof zzgh) {
            objUnmodifiableList = ((zzgh) list).zze();
        } else {
            if (zza.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzhi) && (list instanceof zzfx)) {
                zzfx zzfxVar = (zzfx) list;
                if (zzfxVar.zza()) {
                    zzfxVar.zzb();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzin.zza(obj, j, objUnmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zza(Object obj, long j, int i) {
        zzge zzgeVar;
        List arrayList;
        List listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            if (listZzc instanceof zzgh) {
                arrayList = new zzge(i);
            } else if ((listZzc instanceof zzhi) && (listZzc instanceof zzfx)) {
                arrayList = ((zzfx) listZzc).zza(i);
            } else {
                arrayList = new ArrayList(i);
            }
            zzin.zza(obj, j, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList2 = new ArrayList(listZzc.size() + i);
            arrayList2.addAll(listZzc);
            zzin.zza(obj, j, arrayList2);
            zzgeVar = arrayList2;
        } else if (listZzc instanceof zzii) {
            zzge zzgeVar2 = new zzge(listZzc.size() + i);
            zzgeVar2.addAll((zzii) listZzc);
            zzin.zza(obj, j, zzgeVar2);
            zzgeVar = zzgeVar2;
        } else {
            if (!(listZzc instanceof zzhi) || !(listZzc instanceof zzfx)) {
                return listZzc;
            }
            zzfx zzfxVar = (zzfx) listZzc;
            if (zzfxVar.zza()) {
                return listZzc;
            }
            zzfx zzfxVarZza = zzfxVar.zza(listZzc.size() + i);
            zzin.zza(obj, j, zzfxVarZza);
            return zzfxVarZza;
        }
        return zzgeVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgg
    final void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzin.zza(obj, j, listZzc);
    }

    private static List zzc(Object obj, long j) {
        return (List) zzin.zzf(obj, j);
    }
}
