package org.junit.internal;

/* loaded from: classes6.dex */
public final class Checks {
    public static <T> T notNull(T t) {
        t.getClass();
        return t;
    }

    public static <T> T notNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
