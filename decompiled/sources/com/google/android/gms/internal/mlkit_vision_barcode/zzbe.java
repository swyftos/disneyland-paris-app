package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
abstract class zzbe extends zzbr implements zzcy {
    protected zzbe(Map map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    final /* synthetic */ Collection zzb() {
        return Collections.emptyList();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    final Collection zzc(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzbr
    final Collection zzd(Object obj, Collection collection) {
        return zzm(obj, (List) collection, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcy
    public final List zze(Object obj) {
        return (List) super.zzj(obj);
    }

    public final List zzf(@CheckForNull Object obj) {
        return (List) super.zzk(obj);
    }
}
