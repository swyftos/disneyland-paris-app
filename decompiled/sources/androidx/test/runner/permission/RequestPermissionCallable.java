package androidx.test.runner.permission;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.test.internal.util.Checks;
import java.util.Objects;
import java.util.concurrent.Callable;

@VisibleForTesting
/* loaded from: classes2.dex */
public abstract class RequestPermissionCallable implements Callable<Result> {
    private final String permission;
    private final ShellCommand shellCommand;
    private final Context targetContext;
    private final String targetPackage;

    public enum Result {
        SUCCESS,
        FAILURE
    }

    public RequestPermissionCallable(@NonNull ShellCommand shellCommand, @NonNull Context context, String str) {
        this.shellCommand = (ShellCommand) Checks.checkNotNull(shellCommand, "shellCommand cannot be null!");
        Context context2 = (Context) Checks.checkNotNull(context, "targetContext cannot be null!");
        this.targetContext = context2;
        String packageName = context2.getPackageName();
        Checks.checkState(!TextUtils.isEmpty(packageName), "targetPackage cannot be empty or null!");
        this.targetPackage = packageName;
        this.permission = str;
    }

    protected String getPermission() {
        return this.permission;
    }

    protected boolean isPermissionGranted() {
        return this.targetContext.checkCallingOrSelfPermission(this.permission) == 0;
    }

    protected ShellCommand getShellCommand() {
        return this.shellCommand;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RequestPermissionCallable requestPermissionCallable = (RequestPermissionCallable) obj;
        return Objects.equals(this.targetPackage, requestPermissionCallable.targetPackage) && Objects.equals(this.permission, requestPermissionCallable.permission);
    }

    public int hashCode() {
        return Objects.hash(this.targetPackage, this.permission);
    }
}
