package org.picocontainer.monitors;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.text.MessageFormat;

/* loaded from: classes6.dex */
public final class ComponentMonitorHelper {
    public static final String INSTANTIATED = "PicoContainer: instantiated {0} [{1} ms], component {2}, injected [{3}]";
    public static final String INSTANTIATING = "PicoContainer: instantiating {0}";
    public static final String INSTANTIATION_FAILED = "PicoContainer: instantiation failed: {0}, reason: {1}";
    public static final String INVOCATION_FAILED = "PicoContainer: invocation failed: {0} on {1}, reason: {2}";
    public static final String INVOKED = "PicoContainer: invoked {0} on {1} [{2} ms]";
    public static final String INVOKING = "PicoContainer: invoking {0} on {1}";
    public static final String LIFECYCLE_INVOCATION_FAILED = "PicoContainer: lifecycle invocation failed: {0} on {1}, reason: {2}";
    public static final String NO_COMPONENT = "PicoContainer: No component for key: {0}";

    public static String format(String str, Object... objArr) {
        return MessageFormat.format(str, objArr);
    }

    public static String parmsToString(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < objArr.length; i++) {
            stringBuffer.append(objArr[i].getClass().getName());
            if (i < objArr.length - 1) {
                stringBuffer.append(", ");
            }
        }
        return stringBuffer.toString();
    }

    public static String ctorToString(Constructor constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        StringBuffer stringBuffer = new StringBuffer(constructor.getName());
        stringBuffer.append("(");
        for (int i = 0; i < parameterTypes.length; i++) {
            stringBuffer.append(parameterTypes[i].getName());
            if (i < parameterTypes.length - 1) {
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static String methodToString(Member member) {
        StringBuffer stringBuffer = new StringBuffer(member.getName());
        if (member instanceof Method) {
            Class<?>[] parameterTypes = ((Method) member).getParameterTypes();
            stringBuffer.append("(");
            for (int i = 0; i < parameterTypes.length; i++) {
                stringBuffer.append(parameterTypes[i].getName());
                if (i < parameterTypes.length - 1) {
                    stringBuffer.append(", ");
                }
            }
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    public static String memberToString(Member member) {
        if (member instanceof Field) {
            return toString((Field) member);
        }
        return methodToString((Method) member);
    }

    public static String toString(Field field) {
        StringBuffer stringBuffer = new StringBuffer(field.getName());
        stringBuffer.append("(");
        stringBuffer.append(field.getName());
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
