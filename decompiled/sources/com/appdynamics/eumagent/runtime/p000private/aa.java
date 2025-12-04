package com.appdynamics.eumagent.runtime.p000private;

import android.util.SparseArray;
import com.appdynamics.eumagent.runtime.p000private.ab;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes2.dex */
final class aa {
    private static final byte[] b = {127, 69, 76, 70};
    final RandomAccessFile a;
    private final int c;
    private final int d;
    private final int e;
    private final long f;
    private final int g;
    private final int h;
    private final int i;
    private c j;
    private c k;
    private c l;
    private c m;
    private final SparseArray<c> n = new SparseArray<>();
    private final TreeMap<Long, d> o = new TreeMap<>();
    private a p = new a(0);

    static /* synthetic */ String a(aa aaVar, c cVar, long j) {
        return aaVar.a(cVar, j, 512);
    }

    class c {
        final long a;
        final long b;
        final BigInteger c;
        final long d;
        final long e;
        final long f;

        c(aa aaVar, int i) throws IOException {
            long j = aaVar.f + (i * aaVar.g);
            a aVar = aaVar.p;
            if (aVar.a) {
                throw new RuntimeException("trying to acquire the file cursor, while already in use");
            }
            aVar.a = true;
            aaVar.a.seek(j);
            this.a = aaVar.a();
            this.b = aaVar.a();
            aaVar.b();
            this.c = aaVar.c();
            this.d = aaVar.b();
            this.e = aaVar.b();
            aaVar.a.skipBytes((aaVar.c * 4) + 8);
            this.f = aaVar.b();
            aaVar.p.a = false;
        }
    }

    class d {
        long a;
        long b;
        long c;
        long d;
        private String f;

        private d() {
        }

        /* synthetic */ d(aa aaVar, byte b) {
            this();
        }

        final String a() {
            c cVar;
            String str = this.f;
            if (str != null) {
                return str;
            }
            long j = this.a;
            if (j == 2) {
                cVar = aa.this.k;
            } else {
                if (j != 11) {
                    return null;
                }
                cVar = aa.this.l;
            }
            try {
                this.f = aa.a(aa.this, cVar, this.c);
            } catch (IOException unused) {
            }
            return this.f;
        }
    }

    class b extends Exception {
        b(String str) {
            super(str);
        }
    }

    static class a {
        boolean a;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    aa(File file) throws IOException, b {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        this.a = randomAccessFile;
        a aVar = this.p;
        if (aVar.a) {
            throw new RuntimeException("trying to acquire the file cursor, while already in use");
        }
        aVar.a = true;
        randomAccessFile.seek(0L);
        byte[] bArr = new byte[16];
        randomAccessFile.readFully(bArr);
        if (!Arrays.equals(Arrays.copyOfRange(bArr, 0, 4), b)) {
            throw new b("Not an ELF file.");
        }
        byte b2 = bArr[4];
        this.c = b2;
        if (b2 != 1 && b2 != 2) {
            throw new IllegalArgumentException("bad ELF class: " + ((int) b2));
        }
        byte b3 = bArr[5];
        this.d = b3;
        if (b3 != 1 && b3 != 2) {
            throw new IllegalArgumentException("bad ELF data: " + ((int) b3));
        }
        randomAccessFile.skipBytes(2);
        byte[] bArr2 = new byte[2];
        randomAccessFile.readFully(bArr2);
        this.e = a(bArr2);
        randomAccessFile.skipBytes((b2 * 4) + 4 + (b2 * 4));
        this.f = b();
        randomAccessFile.skipBytes(10);
        byte[] bArr3 = new byte[2];
        randomAccessFile.readFully(bArr3);
        this.g = a(bArr3);
        byte[] bArr4 = new byte[2];
        randomAccessFile.readFully(bArr4);
        this.h = a(bArr4);
        byte[] bArr5 = new byte[2];
        randomAccessFile.readFully(bArr5);
        this.i = a(bArr5);
        this.p.a = false;
        d();
        a(this.j);
        a(this.m);
    }

    private int a(byte[] bArr) {
        int i;
        byte b2;
        if (this.d == 1) {
            i = (bArr[1] & 255) << 8;
            b2 = bArr[0];
        } else {
            i = (bArr[0] & 255) << 8;
            b2 = bArr[1];
        }
        return i | (b2 & 255);
    }

    private BigInteger b(byte[] bArr) {
        if (this.d == 1) {
            return BigInteger.valueOf((((((((((((bArr[6] & 255) | ((bArr[7] & 255) << 8)) << 8) | (bArr[5] & 255)) << 8) | (bArr[4] & 255)) << 8) | (bArr[3] & 255)) << 8) | (bArr[2] & 255)) << 8) | (bArr[1] & 255)).shiftLeft(8).or(BigInteger.valueOf(bArr[0] & 255));
        }
        return BigInteger.valueOf((((((((((bArr[2] & 255) | ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) << 8)) << 8) | (bArr[3] & 255)) << 8) | (bArr[4] & 255)) << 8) | (bArr[5] & 255)) << 8) | (bArr[6] & 255)).shiftLeft(8).or(BigInteger.valueOf(bArr[7] & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long a() throws IOException {
        this.a.readFully(new byte[4]);
        if (this.d == 1) {
            return (r0[0] & 255) | (((((r0[2] & 255) | ((r0[3] & 255) << 8)) << 8) | (r0[1] & 255)) << 8);
        }
        return (((r0[2] & 255) | ((((r0[0] & 255) << 8) | (r0[1] & 255)) << 8)) << 8) | (r0[3] & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long b() throws IOException {
        if (this.c == 1) {
            return a();
        }
        byte[] bArr = new byte[8];
        this.a.readFully(bArr);
        return b(bArr).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BigInteger c() throws IOException {
        if (this.c == 1) {
            return BigInteger.valueOf(a());
        }
        byte[] bArr = new byte[8];
        this.a.readFully(bArr);
        return b(bArr);
    }

    private String a(c cVar, long j, int i) throws IOException {
        long j2 = cVar.d;
        long j3 = cVar.e;
        a aVar = this.p;
        if (aVar.a) {
            throw new RuntimeException("trying to acquire the file cursor, while already in use");
        }
        aVar.a = true;
        this.a.seek(j2 + j);
        int i2 = (int) (j3 - j);
        if (i2 <= i) {
            i = i2;
        }
        byte[] bArr = new byte[i];
        this.a.readFully(bArr);
        this.p.a = false;
        int i3 = 0;
        while (i3 < i) {
            if (bArr[i3] == 0) {
                return new String(bArr, 0, i3);
            }
            i3++;
        }
        return new String(bArr, 0, i3);
    }

    private void d() throws IOException {
        c cVar = new c(this, this.i);
        for (int i = 0; i < this.h; i++) {
            if (i != this.i) {
                c cVar2 = new c(this, i);
                long j = cVar2.b;
                if (j == 2) {
                    if (".symtab".equals(a(cVar, cVar2.a, 7))) {
                        this.j = cVar2;
                    }
                } else if (j == 3) {
                    String strA = a(cVar, cVar2.a, 7);
                    if (".strtab".equals(strA)) {
                        this.k = cVar2;
                    } else if (".dynstr".equals(strA)) {
                        this.l = cVar2;
                    }
                } else if (j == 11 && ".dynsym".equals(a(cVar, cVar2.a, 7))) {
                    this.m = cVar2;
                }
            }
        }
    }

    private void a(c cVar) throws IOException {
        long j;
        long j2;
        aa aaVar;
        a aVar;
        long jA;
        int i;
        int iA;
        BigInteger bigIntegerC;
        long jB;
        if (cVar == null) {
            return;
        }
        long j3 = cVar.f;
        long j4 = 0;
        if (j3 == 0) {
            return;
        }
        long j5 = cVar.e / j3;
        long j6 = 0;
        while (j6 < j5) {
            d dVar = new d(this, (byte) 0);
            try {
                dVar.a = cVar.b;
                j2 = cVar.d + (cVar.f * j6);
                aaVar = aa.this;
                aVar = aaVar.p;
            } catch (IOException unused) {
                j = j4;
            }
            if (aVar.a) {
                throw new RuntimeException("trying to acquire the file cursor, while already in use");
            }
            aVar.a = true;
            aaVar.a.seek(j2);
            aa aaVar2 = aa.this;
            if (aaVar2.c == 1) {
                jA = aaVar2.a();
                bigIntegerC = aa.this.c();
                jB = aa.this.a();
                try {
                    byte[] bArr = new byte[1];
                    aa.this.a.readFully(bArr);
                    i = bArr[0] & 255;
                    aa.this.a.skipBytes(1);
                    aa aaVar3 = aa.this;
                    byte[] bArr2 = new byte[2];
                    aaVar3.a.readFully(bArr2);
                    iA = aaVar3.a(bArr2);
                } catch (IOException unused2) {
                }
            } else {
                jA = aaVar2.a();
                byte[] bArr3 = new byte[1];
                aa.this.a.readFully(bArr3);
                i = bArr3[0] & 255;
                aa.this.a.skipBytes(1);
                aa aaVar4 = aa.this;
                byte[] bArr4 = new byte[2];
                aaVar4.a.readFully(bArr4);
                iA = aaVar4.a(bArr4);
                bigIntegerC = aa.this.c();
                jB = aa.this.b();
            }
            long j7 = jB;
            aa.this.p.a = false;
            if ((i & 15) != 2 || iA == 0 || iA == 65521 || iA == 65522 || jA == 0 || BigInteger.ZERO.equals(bigIntegerC)) {
                j = 0;
            } else {
                dVar.c = jA;
                dVar.d = j7;
                c cVar2 = aa.this.n.get(iA);
                if (cVar2 == null) {
                    cVar2 = new c(aa.this, iA);
                    aa.this.n.put(iA, cVar2);
                }
                long jLongValue = bigIntegerC.subtract(cVar2.c).longValue();
                j = 0;
                if (jLongValue < 0) {
                    throw new RuntimeException("Got negative virtual address offset: ".concat(String.valueOf(jLongValue)));
                }
                try {
                    long j8 = cVar2.d + jLongValue;
                    dVar.b = j8;
                    if (aa.this.e == 40) {
                        dVar.b = j8 - (j8 % 2);
                    }
                    this.o.put(Long.valueOf(dVar.b), dVar);
                } catch (IOException unused3) {
                }
            }
            j6++;
            j4 = j;
        }
    }

    final ab.b a(ab.a aVar) {
        d value;
        String strA;
        long j = aVar.c + aVar.b.d;
        Map.Entry<Long, d> entryFloorEntry = this.o.floorEntry(Long.valueOf(j));
        if (entryFloorEntry == null || (value = entryFloorEntry.getValue()) == null || value.d == 0) {
            return null;
        }
        long jLongValue = j - entryFloorEntry.getKey().longValue();
        if (jLongValue > value.d) {
            return null;
        }
        try {
            strA = value.a();
        } catch (IOException unused) {
            strA = null;
        }
        if (strA == null) {
            return null;
        }
        return new ab.b(strA, jLongValue);
    }

    protected final void finalize() throws Throwable {
        this.a.close();
        super.finalize();
    }
}
