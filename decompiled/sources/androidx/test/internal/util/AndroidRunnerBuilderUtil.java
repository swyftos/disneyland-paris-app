package androidx.test.internal.util;

import androidx.test.internal.runner.listener.InstrumentationResultPrinter;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.runner.BaseTestRunner;

/* loaded from: classes2.dex */
public class AndroidRunnerBuilderUtil {
    public static boolean isJUnit3Test(Class<?> cls) {
        return TestCase.class.isAssignableFrom(cls);
    }

    public static boolean isJUnit3TestSuite(Class<?> cls) {
        return TestSuite.class.isAssignableFrom(cls);
    }

    public static boolean hasSuiteMethod(Class<?> cls) throws NoSuchMethodException, SecurityException {
        try {
            cls.getMethod(BaseTestRunner.SUITE_METHODNAME, new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean hasJUnit3TestMethod(Class<?> cls) throws SecurityException {
        for (Method method : cls.getMethods()) {
            if (isPublicTestMethod(method)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPublicTestMethod(Method method) {
        return isTestMethod(method) && Modifier.isPublic(method.getModifiers());
    }

    private static boolean isTestMethod(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith(InstrumentationResultPrinter.REPORT_KEY_NAME_TEST) && method.getReturnType().equals(Void.TYPE);
    }
}
