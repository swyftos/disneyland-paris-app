package com.disney.id.android.logging;

import android.util.Log;
import com.contentsquare.android.core.system.DeviceInfo;
import com.disney.id.android.OneID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\b\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\"\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\"\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/disney/id/android/logging/OneIDLogger;", "Lcom/disney/id/android/logging/Logger;", "()V", "logLevel", "Lcom/disney/id/android/OneID$LogLevel;", "getLogLevel", "()Lcom/disney/id/android/OneID$LogLevel;", "setLogLevel", "(Lcom/disney/id/android/OneID$LogLevel;)V", "d", "", "logTag", "", "message", "throwable", "", "e", "i", "tag", "v", DeviceInfo.WIDTH, "wtf", "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OneIDLogger implements Logger {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final OneID.LogLevel DEFAULT_LOG_LEVEL = OneID.LogLevel.ERROR;
    private OneID.LogLevel logLevel = DEFAULT_LOG_LEVEL;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/disney/id/android/logging/OneIDLogger$Companion;", "", "()V", "DEFAULT_LOG_LEVEL", "Lcom/disney/id/android/OneID$LogLevel;", "getDEFAULT_LOG_LEVEL", "()Lcom/disney/id/android/OneID$LogLevel;", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final OneID.LogLevel getDEFAULT_LOG_LEVEL() {
            return OneIDLogger.DEFAULT_LOG_LEVEL;
        }
    }

    @Override // com.disney.id.android.logging.Logger
    @NotNull
    public OneID.LogLevel getLogLevel() {
        return this.logLevel;
    }

    @Override // com.disney.id.android.logging.Logger
    public void setLogLevel(@NotNull OneID.LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "<set-?>");
        this.logLevel = logLevel;
    }

    private final String tag(String tag) {
        return "OneID:" + tag;
    }

    @Override // com.disney.id.android.logging.Logger
    public void e(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogLevel().compareTo(OneID.LogLevel.ERROR) >= 0) {
            Log.e(tag(logTag), message, throwable);
        }
    }

    @Override // com.disney.id.android.logging.Logger
    public void w(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogLevel().compareTo(OneID.LogLevel.WARN) >= 0) {
            Log.w(tag(logTag), message, throwable);
        }
    }

    @Override // com.disney.id.android.logging.Logger
    public void i(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogLevel().compareTo(OneID.LogLevel.INFO) >= 0) {
            Log.i(tag(logTag), message, throwable);
        }
    }

    @Override // com.disney.id.android.logging.Logger
    public void d(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogLevel().compareTo(OneID.LogLevel.DEBUG) >= 0) {
            Log.d(tag(logTag), message, throwable);
        }
    }

    @Override // com.disney.id.android.logging.Logger
    public void v(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(message, "message");
        if (getLogLevel().compareTo(OneID.LogLevel.TRACE) >= 0) {
            Log.v(tag(logTag), message, throwable);
        }
    }

    @Override // com.disney.id.android.logging.Logger
    public void wtf(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkNotNullParameter(logTag, "logTag");
        Intrinsics.checkNotNullParameter(message, "message");
        Log.wtf(tag(logTag), message, throwable);
    }
}
