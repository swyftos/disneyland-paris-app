package org.bouncycastle.util;

import com.amazonaws.services.s3.model.InstructionFileId;

/* loaded from: classes6.dex */
public class IPAddress {
    private static boolean isMaskValue(String str, int i) throws NumberFormatException {
        try {
            int i2 = Integer.parseInt(str);
            return i2 >= 0 && i2 <= i;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isValid(String str) {
        return isValidIPv4(str) || isValidIPv6(str);
    }

    public static boolean isValidIPv4(String str) throws NumberFormatException {
        int iIndexOf;
        int i;
        if (str.length() == 0) {
            return false;
        }
        String str2 = str + InstructionFileId.DOT;
        int i2 = 0;
        int i3 = 0;
        while (i2 < str2.length() && (iIndexOf = str2.indexOf(46, i2)) > i2) {
            if (i3 == 4) {
                return false;
            }
            try {
                i = Integer.parseInt(str2.substring(i2, iIndexOf));
            } catch (NumberFormatException unused) {
            }
            if (i < 0 || i > 255) {
                return false;
            }
            i2 = iIndexOf + 1;
            i3++;
        }
        return i3 == 4;
    }

    public static boolean isValidIPv4WithNetmask(String str) {
        int iIndexOf = str.indexOf("/");
        String strSubstring = str.substring(iIndexOf + 1);
        if (iIndexOf <= 0 || !isValidIPv4(str.substring(0, iIndexOf))) {
            return false;
        }
        return isValidIPv4(strSubstring) || isMaskValue(strSubstring, 32);
    }

    public static boolean isValidIPv6(String str) throws NumberFormatException {
        int iIndexOf;
        int i;
        if (str.length() == 0) {
            return false;
        }
        String str2 = str + ":";
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (i2 < str2.length() && (iIndexOf = str2.indexOf(58, i2)) >= i2) {
            if (i3 == 8) {
                return false;
            }
            if (i2 != iIndexOf) {
                String strSubstring = str2.substring(i2, iIndexOf);
                if (iIndexOf != str2.length() - 1 || strSubstring.indexOf(46) <= 0) {
                    try {
                        i = Integer.parseInt(str2.substring(i2, iIndexOf), 16);
                    } catch (NumberFormatException unused) {
                    }
                    if (i < 0 || i > 65535) {
                        return false;
                    }
                } else {
                    if (!isValidIPv4(strSubstring)) {
                        return false;
                    }
                    i3++;
                }
            } else {
                if (iIndexOf != 1 && iIndexOf != str2.length() - 1 && z) {
                    return false;
                }
                z = true;
            }
            i2 = iIndexOf + 1;
            i3++;
        }
        return i3 == 8 || z;
    }

    public static boolean isValidIPv6WithNetmask(String str) {
        int iIndexOf = str.indexOf("/");
        String strSubstring = str.substring(iIndexOf + 1);
        if (iIndexOf <= 0 || !isValidIPv6(str.substring(0, iIndexOf))) {
            return false;
        }
        return isValidIPv6(strSubstring) || isMaskValue(strSubstring, 128);
    }

    public static boolean isValidWithNetMask(String str) {
        return isValidIPv4WithNetmask(str) || isValidIPv6WithNetmask(str);
    }
}
