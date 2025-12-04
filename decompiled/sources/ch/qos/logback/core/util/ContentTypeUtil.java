package ch.qos.logback.core.util;

/* loaded from: classes2.dex */
public class ContentTypeUtil {
    public static String getSubType(String str) {
        int iIndexOf;
        int i;
        if (str == null || (iIndexOf = str.indexOf(47)) == -1 || (i = iIndexOf + 1) >= str.length()) {
            return null;
        }
        return str.substring(i);
    }

    public static boolean isTextual(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("text");
    }
}
