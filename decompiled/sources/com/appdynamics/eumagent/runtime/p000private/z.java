package com.appdynamics.eumagent.runtime.p000private;

import ch.qos.logback.core.CoreConstants;
import com.appdynamics.eumagent.runtime.crashes.ProcMapInfo;
import com.appdynamics.eumagent.runtime.logging.ADLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public final class z {
    public List<c> a;
    public List<b> b;

    public static class d {
        private static SimpleDateFormat c = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
        public long a;
        public String b;

        public final String toString() {
            return c.format(new Date(this.a)) + "  " + this.b;
        }
    }

    public static class b {
        public int a;
        public int b;
        public d[] c;

        public final String toString() {
            return "NativeCrashLogFile{pid=" + this.a + ", tid=" + this.b + ", logs=" + Arrays.toString(this.c) + '}';
        }
    }

    public static class a {
        public long a;
        public String b;

        public final String toString() {
            return this.a + ":" + this.b;
        }
    }

    public static class c {
        public long a;
        public long b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public BigInteger h;
        public BigInteger[] i;
        public ab j;
        public String k;
        public String l;
        public String m;
        public String n;
        public String o;
        public String p;
        public String q;
        public String r;
        public int s;
        public ProcMapInfo t;
        public a[] u;
        public Map<Class, Map<String, Object>> v;

        public final String toString() {
            return "NativeCrashReportFile{timestampMillis=" + this.a + ", upTimeMillis=" + this.b + ", version=" + this.c + ", pid=" + this.d + ", tid=" + this.e + ", signo=" + this.f + ", sigcode=" + this.g + ", faultAddress=" + this.h + ", regs=" + Arrays.toString(this.i) + ", stackInfo=" + this.j + ", abi='" + this.k + CoreConstants.SINGLE_QUOTE_CHAR + ", buildId='" + this.l + CoreConstants.SINGLE_QUOTE_CHAR + ", fingerprint='" + this.m + CoreConstants.SINGLE_QUOTE_CHAR + ", agentVersion='" + this.n + CoreConstants.SINGLE_QUOTE_CHAR + ", agentBuild='" + this.o + CoreConstants.SINGLE_QUOTE_CHAR + ", osVersion='" + this.p + CoreConstants.SINGLE_QUOTE_CHAR + ", appName='" + this.q + CoreConstants.SINGLE_QUOTE_CHAR + ", appVersion='" + this.r + CoreConstants.SINGLE_QUOTE_CHAR + ", appVersionCode=" + this.s + ", procMapInfo=" + this.t + ", breadcrumbs=" + this.u + ", userData=" + this.v + '}';
        }
    }

    public static byte[] a(File file) throws IOException {
        byte[] byteArray = new byte[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    try {
                        try {
                            int i = fileInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        } catch (Throwable th) {
                            try {
                                fileInputStream.close();
                                byteArrayOutputStream.close();
                            } catch (IOException unused) {
                                ADLog.log(1, "IO error closing native crash file (%s), aborting read", file.getName());
                            }
                            throw th;
                        }
                    } catch (IOException unused2) {
                        ADLog.log(1, "IO error while reading native crash file (%s), aborting read", file.getName());
                        fileInputStream.close();
                    }
                } catch (IOException unused3) {
                    ADLog.log(1, "IO error closing native crash file (%s), aborting read", file.getName());
                }
            }
            byteArray = byteArrayOutputStream.toByteArray();
            fileInputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (FileNotFoundException unused4) {
            ADLog.log(1, "Cannot find native crash file (%s), aborting read", file.getName());
            return byteArray;
        }
    }

    public static b b(File file) {
        b bVar = new b();
        String[] strArrSplit = file.getName().split("\\.");
        bVar.a = Integer.valueOf(strArrSplit[1]).intValue();
        bVar.b = Integer.valueOf(strArrSplit[2]).intValue();
        String[] strArrSplit2 = new String(a(file), Charset.forName("UTF-8")).trim().split("\n");
        bVar.c = new d[strArrSplit2.length];
        for (int i = 0; i < bVar.c.length; i++) {
            String[] strArrSplit3 = strArrSplit2[i].split("-");
            bVar.c[i] = new d();
            bVar.c[i].a = Long.valueOf(strArrSplit3[0]).longValue();
            bVar.c[i].b = strArrSplit3[1];
        }
        return bVar;
    }

    public static c a(byte[] bArr) {
        c cVar = new c();
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.nativeOrder());
        byte[] bArr2 = new byte[8];
        byteBufferWrap.get(bArr2);
        String strTrim = new String(bArr2, Charset.forName("UTF-8")).trim();
        if (!"adeumndk".equals(strTrim)) {
            ADLog.log(2, "Incorrect magic of native crash file (%s), aborting read", strTrim);
            return null;
        }
        cVar.a = byteBufferWrap.getLong();
        cVar.b = byteBufferWrap.getLong();
        cVar.c = byteBufferWrap.getInt();
        int i = byteBufferWrap.getInt();
        int i2 = byteBufferWrap.getInt();
        cVar.d = byteBufferWrap.getInt();
        cVar.e = byteBufferWrap.getInt();
        cVar.f = byteBufferWrap.getInt();
        cVar.g = byteBufferWrap.getInt();
        int i3 = byteBufferWrap.getInt();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(byteBufferWrap.getLong());
        if (bigIntegerValueOf.signum() < 0) {
            bigIntegerValueOf = bigIntegerValueOf.add(BigInteger.ONE.shiftLeft(64));
        }
        cVar.h = bigIntegerValueOf;
        cVar.i = new BigInteger[i3];
        int length = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            BigInteger[] bigIntegerArr = cVar.i;
            BigInteger bigIntegerValueOf2 = BigInteger.valueOf(byteBufferWrap.getLong());
            if (bigIntegerValueOf2.signum() < 0) {
                bigIntegerValueOf2 = bigIntegerValueOf2.add(BigInteger.ONE.shiftLeft(64));
            }
            bigIntegerArr[i4] = bigIntegerValueOf2;
        }
        byte[] bArr3 = new byte[16];
        byteBufferWrap.get(bArr3);
        cVar.k = new String(bArr3, Charset.forName("UTF-8")).trim();
        int i5 = byteBufferWrap.getInt();
        byteBufferWrap.getInt();
        int iPosition = byteBufferWrap.position();
        BigInteger[] bigIntegerArr2 = new BigInteger[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            BigInteger bigIntegerValueOf3 = BigInteger.valueOf(byteBufferWrap.getLong());
            if (bigIntegerValueOf3.signum() < 0) {
                bigIntegerValueOf3 = bigIntegerValueOf3.add(BigInteger.ONE.shiftLeft(64));
            }
            bigIntegerArr2[i6] = bigIntegerValueOf3;
        }
        byteBufferWrap.position(iPosition + 256);
        byte[] bArr4 = new byte[48];
        byteBufferWrap.get(bArr4);
        cVar.l = new String(bArr4, Charset.forName("UTF-8")).trim();
        byte[] bArr5 = new byte[256];
        byteBufferWrap.get(bArr5);
        cVar.m = new String(bArr5, Charset.forName("UTF-8")).trim();
        byte[] bArr6 = new byte[64];
        byteBufferWrap.get(bArr6);
        cVar.n = new String(bArr6, Charset.forName("UTF-8")).trim();
        byte[] bArr7 = new byte[64];
        byteBufferWrap.get(bArr7);
        cVar.o = new String(bArr7, Charset.forName("UTF-8")).trim();
        byte[] bArr8 = new byte[32];
        byteBufferWrap.get(bArr8);
        cVar.p = new String(bArr8, Charset.forName("UTF-8")).trim();
        byte[] bArr9 = new byte[256];
        byteBufferWrap.get(bArr9);
        cVar.q = new String(bArr9, Charset.forName("UTF-8")).trim();
        byte[] bArr10 = new byte[64];
        byteBufferWrap.get(bArr10);
        cVar.r = new String(bArr10, Charset.forName("UTF-8")).trim();
        cVar.s = byteBufferWrap.getInt();
        int i7 = byteBufferWrap.getInt();
        int i8 = byteBufferWrap.getInt();
        int i9 = byteBufferWrap.getInt();
        int i10 = byteBufferWrap.getInt();
        byteBufferWrap.position(i);
        byte[] bArr11 = new byte[i2];
        byteBufferWrap.get(bArr11);
        ProcMapInfo procMapInfo = new ProcMapInfo();
        cVar.t = procMapInfo;
        while (length < i2) {
            String strA = ProcMapInfo.a(bArr11, length);
            if (strA != null) {
                String strTrim2 = strA.trim();
                if (strTrim2.length() != 0) {
                    try {
                        ProcMapInfo.a aVar = new ProcMapInfo.a(procMapInfo, strTrim2);
                        procMapInfo.a.put(aVar.a, aVar);
                    } catch (Throwable th) {
                        ADLog.logAgentError("Unable to parse: ".concat(strTrim2), th);
                    }
                }
            }
            length += strA.length() + 1;
        }
        byteBufferWrap.position(i7);
        byte[] bArr12 = new byte[i8];
        byteBufferWrap.get(bArr12);
        cVar.u = a(new String(bArr12, Charset.forName("UTF-8")).trim());
        byteBufferWrap.position(i9);
        byte[] bArr13 = new byte[i10];
        byteBufferWrap.get(bArr13);
        cVar.v = b(new String(bArr13, Charset.forName("UTF-8")).trim());
        byte[] bArr14 = new byte[8];
        byteBufferWrap.get(bArr14);
        String strTrim3 = new String(bArr14, Charset.forName("UTF-8")).trim();
        if (!"adeumend".equals(strTrim3)) {
            ADLog.log(2, "Incorrect trailer of native crash file (%s), aborting read", strTrim3);
            return null;
        }
        cVar.j = new ab(bigIntegerArr2, cVar.t);
        return cVar;
    }

    private static a[] a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split("\u0000\u0000\u0000\u0000")) {
                a aVar = new a();
                String[] strArrSplit = str2.split(":", 2);
                aVar.a = Long.parseLong(strArrSplit[0]);
                aVar.b = strArrSplit[1];
                arrayList.add(aVar);
            }
            return (a[]) arrayList.toArray(new a[arrayList.size()]);
        } catch (Throwable th) {
            ADLog.logAgentError("Failed to parse breadcrumbs from native crash report", th);
            return null;
        }
    }

    private static Map<Class, Map<String, Object>> b(String str) {
        HashMap map = new HashMap();
        map.put(String.class, new HashMap());
        map.put(Long.class, new HashMap());
        map.put(Boolean.class, new HashMap());
        map.put(Double.class, new HashMap());
        map.put(Date.class, new HashMap());
        try {
            String[] strArrSplit = str.split("\u0000\u0000\u0000\u0000");
            for (int i = 0; i < strArrSplit.length; i += 2) {
                String str2 = strArrSplit[i];
                String str3 = strArrSplit[i + 1];
                String[] strArrSplit2 = str2.split(":", 2);
                int iIntValue = Integer.valueOf(strArrSplit2[0]).intValue();
                String str4 = strArrSplit2[1];
                if (iIntValue == 1) {
                    ((Map) map.get(Long.class)).put(str4, Long.valueOf(str3));
                } else if (iIntValue == 2) {
                    ((Map) map.get(Boolean.class)).put(str4, Boolean.valueOf(str3));
                } else if (iIntValue == 3) {
                    ((Map) map.get(Double.class)).put(str4, Double.valueOf(str3));
                } else if (iIntValue == 4) {
                    ((Map) map.get(Date.class)).put(str4, Long.valueOf(str3));
                } else {
                    ((Map) map.get(String.class)).put(str4, str3);
                }
            }
            return map;
        } catch (Throwable th) {
            ADLog.logAgentError("Failed to parse user data from native crash report", th);
            return null;
        }
    }
}
