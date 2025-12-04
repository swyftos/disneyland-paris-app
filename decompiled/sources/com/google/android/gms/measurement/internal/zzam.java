package com.google.android.gms.measurement.internal;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzam implements Iterator {
    private Iterator zza;
    private final /* synthetic */ zzan zzb;

    zzam(zzan zzanVar) {
        this.zzb = zzanVar;
        this.zza = zzanVar.zza.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return (String) this.zza.next();
    }
}
