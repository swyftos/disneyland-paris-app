package com.contentsquare.android.api.bridge.flutter;

import android.app.Application;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.proto.mobilestacktrace.v1.ContextKt;
import com.contentsquare.proto.mobilestacktrace.v1.CrashKt;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import com.contentsquare.proto.mobilestacktrace.v1.ThreadReportKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/contentsquare/android/api/bridge/flutter/FlutterCrashBuilder;", "", "screenViewTracker", "Lcom/contentsquare/android/core/communication/ScreenViewTracker;", "csApplicationModule", "Lcom/contentsquare/android/internal/features/initialize/CsApplicationModule;", "(Lcom/contentsquare/android/core/communication/ScreenViewTracker;Lcom/contentsquare/android/internal/features/initialize/CsApplicationModule;)V", "build", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "report", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$FlutterThreadReport;", "getContext", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Context;", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFlutterCrashBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FlutterCrashBuilder.kt\ncom/contentsquare/android/api/bridge/flutter/FlutterCrashBuilder\n+ 2 CrashKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/CrashKtKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 ThreadReportKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/ThreadReportKtKt\n+ 5 ContextKt.kt\ncom/contentsquare/proto/mobilestacktrace/v1/ContextKtKt\n*L\n1#1,40:1\n11#2:41\n1#3:42\n1#3:44\n1#3:46\n11#4:43\n11#5:45\n*S KotlinDebug\n*F\n+ 1 FlutterCrashBuilder.kt\ncom/contentsquare/android/api/bridge/flutter/FlutterCrashBuilder\n*L\n18#1:41\n18#1:42\n23#1:44\n32#1:46\n23#1:43\n32#1:45\n*E\n"})
/* loaded from: classes2.dex */
public final class FlutterCrashBuilder {

    @NotNull
    private final CsApplicationModule csApplicationModule;

    @NotNull
    private final ScreenViewTracker screenViewTracker;

    public FlutterCrashBuilder(@NotNull ScreenViewTracker screenViewTracker, @NotNull CsApplicationModule csApplicationModule) {
        Intrinsics.checkNotNullParameter(screenViewTracker, "screenViewTracker");
        Intrinsics.checkNotNullParameter(csApplicationModule, "csApplicationModule");
        this.screenViewTracker = screenViewTracker;
        this.csApplicationModule = csApplicationModule;
    }

    private final MobileStacktrace.Context getContext() {
        CoreModule.Companion companion = CoreModule.INSTANCE;
        Application application = this.csApplicationModule.getApplication();
        Intrinsics.checkNotNullExpressionValue(application, "csApplicationModule.application");
        Configuration configuration = companion.safeInstance(application).getConfiguration();
        ContextKt.Dsl.Companion companion2 = ContextKt.Dsl.INSTANCE;
        MobileStacktrace.Context.Builder builderNewBuilder = MobileStacktrace.Context.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        ContextKt.Dsl dsl_create = companion2._create(builderNewBuilder);
        JsonConfig.ProjectConfiguration projectConfig = configuration.getProjectConfig();
        dsl_create.setProjectId(projectConfig != null ? projectConfig.getCsProjectId() : 0);
        dsl_create.setSessionNumber(this.csApplicationModule.getSession().k);
        dsl_create.setViewNumber(this.screenViewTracker.getCurrentScreenNumber());
        String strA = this.csApplicationModule.getUserIdRestoreHelper().a();
        if (strA == null) {
            strA = "";
        }
        dsl_create.setUserId(strA);
        dsl_create.setErrorSource("flutter");
        return dsl_create._build();
    }

    @NotNull
    public final MobileStacktrace.Crash build(@NotNull MobileStacktrace.FlutterThreadReport report) {
        Intrinsics.checkNotNullParameter(report, "report");
        CrashKt.Dsl.Companion companion = CrashKt.Dsl.INSTANCE;
        MobileStacktrace.Crash.Builder builderNewBuilder = MobileStacktrace.Crash.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder, "newBuilder()");
        CrashKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setContext(getContext());
        dsl_create.setOs(MobileStacktrace.OS.OS_ANDROID);
        dsl_create.setCrashId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        dsl_create.setRelativeTime(report.getTimestamp() - this.screenViewTracker.getCurrentScreenTimestamp());
        ThreadReportKt.Dsl.Companion companion2 = ThreadReportKt.Dsl.INSTANCE;
        MobileStacktrace.ThreadReport.Builder builderNewBuilder2 = MobileStacktrace.ThreadReport.newBuilder();
        Intrinsics.checkNotNullExpressionValue(builderNewBuilder2, "newBuilder()");
        ThreadReportKt.Dsl dsl_create2 = companion2._create(builderNewBuilder2);
        dsl_create2.setFlutter(report);
        dsl_create.setThreadReport(dsl_create2._build());
        return dsl_create._build();
    }
}
