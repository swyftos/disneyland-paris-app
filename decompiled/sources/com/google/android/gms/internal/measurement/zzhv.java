package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes3.dex */
final class zzhv extends zzib {
    private final /* synthetic */ zzhq zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzhv(zzhq zzhqVar) {
        super(zzhqVar, null);
        this.zza = zzhqVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzib, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzhs(this.zza, null);
    }

    /* synthetic */ zzhv(zzhq zzhqVar, zzht zzhtVar) {
        this(zzhqVar);
    }
}
