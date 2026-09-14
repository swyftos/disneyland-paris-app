package org.apache.commons.lang3;

import java.util.Arrays;
import org.apache.commons.lang3.function.FailableIntFunction;

/* JADX INFO: loaded from: classes6.dex */
public final class ArrayFill {
    public static boolean[] fill(boolean[] zArr, boolean z) {
        if (zArr != null) {
            Arrays.fill(zArr, z);
        }
        return zArr;
    }

    public static byte[] fill(byte[] bArr, byte b) {
        if (bArr != null) {
            Arrays.fill(bArr, b);
        }
        return bArr;
    }

    public static char[] fill(char[] cArr, char c) {
        if (cArr != null) {
            Arrays.fill(cArr, c);
        }
        return cArr;
    }

    public static double[] fill(double[] dArr, double d) {
        if (dArr != null) {
            Arrays.fill(dArr, d);
        }
        return dArr;
    }

    public static float[] fill(float[] fArr, float f) {
        if (fArr != null) {
            Arrays.fill(fArr, f);
        }
        return fArr;
    }

    public static int[] fill(int[] iArr, int i) {
        if (iArr != null) {
            Arrays.fill(iArr, i);
        }
        return iArr;
    }

    public static long[] fill(long[] jArr, long j) {
        if (jArr != null) {
            Arrays.fill(jArr, j);
        }
        return jArr;
    }

    public static short[] fill(short[] sArr, short s) {
        if (sArr != null) {
            Arrays.fill(sArr, s);
        }
        return sArr;
    }

    public static <T, E extends Throwable> T[] fill(T[] tArr, FailableIntFunction<? extends T, E> failableIntFunction) throws Throwable {
        if (tArr != null && failableIntFunction != null) {
            for (int i = 0; i < tArr.length; i++) {
                tArr[i] = failableIntFunction.apply(i);
            }
        }
        return tArr;
    }

    public static <T> T[] fill(T[] tArr, T t) {
        if (tArr != null) {
            Arrays.fill(tArr, t);
        }
        return tArr;
    }
}
