package androidx.test.espresso.core.internal.deps.guava.primitives;

/* loaded from: classes2.dex */
public final class Ints extends IntsMethodsForWeb {
    public static int saturatedCast(long j) {
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j;
    }
}
