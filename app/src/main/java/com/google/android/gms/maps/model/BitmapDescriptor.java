package com.google.android.gms.maps.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes3.dex */
public final class BitmapDescriptor {
    private final IObjectWrapper zza;

    public BitmapDescriptor(@NonNull IObjectWrapper iObjectWrapper) {
        this.zza = (IObjectWrapper) Preconditions.checkNotNull(iObjectWrapper);
    }

    @NonNull
    public final IObjectWrapper zza() {
        return this.zza;
    }
}
