package com.urbanairship.permission;

import androidx.annotation.NonNull;

/* loaded from: classes5.dex */
public interface OnPermissionStatusChangedListener {
    void onPermissionStatusChanged(@NonNull Permission permission, @NonNull PermissionStatus permissionStatus);
}
