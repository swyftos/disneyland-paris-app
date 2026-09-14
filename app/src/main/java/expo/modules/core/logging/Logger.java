package expo.modules.core.logging;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.disney.p026id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J)\u0010\u0014\u001a\u00020\u00152!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\f0\u0017J$\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m1836d2 = {"Lexpo/modules/core/logging/Logger;", "", "logHandlers", "", "Lexpo/modules/core/logging/LogHandler;", "<init>", "(Ljava/util/List;)V", "minOSLevel", "", "trace", "", "message", "", "debug", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "warn", "cause", "", Constants.IPC_BUNDLE_KEY_SEND_ERROR, "fatal", "startTimer", "Lexpo/modules/core/logging/LoggerTimer;", "logFormatter", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", TypedValues.TransitionType.S_DURATION, "log", "type", "Lexpo/modules/core/logging/LogType;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nLogger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logger.kt\nexpo/modules/core/logging/Logger\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1863#2,2:98\n*S KotlinDebug\n*F\n+ 1 Logger.kt\nexpo/modules/core/logging/Logger\n*L\n91#1:98,2\n*E\n"})
public final class Logger {
    private final List logHandlers;
    private final int minOSLevel;

    public Logger(@NotNull List<? extends LogHandler> logHandlers) {
        Intrinsics.checkNotNullParameter(logHandlers, "logHandlers");
        this.logHandlers = logHandlers;
        this.minOSLevel = 4;
    }

    public final void trace(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Trace, message, null, 4, null);
    }

    public final void debug(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Debug, message, null, 4, null);
    }

    public final void info(@NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        log$default(this, LogType.Info, message, null, 4, null);
    }

    public static /* synthetic */ void warn$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.warn(str, th);
    }

    public final void warn(@NotNull String message, @Nullable Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Warn, message, cause);
    }

    public static /* synthetic */ void error$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.error(str, th);
    }

    public final void error(@NotNull String message, @Nullable Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Error, message, cause);
    }

    public static /* synthetic */ void fatal$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        logger.fatal(str, th);
    }

    public final void fatal(@NotNull String message, @Nullable Throwable cause) {
        Intrinsics.checkNotNullParameter(message, "message");
        log(LogType.Fatal, message, cause);
    }

    @NotNull
    public final LoggerTimer startTimer(@NotNull final Function1<? super Long, String> logFormatter) {
        Intrinsics.checkNotNullParameter(logFormatter, "logFormatter");
        final long jCurrentTimeMillis = System.currentTimeMillis();
        return new LoggerTimer() { // from class: expo.modules.core.logging.Logger.startTimer.1
            @Override // expo.modules.core.logging.LoggerTimer
            /* JADX INFO: renamed from: stop-UwyO8pc, reason: not valid java name */
            public long mo5216stopUwyO8pc() {
                long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                Logger.log$default(this, LogType.Timer, (String) logFormatter.invoke(Long.valueOf(jCurrentTimeMillis2)), null, 4, null);
                return DurationKt.toDuration(jCurrentTimeMillis2, DurationUnit.MILLISECONDS);
            }
        };
    }

    static /* synthetic */ void log$default(Logger logger, LogType logType, String str, Throwable th, int i, Object obj) {
        if ((i & 4) != 0) {
            th = null;
        }
        logger.log(logType, str, th);
    }

    private final void log(LogType type, String message, Throwable cause) {
        if (LogType.INSTANCE.toOSLogType(type) >= this.minOSLevel) {
            Iterator it = this.logHandlers.iterator();
            while (it.hasNext()) {
                ((LogHandler) it.next()).log$expo_modules_core_release(type, message, cause);
            }
        }
    }
}
