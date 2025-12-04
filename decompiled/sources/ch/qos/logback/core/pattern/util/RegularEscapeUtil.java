package ch.qos.logback.core.pattern.util;

import org.apache.commons.lang3.CharUtils;

/* loaded from: classes2.dex */
public class RegularEscapeUtil implements IEscapeUtil {
    public static String basicEscape(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                i += 2;
                cCharAt = str.charAt(i2);
                if (cCharAt == 'n') {
                    cCharAt = '\n';
                } else if (cCharAt == 'r') {
                    cCharAt = CharUtils.CR;
                } else if (cCharAt == 't') {
                    cCharAt = '\t';
                } else if (cCharAt == 'f') {
                    cCharAt = '\f';
                }
            } else {
                i = i2;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    @Override // ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String str, StringBuffer stringBuffer, char c, int i) {
        char c2;
        if (str.indexOf(c) >= 0 || c == '\\') {
            stringBuffer.append(c);
            return;
        }
        if (c != '_') {
            if (c == 'n') {
                c2 = '\n';
            } else if (c == 'r') {
                c2 = CharUtils.CR;
            } else {
                if (c != 't') {
                    throw new IllegalArgumentException("Illegal char '" + c + " at column " + i + ". Only \\\\, \\_" + formatEscapeCharsForListing(str) + ", \\t, \\n, \\r combinations are allowed as escape characters.");
                }
                c2 = '\t';
            }
            stringBuffer.append(c2);
        }
    }

    String formatEscapeCharsForListing(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(", \\");
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
