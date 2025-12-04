package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class zzgb implements Iterator {
    private final ArrayDeque zza;
    private zzdd zzb;

    /* synthetic */ zzgb(zzdf zzdfVar, zzga zzgaVar) {
        if (!(zzdfVar instanceof zzgd)) {
            this.zza = null;
            this.zzb = (zzdd) zzdfVar;
            return;
        }
        zzgd zzgdVar = (zzgd) zzdfVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzgdVar.zzf());
        this.zza = arrayDeque;
        arrayDeque.push(zzgdVar);
        this.zzb = zzb(zzgdVar.zzd);
    }

    private final zzdd zzb(zzdf zzdfVar) {
        while (zzdfVar instanceof zzgd) {
            zzgd zzgdVar = (zzgd) zzdfVar;
            this.zza.push(zzgdVar);
            zzdfVar = zzgdVar.zzd;
        }
        return (zzdd) zzdfVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdd next() {
        zzdd zzddVarZzb;
        zzdd zzddVar = this.zzb;
        if (zzddVar == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.zza;
            zzddVarZzb = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzddVarZzb = zzb(((zzgd) this.zza.pop()).zze);
        } while (zzddVarZzb.zzd() == 0);
        this.zzb = zzddVarZzb;
        return zzddVar;
    }
}
