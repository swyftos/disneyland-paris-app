package com.urbanairship.permission;

import androidx.annotation.NonNull;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes5.dex */
public class PermissionRequestResult {
    private final boolean isSilentlyDenied;
    private PermissionStatus permissionStatus;

    PermissionRequestResult(PermissionStatus permissionStatus, boolean z) {
        this.permissionStatus = permissionStatus;
        this.isSilentlyDenied = z;
    }

    @NonNull
    public static PermissionRequestResult granted() {
        return new PermissionRequestResult(PermissionStatus.GRANTED, false);
    }

    @NonNull
    public static PermissionRequestResult denied(boolean z) {
        return new PermissionRequestResult(PermissionStatus.DENIED, z);
    }

    @NonNull
    public static PermissionRequestResult notDetermined() {
        return new PermissionRequestResult(PermissionStatus.NOT_DETERMINED, false);
    }

    public boolean isSilentlyDenied() {
        return this.isSilentlyDenied;
    }

    @NonNull
    public PermissionStatus getPermissionStatus() {
        return this.permissionStatus;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PermissionRequestResult permissionRequestResult = (PermissionRequestResult) obj;
        return this.isSilentlyDenied == permissionRequestResult.isSilentlyDenied && this.permissionStatus == permissionRequestResult.permissionStatus;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.permissionStatus, Boolean.valueOf(this.isSilentlyDenied));
    }

    public String toString() {
        return "PermissionRequestResult{permissionStatus=" + this.permissionStatus + ", isSilentlyDenied=" + this.isSilentlyDenied + '}';
    }
}
