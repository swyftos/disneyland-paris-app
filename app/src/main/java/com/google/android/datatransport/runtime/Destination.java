package com.google.android.datatransport.runtime;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public interface Destination {
    @Nullable
    byte[] getExtras();

    @NonNull
    String getName();
}
