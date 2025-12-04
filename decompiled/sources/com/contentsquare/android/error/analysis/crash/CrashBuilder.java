package com.contentsquare.android.error.analysis.crash;

import com.contentsquare.android.core.communication.ScreenViewTracker;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.proto.mobilestacktrace.v1.MobileStacktrace;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/CrashBuilder;", "", "()V", "buildCrash", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$Crash;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "threadReport", "Lcom/contentsquare/proto/mobilestacktrace/v1/MobileStacktrace$ThreadReport;", "errorSource", "", "timestamp", "", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CrashBuilder {

    @NotNull
    public static final CrashBuilder INSTANCE = new CrashBuilder();

    private CrashBuilder() {
    }

    @NotNull
    public final MobileStacktrace.Crash buildCrash(ErrorAnalysisLibraryInterface libraryInterface, MobileStacktrace.ThreadReport threadReport, String errorSource, long timestamp) {
        JsonConfig.ProjectConfiguration projectConfig;
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        Intrinsics.checkNotNullParameter(threadReport, "threadReport");
        Intrinsics.checkNotNullParameter(errorSource, "errorSource");
        MobileStacktrace.Crash.Builder crashId = MobileStacktrace.Crash.newBuilder().setCrashId(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);
        ScreenViewTracker screenViewTracker = libraryInterface.getScreenViewTracker();
        MobileStacktrace.Crash.Builder os = crashId.setRelativeTime(timestamp - (screenViewTracker != null ? screenViewTracker.getCurrentScreenTimestamp() : 0L)).setThreadReport(threadReport).setOs(MobileStacktrace.OS.OS_ANDROID);
        MobileStacktrace.Context.Builder builderNewBuilder = MobileStacktrace.Context.newBuilder();
        Configuration configuration = libraryInterface.getConfiguration();
        MobileStacktrace.Context.Builder projectId = builderNewBuilder.setProjectId((configuration == null || (projectConfig = configuration.getProjectConfig()) == null) ? 0 : projectConfig.getCsProjectId());
        Integer sessionId = libraryInterface.getSessionId();
        MobileStacktrace.Context.Builder sessionNumber = projectId.setSessionNumber(sessionId != null ? sessionId.intValue() : 0);
        ScreenViewTracker screenViewTracker2 = libraryInterface.getScreenViewTracker();
        MobileStacktrace.Context.Builder errorSource2 = sessionNumber.setViewNumber(screenViewTracker2 != null ? screenViewTracker2.getCurrentScreenNumber() : 0).setErrorSource(errorSource);
        String userId = libraryInterface.getUserId();
        if (userId == null) {
            userId = "";
        }
        MobileStacktrace.Crash crashBuild = os.setContext(errorSource2.setUserId(userId).build()).build();
        Intrinsics.checkNotNullExpressionValue(crashBuild, "newBuilder()\n           …   )\n            .build()");
        return crashBuild;
    }
}
