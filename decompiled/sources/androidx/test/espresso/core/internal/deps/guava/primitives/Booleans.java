package androidx.test.espresso.core.internal.deps.guava.primitives;

/* loaded from: classes2.dex */
public final class Booleans {
    public static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }
}
