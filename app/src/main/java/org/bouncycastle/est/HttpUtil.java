package org.bouncycastle.est;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
abstract class HttpUtil {

    static class Headers extends HashMap {
        private String actualKey(String str) {
            if (containsKey(str)) {
                return str;
            }
            for (K k : keySet()) {
                if (str.equalsIgnoreCase(k)) {
                    return k;
                }
            }
            return null;
        }

        private String[] copy(String[] strArr) {
            int length = strArr.length;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, length);
            return strArr2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void add(String str, String str2) {
            put(str, HttpUtil.append((String[]) get(str), str2));
        }

        @Override // java.util.HashMap, java.util.AbstractMap
        public Object clone() {
            Headers headers = new Headers();
            Iterator it = entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                headers.put((String) entry.getKey(), copy((String[]) entry.getValue()));
            }
            return headers;
        }

        public String getFirstValue(String str) {
            String[] values = getValues(str);
            if (values == null || values.length <= 0) {
                return null;
            }
            return values[0];
        }

        /* JADX WARN: Multi-variable type inference failed */
        public String[] getValues(String str) {
            String strActualKey = actualKey(str);
            if (strActualKey == null) {
                return null;
            }
            return (String[]) get(strActualKey);
        }

        public void set(String str, String str2) {
            put(str, new String[]{str2});
        }
    }

    static class PartLexer {
        int last = 0;

        /* JADX INFO: renamed from: p */
        int f4615p = 0;
        private final String src;

        PartLexer(String str) {
            this.src = str;
        }

        private String consumeAlpha() {
            char cCharAt = this.src.charAt(this.f4615p);
            while (this.f4615p < this.src.length() && ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z'))) {
                int i = this.f4615p + 1;
                this.f4615p = i;
                cCharAt = this.src.charAt(i);
            }
            String strSubstring = this.src.substring(this.last, this.f4615p);
            this.last = this.f4615p;
            return strSubstring;
        }

        private boolean consumeIf(char c) {
            if (this.f4615p >= this.src.length() || this.src.charAt(this.f4615p) != c) {
                return false;
            }
            this.f4615p++;
            return true;
        }

        private String consumeUntil(char c) {
            while (this.f4615p < this.src.length() && this.src.charAt(this.f4615p) != c) {
                this.f4615p++;
            }
            String strSubstring = this.src.substring(this.last, this.f4615p);
            this.last = this.f4615p;
            return strSubstring;
        }

        private void discard() {
            this.last = this.f4615p;
        }

        private void discard(int i) {
            int i2 = this.f4615p + i;
            this.f4615p = i2;
            this.last = i2;
        }

        private void skipWhiteSpace() {
            while (this.f4615p < this.src.length() && this.src.charAt(this.f4615p) < '!') {
                this.f4615p++;
            }
            this.last = this.f4615p;
        }

        Map Parse() {
            HashMap map = new HashMap();
            while (this.f4615p < this.src.length()) {
                skipWhiteSpace();
                String strConsumeAlpha = consumeAlpha();
                if (strConsumeAlpha.length() == 0) {
                    throw new IllegalArgumentException("Expecting alpha label.");
                }
                skipWhiteSpace();
                if (!consumeIf('=')) {
                    throw new IllegalArgumentException("Expecting assign: '='");
                }
                skipWhiteSpace();
                if (!consumeIf('\"')) {
                    throw new IllegalArgumentException("Expecting start quote: '\"'");
                }
                discard();
                String strConsumeUntil = consumeUntil('\"');
                discard(1);
                map.put(strConsumeAlpha, strConsumeUntil);
                skipWhiteSpace();
                if (!consumeIf(',')) {
                    break;
                }
                discard();
            }
            return map;
        }
    }

    public static String[] append(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    static String mergeCSL(String str, Map map) {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write(str);
        stringWriter.write(32);
        boolean z = false;
        for (Map.Entry entry : map.entrySet()) {
            if (z) {
                stringWriter.write(44);
            } else {
                z = true;
            }
            stringWriter.write((String) entry.getKey());
            stringWriter.write("=\"");
            stringWriter.write((String) entry.getValue());
            stringWriter.write(34);
        }
        return stringWriter.toString();
    }

    static Map splitCSL(String str, String str2) {
        String strTrim = str2.trim();
        if (strTrim.startsWith(str)) {
            strTrim = strTrim.substring(str.length());
        }
        return new PartLexer(strTrim).Parse();
    }
}
