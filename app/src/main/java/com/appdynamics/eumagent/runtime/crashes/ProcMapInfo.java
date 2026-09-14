package com.appdynamics.eumagent.runtime.crashes;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class ProcMapInfo {

    /* JADX INFO: renamed from: b */
    private static final Pattern f446b = Pattern.compile("\\p{Space}+");

    /* JADX INFO: renamed from: c */
    private static final Pattern f447c = Pattern.compile("\\-");

    /* JADX INFO: renamed from: d */
    private static final Pattern f448d = Pattern.compile(":");

    /* JADX INFO: renamed from: a */
    public final TreeMap<BigInteger, C2048a> f449a = new TreeMap<>();

    /* JADX INFO: renamed from: e */
    private final HashMap<String, FileInfo> f450e = new HashMap<>();

    public static class FileInfo {

        /* JADX INFO: renamed from: a */
        public final BigInteger f451a;

        /* JADX INFO: renamed from: b */
        public String f452b;

        /* JADX INFO: renamed from: c */
        public boolean f453c;

        /* JADX INFO: renamed from: d */
        public Boolean f454d;

        /* JADX INFO: renamed from: e */
        private int f455e;

        /* JADX INFO: renamed from: f */
        private int f456f;

        private native boolean verifyFileStats(String str, int i, int i2, long j);

        FileInfo(int i, int i2, BigInteger bigInteger) {
            this.f455e = i;
            this.f456f = i2;
            this.f451a = bigInteger;
        }

        /* JADX INFO: renamed from: a */
        static String m498a(int i, int i2, BigInteger bigInteger) {
            if (BigInteger.ZERO.equals(bigInteger)) {
                return null;
            }
            return Integer.toHexString(i) + ":" + Integer.toHexString(i2) + ":" + bigInteger.toString(10);
        }

        /* JADX INFO: renamed from: a */
        public final boolean m499a(String str) {
            try {
                return verifyFileStats(str, this.f455e, this.f456f, this.f451a.longValue());
            } catch (UnsatisfiedLinkError unused) {
                return true;
            }
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.crashes.ProcMapInfo$a */
    public class C2048a {

        /* JADX INFO: renamed from: a */
        public final BigInteger f457a;

        /* JADX INFO: renamed from: b */
        public final BigInteger f458b;

        /* JADX INFO: renamed from: c */
        public final FileInfo f459c;

        /* JADX INFO: renamed from: d */
        public final long f460d;

        /* JADX INFO: renamed from: e */
        private String f461e;

        public C2048a(ProcMapInfo procMapInfo, String str) {
            String[] strArrSplit = ProcMapInfo.f446b.split(str, 6);
            if (strArrSplit.length >= 5) {
                String[] strArrSplit2 = ProcMapInfo.f447c.split(strArrSplit[0], 2);
                if (strArrSplit2.length != 2) {
                    throw new IllegalArgumentException("bad address field: " + strArrSplit[0]);
                }
                this.f457a = new BigInteger(strArrSplit2[0], 16);
                this.f458b = new BigInteger(strArrSplit2[1], 16);
                String str2 = strArrSplit[1];
                this.f461e = str2;
                if (str2.length() != 4) {
                    throw new IllegalArgumentException("bad permissions: " + this.f461e);
                }
                this.f460d = Long.valueOf(strArrSplit[2], 16).longValue();
                String[] strArrSplit3 = ProcMapInfo.f448d.split(strArrSplit[3], 2);
                if (strArrSplit3.length != 2) {
                    throw new IllegalArgumentException("bad dev field: " + strArrSplit[3]);
                }
                int iIntValue = Integer.valueOf(strArrSplit3[0], 16).intValue();
                int iIntValue2 = Integer.valueOf(strArrSplit3[1], 16).intValue();
                BigInteger bigInteger = new BigInteger(strArrSplit[4], 10);
                String strM498a = FileInfo.m498a(iIntValue, iIntValue2, bigInteger);
                if (strM498a != null) {
                    FileInfo fileInfo = (FileInfo) procMapInfo.f450e.get(strM498a);
                    if (fileInfo == null) {
                        fileInfo = new FileInfo(iIntValue, iIntValue2, bigInteger);
                        procMapInfo.f450e.put(strM498a, fileInfo);
                    }
                    this.f459c = fileInfo;
                } else {
                    this.f459c = new FileInfo(iIntValue, iIntValue2, bigInteger);
                }
                if (strArrSplit.length > 5) {
                    FileInfo fileInfo2 = this.f459c;
                    String strTrim = strArrSplit[5].trim();
                    if (fileInfo2.f452b == null) {
                        int iLastIndexOf = strTrim.lastIndexOf(32);
                        if (iLastIndexOf != -1 && "(deleted)".equals(strTrim.substring(iLastIndexOf + 1))) {
                            strTrim = strTrim.substring(0, iLastIndexOf);
                            fileInfo2.f453c = true;
                        }
                        fileInfo2.f452b = strTrim;
                        return;
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("bad Maps line: ".concat(String.valueOf(str)));
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m493a(byte[] bArr, int i) {
        int i2 = i;
        while (i2 < bArr.length && bArr[i2] != 10) {
            i2++;
        }
        return new String(Arrays.copyOfRange(bArr, i, i2), Charset.forName("UTF-8")).trim();
    }
}
