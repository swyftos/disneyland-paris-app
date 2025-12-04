package androidx.core.os;

import android.os.UserHandle;

/* loaded from: classes.dex */
public class UserHandleCompat {
    public static UserHandle getUserHandleForUid(int i) {
        return Api24Impl.getUserHandleForUid(i);
    }

    private static class Api24Impl {
        static UserHandle getUserHandleForUid(int i) {
            return UserHandle.getUserHandleForUid(i);
        }
    }
}
