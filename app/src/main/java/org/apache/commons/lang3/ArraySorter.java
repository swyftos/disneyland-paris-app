package org.apache.commons.lang3;

import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes6.dex */
public class ArraySorter {
    public static byte[] sort(byte[] bArr) {
        if (bArr != null) {
            Arrays.sort(bArr);
        }
        return bArr;
    }

    public static char[] sort(char[] cArr) {
        if (cArr != null) {
            Arrays.sort(cArr);
        }
        return cArr;
    }

    public static double[] sort(double[] dArr) {
        if (dArr != null) {
            Arrays.sort(dArr);
        }
        return dArr;
    }

    public static float[] sort(float[] fArr) {
        if (fArr != null) {
            Arrays.sort(fArr);
        }
        return fArr;
    }

    public static int[] sort(int[] iArr) {
        if (iArr != null) {
            Arrays.sort(iArr);
        }
        return iArr;
    }

    public static long[] sort(long[] jArr) {
        if (jArr != null) {
            Arrays.sort(jArr);
        }
        return jArr;
    }

    public static short[] sort(short[] sArr) {
        if (sArr != null) {
            Arrays.sort(sArr);
        }
        return sArr;
    }

    public static <T> T[] sort(T[] tArr) {
        if (tArr != null) {
            Arrays.sort(tArr);
        }
        return tArr;
    }

    public static <T> T[] sort(T[] tArr, Comparator<? super T> comparator) {
        if (tArr != null) {
            Arrays.sort(tArr, comparator);
        }
        return tArr;
    }

    @Deprecated
    public ArraySorter() {
    }
}
