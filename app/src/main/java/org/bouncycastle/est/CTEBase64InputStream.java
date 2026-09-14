package org.bouncycastle.est;

import com.google.android.material.internal.ViewUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Base64;

/* JADX INFO: loaded from: classes6.dex */
class CTEBase64InputStream extends InputStream {
    protected final Long max;
    protected long read;

    /* JADX INFO: renamed from: rp */
    protected int f4613rp;
    protected final InputStream src;

    /* JADX INFO: renamed from: wp */
    protected int f4614wp;
    protected final byte[] rawBuf = new byte[1024];
    protected final byte[] data = new byte[ViewUtils.EDGE_TO_EDGE_FLAGS];
    protected final OutputStream dataOutputStream = new OutputStream() { // from class: org.bouncycastle.est.CTEBase64InputStream.1
        @Override // java.io.OutputStream
        public void write(int i) {
            CTEBase64InputStream cTEBase64InputStream = CTEBase64InputStream.this;
            byte[] bArr = cTEBase64InputStream.data;
            int i2 = cTEBase64InputStream.f4614wp;
            cTEBase64InputStream.f4614wp = i2 + 1;
            bArr[i2] = (byte) i;
        }
    };

    public CTEBase64InputStream(InputStream inputStream, Long l) {
        this.src = inputStream;
        this.max = l;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.src.close();
    }

    protected int pullFromSrc() throws IOException {
        int i;
        if (this.read >= this.max.longValue()) {
            return -1;
        }
        int i2 = 0;
        do {
            i = this.src.read();
            if (i >= 33 || i == 13 || i == 10) {
                byte[] bArr = this.rawBuf;
                if (i2 >= bArr.length) {
                    throw new IOException("Content Transfer Encoding, base64 line length > 1024");
                }
                bArr[i2] = (byte) i;
                this.read++;
                i2++;
            } else if (i >= 0) {
                this.read++;
            }
            if (i <= -1 || i2 >= this.rawBuf.length || i == 10) {
                break;
            }
        } while (this.read < this.max.longValue());
        if (i2 > 0) {
            try {
                Base64.decode(this.rawBuf, 0, i2, this.dataOutputStream);
            } catch (Exception e) {
                throw new IOException("Decode Base64 Content-Transfer-Encoding: " + e);
            }
        } else if (i == -1) {
            return -1;
        }
        return this.f4614wp;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f4613rp == this.f4614wp) {
            this.f4613rp = 0;
            this.f4614wp = 0;
            int iPullFromSrc = pullFromSrc();
            if (iPullFromSrc == -1) {
                return iPullFromSrc;
            }
        }
        byte[] bArr = this.data;
        int i = this.f4613rp;
        this.f4613rp = i + 1;
        return bArr[i] & 255;
    }
}
