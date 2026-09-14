package com.contentsquare.android.internal.core.logmonitor.processing;

import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C2793k2;
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

/* JADX INFO: loaded from: classes2.dex */
@Serializable
public final class LogContext {

    @NotNull
    public static final C2408a Companion = new C2408a();

    /* JADX INFO: renamed from: a */
    @NotNull
    public final String f1222a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final JsonElement f1223b;

    /* JADX INFO: renamed from: c */
    @NotNull
    public final String f1224c;

    /* JADX INFO: renamed from: d */
    @NotNull
    public final String f1225d;

    /* JADX INFO: renamed from: com.contentsquare.android.internal.core.logmonitor.processing.LogContext$a */
    public static final class C2408a {
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
            this.f1222a = "";
        } else {
            this.f1222a = str;
        }
        if ((i & 2) == 0) {
            this.f1223b = null;
        } else {
            this.f1223b = jsonElement;
        }
        if ((i & 4) == 0) {
            this.f1224c = "";
        } else {
            this.f1224c = str2;
        }
        if ((i & 8) == 0) {
            this.f1225d = "";
        } else {
            this.f1225d = str3;
        }
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            String str4 = ((C2793k2) csApplicationModule.getGesturesInterceptor()).f2810e;
            this.f1224c = str4 == null ? "" : str4;
            String str5 = ((C2793k2) csApplicationModule.getGesturesInterceptor()).f2809d;
            this.f1225d = str5 != null ? str5 : "";
        }
    }

    public LogContext(@NotNull String description, @Nullable JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.f1222a = description;
        this.f1223b = jsonElement;
        this.f1224c = "";
        this.f1225d = "";
        CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
        if (csApplicationModule != null) {
            String str = ((C2793k2) csApplicationModule.getGesturesInterceptor()).f2810e;
            this.f1224c = str == null ? "" : str;
            String str2 = ((C2793k2) csApplicationModule.getGesturesInterceptor()).f2809d;
            this.f1225d = str2 != null ? str2 : "";
        }
    }
}
