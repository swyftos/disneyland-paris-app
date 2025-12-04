package androidx.test.internal.platform.content;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public interface PermissionGranter {
    void addPermissions(@NonNull String... strArr);

    void requestPermissions();
}
