package org.apache.commons.lang3;

/* loaded from: classes6.dex */
public class CharSetUtils {
    /* JADX WARN: Removed duplicated region for block: B:22:0x004e A[PHI: r5
  0x004e: PHI (r5v2 java.lang.Character) = (r5v1 java.lang.Character), (r5v4 java.lang.Character), (r5v1 java.lang.Character) binds: [B:10:0x002c, B:21:0x004a, B:17:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String squeeze(java.lang.String r8, java.lang.String... r9) {
        /*
            boolean r0 = org.apache.commons.lang3.StringUtils.isEmpty(r8)
            if (r0 != 0) goto L59
            boolean r0 = deepEmpty(r9)
            if (r0 == 0) goto Ld
            goto L59
        Ld:
            org.apache.commons.lang3.CharSet r9 = org.apache.commons.lang3.CharSet.getInstance(r9)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r8.length()
            r0.<init>(r1)
            char[] r8 = r8.toCharArray()
            int r1 = r8.length
            r2 = 0
            char r2 = r8[r2]
            r0.append(r2)
            r3 = 1
            r4 = 0
            r5 = r4
        L28:
            if (r3 >= r1) goto L55
            char r6 = r8[r3]
            if (r6 != r2) goto L4e
            if (r4 == 0) goto L37
            char r7 = r4.charValue()
            if (r6 != r7) goto L37
            goto L52
        L37:
            if (r5 == 0) goto L3f
            char r7 = r5.charValue()
            if (r6 == r7) goto L4e
        L3f:
            boolean r7 = r9.contains(r6)
            if (r7 == 0) goto L4a
            java.lang.Character r4 = java.lang.Character.valueOf(r6)
            goto L52
        L4a:
            java.lang.Character r5 = java.lang.Character.valueOf(r6)
        L4e:
            r0.append(r6)
            r2 = r6
        L52:
            int r3 = r3 + 1
            goto L28
        L55:
            java.lang.String r8 = r0.toString()
        L59:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.CharSetUtils.squeeze(java.lang.String, java.lang.String[]):java.lang.String");
    }

    public static boolean containsAny(String str, String... strArr) {
        if (!StringUtils.isEmpty(str) && !deepEmpty(strArr)) {
            CharSet charSet = CharSet.getInstance(strArr);
            for (char c : str.toCharArray()) {
                if (charSet.contains(c)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int count(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return 0;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        int i = 0;
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                i++;
            }
        }
        return i;
    }

    public static String keep(String str, String... strArr) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty() || deepEmpty(strArr)) {
            return "";
        }
        return modify(str, strArr, true);
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
    }

    private static String modify(String str, String[] strArr, boolean z) {
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        for (char c : str.toCharArray()) {
            if (charSet.contains(c) == z) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private static boolean deepEmpty(String[] strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (StringUtils.isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
