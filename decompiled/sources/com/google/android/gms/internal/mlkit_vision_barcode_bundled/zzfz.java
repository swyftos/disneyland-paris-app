package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class zzfz {
    private final ArrayDeque zza = new ArrayDeque();

    static /* bridge */ /* synthetic */ zzdf zza(zzfz zzfzVar, zzdf zzdfVar, zzdf zzdfVar2) {
        zzfzVar.zzb(zzdfVar);
        zzfzVar.zzb(zzdfVar2);
        zzdf zzgdVar = (zzdf) zzfzVar.zza.pop();
        while (!zzfzVar.zza.isEmpty()) {
            zzgdVar = new zzgd((zzdf) zzfzVar.zza.pop(), zzgdVar);
        }
        return zzgdVar;
    }

    private final void zzb(zzdf zzdfVar) {
        zzgc zzgcVar;
        if (!zzdfVar.zzh()) {
            if (!(zzdfVar instanceof zzgd)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzdfVar.getClass())));
            }
            zzgd zzgdVar = (zzgd) zzdfVar;
            zzb(zzgdVar.zzd);
            zzb(zzgdVar.zze);
            return;
        }
        int iZzc = zzc(zzdfVar.zzd());
        ArrayDeque arrayDeque = this.zza;
        int iZzc2 = zzgd.zzc(iZzc + 1);
        if (arrayDeque.isEmpty() || ((zzdf) this.zza.peek()).zzd() >= iZzc2) {
            this.zza.push(zzdfVar);
            return;
        }
        int iZzc3 = zzgd.zzc(iZzc);
        zzdf zzgdVar2 = (zzdf) this.zza.pop();
        while (true) {
            zzgcVar = null;
            if (this.zza.isEmpty() || ((zzdf) this.zza.peek()).zzd() >= iZzc3) {
                break;
            } else {
                zzgdVar2 = new zzgd((zzdf) this.zza.pop(), zzgdVar2);
            }
        }
        zzgd zzgdVar3 = new zzgd(zzgdVar2, zzdfVar);
        while (!this.zza.isEmpty()) {
            int iZzc4 = zzc(zzgdVar3.zzd()) + 1;
            ArrayDeque arrayDeque2 = this.zza;
            if (((zzdf) arrayDeque2.peek()).zzd() >= zzgd.zzc(iZzc4)) {
                break;
            } else {
                zzgdVar3 = new zzgd((zzdf) this.zza.pop(), zzgdVar3);
            }
        }
        this.zza.push(zzgdVar3);
    }

    private static final int zzc(int i) {
        int iBinarySearch = Arrays.binarySearch(zzgd.zza, i);
        return iBinarySearch < 0 ? (-(iBinarySearch + 1)) - 1 : iBinarySearch;
    }

    /* synthetic */ zzfz(zzfy zzfyVar) {
    }
}
