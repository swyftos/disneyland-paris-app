package com.contentsquare.android.internal.core.logmonitor.processing;

import androidx.media3.common.MimeTypes;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Serializable
/* loaded from: classes2.dex */
public final class LogMessage {

    @NotNull
    public static final a Companion = new a();

    @JvmField
    @NotNull
    public static final KSerializer<Object>[] r = {com.contentsquare.android.internal.core.logmonitor.processing.a.Companion.serializer(), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null};

    @Nullable
    public final com.contentsquare.android.internal.core.logmonitor.processing.a a;

    @NotNull
    public final String b;

    @Nullable
    public final LogContext c;

    @Nullable
    public final LogError d;

    @Nullable
    public final LogXpf e;

    @Nullable
    public final Integer f;

    @NotNull
    public final String g;

    @NotNull
    public final String h;

    @Nullable
    public final Long i;

    @NotNull
    public final String j;

    @NotNull
    public final String k;

    @NotNull
    public final String l;

    @NotNull
    public final String m;

    @NotNull
    public final String n;

    @NotNull
    public final String o;

    @NotNull
    public final String p;

    @NotNull
    public final String q;

    public static final class a {
        @NotNull
        public final KSerializer<LogMessage> serializer() {
            return LogMessage$$serializer.INSTANCE;
        }
    }

    public LogMessage() {
        this((com.contentsquare.android.internal.core.logmonitor.processing.a) null, (String) null, (LogContext) null, (LogXpf) null, 31);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public LogMessage(int i, com.contentsquare.android.internal.core.logmonitor.processing.a aVar, String str, LogContext logContext, LogError logError, LogXpf logXpf, @SerialName("pid") Integer num, @SerialName(MimeTypes.BASE_TYPE_APPLICATION) String str2, @SerialName("version") String str3, @SerialName("date") Long l, @SerialName("device_model") String str4, @SerialName("os_type") String str5, @SerialName("os_version") String str6, @SerialName("os_api") String str7, @SerialName("bundle_id") String str8, @SerialName("build_version") String str9, @SerialName("app_version") String str10, @SerialName("app_build_version") String str11) {
        Configuration configuration;
        JsonConfig.ProjectConfiguration projectConfig;
        Integer numValueOf = null;
        if ((i & 1) == 0) {
            this.a = null;
        } else {
            this.a = aVar;
        }
        if ((i & 2) == 0) {
            this.b = "";
        } else {
            this.b = str;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = logContext;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = logError;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = logXpf;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = num;
        }
        if ((i & 64) == 0) {
            this.g = "";
        } else {
            this.g = str2;
        }
        if ((i & 128) == 0) {
            this.h = "";
        } else {
            this.h = str3;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = l;
        }
        if ((i & 512) == 0) {
            this.j = "";
        } else {
            this.j = str4;
        }
        this.k = (i & 1024) == 0 ? "android" : str5;
        if ((i & 2048) == 0) {
            this.l = "";
        } else {
            this.l = str6;
        }
        if ((i & 4096) == 0) {
            this.m = "";
        } else {
            this.m = str7;
        }
        if ((i & 8192) == 0) {
            this.n = "";
        } else {
            this.n = str8;
        }
        if ((i & 16384) == 0) {
            this.o = "";
        } else {
            this.o = str9;
        }
        if ((32768 & i) == 0) {
            this.p = "";
        } else {
            this.p = str10;
        }
        if ((i & 65536) == 0) {
            this.q = "";
        } else {
            this.q = str11;
        }
        CoreModule.Companion companion = CoreModule.INSTANCE;
        CoreModule companion2 = companion.getInstance();
        if (companion2 != null && (configuration = companion2.getConfiguration()) != null && (projectConfig = configuration.getProjectConfig()) != null) {
            numValueOf = Integer.valueOf(projectConfig.getCsProjectId());
        }
        this.f = numValueOf;
        CoreModule companion3 = companion.getInstance();
        if (companion3 != null) {
            this.g = companion3.getDeviceInfo().getBuildInformation().getApplicationName();
            this.p = companion3.getDeviceInfo().getBuildInformation().getApplicationVersion();
            this.q = String.valueOf(companion3.getDeviceInfo().getBuildInformation().getApplicationVersionCode());
            this.n = companion3.getDeviceInfo().getBuildInformation().getApplicationId();
            this.h = companion3.getDeviceInfo().getBuildInformation().getSdkVersion();
            this.o = String.valueOf(companion3.getDeviceInfo().getBuildInformation().getSdkBuild());
            this.j = companion3.getDeviceInfo().getDeviceManufacturer() + ' ' + companion3.getDeviceInfo().getDeviceModel();
            this.l = companion3.getDeviceInfo().getDeviceOs();
            this.m = String.valueOf(companion3.getDeviceInfo().getDeviceOsApi());
        }
        this.i = Long.valueOf(System.currentTimeMillis());
    }

    public LogMessage(@Nullable com.contentsquare.android.internal.core.logmonitor.processing.a aVar, @NotNull String stacktrace, @Nullable LogContext logContext, @Nullable LogError logError, @Nullable LogXpf logXpf) {
        Configuration configuration;
        JsonConfig.ProjectConfiguration projectConfig;
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        this.a = aVar;
        this.b = stacktrace;
        this.c = logContext;
        this.d = logError;
        this.e = logXpf;
        this.g = "";
        this.h = "";
        this.j = "";
        this.k = "android";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        CoreModule.Companion companion = CoreModule.INSTANCE;
        CoreModule companion2 = companion.getInstance();
        this.f = (companion2 == null || (configuration = companion2.getConfiguration()) == null || (projectConfig = configuration.getProjectConfig()) == null) ? null : Integer.valueOf(projectConfig.getCsProjectId());
        CoreModule companion3 = companion.getInstance();
        if (companion3 != null) {
            this.g = companion3.getDeviceInfo().getBuildInformation().getApplicationName();
            this.p = companion3.getDeviceInfo().getBuildInformation().getApplicationVersion();
            this.q = String.valueOf(companion3.getDeviceInfo().getBuildInformation().getApplicationVersionCode());
            this.n = companion3.getDeviceInfo().getBuildInformation().getApplicationId();
            this.h = companion3.getDeviceInfo().getBuildInformation().getSdkVersion();
            this.o = String.valueOf(companion3.getDeviceInfo().getBuildInformation().getSdkBuild());
            this.j = companion3.getDeviceInfo().getDeviceManufacturer() + ' ' + companion3.getDeviceInfo().getDeviceModel();
            this.l = companion3.getDeviceInfo().getDeviceOs();
            this.m = String.valueOf(companion3.getDeviceInfo().getDeviceOsApi());
        }
        this.i = Long.valueOf(System.currentTimeMillis());
    }

    public /* synthetic */ LogMessage(com.contentsquare.android.internal.core.logmonitor.processing.a aVar, String str, LogContext logContext, LogXpf logXpf, int i) {
        this((i & 1) != 0 ? null : aVar, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : logContext, (LogError) null, (i & 16) != 0 ? null : logXpf);
    }
}
