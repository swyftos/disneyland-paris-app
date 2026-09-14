package com.contentsquare.android.internal.core.logmonitor;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.internal.core.logmonitor.processing.EnumC2412a;
import com.contentsquare.android.internal.core.logmonitor.processing.LogContext;
import com.contentsquare.android.internal.core.logmonitor.processing.LogError;
import com.contentsquare.android.internal.core.logmonitor.processing.LogMessage;
import com.contentsquare.android.internal.core.logmonitor.processing.LogXpf;
import com.contentsquare.android.internal.features.initialize.CsApplicationModule;
import com.contentsquare.android.sdk.C2579O2;
import com.contentsquare.android.sdk.C2644U8;
import com.contentsquare.android.sdk.C2946z5;
import com.google.firebase.messaging.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJD\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bJ&\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, m1836d2 = {"Lcom/contentsquare/android/internal/core/logmonitor/LogMonitor;", "", "()V", "logger", "Lcom/contentsquare/android/core/features/logging/Logger;", "crash", "", "description", "", "stacktrace", "additionalContext", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "errorType", "errorMessage", "warn", "library_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLogMonitor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogMonitor.kt\ncom/contentsquare/android/internal/core/logmonitor/LogMonitor\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n1#2:97\n*E\n"})
public final class LogMonitor {

    @NotNull
    public static final LogMonitor INSTANCE = new LogMonitor();

    @NotNull
    private static final Logger logger = new Logger("LogMonitor");

    private LogMonitor() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void crash$default(LogMonitor logMonitor, String str, String str2, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "";
        }
        if ((i & 4) != 0) {
            map = null;
        }
        logMonitor.crash(str, str2, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void error$default(LogMonitor logMonitor, String str, String str2, String str3, String str4, Map map, int i, Object obj) {
        String str5 = (i & 2) != 0 ? "" : str2;
        String str6 = (i & 4) != 0 ? "" : str3;
        String str7 = (i & 8) != 0 ? "" : str4;
        if ((i & 16) != 0) {
            map = null;
        }
        logMonitor.error(str, str5, str6, str7, map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void warn$default(LogMonitor logMonitor, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = null;
        }
        logMonitor.warn(str, map);
    }

    public final void crash(@NotNull String description, @NotNull String stacktrace, @Nullable Map<String, ? extends Object> additionalContext) {
        C2579O2 logProcessor;
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        try {
            EnumC2412a enumC2412a = EnumC2412a.CRITICAL;
            LogContext logContext = new LogContext(description, C2946z5.m1253a(additionalContext));
            String str = C2644U8.f2182a;
            LogMessage logMessage = new LogMessage(enumC2412a, stacktrace, logContext, str != null ? new LogXpf(str, C2644U8.f2183b, C2644U8.f2184c) : null, 8);
            CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
            if (csApplicationModule == null || (logProcessor = csApplicationModule.getLogProcessor()) == null) {
                return;
            }
            logProcessor.m996a(logMessage);
        } catch (IllegalStateException e) {
            logger.m829e("Failed to save crash log: " + e.getMessage());
        }
    }

    public final void error(@NotNull String description, @NotNull String errorType, @NotNull String errorMessage, @NotNull String stacktrace, @Nullable Map<String, ? extends Object> additionalContext) {
        C2579O2 logProcessor;
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
        try {
            EnumC2412a enumC2412a = EnumC2412a.ERROR;
            LogContext logContext = new LogContext(description, C2946z5.m1253a(additionalContext));
            LogError logError = new LogError(errorType, errorMessage);
            String str = C2644U8.f2182a;
            LogMessage logMessage = new LogMessage(enumC2412a, stacktrace, logContext, logError, str != null ? new LogXpf(str, C2644U8.f2183b, C2644U8.f2184c) : null);
            CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
            if (csApplicationModule == null || (logProcessor = csApplicationModule.getLogProcessor()) == null) {
                return;
            }
            logProcessor.m996a(logMessage);
        } catch (IllegalStateException e) {
            logger.m829e("Failed to save error log: " + e.getMessage());
        }
    }

    public final void warn(@NotNull String description, @Nullable Map<String, ? extends Object> additionalContext) {
        C2579O2 logProcessor;
        Intrinsics.checkNotNullParameter(description, "description");
        try {
            EnumC2412a enumC2412a = EnumC2412a.WARN;
            LogContext logContext = new LogContext(description, C2946z5.m1253a(additionalContext));
            String str = C2644U8.f2182a;
            LogMessage logMessage = new LogMessage(enumC2412a, (String) null, logContext, str != null ? new LogXpf(str, C2644U8.f2183b, C2644U8.f2184c) : null, 10);
            CsApplicationModule csApplicationModule = CsApplicationModule.getInstance();
            if (csApplicationModule == null || (logProcessor = csApplicationModule.getLogProcessor()) == null) {
                return;
            }
            logProcessor.m996a(logMessage);
        } catch (IllegalStateException e) {
            logger.m829e("Failed to save warning log: " + e.getMessage());
        }
    }
}
