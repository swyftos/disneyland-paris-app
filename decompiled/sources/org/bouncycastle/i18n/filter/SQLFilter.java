package org.bouncycastle.i18n.filter;

/* loaded from: classes6.dex */
public class SQLFilter implements Filter {
    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilter(String str) {
        int i;
        String str2;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i2 = 0;
        while (i2 < stringBuffer.length()) {
            char cCharAt = stringBuffer.charAt(i2);
            if (cCharAt == '\n') {
                i = i2 + 1;
                str2 = "\\n";
            } else if (cCharAt == '\r') {
                i = i2 + 1;
                str2 = "\\r";
            } else if (cCharAt == '\"') {
                i = i2 + 1;
                str2 = "\\\"";
            } else if (cCharAt == '\'') {
                i = i2 + 1;
                str2 = "\\'";
            } else if (cCharAt == '-') {
                i = i2 + 1;
                str2 = "\\-";
            } else if (cCharAt == '/') {
                i = i2 + 1;
                str2 = "\\/";
            } else if (cCharAt == ';') {
                i = i2 + 1;
                str2 = "\\;";
            } else if (cCharAt == '=') {
                i = i2 + 1;
                str2 = "\\=";
            } else if (cCharAt != '\\') {
                i2++;
            } else {
                i = i2 + 1;
                str2 = "\\\\";
            }
            stringBuffer.replace(i2, i, str2);
            i2 = i;
            i2++;
        }
        return stringBuffer.toString();
    }

    @Override // org.bouncycastle.i18n.filter.Filter
    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
