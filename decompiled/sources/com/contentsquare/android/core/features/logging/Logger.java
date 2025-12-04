package com.contentsquare.android.core.features.logging;

import androidx.annotation.VisibleForTesting;
import com.contentsquare.android.core.features.logging.LogPrinter;
import com.contentsquare.android.core.system.DeviceInfo;
import com.contentsquare.android.core.utils.BuildConfigInstantiable;
import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ!\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0017\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ!\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ!\u0010\u000f\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/features/logging/Logger;", "", "tag", "", "(Ljava/lang/String;)V", "d", "", "message", "(Ljava/lang/String;)Lkotlin/Unit;", "t", "", "(Ljava/lang/Throwable;Ljava/lang/String;)Lkotlin/Unit;", "e", "i", ContextChain.TAG_PRODUCT, DeviceInfo.WIDTH, "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG_CS_LIB = "CSLIB";

    @NotNull
    private static BuildConfigInstantiable buildConfigInstantiable;

    @Nullable
    private static DebugLogWriter debugLogWriter;

    @NotNull
    private static final LogPrinter logPrinter;

    @NotNull
    private static LogPrinter.Printer printer;

    @NotNull
    private final String tag;

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0004H\u0002J\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0001¢\u0006\u0002\b!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0002\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\""}, d2 = {"Lcom/contentsquare/android/core/features/logging/Logger$Companion;", "", "()V", "TAG_CS_LIB", "", "buildConfigInstantiable", "Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;", "getBuildConfigInstantiable$annotations", "getBuildConfigInstantiable", "()Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;", "setBuildConfigInstantiable", "(Lcom/contentsquare/android/core/utils/BuildConfigInstantiable;)V", "debugLogWriter", "Lcom/contentsquare/android/core/features/logging/DebugLogWriter;", "getDebugLogWriter", "()Lcom/contentsquare/android/core/features/logging/DebugLogWriter;", "setDebugLogWriter", "(Lcom/contentsquare/android/core/features/logging/DebugLogWriter;)V", "logPrinter", "Lcom/contentsquare/android/core/features/logging/LogPrinter;", "printer", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "getPrinter$annotations", "getPrinter", "()Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "setPrinter", "(Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;)V", "buildTag", "tag", "setLogLevel", "", "logLevel", "Lcom/contentsquare/android/core/features/logging/LogPrinter$LogLevel;", "setLogLevel$core_release", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String buildTag(String tag) {
            return "CSLIB|" + tag;
        }

        @VisibleForTesting
        public static /* synthetic */ void getBuildConfigInstantiable$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPrinter$annotations() {
        }

        @NotNull
        public final BuildConfigInstantiable getBuildConfigInstantiable() {
            return Logger.buildConfigInstantiable;
        }

        @Nullable
        public final DebugLogWriter getDebugLogWriter() {
            return Logger.debugLogWriter;
        }

        @NotNull
        public final LogPrinter.Printer getPrinter() {
            return Logger.printer;
        }

        public final void setBuildConfigInstantiable(BuildConfigInstantiable buildConfigInstantiable) {
            Intrinsics.checkNotNullParameter(buildConfigInstantiable, "<set-?>");
            Logger.buildConfigInstantiable = buildConfigInstantiable;
        }

        public final void setDebugLogWriter(DebugLogWriter debugLogWriter) {
            Logger.debugLogWriter = debugLogWriter;
        }

        @JvmStatic
        public final void setLogLevel$core_release(LogPrinter.LogLevel logLevel) {
            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
            setPrinter((getBuildConfigInstantiable().isDebug() || logLevel == LogPrinter.LogLevel.DEBUG) ? Logger.logPrinter.createPrinter(LogPrinter.LogLevel.DEBUG) : Logger.logPrinter.createPrinter(logLevel));
        }

        public final void setPrinter(LogPrinter.Printer printer) {
            Intrinsics.checkNotNullParameter(printer, "<set-?>");
            Logger.printer = printer;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        LogPrinter logPrinter2 = new LogPrinter();
        logPrinter = logPrinter2;
        printer = logPrinter2.createPrinter(LogPrinter.LogLevel.PUBLIC);
        buildConfigInstantiable = new BuildConfigInstantiable();
    }

    public Logger() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Nullable
    public final Unit d(String message) {
        if (message != null) {
            printer.d(this.tag, message);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                DebugLogWriter.add$default(debugLogWriter2, "DEBUG", this.tag, message, null, 8, null);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit e(String message) {
        if (message != null) {
            printer.e(this.tag, message);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                DebugLogWriter.add$default(debugLogWriter2, "ERROR", this.tag, message, null, 8, null);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit i(String message) {
        if (message != null) {
            printer.i(this.tag, message);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                DebugLogWriter.add$default(debugLogWriter2, "INFO", this.tag, message, null, 8, null);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit p(String message) {
        if (message != null) {
            printer.p(TAG_CS_LIB, message);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                DebugLogWriter.add$default(debugLogWriter2, "PUBLIC", this.tag, message, null, 8, null);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit w(String message) {
        if (message != null) {
            printer.w(this.tag, message);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                DebugLogWriter.add$default(debugLogWriter2, "WARN", this.tag, message, null, 8, null);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    public Logger(String str) {
        this.tag = str == null ? TAG_CS_LIB : INSTANCE.buildTag(str);
    }

    @Nullable
    public final Unit d(Throwable t, String message) {
        if (t != null && message != null) {
            printer.d(this.tag, message, t);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                debugLogWriter2.add("DEBUG", this.tag, message, t);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit e(Throwable t, String message) {
        if (t != null && message != null) {
            printer.e(this.tag, message, t);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                debugLogWriter2.add("ERROR", this.tag, message, t);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit i(Throwable t, String message) {
        if (t != null && message != null) {
            printer.i(this.tag, message, t);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                debugLogWriter2.add("INFO", this.tag, message, t);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    @Nullable
    public final Unit w(Throwable t, String message) {
        if (t != null && message != null) {
            printer.w(this.tag, message, t);
            DebugLogWriter debugLogWriter2 = debugLogWriter;
            if (debugLogWriter2 != null) {
                debugLogWriter2.add("WARN", this.tag, message, t);
                return Unit.INSTANCE;
            }
        }
        return null;
    }

    public /* synthetic */ Logger(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }
}
