package com.contentsquare.android.internal.core.logmonitor.processing;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import org.jetbrains.annotations.NotNull;

@Serializable
/* loaded from: classes2.dex */
public final class LogError {

    @NotNull
    public static final a Companion = new a();

    @NotNull
    public final String a;

    @NotNull
    public final String b;

    public static final class a {
        @NotNull
        public final KSerializer<LogError> serializer() {
            return LogError$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public LogError(int i, String str, String str2) {
        if (3 != (i & 3)) {
            LogError$$serializer.INSTANCE.getClass();
            PluginExceptionsKt.throwMissingFieldException(i, 3, LogError$$serializer.a);
        }
        this.a = str;
        this.b = str2;
    }

    public LogError(@NotNull String type, @NotNull String content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        this.a = type;
        this.b = content;
    }
}
