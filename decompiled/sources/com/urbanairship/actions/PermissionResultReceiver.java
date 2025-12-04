package com.urbanairship.actions;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import com.urbanairship.UALog;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonValue;
import com.urbanairship.permission.Permission;
import com.urbanairship.permission.PermissionStatus;

/* loaded from: classes4.dex */
public abstract class PermissionResultReceiver extends ResultReceiver {
    public abstract void onResult(@NonNull Permission permission, @NonNull PermissionStatus permissionStatus, @NonNull PermissionStatus permissionStatus2);

    public PermissionResultReceiver(@NonNull Handler handler) {
        super(handler);
    }

    @Override // android.os.ResultReceiver
    protected final void onReceiveResult(int i, Bundle bundle) {
        super.onReceiveResult(i, bundle);
        try {
            onResult(parsePermission(bundle, "permission"), parseStatus(bundle, PromptPermissionAction.BEFORE_PERMISSION_STATUS_RESULT_KEY), parseStatus(bundle, PromptPermissionAction.AFTER_PERMISSION_STATUS_RESULT_KEY));
        } catch (JsonException e) {
            UALog.e(e, "Failed to parse result", new Object[0]);
        }
    }

    @NonNull
    public static Permission parsePermission(Bundle bundle, String str) throws JsonException {
        return Permission.fromJson(JsonValue.parseString(bundle.getString(str)));
    }

    @NonNull
    public static PermissionStatus parseStatus(Bundle bundle, String str) throws JsonException {
        return PermissionStatus.fromJson(JsonValue.parseString(bundle.getString(str)));
    }
}
