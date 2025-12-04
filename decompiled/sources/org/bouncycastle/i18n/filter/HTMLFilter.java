package org.bouncycastle.i18n.filter;

/* loaded from: classes6.dex */
public class HTMLFilter implements Filter {
    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilter(String str) {
        int i;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i2 = 0;
        while (i2 < stringBuffer.length()) {
            char cCharAt = stringBuffer.charAt(i2);
            if (cCharAt == '\"') {
                i = i2 + 1;
                str2 = "&#34";
            } else if (cCharAt == '#') {
                i = i2 + 1;
                str2 = "&#35";
            } else if (cCharAt == '+') {
                i = i2 + 1;
                str2 = "&#43";
            } else if (cCharAt == '-') {
                i = i2 + 1;
                str2 = "&#45";
            } else if (cCharAt == '>') {
                i = i2 + 1;
                str2 = "&#62";
            } else if (cCharAt == ';') {
                i = i2 + 1;
                str2 = "&#59";
            } else if (cCharAt != '<') {
                switch (cCharAt) {
                    case '%':
                        i = i2 + 1;
                        str2 = "&#37";
                        break;
                    case '&':
                        i = i2 + 1;
                        str2 = "&#38";
                        break;
                    case '\'':
                        i = i2 + 1;
                        str2 = "&#39";
                        break;
                    case '(':
                        i = i2 + 1;
                        str2 = "&#40";
                        break;
                    case ')':
                        i = i2 + 1;
                        str2 = "&#41";
                        break;
                    default:
                        i2 -= 3;
                        continue;
                        i2 += 4;
                }
            } else {
                i = i2 + 1;
                str2 = "&#60";
            }
            stringBuffer.replace(i2, i, str2);
            i2 += 4;
        }
        return stringBuffer.toString();
    }

    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
