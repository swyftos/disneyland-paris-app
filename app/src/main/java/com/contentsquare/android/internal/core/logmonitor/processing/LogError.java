package com.contentsquare.android.internal.core.logmonitor.processing;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class LogError {

    @NotNull
    public static final C2409a Companion = new C2409a();

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1227a;

    /* JADX INFO: renamed from: b */
    @NotNull
    public final String f1228b;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.logmonitor.processing.LogError$a */
    public static final class C2409a {
        @NotNull
        public final KSerializer<LogError> serializer() {
            return LogError$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public LogError(int i, String str, String str2) {
        if (3 != (i & 3)) {
            LogError$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, LogError$$serializer.f1229a);
        }
        this.f1227a = str;
        this.f1228b = str2;
    }

    public LogError(@NotNull String type, @NotNull String content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        this.f1227a = type;
        this.f1228b = content;
    }
}
