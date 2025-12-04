package androidx.test.internal.runner;

import androidx.annotation.VisibleForTesting;
import androidx.test.filters.LargeTest;
import androidx.test.filters.MediumTest;
import androidx.test.filters.SmallTest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;

/* loaded from: classes2.dex */
public final class TestSize {
    private static final Set ALL_SIZES;
    public static final TestSize LARGE;
    public static final TestSize MEDIUM;
    public static final TestSize NONE;
    public static final TestSize SMALL;
    private final Class platformAnnotationClass;
    private final Class runnerFilterAnnotationClass;
    private final String sizeQualifierName;
    private final float testSizeRunTimeThreshold;

    static {
        TestSize testSize = new TestSize("small", SmallTest.class, "android.test.suitebuilder.annotation.SmallTest", 200.0f);
        SMALL = testSize;
        TestSize testSize2 = new TestSize("medium", MediumTest.class, "android.test.suitebuilder.annotation.MediumTest", 1000.0f);
        MEDIUM = testSize2;
        TestSize testSize3 = new TestSize("large", LargeTest.class, "android.test.suitebuilder.annotation.LargeTest", Float.MAX_VALUE);
        LARGE = testSize3;
        NONE = new TestSize("", null, null, BitmapDescriptorFactory.HUE_RED);
        ALL_SIZES = Collections.unmodifiableSet(new HashSet(Arrays.asList(testSize, testSize2, testSize3)));
    }

    @VisibleForTesting
    public TestSize(String str, Class<? extends Annotation> cls, String str2, float f) {
        this.sizeQualifierName = str;
        this.platformAnnotationClass = loadPlatformAnnotationClass(str2);
        this.runnerFilterAnnotationClass = cls;
        this.testSizeRunTimeThreshold = f;
    }

    private static Class loadPlatformAnnotationClass(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public String getSizeQualifierName() {
        return this.sizeQualifierName;
    }

    public boolean testMethodIsAnnotatedWithTestSize(Description description) {
        return (description.getAnnotation(this.runnerFilterAnnotationClass) == null && description.getAnnotation(this.platformAnnotationClass) == null) ? false : true;
    }

    public boolean testClassIsAnnotatedWithTestSize(Description description) {
        Class<?> testClass = description.getTestClass();
        if (testClass == null) {
            return false;
        }
        return hasAnnotation(testClass, this.runnerFilterAnnotationClass) || hasAnnotation(testClass, this.platformAnnotationClass);
    }

    private static boolean hasAnnotation(Class cls, Class cls2) {
        return cls2 != null && cls.isAnnotationPresent(cls2);
    }

    public float getRunTimeThreshold() {
        return this.testSizeRunTimeThreshold;
    }

    public static TestSize getTestSizeForRunTime(float f) {
        TestSize testSize = SMALL;
        if (runTimeSmallerThanThreshold(f, testSize.getRunTimeThreshold())) {
            return testSize;
        }
        TestSize testSize2 = MEDIUM;
        return runTimeSmallerThanThreshold(f, testSize2.getRunTimeThreshold()) ? testSize2 : LARGE;
    }

    public static boolean isAnyTestSize(Class<? extends Annotation> cls) {
        for (TestSize testSize : ALL_SIZES) {
            if (testSize.getRunnerAnnotation() == cls || testSize.getFrameworkAnnotation() == cls) {
                return true;
            }
        }
        return false;
    }

    public static TestSize fromString(String str) {
        TestSize testSize = NONE;
        for (TestSize testSize2 : ALL_SIZES) {
            if (testSize2.getSizeQualifierName().equals(str)) {
                testSize = testSize2;
            }
        }
        return testSize;
    }

    public static TestSize fromDescription(Description description) {
        TestSize testSize = NONE;
        Iterator it = ALL_SIZES.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TestSize testSize2 = (TestSize) it.next();
            if (testSize2.testMethodIsAnnotatedWithTestSize(description)) {
                testSize = testSize2;
                break;
            }
        }
        if (!NONE.equals(testSize)) {
            return testSize;
        }
        for (TestSize testSize3 : ALL_SIZES) {
            if (testSize3.testClassIsAnnotatedWithTestSize(description)) {
                return testSize3;
            }
        }
        return testSize;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TestSize.class != obj.getClass()) {
            return false;
        }
        return this.sizeQualifierName.equals(((TestSize) obj).sizeQualifierName);
    }

    public int hashCode() {
        return this.sizeQualifierName.hashCode();
    }

    private static boolean runTimeSmallerThanThreshold(float f, float f2) {
        return Float.compare(f, f2) < 0;
    }

    private Class getFrameworkAnnotation() {
        return this.platformAnnotationClass;
    }

    private Class getRunnerAnnotation() {
        return this.runnerFilterAnnotationClass;
    }
}
