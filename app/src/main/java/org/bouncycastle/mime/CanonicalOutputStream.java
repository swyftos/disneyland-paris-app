package org.bouncycastle.mime;

import com.google.common.base.Ascii;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.mime.smime.SMimeParserContext;

/* JADX INFO: loaded from: classes6.dex */
public class CanonicalOutputStream extends FilterOutputStream {
    protected static byte[] newline = {Ascii.f3522CR, 10};
    private final boolean is7Bit;
    protected int lastb;

    public CanonicalOutputStream(SMimeParserContext sMimeParserContext, Headers headers, OutputStream outputStream) {
        super(outputStream);
        this.lastb = -1;
        this.is7Bit = headers.getContentType() != null ? (headers.getContentType() == null || headers.getContentType().equals("binary")) ? false : true : sMimeParserContext.getDefaultContentTransferEncoding().equals("7bit");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0020  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        if (!this.is7Bit) {
            ((FilterOutputStream) this).out.write(i);
        } else if (i == 13) {
            ((FilterOutputStream) this).out.write(newline);
        } else if (i != 10) {
            ((FilterOutputStream) this).out.write(i);
        } else if (this.lastb != 13) {
            ((FilterOutputStream) this).out.write(newline);
        }
        this.lastb = i;
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
