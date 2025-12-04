package com.urbanairship.android.framework.proxy;

import android.util.Log;
import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.google.firebase.messaging.Constants;
import com.urbanairship.util.UAStringUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ7\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u0012J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u000e\u0010\u0013J/\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0014\u0010\u000fJ/\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u000fJ7\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0015\u0010\u0012J+\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\f\"\u00020\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u000fJ7\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0016\u0010\u0012J/\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0017\u0010\u000fJ\u0017\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0017\u0010\u0013J7\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0017\u0010\u0012JC\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/android/framework/proxy/ProxyLogger;", "", "<init>", "()V", "", "logLevel", "", "setLogLevel$airship_framework_proxy_release", "(I)V", "setLogLevel", "", "message", "", "args", "warn", "(Ljava/lang/String;[Ljava/lang/Object;)V", "", "t", "(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/Throwable;)V", "verbose", "debug", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, Constants.IPC_BUNDLE_KEY_SEND_ERROR, Constants.FirelogAnalytics.PARAM_PRIORITY, "throwable", "log", "(ILjava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V", "I", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProxyLogger {

    @NotNull
    public static final ProxyLogger INSTANCE = new ProxyLogger();
    private static int logLevel = 2;

    private ProxyLogger() {
    }

    @JvmStatic
    public static final void warn(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(5, null, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void warn(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(5, t, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void warn(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        INSTANCE.log(5, t, null, new Object[0]);
    }

    @JvmStatic
    public static final void verbose(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(2, null, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void debug(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(3, null, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void debug(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(3, t, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void info(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(4, null, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void info(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(4, t, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void error(@NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(6, null, message, Arrays.copyOf(args, args.length));
    }

    @JvmStatic
    public static final void error(@NotNull Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        INSTANCE.log(6, t, null, new Object[0]);
    }

    @JvmStatic
    public static final void error(@NotNull Throwable t, @NotNull String message, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(args, "args");
        INSTANCE.log(6, t, message, Arrays.copyOf(args, args.length));
    }

    private final void log(int priority, Throwable throwable, String message, Object... args) {
        String str;
        if (logLevel > priority) {
        }
        if (message == null && throwable == null) {
            return;
        }
        if (UAStringUtil.isEmpty(message)) {
            str = "";
        } else {
            try {
                if (args.length != 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Locale locale = Locale.ROOT;
                    Intrinsics.checkNotNull(message);
                    Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
                    message = String.format(locale, message, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
                    Intrinsics.checkNotNullExpressionValue(message, "format(...)");
                }
                str = message;
            } catch (Exception e) {
                Log.wtf("UALib-Framework", "Failed to format log.", e);
                return;
            }
        }
        if (throwable == null) {
            if (priority == 7) {
                Log.wtf("UALib-Framework", str);
                return;
            } else {
                Intrinsics.checkNotNull(str);
                Log.println(priority, "UALib-Framework", str);
                return;
            }
        }
        switch (priority) {
            case 2:
                Log.v("UALib-Framework", str, throwable);
                break;
            case 3:
                Log.d("UALib-Framework", str, throwable);
                break;
            case 4:
                Log.i("UALib-Framework", str, throwable);
                break;
            case 5:
                Log.w("UALib-Framework", str, throwable);
                break;
            case 6:
                Log.e("UALib-Framework", str, throwable);
                break;
            case 7:
                Log.wtf("UALib-Framework", str, throwable);
                break;
        }
    }
}
