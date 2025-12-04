package ch.qos.logback.classic.util;

/* loaded from: classes2.dex */
public class LoggerNameUtil {
    public static int getFirstSeparatorIndexOf(String str) {
        return getSeparatorIndexOf(str, 0);
    }

    public static int getSeparatorIndexOf(String str, int i) {
        int iIndexOf = str.indexOf(46, i);
        int iIndexOf2 = str.indexOf(36, i);
        if (iIndexOf == -1 && iIndexOf2 == -1) {
            return -1;
        }
        return iIndexOf == -1 ? iIndexOf2 : (iIndexOf2 != -1 && iIndexOf >= iIndexOf2) ? iIndexOf2 : iIndexOf;
    }
}
