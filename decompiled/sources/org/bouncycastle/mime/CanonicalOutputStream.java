package org.bouncycastle.mime;

import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.mime.smime.SMimeParserContext;

/* loaded from: classes6.dex */
public class CanonicalOutputStream extends FilterOutputStream {
    protected static byte[] newline = {Ascii.CR, 10};
    private final boolean is7Bit;
    protected int lastb;

    public CanonicalOutputStream(SMimeParserContext sMimeParserContext, Headers headers, OutputStream outputStream) {
        super(outputStream);
        this.lastb = -1;
        this.is7Bit = headers.getContentType() != null ? (headers.getContentType() == null || headers.getContentType().equals("binary")) ? false : true : sMimeParserContext.getDefaultContentTransferEncoding().equals("7bit");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void write(int r3) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r2.is7Bit
            if (r0 == 0) goto L20
            r0 = 13
            if (r3 != r0) goto L10
            java.io.OutputStream r0 = r2.out
            byte[] r1 = org.bouncycastle.mime.CanonicalOutputStream.newline
            r0.write(r1)
            goto L25
        L10:
            r1 = 10
            if (r3 != r1) goto L20
            int r1 = r2.lastb
            if (r1 == r0) goto L25
            java.io.OutputStream r0 = r2.out
            byte[] r1 = org.bouncycastle.mime.CanonicalOutputStream.newline
            r0.write(r1)
            goto L25
        L20:
            java.io.OutputStream r0 = r2.out
            r0.write(r3)
        L25:
            r2.lastb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.mime.CanonicalOutputStream.write(int):void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        for (int i3 = i; i3 != i + i2; i3++) {
            write(bArr[i3]);
        }
    }

    public void writeln() throws IOException {
        ((FilterOutputStream) this).out.write(newline);
    }
}
