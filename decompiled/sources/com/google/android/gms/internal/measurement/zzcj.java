package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes3.dex */
final class zzcj extends ContentObserver {
    private final /* synthetic */ zzch zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzcj(zzch zzchVar, Handler handler) {
        super(null);
        this.zza = zzchVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.zza.zzb();
    }
}
