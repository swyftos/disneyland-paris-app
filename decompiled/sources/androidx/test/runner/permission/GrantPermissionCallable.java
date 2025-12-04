package androidx.test.runner.permission;

import android.content.Context;
import android.util.Log;
import androidx.test.runner.permission.RequestPermissionCallable;

/* loaded from: classes2.dex */
class GrantPermissionCallable extends RequestPermissionCallable {
    GrantPermissionCallable(ShellCommand shellCommand, Context context, String str) {
        super(shellCommand, context, str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public RequestPermissionCallable.Result call() throws InterruptedException {
        if (isPermissionGranted()) {
            String permission = getPermission();
            StringBuilder sb = new StringBuilder(String.valueOf(permission).length() + 32);
            sb.append("Permission: ");
            sb.append(permission);
            sb.append(" is already granted!");
            Log.i("GrantPermissionCallable", sb.toString());
            return RequestPermissionCallable.Result.SUCCESS;
        }
        try {
            getShellCommand().execute();
            if (!isPermissionGranted()) {
                Thread.sleep(1000L);
                if (!isPermissionGranted()) {
                    String permission2 = getPermission();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(permission2).length() + 31);
                    sb2.append("Permission: ");
                    sb2.append(permission2);
                    sb2.append(" cannot be granted!");
                    Log.e("GrantPermissionCallable", sb2.toString());
                    return RequestPermissionCallable.Result.FAILURE;
                }
            }
            return RequestPermissionCallable.Result.SUCCESS;
        } catch (Throwable th) {
            if (!isPermissionGranted()) {
                Thread.sleep(1000L);
                if (!isPermissionGranted()) {
                    String permission3 = getPermission();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(permission3).length() + 31);
                    sb3.append("Permission: ");
                    sb3.append(permission3);
                    sb3.append(" cannot be granted!");
                    Log.e("GrantPermissionCallable", sb3.toString());
                    return RequestPermissionCallable.Result.FAILURE;
                }
            }
            throw th;
        }
    }
}
