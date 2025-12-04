package com.brentvatne.common.toolbox;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.contentsquare.android.core.system.DeviceInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0013\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0014\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0015\u0010\u0012J\u001f\u0010\u0016\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0016\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0017\u0010\u0012J\u000f\u0010\u0018\u001a\u00020\bH\u0007¢\u0006\u0004\b\u0018\u0010\u0003J\u001f\u0010\u0019\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0019\u0010\u0012J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/brentvatne/common/toolbox/DebugLog;", "", "<init>", "()V", "", "_level", "", "_displayThread", "", "setConfig", "(IZ)V", "", "tag", "getTag", "(Ljava/lang/String;)Ljava/lang/String;", NotificationCompat.CATEGORY_MESSAGE, "getMsg", "v", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "i", DeviceInfo.WIDTH, "e", "wtf", "printCallStack", "checkUIThread", "checkNotUIThread", "level", "I", "displayThread", "Z", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DebugLog {

    @NotNull
    public static final DebugLog INSTANCE = new DebugLog();
    private static int level = 5;
    private static boolean displayThread = true;

    private DebugLog() {
    }

    @JvmStatic
    public static final void setConfig(int _level, boolean _displayThread) {
        level = _level;
        displayThread = _displayThread;
    }

    private static final String getTag(String tag) {
        return "RNV" + tag;
    }

    private static final String getMsg(String msg) {
        if (!displayThread) {
            return msg;
        }
        return "[" + Thread.currentThread().getName() + "] " + msg;
    }

    @JvmStatic
    public static final void v(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 2) {
            Log.v(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void d(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 3) {
            Log.d(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void i(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 4) {
            Log.i(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void w(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 5) {
            Log.w(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void e(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (level <= 6) {
            Log.e(getTag(tag), getMsg(msg));
        }
    }

    @JvmStatic
    public static final void wtf(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        Log.wtf(getTag(tag), "--------------->" + getMsg(msg));
        printCallStack();
    }

    @JvmStatic
    public static final void printCallStack() {
        if (level <= 2) {
            new Exception().printStackTrace();
        }
    }

    @JvmStatic
    public static final void checkUIThread(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual(Thread.currentThread().getName(), "main")) {
            return;
        }
        wtf(tag, "------------------------>" + getMsg(msg));
    }

    @JvmStatic
    public static final void checkNotUIThread(@NotNull String tag, @NotNull String msg) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(msg, "msg");
        if (Intrinsics.areEqual(Thread.currentThread().getName(), "main")) {
            wtf(tag, "------------------------>" + getMsg(msg));
        }
    }
}
