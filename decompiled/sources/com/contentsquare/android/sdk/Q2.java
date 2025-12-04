package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.internal.core.logmonitor.LogMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class Q2 {
    public static final void a(@NotNull Logger logger, @NotNull String description, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(description, "description");
        logger.e(th, description);
        LogMonitor logMonitor = LogMonitor.INSTANCE;
        String name = th != null ? th.getClass().getName() : null;
        String str = name == null ? "" : name;
        String message = th != null ? th.getMessage() : null;
        String str2 = message == null ? "" : message;
        String strConvertStackTraceToString$default = th != null ? ExtensionsKt.convertStackTraceToString$default(th, 0, 1, null) : null;
        LogMonitor.error$default(logMonitor, description, str, str2, strConvertStackTraceToString$default == null ? "" : strConvertStackTraceToString$default, null, 16, null);
    }
}
