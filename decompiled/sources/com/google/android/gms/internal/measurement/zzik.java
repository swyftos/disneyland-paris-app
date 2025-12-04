package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzik implements Iterator {
    private Iterator zza;
    private final /* synthetic */ zzii zzb;

    zzik(zzii zziiVar) {
        this.zzb = zziiVar;
        this.zza = zziiVar.zza.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return (String) this.zza.next();
    }
}
