package com.urbanairship.permission;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* loaded from: classes5.dex */
public interface PermissionDelegate {
    @MainThread
    void checkPermissionStatus(@NonNull Context context, @NonNull Consumer<PermissionStatus> consumer);

    @MainThread
    void requestPermission(@NonNull Context context, @NonNull Consumer<PermissionRequestResult> consumer);
}
