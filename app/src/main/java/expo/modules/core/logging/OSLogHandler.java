package expo.modules.core.logging;

import android.util.Log;
import ch.qos.logback.classic.net.SyslogAppender;
import java.io.PrintStream;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m1836d2 = {"Lexpo/modules/core/logging/OSLogHandler;", "Lexpo/modules/core/logging/LogHandler;", "category", "", "<init>", "(Ljava/lang/String;)V", "getCategory", "()Ljava/lang/String;", "log", "", "type", "Lexpo/modules/core/logging/LogType;", "message", "cause", "", "log$expo_modules_core_release", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class OSLogHandler extends LogHandler {
    private final String category;

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    public OSLogHandler(@NotNull String category) {
        Intrinsics.checkNotNullParameter(category, "category");
        this.category = category;
    }

    @Override // expo.modules.core.logging.LogHandler
    public void log$expo_modules_core_release(@NotNull LogType type, @NotNull String message, @Nullable Throwable cause) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(message, "message");
        if (!OSLogHandlerKt.isAndroid) {
            String str = "[" + type.getType() + "] " + this.category + SyslogAppender.DEFAULT_STACKTRACE_PATTERN + message;
            PrintStream printStream = System.out;
            printStream.println((Object) str);
            if (cause != null) {
                printStream.println((Object) (LoggerUtilsKt.localizedMessageWithCauseLocalizedMessage(cause) + "\n" + ExceptionsKt.stackTraceToString(cause)));
                return;
            }
            return;
        }
        int oSLogType = LogType.INSTANCE.toOSLogType(type);
        if (oSLogType == 3) {
            Log.d(this.category, message, cause);
            return;
        }
        if (oSLogType == 4) {
            Log.i(this.category, message, cause);
            return;
        }
        if (oSLogType == 5) {
            Log.w(this.category, message, cause);
        } else if (oSLogType == 6) {
            Log.e(this.category, message, cause);
        } else {
            if (oSLogType != 7) {
                return;
            }
            Log.e(this.category, message, cause);
        }
    }
}
