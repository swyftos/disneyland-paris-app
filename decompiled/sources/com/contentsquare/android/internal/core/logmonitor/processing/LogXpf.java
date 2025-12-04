package com.contentsquare.android.internal.core.logmonitor.processing;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class LogXpf {

    @NotNull
    public static final a Companion = new a();

    @Nullable
    public final String a;

    @Nullable
    public final String b;

    @Nullable
    public final String c;

    public static final class a {
        @NotNull
        public final KSerializer<LogXpf> serializer() {
            return LogXpf$$serializer.INSTANCE;
        }
    }

    public LogXpf() {
        this.a = null;
        this.b = null;
        this.c = null;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public LogXpf(int i, String str, String str2, @SerialName("bridge_version") String str3) {
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
    }

    public LogXpf(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }
}
