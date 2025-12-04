package com.contentsquare.android.error.analysis.crash;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.contentsquare.android.core.communication.error.ErrorAnalysisLibraryInterface;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.facebook.react.uimanager.ViewProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.i18n.ErrorBundle;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0006\u0010\u0011\u001a\u00020\u000eJ\u001a\u0010\u0012\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00010\u0014J\u000e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0010R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/contentsquare/android/error/analysis/crash/CrashHandlerController;", "", "crashEventReporter", "Lcom/contentsquare/android/error/analysis/crash/CrashEventReporter;", "libraryInterface", "Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "(Lcom/contentsquare/android/error/analysis/crash/CrashEventReporter;Lcom/contentsquare/android/core/communication/error/ErrorAnalysisLibraryInterface;Lcom/contentsquare/android/core/features/logging/Logger;)V", "applicationData", "Lcom/contentsquare/android/error/analysis/crash/ApplicationData;", "errorCrashHandler", "Lcom/contentsquare/android/error/analysis/crash/ErrorAnalysisCrashHandler;", "isStarted", "", "handlePendingCrashEvents", "", "isCrashReportingEnabled", "sendReactNativeError", ErrorBundle.DETAIL_ENTRY, "", "", ViewProps.START, "context", "Landroid/content/Context;", "stop", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CrashHandlerController {

    @Nullable
    private ApplicationData applicationData;

    @NotNull
    private final CrashEventReporter crashEventReporter;

    @Nullable
    private ErrorAnalysisCrashHandler errorCrashHandler;
    private boolean isStarted;

    @NotNull
    private final ErrorAnalysisLibraryInterface libraryInterface;

    @NotNull
    private final Logger logger;

    public CrashHandlerController(CrashEventReporter crashEventReporter, ErrorAnalysisLibraryInterface libraryInterface, Logger logger) {
        Intrinsics.checkNotNullParameter(crashEventReporter, "crashEventReporter");
        Intrinsics.checkNotNullParameter(libraryInterface, "libraryInterface");
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.crashEventReporter = crashEventReporter;
        this.libraryInterface = libraryInterface;
        this.logger = logger;
    }

    private final void handlePendingCrashEvents() {
        boolean zIsCrashReportingEnabled = isCrashReportingEnabled();
        CrashEventReporter crashEventReporter = this.crashEventReporter;
        if (zIsCrashReportingEnabled) {
            crashEventReporter.sendPendingCrashEvents();
        } else {
            crashEventReporter.deletePendingCrashEvents();
        }
    }

    public final boolean isCrashReportingEnabled() {
        return this.libraryInterface.isFeatureEnabled(JsonConfigFeatureFlagNames.CRASH_REPORTER);
    }

    public final void sendReactNativeError(Map<String, ? extends Object> details) {
        ApplicationData applicationData;
        Intrinsics.checkNotNullParameter(details, "details");
        if (!isCrashReportingEnabled() || (applicationData = this.applicationData) == null) {
            return;
        }
        this.crashEventReporter.saveCrashEvent(ReactNativeCrashBuilder.INSTANCE.buildReactNativeCrash(this.libraryInterface, details, applicationData));
    }

    public final void start(Context context) throws Resources.NotFoundException, PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.isStarted) {
            return;
        }
        ApplicationData applicationDataFromContext = ApplicationData.INSTANCE.fromContext(context);
        this.applicationData = applicationDataFromContext;
        ErrorAnalysisCrashHandler errorAnalysisCrashHandler = new ErrorAnalysisCrashHandler(Thread.getDefaultUncaughtExceptionHandler(), applicationDataFromContext, this.crashEventReporter, this.libraryInterface);
        this.errorCrashHandler = errorAnalysisCrashHandler;
        Thread.setDefaultUncaughtExceptionHandler(errorAnalysisCrashHandler);
        handlePendingCrashEvents();
        this.isStarted = true;
        this.logger.i("Crash Reporter is enabled");
    }

    public final void stop() {
        if (this.isStarted) {
            ErrorAnalysisCrashHandler errorAnalysisCrashHandler = this.errorCrashHandler;
            Thread.setDefaultUncaughtExceptionHandler(errorAnalysisCrashHandler != null ? errorAnalysisCrashHandler.getChainedHandler() : null);
            this.errorCrashHandler = null;
            this.isStarted = false;
            this.logger.i("Crash Reporter is disabled");
        }
    }

    public /* synthetic */ CrashHandlerController(CrashEventReporter crashEventReporter, ErrorAnalysisLibraryInterface errorAnalysisLibraryInterface, Logger logger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(crashEventReporter, errorAnalysisLibraryInterface, (i & 4) != 0 ? new Logger("CrashHandlerController") : logger);
    }
}
