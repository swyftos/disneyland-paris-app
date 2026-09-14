package com.google.mlkit.common.sdkinternal.model;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import java.nio.MappedByteBuffer;

/* JADX INFO: loaded from: classes4.dex */
@KeepForSdk
public interface RemoteModelLoaderHelper {
    @NonNull
    @KeepForSdk
    MappedByteBuffer loadModelAtPath(@NonNull String str) throws MlKitException;
}
