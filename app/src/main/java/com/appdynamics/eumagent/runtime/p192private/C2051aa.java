package com.appdynamics.eumagent.runtime.p192private;

import android.util.SparseArray;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aa */
/* JADX INFO: loaded from: classes2.dex */
final class C2051aa {

    /* JADX INFO: renamed from: b */
    private static final byte[] f466b = {127, 69, 76, 70};

    /* JADX INFO: renamed from: a */
    final RandomAccessFile f467a;

    /* JADX INFO: renamed from: c */
    private final int f468c;

    /* JADX INFO: renamed from: d */
    private final int f469d;

    /* JADX INFO: renamed from: e */
    private final int f470e;

    /* JADX INFO: renamed from: f */
    private final long f471f;

    /* JADX INFO: renamed from: g */
    private final int f472g;

    /* JADX INFO: renamed from: h */
    private final int f473h;

    /* JADX INFO: renamed from: i */
    private final int f474i;

    /* JADX INFO: renamed from: j */
    private c f475j;

    /* JADX INFO: renamed from: k */
    private c f476k;

    /* JADX INFO: renamed from: l */
    private c f477l;

    /* JADX INFO: renamed from: m */
    private c f478m;

    /* JADX INFO: renamed from: n */
    private final SparseArray<c> f479n = new SparseArray<>();

    /* JADX INFO: renamed from: o */
    private final TreeMap<Long, d> f480o = new TreeMap<>();

    /* JADX INFO: renamed from: p */
    private a f481p = new a(0);

    /* JADX INFO: renamed from: a */
    static /* synthetic */ String m505a(C2051aa c2051aa, c cVar, long j) {
        return c2051aa.m504a(cVar, j, 512);
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aa$c */
    class c {

        /* JADX INFO: renamed from: a */
        final long f483a;

        /* JADX INFO: renamed from: b */
        final long f484b;

        /* JADX INFO: renamed from: c */
        final BigInteger f485c;

        /* JADX INFO: renamed from: d */
        final long f486d;

        /* JADX INFO: renamed from: e */
        final long f487e;

        /* JADX INFO: renamed from: f */
        final long f488f;

        c(C2051aa c2051aa, int i) throws IOException {
            long j = c2051aa.f471f + ((long) (i * c2051aa.f472g));
            a aVar = c2051aa.f481p;
            if (aVar.f482a) {
                throw new RuntimeException("trying to acquire the file cursor, while already in use");
            }
            aVar.f482a = true;
            c2051aa.f467a.seek(j);
            this.f483a = c2051aa.m502a();
            this.f484b = c2051aa.m502a();
            c2051aa.m508b();
            this.f485c = c2051aa.m511c();
            this.f486d = c2051aa.m508b();
            this.f487e = c2051aa.m508b();
            c2051aa.f467a.skipBytes((c2051aa.f468c * 4) + 8);
            this.f488f = c2051aa.m508b();
            c2051aa.f481p.f482a = false;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aa$d */
    class d {

        /* JADX INFO: renamed from: a */
        long f489a;

        /* JADX INFO: renamed from: b */
        long f490b;

        /* JADX INFO: renamed from: c */
        long f491c;

        /* JADX INFO: renamed from: d */
        long f492d;

        /* JADX INFO: renamed from: f */
        private String f494f;

        private d() {
        }

        /* synthetic */ d(C2051aa c2051aa, byte b) {
            this();
        }

        /* JADX INFO: renamed from: a */
        final String m521a() {
            c cVar;
            String str = this.f494f;
            if (str != null) {
                return str;
            }
            long j = this.f489a;
            if (j == 2) {
                cVar = C2051aa.this.f476k;
            } else {
                if (j != 11) {
                    return null;
                }
                cVar = C2051aa.this.f477l;
            }
            try {
                this.f494f = C2051aa.m505a(C2051aa.this, cVar, this.f491c);
            } catch (IOException unused) {
            }
            return this.f494f;
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aa$b */
    class b extends Exception {
        b(String str) {
            super(str);
        }
    }

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.aa$a */
    static class a {

        /* JADX INFO: renamed from: a */
        boolean f482a;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    C2051aa(File file) throws IOException, b {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.f467a = randomAccessFile;
        a aVar = this.f481p;
        if (aVar.f482a) {
            throw new RuntimeException("trying to acquire the file cursor, while already in use");
        }
        aVar.f482a = true;
        randomAccessFile.seek(0L);
        byte[] bArr = new byte[16];
        randomAccessFile.readFully(bArr);
        if (!Arrays.equals(Arrays.copyOfRange(bArr, 0, 4), f466b)) {
            throw new b("Not an ELF file.");
        }
        byte b2 = bArr[4];
        this.f468c = b2;
        if (b2 != 1 && b2 != 2) {
            throw new IllegalArgumentException("bad ELF class: " + ((int) b2));
        }
        byte b3 = bArr[5];
        this.f469d = b3;
        if (b3 != 1 && b3 != 2) {
            throw new IllegalArgumentException("bad ELF data: " + ((int) b3));
        }
        randomAccessFile.skipBytes(2);
        byte[] bArr2 = new byte[2];
        randomAccessFile.readFully(bArr2);
        this.f470e = m501a(bArr2);
        randomAccessFile.skipBytes((b2 * 4) + 4 + (b2 * 4));
        this.f471f = m508b();
        randomAccessFile.skipBytes(10);
        byte[] bArr3 = new byte[2];
        randomAccessFile.readFully(bArr3);
        this.f472g = m501a(bArr3);
        byte[] bArr4 = new byte[2];
        randomAccessFile.readFully(bArr4);
        this.f473h = m501a(bArr4);
        byte[] bArr5 = new byte[2];
        randomAccessFile.readFully(bArr5);
        this.f474i = m501a(bArr5);
        this.f481p.f482a = false;
        m513d();
        m506a(this.f475j);
        m506a(this.f478m);
    }

    /* JADX INFO: renamed from: a */
    private int m501a(byte[] bArr) {
        int i;
        byte b2;
        if (this.f469d == 1) {
            i = (bArr[1] & 255) << 8;
            b2 = bArr[0];
        } else {
            i = (bArr[0] & 255) << 8;
            b2 = bArr[1];
        }
        return i | (b2 & 255);
    }

    /* JADX INFO: renamed from: b */
    private BigInteger m509b(byte[] bArr) {
        if (this.f469d == 1) {
            return BigInteger.valueOf(((((((((((((long) (bArr[6] & 255)) | (((long) (bArr[7] & 255)) << 8)) << 8) | ((long) (bArr[5] & 255))) << 8) | ((long) (bArr[4] & 255))) << 8) | ((long) (bArr[3] & 255))) << 8) | ((long) (bArr[2] & 255))) << 8) | ((long) (bArr[1] & 255))).shiftLeft(8).or(BigInteger.valueOf(bArr[0] & 255));
        }
        return BigInteger.valueOf(((((((((((long) (bArr[2] & 255)) | (((((long) (bArr[0] & 255)) << 8) | ((long) (bArr[1] & 255))) << 8)) << 8) | ((long) (bArr[3] & 255))) << 8) | ((long) (bArr[4] & 255))) << 8) | ((long) (bArr[5] & 255))) << 8) | ((long) (bArr[6] & 255))).shiftLeft(8).or(BigInteger.valueOf(bArr[7] & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public long m502a() throws IOException {
        byte[] bArr = new byte[4];
        this.f467a.readFully(bArr);
        if (this.f469d == 1) {
            return ((long) (bArr[0] & 255)) | ((((((long) (bArr[2] & 255)) | (((long) (bArr[3] & 255)) << 8)) << 8) | ((long) (bArr[1] & 255))) << 8);
        }
        return ((((long) (bArr[2] & 255)) | (((((long) (bArr[0] & 255)) << 8) | ((long) (bArr[1] & 255))) << 8)) << 8) | ((long) (bArr[3] & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public long m508b() throws IOException {
        if (this.f468c == 1) {
            return m502a();
        }
        byte[] bArr = new byte[8];
        this.f467a.readFully(bArr);
        return m509b(bArr).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public BigInteger m511c() throws IOException {
        if (this.f468c == 1) {
            return BigInteger.valueOf(m502a());
        }
        byte[] bArr = new byte[8];
        this.f467a.readFully(bArr);
        return m509b(bArr);
    }

    /* JADX INFO: renamed from: a */
    private String m504a(c cVar, long j, int i) throws IOException {
        long j2 = cVar.f486d;
        long j3 = cVar.f487e;
        a aVar = this.f481p;
        if (aVar.f482a) {
            throw new RuntimeException("trying to acquire the file cursor, while already in use");
        }
        aVar.f482a = true;
        this.f467a.seek(j2 + j);
        int i2 = (int) (j3 - j);
        if (i2 <= i) {
            i = i2;
        }
        byte[] bArr = new byte[i];
        this.f467a.readFully(bArr);
        this.f481p.f482a = false;
        int i3 = 0;
        while (i3 < i) {
            if (bArr[i3] == 0) {
                return new String(bArr, 0, i3);
            }
            i3++;
        }
        return new String(bArr, 0, i3);
    }

    /* JADX INFO: renamed from: d */
    private void m513d() throws IOException {
        c cVar = new c(this, this.f474i);
        for (int i = 0; i < this.f473h; i++) {
            if (i != this.f474i) {
                c cVar2 = new c(this, i);
                long j = cVar2.f484b;
                if (j == 2) {
                    if (".symtab".equals(m504a(cVar, cVar2.f483a, 7))) {
                        this.f475j = cVar2;
                    }
                } else if (j == 3) {
                    String strM504a = m504a(cVar, cVar2.f483a, 7);
                    if (".strtab".equals(strM504a)) {
                        this.f476k = cVar2;
                    } else if (".dynstr".equals(strM504a)) {
                        this.f477l = cVar2;
                    }
                } else if (j == 11 && ".dynsym".equals(m504a(cVar, cVar2.f483a, 7))) {
                    this.f478m = cVar2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m506a(c cVar) {
        long j;
        long jM502a;
        int i;
        int iM501a;
        BigInteger bigIntegerM511c;
        long jM508b;
        if (cVar == null) {
            return;
        }
        long j2 = cVar.f488f;
        long j3 = 0;
        if (j2 == 0) {
            return;
        }
        long j4 = cVar.f487e / j2;
        long j5 = 0;
        while (j5 < j4) {
            d dVar = new d(this, (byte) 0);
            try {
                dVar.f489a = cVar.f484b;
                long j6 = cVar.f486d + (cVar.f488f * j5);
                C2051aa c2051aa = C2051aa.this;
                a aVar = c2051aa.f481p;
                if (aVar.f482a) {
                    throw new RuntimeException("trying to acquire the file cursor, while already in use");
                }
                aVar.f482a = true;
                c2051aa.f467a.seek(j6);
                C2051aa c2051aa2 = C2051aa.this;
                if (c2051aa2.f468c == 1) {
                    jM502a = c2051aa2.m502a();
                    bigIntegerM511c = C2051aa.this.m511c();
                    jM508b = C2051aa.this.m502a();
                    try {
                        byte[] bArr = new byte[1];
                        C2051aa.this.f467a.readFully(bArr);
                        i = bArr[0] & 255;
                        C2051aa.this.f467a.skipBytes(1);
                        C2051aa c2051aa3 = C2051aa.this;
                        byte[] bArr2 = new byte[2];
                        c2051aa3.f467a.readFully(bArr2);
                        iM501a = c2051aa3.m501a(bArr2);
                    } catch (IOException unused) {
                    }
                } else {
                    jM502a = c2051aa2.m502a();
                    byte[] bArr3 = new byte[1];
                    C2051aa.this.f467a.readFully(bArr3);
                    i = bArr3[0] & 255;
                    C2051aa.this.f467a.skipBytes(1);
                    C2051aa c2051aa4 = C2051aa.this;
                    byte[] bArr4 = new byte[2];
                    c2051aa4.f467a.readFully(bArr4);
                    iM501a = c2051aa4.m501a(bArr4);
                    bigIntegerM511c = C2051aa.this.m511c();
                    jM508b = C2051aa.this.m508b();
                }
                long j7 = jM508b;
                C2051aa.this.f481p.f482a = false;
                if ((i & 15) != 2 || iM501a == 0 || iM501a == 65521 || iM501a == 65522 || jM502a == 0 || BigInteger.ZERO.equals(bigIntegerM511c)) {
                    j = 0;
                } else {
                    dVar.f491c = jM502a;
                    dVar.f492d = j7;
                    c cVar2 = C2051aa.this.f479n.get(iM501a);
                    if (cVar2 == null) {
                        cVar2 = new c(C2051aa.this, iM501a);
                        C2051aa.this.f479n.put(iM501a, cVar2);
                    }
                    long jLongValue = bigIntegerM511c.subtract(cVar2.f485c).longValue();
                    j = 0;
                    if (jLongValue < 0) {
                        throw new RuntimeException("Got negative virtual address offset: ".concat(String.valueOf(jLongValue)));
                    }
                    try {
                        long j8 = cVar2.f486d + jLongValue;
                        dVar.f490b = j8;
                        if (C2051aa.this.f470e == 40) {
                            dVar.f490b = j8 - (j8 % 2);
                        }
                        this.f480o.put(Long.valueOf(dVar.f490b), dVar);
                    } catch (IOException unused2) {
                    }
                }
            } catch (IOException unused3) {
                j = j3;
            }
            j5++;
            j3 = j;
        }
    }

    /* JADX INFO: renamed from: a */
    final C2052ab.b m520a(C2052ab.a aVar) {
        d value;
        String strM521a;
        long j = aVar.f500c + aVar.f499b.f460d;
        Map.Entry<Long, d> entryFloorEntry = this.f480o.floorEntry(Long.valueOf(j));
        if (entryFloorEntry == null || (value = entryFloorEntry.getValue()) == null || value.f492d == 0) {
            return null;
        }
        long jLongValue = j - entryFloorEntry.getKey().longValue();
        if (jLongValue > value.f492d) {
            return null;
        }
        try {
            strM521a = value.m521a();
        } catch (IOException unused) {
            strM521a = null;
        }
        if (strM521a == null) {
            return null;
        }
        return new C2052ab.b(strM521a, jLongValue);
    }

    protected final void finalize() throws Throwable {
        this.f467a.close();
        super.finalize();
    }
}
