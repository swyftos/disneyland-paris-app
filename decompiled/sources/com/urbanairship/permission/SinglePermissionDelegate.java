package com.urbanairship.permission;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.urbanairship.UALog;

/* loaded from: classes5.dex */
public class SinglePermissionDelegate implements PermissionDelegate {
    private final String permission;

    public SinglePermissionDelegate(@NonNull String str) {
        this.permission = str;
    }

    @Override // com.urbanairship.permission.PermissionDelegate
    @NonNull
    public void checkPermissionStatus(@NonNull Context context, @NonNull Consumer<PermissionStatus> consumer) {
        try {
            if (ContextCompat.checkSelfPermission(context, this.permission) == 0) {
                consumer.accept(PermissionStatus.GRANTED);
            } else {
                consumer.accept(PermissionStatus.DENIED);
            }
        } catch (Exception e) {
            UALog.e(e, "Failed to get permission status.", new Object[0]);
            consumer.accept(PermissionStatus.NOT_DETERMINED);
        }
    }

    @Override // com.urbanairship.permission.PermissionDelegate
    public void requestPermission(@NonNull Context context, @NonNull Consumer<PermissionRequestResult> consumer) {
        PermissionsActivity.requestPermission(context, this.permission, consumer);
    }
}
