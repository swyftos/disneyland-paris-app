package org.apache.commons.lang3;

import java.util.function.Predicate;

/* JADX INFO: loaded from: classes6.dex */
public class CharSetUtils {
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

    private static boolean deepEmpty(String[] strArr) {
        return org.apache.commons.lang3.stream.Streams.m1973of(strArr).allMatch(new Predicate() { // from class: org.apache.commons.lang3.CharSetUtils$$ExternalSyntheticLambda0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return StringUtils.isEmpty((String) obj);
            }
        });
    }

    public static String delete(String str, String... strArr) {
        return (StringUtils.isEmpty(str) || deepEmpty(strArr)) ? str : modify(str, strArr, false);
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

    /* JADX WARN: Code duplicated, block: B:22:0x004e A[PHI: r5
  0x004e: PHI (r5v2 java.lang.Character) = (r5v1 java.lang.Character), (r5v4 java.lang.Character), (r5v1 java.lang.Character) binds: [B:10:0x002c, B:21:0x004a, B:17:0x003d] A[DONT_GENERATE, DONT_INLINE]] */
    public static String squeeze(String str, String... strArr) {
        if (StringUtils.isEmpty(str) || deepEmpty(strArr)) {
            return str;
        }
        CharSet charSet = CharSet.getInstance(strArr);
        StringBuilder sb = new StringBuilder(str.length());
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        char c = charArray[0];
        sb.append(c);
        Character chValueOf = null;
        Character chValueOf2 = null;
        for (int i = 1; i < length; i++) {
            char c2 = charArray[i];
            if (c2 == c) {
                if (chValueOf == null || c2 != chValueOf.charValue()) {
                    if (chValueOf2 == null || c2 != chValueOf2.charValue()) {
                        if (charSet.contains(c2)) {
                            chValueOf = Character.valueOf(c2);
                        } else {
                            chValueOf2 = Character.valueOf(c2);
                            sb.append(c2);
                            c = c2;
                        }
                    } else {
                        sb.append(c2);
                        c = c2;
                    }
                }
            } else {
                sb.append(c2);
                c = c2;
            }
        }
        return sb.toString();
    }

    @Deprecated
    public CharSetUtils() {
    }
}
