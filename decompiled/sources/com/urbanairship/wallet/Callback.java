package com.urbanairship.wallet;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public interface Callback {
    void onError(int i);

    void onResult(@NonNull Pass pass);
}
