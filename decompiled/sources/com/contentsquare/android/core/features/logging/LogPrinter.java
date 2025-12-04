package com.contentsquare.android.core.features.logging;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.NotificationCompat;
import com.contentsquare.android.core.system.DeviceInfo;
import com.facebook.common.callercontext.ContextChain;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter;", "", "()V", "createPrinter", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "logLevel", "Lcom/contentsquare/android/core/features/logging/LogPrinter$LogLevel;", "Companion", "CsInAppPrinter", "DebugPrinter", "LogLevel", "LogcatWrapper", "Printer", "PublicPrinter", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LogPrinter {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static LogcatWrapper logcatWrapper = new LogcatWrapper();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$Companion;", "", "()V", "logcatWrapper", "Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;", "getLogcatWrapper$annotations", "getLogcatWrapper", "()Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;", "setLogcatWrapper", "(Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;)V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getLogcatWrapper$annotations() {
        }

        @NotNull
        public final LogcatWrapper getLogcatWrapper() {
            return LogPrinter.logcatWrapper;
        }

        public final void setLogcatWrapper(LogcatWrapper logcatWrapper) {
            Intrinsics.checkNotNullParameter(logcatWrapper, "<set-?>");
            LogPrinter.logcatWrapper = logcatWrapper;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$CsInAppPrinter;", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "()V", "i", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", ContextChain.TAG_PRODUCT, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CsInAppPrinter implements Printer {
        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int d(String str, String str2) {
            return Printer.DefaultImpls.d(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int e(String str, String str2) {
            return Printer.DefaultImpls.e(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int p(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int v(String str, String str2) {
            return Printer.DefaultImpls.v(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int w(String str, String str2) {
            return Printer.DefaultImpls.w(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int d(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.d(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int e(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.e(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int i(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int v(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.v(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int w(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.w(this, str, str2, th);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$DebugPrinter;", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "()V", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", ContextChain.TAG_PRODUCT, "v", DeviceInfo.WIDTH, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DebugPrinter implements Printer {
        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int d(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().d(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int e(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().e(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int p(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int v(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().v(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int w(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().w(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int d(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().d(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int e(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().e(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int i(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int v(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().v(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int w(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().w(tag, msg, tr);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$LogLevel;", "", "(Ljava/lang/String;I)V", "PUBLIC", "CS_IN_APP", "DEBUG", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum LogLevel {
        PUBLIC,
        CS_IN_APP,
        DEBUG
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;", "", "()V", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", "v", DeviceInfo.WIDTH, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class LogcatWrapper {
        public final int d(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.d(tag, msg);
        }

        public final int e(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.e(tag, msg);
        }

        public final int i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.i(tag, msg);
        }

        public final int v(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.v(tag, msg);
        }

        public final int w(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.w(tag, msg);
        }

        public final int d(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.d(tag, msg, tr);
        }

        public final int e(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.e(tag, msg, tr);
        }

        public final int i(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.i(tag, msg, tr);
        }

        public final int v(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.v(tag, msg, tr);
        }

        public final int w(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.w(tag, msg, tr);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", ContextChain.TAG_PRODUCT, "v", DeviceInfo.WIDTH, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Printer {

        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public static final class DefaultImpls {
            public static int d(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            public static int e(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            public static int i(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            public static int p(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            public static int v(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            public static int w(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            public static int d(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            public static int e(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            public static int i(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            public static int v(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            public static int w(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }
        }

        int d(String tag, String msg);

        int d(String tag, String msg, Throwable tr);

        int e(String tag, String msg);

        int e(String tag, String msg, Throwable tr);

        int i(String tag, String msg);

        int i(String tag, String msg, Throwable tr);

        int p(String tag, String msg);

        int v(String tag, String msg);

        int v(String tag, String msg, Throwable tr);

        int w(String tag, String msg);

        int w(String tag, String msg, Throwable tr);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$PublicPrinter;", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "()V", ContextChain.TAG_PRODUCT, "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PublicPrinter implements Printer {
        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int d(String str, String str2) {
            return Printer.DefaultImpls.d(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int e(String str, String str2) {
            return Printer.DefaultImpls.e(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int i(String str, String str2) {
            return Printer.DefaultImpls.i(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int p(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int v(String str, String str2) {
            return Printer.DefaultImpls.v(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int w(String str, String str2) {
            return Printer.DefaultImpls.w(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int d(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.d(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int e(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.e(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int i(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.i(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int v(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.v(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        public int w(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.w(this, str, str2, th);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.PUBLIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.CS_IN_APP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @NotNull
    public final Printer createPrinter(LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        int i = WhenMappings.$EnumSwitchMapping$0[logLevel.ordinal()];
        return i != 1 ? i != 2 ? new DebugPrinter() : new CsInAppPrinter() : new PublicPrinter();
    }
}
