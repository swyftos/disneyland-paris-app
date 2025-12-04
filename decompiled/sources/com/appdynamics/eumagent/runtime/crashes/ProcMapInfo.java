package com.appdynamics.eumagent.runtime.crashes;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class ProcMapInfo {
    private static final Pattern b = Pattern.compile("\\p{Space}+");
    private static final Pattern c = Pattern.compile("\\-");
    private static final Pattern d = Pattern.compile(":");
    public final TreeMap<BigInteger, a> a = new TreeMap<>();
    private final HashMap<String, FileInfo> e = new HashMap<>();

    public static class FileInfo {
        public final BigInteger a;
        public String b;
        public boolean c;
        public Boolean d;
        private int e;
        private int f;

        private native boolean verifyFileStats(String str, int i, int i2, long j);

        FileInfo(int i, int i2, BigInteger bigInteger) {
            this.e = i;
            this.f = i2;
            this.a = bigInteger;
        }

        static String a(int i, int i2, BigInteger bigInteger) {
            if (BigInteger.ZERO.equals(bigInteger)) {
                return null;
            }
            return Integer.toHexString(i) + ":" + Integer.toHexString(i2) + ":" + bigInteger.toString(10);
        }

        public final boolean a(String str) {
            try {
                return verifyFileStats(str, this.e, this.f, this.a.longValue());
            } catch (UnsatisfiedLinkError unused) {
                return true;
            }
        }
    }

    public class a {
        public final BigInteger a;
        public final BigInteger b;
        public final FileInfo c;
        public final long d;
        private String e;

        public a(ProcMapInfo procMapInfo, String str) {
            String[] strArrSplit = ProcMapInfo.b.split(str, 6);
            if (strArrSplit.length >= 5) {
                String[] strArrSplit2 = ProcMapInfo.c.split(strArrSplit[0], 2);
                if (strArrSplit2.length != 2) {
                    throw new IllegalArgumentException("bad address field: " + strArrSplit[0]);
                }
                this.a = new BigInteger(strArrSplit2[0], 16);
                this.b = new BigInteger(strArrSplit2[1], 16);
                String str2 = strArrSplit[1];
                this.e = str2;
                if (str2.length() != 4) {
                    throw new IllegalArgumentException("bad permissions: " + this.e);
                }
                this.d = Long.valueOf(strArrSplit[2], 16).longValue();
                String[] strArrSplit3 = ProcMapInfo.d.split(strArrSplit[3], 2);
                if (strArrSplit3.length != 2) {
                    throw new IllegalArgumentException("bad dev field: " + strArrSplit[3]);
                }
                int iIntValue = Integer.valueOf(strArrSplit3[0], 16).intValue();
                int iIntValue2 = Integer.valueOf(strArrSplit3[1], 16).intValue();
                BigInteger bigInteger = new BigInteger(strArrSplit[4], 10);
                String strA = FileInfo.a(iIntValue, iIntValue2, bigInteger);
                if (strA != null) {
                    FileInfo fileInfo = (FileInfo) procMapInfo.e.get(strA);
                    if (fileInfo == null) {
                        fileInfo = new FileInfo(iIntValue, iIntValue2, bigInteger);
                        procMapInfo.e.put(strA, fileInfo);
                    }
                    this.c = fileInfo;
                } else {
                    this.c = new FileInfo(iIntValue, iIntValue2, bigInteger);
                }
                if (strArrSplit.length > 5) {
                    FileInfo fileInfo2 = this.c;
                    String strTrim = strArrSplit[5].trim();
                    if (fileInfo2.b == null) {
                        int iLastIndexOf = strTrim.lastIndexOf(32);
                        if (iLastIndexOf != -1 && "(deleted)".equals(strTrim.substring(iLastIndexOf + 1))) {
                            strTrim = strTrim.substring(0, iLastIndexOf);
                            fileInfo2.c = true;
                        }
                        fileInfo2.b = strTrim;
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("bad Maps line: ".concat(String.valueOf(str)));
        }
    }

    public static String a(byte[] bArr, int i) {
        int i2 = i;
        while (i2 < bArr.length && bArr[i2] != 10) {
            i2++;
        }
        return new String(Arrays.copyOfRange(bArr, i, i2), Charset.forName("UTF-8")).trim();
    }
}
