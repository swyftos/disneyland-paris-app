package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* loaded from: classes3.dex */
final class zzei implements Comparator {
    zzei() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeg zzegVar = (zzeg) obj;
        zzeg zzegVar2 = (zzeg) obj2;
        zzel zzelVar = (zzel) zzegVar.iterator();
        zzel zzelVar2 = (zzel) zzegVar2.iterator();
        while (zzelVar.hasNext() && zzelVar2.hasNext()) {
            int iCompare = Integer.compare(zzeg.zzb(zzelVar.zza()), zzeg.zzb(zzelVar2.zza()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzegVar.zza(), zzegVar2.zza());
    }
}
