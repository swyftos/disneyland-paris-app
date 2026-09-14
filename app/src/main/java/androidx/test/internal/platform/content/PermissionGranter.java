package androidx.test.internal.platform.content;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface PermissionGranter {
    void addPermissions(@NonNull String... strArr);

    void requestPermissions();
}
