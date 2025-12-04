package com.disney.id.android.logging;

import com.contentsquare.android.core.system.DeviceInfo;
import com.disney.id.android.OneID;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\b`\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u000f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&J$\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/disney/id/android/logging/Logger;", "", "logLevel", "Lcom/disney/id/android/OneID$LogLevel;", "getLogLevel", "()Lcom/disney/id/android/OneID$LogLevel;", "setLogLevel", "(Lcom/disney/id/android/OneID$LogLevel;)V", "d", "", "logTag", "", "message", "throwable", "", "e", "i", "v", DeviceInfo.WIDTH, "wtf", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface Logger {
    void d(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable);

    void e(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable);

    @NotNull
    OneID.LogLevel getLogLevel();

    void i(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable);

    void setLogLevel(@NotNull OneID.LogLevel logLevel);

    void v(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable);

    void w(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable);

    void wtf(@NotNull String logTag, @NotNull String message, @Nullable Throwable throwable);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void e$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.e(str, str2, th);
        }

        public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.w(str, str2, th);
        }

        public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.i(str, str2, th);
        }

        public static /* synthetic */ void d$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.d(str, str2, th);
        }

        public static /* synthetic */ void v$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.v(str, str2, th);
        }

        public static /* synthetic */ void wtf$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: wtf");
            }
            if ((i & 4) != 0) {
                th = null;
            }
            logger.wtf(str, str2, th);
        }
    }
}
