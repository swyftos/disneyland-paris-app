package org.apache.commons.lang3;

import androidx.camera.video.AudioStats;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import org.apache.commons.lang3.exception.UncheckedException;

/* JADX INFO: loaded from: classes6.dex */
public class RandomUtils {
    private static RandomUtils INSECURE = new RandomUtils(new Supplier() { // from class: org.apache.commons.lang3.RandomUtils$$ExternalSyntheticLambda0
        @Override // java.util.function.Supplier
        public final Object get() {
            return ThreadLocalRandom.current();
        }
    });
    private static RandomUtils SECURE = new RandomUtils(new Supplier() { // from class: org.apache.commons.lang3.RandomUtils$$ExternalSyntheticLambda1
        @Override // java.util.function.Supplier
        public final Object get() {
            return new SecureRandom();
        }
    });
    private static final ThreadLocal SECURE_RANDOM_STRONG;
    private static RandomUtils SECURE_STRONG;
    private static final Supplier SECURE_STRONG_SUPPLIER;
    private final Supplier random;

    static {
        Supplier supplier = new Supplier() { // from class: org.apache.commons.lang3.RandomUtils$$ExternalSyntheticLambda2
            @Override // java.util.function.Supplier
            public final Object get() {
                return RandomUtils.lambda$static$0();
            }
        };
        SECURE_STRONG_SUPPLIER = supplier;
        SECURE_STRONG = new RandomUtils(supplier);
        SECURE_RANDOM_STRONG = ThreadLocal.withInitial(new Supplier() { // from class: org.apache.commons.lang3.RandomUtils$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                return RandomUtils.lambda$static$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Random lambda$static$0() {
        return (Random) SECURE_RANDOM_STRONG.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SecureRandom lambda$static$1() {
        try {
            return SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            throw new UncheckedException(e);
        }
    }

    public static RandomUtils insecure() {
        return INSECURE;
    }

    @Deprecated
    public static boolean nextBoolean() {
        return secure().randomBoolean();
    }

    @Deprecated
    public static byte[] nextBytes(int i) {
        return secure().randomBytes(i);
    }

    @Deprecated
    public static double nextDouble() {
        return secure().randomDouble();
    }

    @Deprecated
    public static double nextDouble(double d, double d2) {
        return secure().randomDouble(d, d2);
    }

    @Deprecated
    public static float nextFloat() {
        return secure().randomFloat();
    }

    @Deprecated
    public static float nextFloat(float f, float f2) {
        return secure().randomFloat(f, f2);
    }

    @Deprecated
    public static int nextInt() {
        return secure().randomInt();
    }

    @Deprecated
    public static int nextInt(int i, int i2) {
        return secure().randomInt(i, i2);
    }

    @Deprecated
    public static long nextLong() {
        return secure().randomLong();
    }

    @Deprecated
    public static long nextLong(long j, long j2) {
        return secure().randomLong(j, j2);
    }

    public static RandomUtils secure() {
        return SECURE;
    }

    public static RandomUtils secureStrong() {
        return SECURE_STRONG;
    }

    @Deprecated
    public RandomUtils() {
        this(SECURE_STRONG_SUPPLIER);
    }

    private RandomUtils(Supplier supplier) {
        this.random = supplier;
    }

    Random random() {
        return (Random) this.random.get();
    }

    public boolean randomBoolean() {
        return random().nextBoolean();
    }

    public byte[] randomBytes(int i) {
        Validate.isTrue(i >= 0, "Count cannot be negative.", new Object[0]);
        byte[] bArr = new byte[i];
        random().nextBytes(bArr);
        return bArr;
    }

    public double randomDouble() {
        return randomDouble(AudioStats.AUDIO_AMPLITUDE_NONE, Double.MAX_VALUE);
    }

    public double randomDouble(double d, double d2) {
        Validate.isTrue(d2 >= d, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(d >= AudioStats.AUDIO_AMPLITUDE_NONE, "Both range values must be non-negative.", new Object[0]);
        return d == d2 ? d : d + ((d2 - d) * random().nextDouble());
    }

    public float randomFloat() {
        return randomFloat(BitmapDescriptorFactory.HUE_RED, Float.MAX_VALUE);
    }

    public float randomFloat(float f, float f2) {
        Validate.isTrue(f2 >= f, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(f >= BitmapDescriptorFactory.HUE_RED, "Both range values must be non-negative.", new Object[0]);
        return f == f2 ? f : f + ((f2 - f) * random().nextFloat());
    }

    public int randomInt() {
        return randomInt(0, Integer.MAX_VALUE);
    }

    public int randomInt(int i, int i2) {
        Validate.isTrue(i2 >= i, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(i >= 0, "Both range values must be non-negative.", new Object[0]);
        return i == i2 ? i : i + random().nextInt(i2 - i);
    }

    public long randomLong() {
        return randomLong(Long.MAX_VALUE);
    }

    private long randomLong(long j) {
        long jNextLong;
        long j2;
        do {
            jNextLong = random().nextLong() >>> 1;
            j2 = jNextLong % j;
        } while (((jNextLong - j2) + j) - 1 < 0);
        return j2;
    }

    public long randomLong(long j, long j2) {
        Validate.isTrue(j2 >= j, "Start value must be smaller or equal to end value.", new Object[0]);
        Validate.isTrue(j >= 0, "Both range values must be non-negative.", new Object[0]);
        return j == j2 ? j : j + randomLong(j2 - j);
    }

    public String toString() {
        return "RandomUtils [random=" + random() + "]";
    }
}
