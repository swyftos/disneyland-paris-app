package com.contentsquare.android.internal.core.logmonitor.processing;

import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C0723k2;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.json.JsonElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class LogContext {

    @NotNull
    public static final a Companion = new a();

    @NotNull
    public final String a;

    @Nullable
    public final JsonElement b;

    @NotNull
    public final String c;

    @NotNull
    public final String d;

    public static final class a {
        @NotNull
        public final KSerializer<LogContext> serializer() {
            return LogContext$$serializer.INSTANCE;
        }
    }

    public LogContext() {
        this("", null);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public LogContext(int i, String str, JsonElement jsonElement, @SerialName("screen_name") String str2, @SerialName("screen_url") String str3) {
        if ((i & 1) == 0) {
            this.a = "";
        } else {
            this.a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = jsonElement;
        }
        if ((i & 4) == 0) {
            this.c = "";
        } else {
            this.c = str2;
        }
        if ((i & 8) == 0) {
            this.d = "";
        } else {
            this.d = str3;
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            String str4 = ((C0723k2) csApplicationModule.getGesturesInterceptor()).e;
            this.c = str4 == null ? "" : str4;
            String str5 = ((C0723k2) csApplicationModule.getGesturesInterceptor()).d;
            this.d = str5 != null ? str5 : "";
        }
    }

    public LogContext(@NotNull String description, @Nullable JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.a = description;
        this.b = jsonElement;
        this.c = "";
        this.d = "";
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            String str = ((C0723k2) csApplicationModule.getGesturesInterceptor()).e;
            this.c = str == null ? "" : str;
            String str2 = ((C0723k2) csApplicationModule.getGesturesInterceptor()).d;
            this.d = str2 != null ? str2 : "";
        }
    }
}
