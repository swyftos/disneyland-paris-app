package com.allegion.core.operations.support;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class HexConverter {
    private HexConverter() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static byte[] stringToBytes(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String byteToString(byte b) {
        String hexString = Integer.toHexString(b & 255);
        if (hexString.length() != 1) {
            return hexString;
        }
        return "0" + hexString;
    }

    public static String bytesToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        if (bArr == null) {
            return "";
        }
        for (byte b : bArr) {
            sb.append(byteToString(b));
        }
        return sb.toString();
    }

    public static List<byte[]> stringListToByteArrayList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                arrayList.add(stringToBytes(str));
            }
        }
        return arrayList;
    }
}
