package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Message;

/* loaded from: classes.dex */
public final class MessageCompat {
    @SuppressLint({"NewApi"})
    public static void setAsynchronous(Message message, boolean z) {
        Api22Impl.setAsynchronous(message, z);
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(Message message) {
        return Api22Impl.isAsynchronous(message);
    }

    static class Api22Impl {
        static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        static void setAsynchronous(Message message, boolean z) {
            message.setAsynchronous(z);
        }
    }
}
