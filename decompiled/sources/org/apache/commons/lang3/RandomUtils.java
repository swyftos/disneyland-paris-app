package org.apache.commons.lang3;

import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Random;

/* loaded from: classes6.dex */
public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static boolean nextBoolean() {
        return RANDOM.nextBoolean();
    }

    public static byte[] nextBytes(int i) {
        Validate.isTrue(i >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static int nextInt(int i, int i2) {
        Validate.isTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(i >= 0, "Both range values must be non-negative.", new Object[0]);
        return i == i2 ? i : i + RANDOM.nextInt(i2 - i);
    }

    public static int nextInt() {
        return nextInt(0, Integer.MAX_VALUE);
    }

    public static long nextLong(long j, long j2) {
        Validate.isTrue(j2 >= j, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(j >= 0, "Both range values must be non-negative.", new Object[0]);
        return j == j2 ? j : (long) nextDouble(j, j2);
    }

    public static long nextLong() {
        return nextLong(0L, Long.MAX_VALUE);
    }

    public static double nextDouble(double d, double d2) {
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d >= AudioStats.AUDIO_AMPLITUDE_NONE, "Both range values must be non-negative.", new Object[0]);
        return d == d2 ? d : d + ((d2 - d) * RANDOM.nextDouble());
    }

    public static double nextDouble() {
        return nextDouble(AudioStats.AUDIO_AMPLITUDE_NONE, Double.MAX_VALUE);
    }

    public static float nextFloat(float f, float f2) {
        Validate.isTrue(f2 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f >= BitmapDescriptorFactory.HUE_RED, "Both range values must be non-negative.", new Object[0]);
        return f == f2 ? f : f + ((f2 - f) * RANDOM.nextFloat());
    }

    public static float nextFloat() {
        return nextFloat(BitmapDescriptorFactory.HUE_RED, Float.MAX_VALUE);
    }
}
