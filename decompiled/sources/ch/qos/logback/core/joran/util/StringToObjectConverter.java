package ch.qos.logback.core.joran.util;

import ch.qos.logback.core.CoreConstants;
import ch.qos.logback.core.spi.ContextAware;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.picocontainer.Characteristics;

/* loaded from: classes2.dex */
public class StringToObjectConverter {
    private static final Class[] STING_CLASS_PARAMETER = {String.class};

    public static boolean canBeBuiltFromSimpleString(Class<?> cls) {
        Package r0 = cls.getPackage();
        if (cls.isPrimitive()) {
            return true;
        }
        return (r0 != null && "java.lang".equals(r0.getName())) || followsTheValueOfConvention(cls) || cls.isEnum() || isOfTypeCharset(cls);
    }

    public static Object convertArg(ContextAware contextAware, String str, Class<?> cls) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (String.class.isAssignableFrom(cls)) {
            return strTrim;
        }
        if (Integer.TYPE.isAssignableFrom(cls)) {
            return Integer.valueOf(strTrim);
        }
        if (Long.TYPE.isAssignableFrom(cls)) {
            return Long.valueOf(strTrim);
        }
        if (Float.TYPE.isAssignableFrom(cls)) {
            return Float.valueOf(strTrim);
        }
        if (Double.TYPE.isAssignableFrom(cls)) {
            return Double.valueOf(strTrim);
        }
        if (Boolean.TYPE.isAssignableFrom(cls)) {
            if (Characteristics.TRUE.equalsIgnoreCase(strTrim)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(strTrim)) {
                return Boolean.FALSE;
            }
        } else {
            if (cls.isEnum()) {
                return convertToEnum(contextAware, strTrim, cls);
            }
            if (followsTheValueOfConvention(cls)) {
                return convertByValueOfMethod(contextAware, cls, strTrim);
            }
            if (isOfTypeCharset(cls)) {
                return convertToCharset(contextAware, str);
            }
        }
        return null;
    }

    private static Object convertByValueOfMethod(ContextAware contextAware, Class cls, String str) {
        try {
            return cls.getMethod(CoreConstants.VALUE_OF, STING_CLASS_PARAMETER).invoke(null, str);
        } catch (Exception unused) {
            contextAware.addError("Failed to invoke valueOf{} method in class [" + cls.getName() + "] with value [" + str + "]");
            return null;
        }
    }

    private static Charset convertToCharset(ContextAware contextAware, String str) {
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException e) {
            contextAware.addError("Failed to get charset [" + str + "]", e);
            return null;
        }
    }

    private static Object convertToEnum(ContextAware contextAware, String str, Class cls) {
        return Enum.valueOf(cls, str);
    }

    private static boolean followsTheValueOfConvention(Class cls) {
        Method valueOfMethod = getValueOfMethod(cls);
        if (valueOfMethod == null) {
            return false;
        }
        return Modifier.isStatic(valueOfMethod.getModifiers());
    }

    public static Method getValueOfMethod(Class<?> cls) {
        try {
            return cls.getMethod(CoreConstants.VALUE_OF, STING_CLASS_PARAMETER);
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private static boolean isOfTypeCharset(Class cls) {
        return Charset.class.isAssignableFrom(cls);
    }
}
