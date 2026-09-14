package com.appdynamics.eumagent.runtime.p192private;

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

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.z */
/* JADX INFO: loaded from: classes2.dex */
public final class C2147z {

    /* JADX INFO: renamed from: a */
    public List<c> f969a;

    /* JADX INFO: renamed from: b */
    public List<b> f970b;

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.z$d */
    public static class d {

        /* JADX INFO: renamed from: c */
        private static SimpleDateFormat f998c = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());

        /* JADX INFO: renamed from: a */
        public long f999a;

        /* JADX INFO: renamed from: b */
        public String f1000b;

        public final String toString() {
            return f998c.format(new Date(this.f999a)) + "  " + this.f1000b;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.z$b */
    public static class b {

        /* JADX INFO: renamed from: a */
        public int f973a;

        /* JADX INFO: renamed from: b */
        public int f974b;

        /* JADX INFO: renamed from: c */
        public d[] f975c;

        public final String toString() {
            return "NativeCrashLogFile{pid=" + this.f973a + ", tid=" + this.f974b + ", logs=" + Arrays.toString(this.f975c) + '}';
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.z$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public long f971a;

        /* JADX INFO: renamed from: b */
        public String f972b;

        public final String toString() {
            return this.f971a + ":" + this.f972b;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.z$c */
    public static class c {

        /* JADX INFO: renamed from: a */
        public long f976a;

        /* JADX INFO: renamed from: b */
        public long f977b;

        /* JADX INFO: renamed from: c */
        public int f978c;

        /* JADX INFO: renamed from: d */
        public int f979d;

        /* JADX INFO: renamed from: e */
        public int f980e;

        /* JADX INFO: renamed from: f */
        public int f981f;

        /* JADX INFO: renamed from: g */
        public int f982g;

        /* JADX INFO: renamed from: h */
        public BigInteger f983h;

        /* JADX INFO: renamed from: i */
        public BigInteger[] f984i;

        /* JADX INFO: renamed from: j */
        public C2052ab f985j;

        /* JADX INFO: renamed from: k */
        public String f986k;

        /* JADX INFO: renamed from: l */
        public String f987l;

        /* JADX INFO: renamed from: m */
        public String f988m;

        /* JADX INFO: renamed from: n */
        public String f989n;

        /* JADX INFO: renamed from: o */
        public String f990o;

        /* JADX INFO: renamed from: p */
        public String f991p;

        /* JADX INFO: renamed from: q */
        public String f992q;

        /* JADX INFO: renamed from: r */
        public String f993r;

        /* JADX INFO: renamed from: s */
        public int f994s;

        /* JADX INFO: renamed from: t */
        public ProcMapInfo f995t;

        /* JADX INFO: renamed from: u */
        public a[] f996u;

        /* JADX INFO: renamed from: v */
        public Map<Class, Map<String, Object>> f997v;

        public final String toString() {
            return "NativeCrashReportFile{timestampMillis=" + this.f976a + ", upTimeMillis=" + this.f977b + ", version=" + this.f978c + ", pid=" + this.f979d + ", tid=" + this.f980e + ", signo=" + this.f981f + ", sigcode=" + this.f982g + ", faultAddress=" + this.f983h + ", regs=" + Arrays.toString(this.f984i) + ", stackInfo=" + this.f985j + ", abi='" + this.f986k + CoreConstants.SINGLE_QUOTE_CHAR + ", buildId='" + this.f987l + CoreConstants.SINGLE_QUOTE_CHAR + ", fingerprint='" + this.f988m + CoreConstants.SINGLE_QUOTE_CHAR + ", agentVersion='" + this.f989n + CoreConstants.SINGLE_QUOTE_CHAR + ", agentBuild='" + this.f990o + CoreConstants.SINGLE_QUOTE_CHAR + ", osVersion='" + this.f991p + CoreConstants.SINGLE_QUOTE_CHAR + ", appName='" + this.f992q + CoreConstants.SINGLE_QUOTE_CHAR + ", appVersion='" + this.f993r + CoreConstants.SINGLE_QUOTE_CHAR + ", appVersionCode=" + this.f994s + ", procMapInfo=" + this.f995t + ", breadcrumbs=" + this.f996u + ", userData=" + this.f997v + '}';
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m725a(File file) {
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

    /* JADX INFO: renamed from: b */
    public static b m727b(File file) {
        b bVar = new b();
        String[] strArrSplit = file.getName().split("\\.");
        bVar.f973a = Integer.valueOf(strArrSplit[1]).intValue();
        bVar.f974b = Integer.valueOf(strArrSplit[2]).intValue();
        String[] strArrSplit2 = new String(m725a(file), Charset.forName("UTF-8")).trim().split("\n");
        bVar.f975c = new d[strArrSplit2.length];
        for (int i = 0; i < bVar.f975c.length; i++) {
            String[] strArrSplit3 = strArrSplit2[i].split("-");
            bVar.f975c[i] = new d();
            bVar.f975c[i].f999a = Long.valueOf(strArrSplit3[0]).longValue();
            bVar.f975c[i].f1000b = strArrSplit3[1];
        }
        return bVar;
    }

    /* JADX INFO: renamed from: a */
    public static c m724a(byte[] bArr) {
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
        cVar.f976a = byteBufferWrap.getLong();
        cVar.f977b = byteBufferWrap.getLong();
        cVar.f978c = byteBufferWrap.getInt();
        int i = byteBufferWrap.getInt();
        int i2 = byteBufferWrap.getInt();
        cVar.f979d = byteBufferWrap.getInt();
        cVar.f980e = byteBufferWrap.getInt();
        cVar.f981f = byteBufferWrap.getInt();
        cVar.f982g = byteBufferWrap.getInt();
        int i3 = byteBufferWrap.getInt();
        BigInteger bigIntegerValueOf = BigInteger.valueOf(byteBufferWrap.getLong());
        if (bigIntegerValueOf.signum() < 0) {
            bigIntegerValueOf = bigIntegerValueOf.add(BigInteger.ONE.shiftLeft(64));
        }
        cVar.f983h = bigIntegerValueOf;
        cVar.f984i = new BigInteger[i3];
        int length = 0;
        for (int i4 = 0; i4 < i3; i4++) {
            BigInteger[] bigIntegerArr = cVar.f984i;
            BigInteger bigIntegerValueOf2 = BigInteger.valueOf(byteBufferWrap.getLong());
            if (bigIntegerValueOf2.signum() < 0) {
                bigIntegerValueOf2 = bigIntegerValueOf2.add(BigInteger.ONE.shiftLeft(64));
            }
            bigIntegerArr[i4] = bigIntegerValueOf2;
        }
        byte[] bArr3 = new byte[16];
        byteBufferWrap.get(bArr3);
        cVar.f986k = new String(bArr3, Charset.forName("UTF-8")).trim();
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
        cVar.f987l = new String(bArr4, Charset.forName("UTF-8")).trim();
        byte[] bArr5 = new byte[256];
        byteBufferWrap.get(bArr5);
        cVar.f988m = new String(bArr5, Charset.forName("UTF-8")).trim();
        byte[] bArr6 = new byte[64];
        byteBufferWrap.get(bArr6);
        cVar.f989n = new String(bArr6, Charset.forName("UTF-8")).trim();
        byte[] bArr7 = new byte[64];
        byteBufferWrap.get(bArr7);
        cVar.f990o = new String(bArr7, Charset.forName("UTF-8")).trim();
        byte[] bArr8 = new byte[32];
        byteBufferWrap.get(bArr8);
        cVar.f991p = new String(bArr8, Charset.forName("UTF-8")).trim();
        byte[] bArr9 = new byte[256];
        byteBufferWrap.get(bArr9);
        cVar.f992q = new String(bArr9, Charset.forName("UTF-8")).trim();
        byte[] bArr10 = new byte[64];
        byteBufferWrap.get(bArr10);
        cVar.f993r = new String(bArr10, Charset.forName("UTF-8")).trim();
        cVar.f994s = byteBufferWrap.getInt();
        int i7 = byteBufferWrap.getInt();
        int i8 = byteBufferWrap.getInt();
        int i9 = byteBufferWrap.getInt();
        int i10 = byteBufferWrap.getInt();
        byteBufferWrap.position(i);
        byte[] bArr11 = new byte[i2];
        byteBufferWrap.get(bArr11);
        ProcMapInfo procMapInfo = new ProcMapInfo();
        cVar.f995t = procMapInfo;
        while (length < i2) {
            String strM493a = ProcMapInfo.m493a(bArr11, length);
            if (strM493a != null) {
                String strTrim2 = strM493a.trim();
                if (strTrim2.length() != 0) {
                    try {
                        ProcMapInfo.C2048a c2048a = new ProcMapInfo.C2048a(procMapInfo, strTrim2);
                        procMapInfo.f449a.put(c2048a.f457a, c2048a);
                    } catch (Throwable th) {
                        ADLog.logAgentError("Unable to parse: ".concat(strTrim2), th);
                    }
                }
            }
            length += strM493a.length() + 1;
        }
        byteBufferWrap.position(i7);
        byte[] bArr12 = new byte[i8];
        byteBufferWrap.get(bArr12);
        cVar.f996u = m726a(new String(bArr12, Charset.forName("UTF-8")).trim());
        byteBufferWrap.position(i9);
        byte[] bArr13 = new byte[i10];
        byteBufferWrap.get(bArr13);
        cVar.f997v = m728b(new String(bArr13, Charset.forName("UTF-8")).trim());
        byte[] bArr14 = new byte[8];
        byteBufferWrap.get(bArr14);
        String strTrim3 = new String(bArr14, Charset.forName("UTF-8")).trim();
        if (!"adeumend".equals(strTrim3)) {
            ADLog.log(2, "Incorrect trailer of native crash file (%s), aborting read", strTrim3);
            return null;
        }
        cVar.f985j = new C2052ab(bigIntegerArr2, cVar.f995t);
        return cVar;
    }

    /* JADX INFO: renamed from: a */
    private static a[] m726a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str2 : str.split("\u0000\u0000\u0000\u0000")) {
                a aVar = new a();
                String[] strArrSplit = str2.split(":", 2);
                aVar.f971a = Long.parseLong(strArrSplit[0]);
                aVar.f972b = strArrSplit[1];
                arrayList.add(aVar);
            }
            return (a[]) arrayList.toArray(new a[arrayList.size()]);
        } catch (Throwable th) {
            ADLog.logAgentError("Failed to parse breadcrumbs from native crash report", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static Map<Class, Map<String, Object>> m728b(String str) {
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
