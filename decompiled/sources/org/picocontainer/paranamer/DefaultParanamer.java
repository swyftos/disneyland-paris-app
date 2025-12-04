package org.picocontainer.paranamer;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import okhttp3.HttpUrl;

/* loaded from: classes6.dex */
public class DefaultParanamer implements Paranamer {
    public static final String __PARANAMER_DATA = "v1.0 \nlookupParameterNames java.lang.AccessibleObject methodOrConstructor \nlookupParameterNames java.lang.AccessibleObject,boolean methodOrCtor,throwExceptionIfMissing \ngetParameterTypeName java.lang.Class cls\n";

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject) {
        return lookupParameterNames(accessibleObject, true);
    }

    @Override // org.picocontainer.paranamer.Paranamer
    public String[] lookupParameterNames(AccessibleObject accessibleObject, boolean z) throws NoSuchFieldException {
        Class<?>[] parameterTypes;
        Class<?> declaringClass;
        String name;
        if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            parameterTypes = method.getParameterTypes();
            name = method.getName();
            declaringClass = method.getDeclaringClass();
        } else {
            Constructor constructor = (Constructor) accessibleObject;
            parameterTypes = constructor.getParameterTypes();
            declaringClass = constructor.getDeclaringClass();
            name = "<init>";
        }
        if (parameterTypes.length == 0) {
            return Paranamer.EMPTY_NAMES;
        }
        String parameterTypeNamesCSV = getParameterTypeNamesCSV(parameterTypes);
        String[] parameterNames = getParameterNames(declaringClass, parameterTypeNamesCSV, name + " ");
        if (parameterNames != null) {
            return parameterNames;
        }
        if (z) {
            throw new ParameterNamesNotFoundException("No parameter names found for class '" + declaringClass + "', methodOrCtor " + name + " and parameter types " + parameterTypeNamesCSV);
        }
        return Paranamer.EMPTY_NAMES;
    }

    private static String[] getParameterNames(Class cls, String str, String str2) throws NoSuchFieldException {
        String[] strArrSplit = findFirstMatchingLine(getParameterListResource(cls), str2 + str + " ").split(" ");
        if (strArrSplit.length == 3 && strArrSplit[1].equals(str)) {
            return strArrSplit[2].split(",");
        }
        return Paranamer.EMPTY_NAMES;
    }

    static String getParameterTypeNamesCSV(Class[] clsArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < clsArr.length; i++) {
            stringBuffer.append(getParameterTypeName(clsArr[i]));
            if (i < clsArr.length - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    private static String getParameterListResource(Class cls) throws NoSuchFieldException {
        try {
            Field declaredField = cls.getDeclaredField("__PARANAMER_DATA");
            if (Modifier.isStatic(declaredField.getModifiers()) && declaredField.getType().equals(String.class)) {
                return (String) declaredField.get(null);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
        return null;
    }

    private static String findFirstMatchingLine(String str, String str2) {
        int iIndexOf;
        int iIndexOf2;
        if (str == null || (iIndexOf = str.indexOf(str2)) < 0 || (iIndexOf2 = str.indexOf("\n", iIndexOf)) <= 0) {
            return "";
        }
        return str.substring(iIndexOf, iIndexOf2);
    }

    private static String getParameterTypeName(Class cls) {
        String strReplace = cls.getName().replace("[J", "[Xlong").replace("[I", "[Xint").replace("[Z", "[Xboolean").replace("[S", "[Xshort").replace("[F", "[Xfloat").replace("[D", "[Xdouble").replace("[B", "[Xbyte").replace("[C", "[Xchar");
        int iIndexOf = strReplace.indexOf("[");
        int i = 0;
        while (iIndexOf > -1) {
            i++;
            strReplace = strReplace.replaceFirst("(\\[\\w)|(\\[)", "");
            iIndexOf = strReplace.indexOf("[");
        }
        String strReplaceFirst = strReplace.replaceFirst(";", "");
        for (int i2 = 0; i2 < i; i2++) {
            strReplaceFirst = strReplaceFirst + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return strReplaceFirst;
    }
}
