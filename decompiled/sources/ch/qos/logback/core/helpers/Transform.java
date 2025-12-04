package ch.qos.logback.core.helpers;

import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class Transform {
    private static final int CDATA_END_LEN = 3;
    private static final Pattern UNSAFE_XML_CHARS = Pattern.compile("[\u0000-\b\u000b\f\u000e-\u001f<>&'\"]");

    public static void appendEscapingCDATA(StringBuilder sb, String str) {
        if (str == null) {
            return;
        }
        int iIndexOf = str.indexOf("]]>");
        if (iIndexOf < 0) {
            sb.append(str);
            return;
        }
        int i = 0;
        while (iIndexOf > -1) {
            sb.append(str.substring(i, iIndexOf));
            sb.append("]]>]]&gt;<![CDATA[");
            i = CDATA_END_LEN + iIndexOf;
            if (i >= str.length()) {
                return;
            } else {
                iIndexOf = str.indexOf("]]>", i);
            }
        }
        sb.append(str.substring(i));
    }

    public static String escapeTags(String str) {
        return (str == null || str.length() == 0 || !UNSAFE_XML_CHARS.matcher(str).find()) ? str : escapeTags(new StringBuffer(str));
    }

    public static String escapeTags(StringBuffer stringBuffer) {
        int i;
        String str;
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char cCharAt = stringBuffer.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r') {
                if (cCharAt == '\"') {
                    i = i2 + 1;
                    str = "&quot;";
                } else if (cCharAt == '<') {
                    i = i2 + 1;
                    str = "&lt;";
                } else if (cCharAt == '>') {
                    i = i2 + 1;
                    str = "&gt;";
                } else if (cCharAt == '&') {
                    i = i2 + 1;
                    str = "&amp;";
                } else if (cCharAt == '\'') {
                    i = i2 + 1;
                    str = "&#39;";
                } else if (cCharAt < ' ') {
                    i = i2 + 1;
                    str = "�";
                }
                stringBuffer.replace(i2, i, str);
            }
        }
        return stringBuffer.toString();
    }
}
