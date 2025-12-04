package org.bouncycastle.mime;

import java.io.InputStream;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class BoundaryLimitedInputStream extends InputStream {
    private final byte[] boundary;
    private final byte[] buf;
    private int bufOff;
    private int lastI;
    private final InputStream src;
    private int index = 0;
    private boolean ended = false;

    public BoundaryLimitedInputStream(InputStream inputStream, String str) {
        this.bufOff = 0;
        this.src = inputStream;
        this.boundary = Strings.toByteArray(str);
        this.buf = new byte[str.length() + 3];
        this.bufOff = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int read() throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.ended
            r1 = -1
            if (r0 == 0) goto L6
            return r1
        L6:
            int r0 = r8.index
            int r2 = r8.bufOff
            r3 = 0
            if (r0 >= r2) goto L1f
            byte[] r4 = r8.buf
            int r5 = r0 + 1
            r8.index = r5
            r0 = r4[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            if (r5 >= r2) goto L1a
            return r0
        L1a:
            r8.bufOff = r3
            r8.index = r3
            goto L25
        L1f:
            java.io.InputStream r0 = r8.src
            int r0 = r0.read()
        L25:
            r8.lastI = r0
            if (r0 >= 0) goto L2a
            return r1
        L2a:
            r2 = 13
            r4 = 10
            if (r0 == r2) goto L32
            if (r0 != r4) goto Laf
        L32:
            r8.index = r3
            if (r0 != r2) goto L48
            java.io.InputStream r2 = r8.src
            int r2 = r2.read()
            if (r2 != r4) goto L4e
            byte[] r2 = r8.buf
            int r3 = r8.bufOff
            int r5 = r3 + 1
            r8.bufOff = r5
            r2[r3] = r4
        L48:
            java.io.InputStream r2 = r8.src
            int r2 = r2.read()
        L4e:
            r3 = 45
            if (r2 != r3) goto L62
            byte[] r2 = r8.buf
            int r4 = r8.bufOff
            int r5 = r4 + 1
            r8.bufOff = r5
            r2[r4] = r3
            java.io.InputStream r2 = r8.src
            int r2 = r2.read()
        L62:
            if (r2 != r3) goto La2
            byte[] r2 = r8.buf
            int r4 = r8.bufOff
            int r5 = r4 + 1
            r8.bufOff = r5
            r2[r4] = r3
        L6e:
            int r2 = r8.bufOff
            int r2 = r2 - r5
            byte[] r3 = r8.boundary
            int r3 = r3.length
            r4 = 1
            if (r2 == r3) goto L97
            java.io.InputStream r2 = r8.src
            int r2 = r2.read()
            if (r2 < 0) goto L97
            byte[] r3 = r8.buf
            int r6 = r8.bufOff
            byte r2 = (byte) r2
            r3[r6] = r2
            byte[] r3 = r8.boundary
            int r7 = r6 - r5
            r3 = r3[r7]
            if (r2 == r3) goto L92
            int r6 = r6 + r4
            r8.bufOff = r6
            goto L97
        L92:
            int r6 = r6 + 1
            r8.bufOff = r6
            goto L6e
        L97:
            int r2 = r8.bufOff
            int r2 = r2 - r5
            byte[] r3 = r8.boundary
            int r3 = r3.length
            if (r2 != r3) goto Laf
            r8.ended = r4
            return r1
        La2:
            if (r2 < 0) goto Laf
            byte[] r1 = r8.buf
            int r3 = r8.bufOff
            int r4 = r3 + 1
            r8.bufOff = r4
            byte r8 = (byte) r2
            r1[r3] = r8
        Laf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.mime.BoundaryLimitedInputStream.read():int");
    }
}
