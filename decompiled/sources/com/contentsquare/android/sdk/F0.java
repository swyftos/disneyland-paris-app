package com.contentsquare.android.sdk;

import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.features.config.Configuration;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.core.features.logging.DebugLogWriter;
import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.internal.core.logmonitor.LogMonitor;
import java.lang.Thread;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes2.dex */
public final class F0 implements Thread.UncaughtExceptionHandler {
    public static boolean b;

    @NotNull
    public static final Logger c = new Logger("CrashHandler");

    @Nullable
    public final Thread.UncaughtExceptionHandler a;

    public F0(@Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = uncaughtExceptionHandler;
    }

    @JvmStatic
    public static final void a() {
        String str;
        Configuration configuration;
        JsonConfig.ProjectConfiguration projectConfig;
        Logger logger = c;
        logger.d("Trying to attach Crash reporter...");
        CoreModule companion = CoreModule.INSTANCE.getInstance();
        if (!((companion == null || (configuration = companion.getConfiguration()) == null || (projectConfig = configuration.getProjectConfig()) == null) ? false : projectConfig.getCrashHandler())) {
            str = "The Crash reporter could not be attached because it was disabled from Project Config";
        } else if (b) {
            logger.d("The Crash reporter is already attached, aborting");
            return;
        } else {
            Thread.setDefaultUncaughtExceptionHandler(new F0(Thread.getDefaultUncaughtExceptionHandler()));
            b = true;
            str = "The Crash reporter has been successfully attached";
        }
        logger.d(str);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(@NotNull Thread thread, @NotNull Throwable throwable) {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        String strConvertStackTraceToString$default = ExtensionsKt.convertStackTraceToString$default(throwable, 0, 1, null);
        String message = throwable.getMessage();
        if (message == null) {
            message = "";
        }
        if (StringsKt.contains$default((CharSequence) strConvertStackTraceToString$default, (CharSequence) "com.contentsquare", false, 2, (Object) null)) {
            LogMonitor.crash$default(LogMonitor.INSTANCE, message, strConvertStackTraceToString$default, null, 4, null);
        }
        Logger.Companion companion = Logger.INSTANCE;
        DebugLogWriter debugLogWriter = companion.getDebugLogWriter();
        if (debugLogWriter != null) {
            debugLogWriter.add("FATAL", "CSLIB", message, throwable);
        }
        DebugLogWriter debugLogWriter2 = companion.getDebugLogWriter();
        if (debugLogWriter2 != null) {
            debugLogWriter2.forceFlush();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, throwable);
        }
    }
}
