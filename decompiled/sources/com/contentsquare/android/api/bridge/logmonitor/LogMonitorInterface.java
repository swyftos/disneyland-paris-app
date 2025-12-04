package com.contentsquare.android.api.bridge.logmonitor;

import com.contentsquare.android.internal.core.logmonitor.LogMonitor;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJD\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tJ&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\t¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/api/bridge/logmonitor/LogMonitorInterface;", "", "()V", "crash", "", "description", "", "stacktrace", "additionalContext", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "errorType", "errorMessage", "warn", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LogMonitorInterface {
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void crash$default(LogMonitorInterface logMonitorInterface, String str, String str2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            map = null;
        }
        logMonitorInterface.crash(str, str2, map);
    }

    public static /* synthetic */ void error$default(LogMonitorInterface logMonitorInterface, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        String str7 = (i & 8) != 0 ? "" : str4;
        if ((i & 16) != 0) {
            map = null;
        }
        logMonitorInterface.error(str, str5, str6, str7, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void warn$default(LogMonitorInterface logMonitorInterface, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        logMonitorInterface.warn(str, map);
    }

    public final void crash(@NotNull String description, @NotNull String stacktrace, @Nullable Map<String, ? extends Object> additionalContext) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        LogMonitor.INSTANCE.crash(description, stacktrace, additionalContext);
    }

    public final void error(@NotNull String description, @NotNull String errorType, @NotNull String errorMessage, @NotNull String stacktrace, @Nullable Map<String, ? extends Object> additionalContext) {
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        LogMonitor.INSTANCE.error(description, errorType, errorMessage, stacktrace, additionalContext);
    }

    public final void warn(@NotNull String description, @Nullable Map<String, ? extends Object> additionalContext) {
        Intrinsics.checkNotNullParameter(description, "description");
        LogMonitor.INSTANCE.warn(description, additionalContext);
    }
}
