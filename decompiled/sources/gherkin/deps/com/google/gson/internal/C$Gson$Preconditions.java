package gherkin.deps.com.google.gson.internal;

/* renamed from: gherkin.deps.com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: classes5.dex */
public final class C$Gson$Preconditions {
    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
