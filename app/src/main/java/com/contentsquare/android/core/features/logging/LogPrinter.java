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

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00072\u00020\u0001:\u0007\u0007\b\t\n\u000b\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000e"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter;", "", "()V", "createPrinter", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "logLevel", "Lcom/contentsquare/android/core/features/logging/LogPrinter$LogLevel;", "Companion", "CsInAppPrinter", "DebugPrinter", "LogLevel", "LogcatWrapper", "Printer", "PublicPrinter", "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
public final class LogPrinter {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static LogcatWrapper logcatWrapper = new LogcatWrapper();

    @Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$Companion;", "", "()V", "logcatWrapper", "Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;", "getLogcatWrapper$annotations", "getLogcatWrapper", "()Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;", "setLogcatWrapper", "(Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;)V", "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
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

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$CsInAppPrinter;", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "()V", "i", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", ContextChain.TAG_PRODUCT, "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    public static final class CsInAppPrinter implements Printer {
        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: d */
        public int mo795d(String str, String str2) {
            return Printer.DefaultImpls.m816d(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: e */
        public int mo797e(String str, String str2) {
            return Printer.DefaultImpls.m818e(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: i */
        public int mo799i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m810i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: p */
        public int mo801p(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m810i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: v */
        public int mo802v(String str, String str2) {
            return Printer.DefaultImpls.m823v(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: w */
        public int mo804w(String str, String str2) {
            return Printer.DefaultImpls.m825w(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: d */
        public int mo796d(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m817d(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: e */
        public int mo798e(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m819e(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: i */
        public int mo800i(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().m811i(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: v */
        public int mo803v(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m824v(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: w */
        public int mo805w(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m826w(this, str, str2, th);
        }
    }

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$DebugPrinter;", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "()V", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", ContextChain.TAG_PRODUCT, "v", DeviceInfo.WIDTH, "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    public static final class DebugPrinter implements Printer {
        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: d */
        public int mo795d(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m806d(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: e */
        public int mo797e(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m808e(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: i */
        public int mo799i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m810i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: p */
        public int mo801p(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m810i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: v */
        public int mo802v(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m812v(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: w */
        public int mo804w(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m814w(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: d */
        public int mo796d(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().m807d(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: e */
        public int mo798e(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().m809e(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: i */
        public int mo800i(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().m811i(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: v */
        public int mo803v(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().m813v(tag, msg, tr);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: w */
        public int mo805w(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return LogPrinter.INSTANCE.getLogcatWrapper().m815w(tag, msg, tr);
        }
    }

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$LogLevel;", "", "(Ljava/lang/String;I)V", "PUBLIC", "CS_IN_APP", "DEBUG", "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    public enum LogLevel {
        PUBLIC,
        CS_IN_APP,
        DEBUG
    }

    @Metadata(m1835d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\u000e"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$LogcatWrapper;", "", "()V", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", "v", DeviceInfo.WIDTH, "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    public static final class LogcatWrapper {
        /* JADX INFO: renamed from: d */
        public final int m806d(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.d(tag, msg);
        }

        /* JADX INFO: renamed from: e */
        public final int m808e(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.e(tag, msg);
        }

        /* JADX INFO: renamed from: i */
        public final int m810i(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.i(tag, msg);
        }

        /* JADX INFO: renamed from: v */
        public final int m812v(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.v(tag, msg);
        }

        /* JADX INFO: renamed from: w */
        public final int m814w(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return Log.w(tag, msg);
        }

        /* JADX INFO: renamed from: d */
        public final int m807d(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.d(tag, msg, tr);
        }

        /* JADX INFO: renamed from: e */
        public final int m809e(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.e(tag, msg, tr);
        }

        /* JADX INFO: renamed from: i */
        public final int m811i(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.i(tag, msg, tr);
        }

        /* JADX INFO: renamed from: v */
        public final int m813v(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.v(tag, msg, tr);
        }

        /* JADX INFO: renamed from: w */
        public final int m815w(String tag, String msg, Throwable tr) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            Intrinsics.checkNotNullParameter(tr, "tr");
            return Log.w(tag, msg, tr);
        }
    }

    @Metadata(m1835d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u000e"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "", "d", "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "tr", "", "e", "i", ContextChain.TAG_PRODUCT, "v", DeviceInfo.WIDTH, "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    public interface Printer {

        @Metadata(m1837k = 3, m1838mv = {1, 8, 0}, m1840xi = 48)
        public static final class DefaultImpls {
            /* JADX INFO: renamed from: d */
            public static int m816d(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            /* JADX INFO: renamed from: e */
            public static int m818e(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            /* JADX INFO: renamed from: i */
            public static int m820i(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            /* JADX INFO: renamed from: p */
            public static int m822p(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            /* JADX INFO: renamed from: v */
            public static int m823v(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            /* JADX INFO: renamed from: w */
            public static int m825w(Printer printer, String tag, String msg) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                return 0;
            }

            /* JADX INFO: renamed from: d */
            public static int m817d(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            /* JADX INFO: renamed from: e */
            public static int m819e(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            /* JADX INFO: renamed from: i */
            public static int m821i(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            /* JADX INFO: renamed from: v */
            public static int m824v(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }

            /* JADX INFO: renamed from: w */
            public static int m826w(Printer printer, String tag, String msg, Throwable tr) {
                Intrinsics.checkNotNullParameter(tag, "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                Intrinsics.checkNotNullParameter(tr, "tr");
                return 0;
            }
        }

        /* JADX INFO: renamed from: d */
        int mo795d(String tag, String msg);

        /* JADX INFO: renamed from: d */
        int mo796d(String tag, String msg, Throwable tr);

        /* JADX INFO: renamed from: e */
        int mo797e(String tag, String msg);

        /* JADX INFO: renamed from: e */
        int mo798e(String tag, String msg, Throwable tr);

        /* JADX INFO: renamed from: i */
        int mo799i(String tag, String msg);

        /* JADX INFO: renamed from: i */
        int mo800i(String tag, String msg, Throwable tr);

        /* JADX INFO: renamed from: p */
        int mo801p(String tag, String msg);

        /* JADX INFO: renamed from: v */
        int mo802v(String tag, String msg);

        /* JADX INFO: renamed from: v */
        int mo803v(String tag, String msg, Throwable tr);

        /* JADX INFO: renamed from: w */
        int mo804w(String tag, String msg);

        /* JADX INFO: renamed from: w */
        int mo805w(String tag, String msg, Throwable tr);
    }

    @Metadata(m1835d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, m1836d2 = {"Lcom/contentsquare/android/core/features/logging/LogPrinter$PublicPrinter;", "Lcom/contentsquare/android/core/features/logging/LogPrinter$Printer;", "()V", ContextChain.TAG_PRODUCT, "", "tag", "", NotificationCompat.CATEGORY_MESSAGE, "core_release"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
    public static final class PublicPrinter implements Printer {
        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: d */
        public int mo795d(String str, String str2) {
            return Printer.DefaultImpls.m816d(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: e */
        public int mo797e(String str, String str2) {
            return Printer.DefaultImpls.m818e(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: i */
        public int mo799i(String str, String str2) {
            return Printer.DefaultImpls.m820i(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: p */
        public int mo801p(String tag, String msg) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(msg, "msg");
            return LogPrinter.INSTANCE.getLogcatWrapper().m810i(tag, msg);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: v */
        public int mo802v(String str, String str2) {
            return Printer.DefaultImpls.m823v(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: w */
        public int mo804w(String str, String str2) {
            return Printer.DefaultImpls.m825w(this, str, str2);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: d */
        public int mo796d(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m817d(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: e */
        public int mo798e(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m819e(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: i */
        public int mo800i(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m821i(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: v */
        public int mo803v(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m824v(this, str, str2, th);
        }

        @Override // com.contentsquare.android.core.features.logging.LogPrinter.Printer
        /* JADX INFO: renamed from: w */
        public int mo805w(String str, String str2, Throwable th) {
            return Printer.DefaultImpls.m826w(this, str, str2, th);
        }
    }

    @Metadata(m1837k = 3, m1838mv = {1, 8, 0}, m1840xi = 48)
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
        if (i != 1) {
            return i != 2 ? new DebugPrinter() : new CsInAppPrinter();
        }
        return new PublicPrinter();
    }
}
