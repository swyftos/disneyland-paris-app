package com.google.firebase.iid.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: loaded from: classes4.dex */
@KeepForSdk
public interface FirebaseInstanceIdInternal {
    @KeepForSdk
    String getId();

    @Nullable
    @KeepForSdk
    String getToken();
}
