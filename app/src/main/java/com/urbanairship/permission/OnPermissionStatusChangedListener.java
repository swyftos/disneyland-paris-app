package com.urbanairship.permission;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes5.dex */
public interface OnPermissionStatusChangedListener {
    void onPermissionStatusChanged(@NonNull Permission permission, @NonNull PermissionStatus permissionStatus);
}
