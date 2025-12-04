package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;

/* loaded from: classes6.dex */
public class CipherOutputStream extends FilterOutputStream {
    private AEADBlockCipher aeadBlockCipher;
    private byte[] buf;
    private BufferedBlockCipher bufferedBlockCipher;
    private final byte[] oneByte;
    private StreamCipher streamCipher;

    public CipherOutputStream(OutputStream outputStream, BufferedBlockCipher bufferedBlockCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.bufferedBlockCipher = bufferedBlockCipher;
    }

    public CipherOutputStream(OutputStream outputStream, StreamCipher streamCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.streamCipher = streamCipher;
    }

    public CipherOutputStream(OutputStream outputStream, AEADBlockCipher aEADBlockCipher) {
        super(outputStream);
        this.oneByte = new byte[1];
        this.aeadBlockCipher = aEADBlockCipher;
    }

    private void ensureCapacity(int i, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
            if (bufferedBlockCipher != null) {
                i = bufferedBlockCipher.getOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
                if (aEADBlockCipher != null) {
                    i = aEADBlockCipher.getOutputSize(i);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher2 = this.bufferedBlockCipher;
            if (bufferedBlockCipher2 != null) {
                i = bufferedBlockCipher2.getUpdateOutputSize(i);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.aeadBlockCipher;
                if (aEADBlockCipher2 != null) {
                    i = aEADBlockCipher2.getUpdateOutputSize(i);
                }
            }
        }
        byte[] bArr = this.buf;
        if (bArr == null || bArr.length < i) {
            this.buf = new byte[i];
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005b  */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void close() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r4.ensureCapacity(r1, r0)
            org.bouncycastle.crypto.BufferedBlockCipher r0 = r4.bufferedBlockCipher     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            if (r0 == 0) goto L1d
            byte[] r2 = r4.buf     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            int r0 = r0.doFinal(r2, r1)     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            if (r0 == 0) goto L38
            java.io.OutputStream r2 = r4.out     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            byte[] r3 = r4.buf     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            r2.write(r3, r1, r0)     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            goto L38
        L19:
            r0 = move-exception
            goto L3a
        L1b:
            r0 = move-exception
            goto L43
        L1d:
            org.bouncycastle.crypto.modes.AEADBlockCipher r0 = r4.aeadBlockCipher     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            if (r0 == 0) goto L31
            byte[] r2 = r4.buf     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            int r0 = r0.doFinal(r2, r1)     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            if (r0 == 0) goto L38
            java.io.OutputStream r2 = r4.out     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            byte[] r3 = r4.buf     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            r2.write(r3, r1, r0)     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            goto L38
        L31:
            org.bouncycastle.crypto.StreamCipher r0 = r4.streamCipher     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
            if (r0 == 0) goto L38
            r0.reset()     // Catch: java.lang.Exception -> L19 org.bouncycastle.crypto.InvalidCipherTextException -> L1b
        L38:
            r0 = 0
            goto L4b
        L3a:
            org.bouncycastle.crypto.io.CipherIOException r1 = new org.bouncycastle.crypto.io.CipherIOException
            java.lang.String r2 = "Error closing stream: "
            r1.<init>(r2, r0)
        L41:
            r0 = r1
            goto L4b
        L43:
            org.bouncycastle.crypto.io.InvalidCipherTextIOException r1 = new org.bouncycastle.crypto.io.InvalidCipherTextIOException
            java.lang.String r2 = "Error finalising cipher data"
            r1.<init>(r2, r0)
            goto L41
        L4b:
            r4.flush()     // Catch: java.io.IOException -> L54
            java.io.OutputStream r4 = r4.out     // Catch: java.io.IOException -> L54
            r4.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r4 = move-exception
            if (r0 != 0) goto L58
            r0 = r4
        L58:
            if (r0 != 0) goto L5b
            return
        L5b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.io.CipherOutputStream.close():void");
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        ((FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IllegalStateException, DataLengthException, IOException {
        byte[] bArr = this.oneByte;
        byte b = (byte) i;
        bArr[0] = b;
        StreamCipher streamCipher = this.streamCipher;
        if (streamCipher != null) {
            ((FilterOutputStream) this).out.write(streamCipher.returnByte(b));
        } else {
            write(bArr, 0, 1);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IllegalStateException, DataLengthException, IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException, IOException {
        ensureCapacity(i2, false);
        BufferedBlockCipher bufferedBlockCipher = this.bufferedBlockCipher;
        if (bufferedBlockCipher != null) {
            int iProcessBytes = bufferedBlockCipher.processBytes(bArr, i, i2, this.buf, 0);
            if (iProcessBytes != 0) {
                ((FilterOutputStream) this).out.write(this.buf, 0, iProcessBytes);
                return;
            }
            return;
        }
        AEADBlockCipher aEADBlockCipher = this.aeadBlockCipher;
        if (aEADBlockCipher == null) {
            this.streamCipher.processBytes(bArr, i, i2, this.buf, 0);
            ((FilterOutputStream) this).out.write(this.buf, 0, i2);
        } else {
            int iProcessBytes2 = aEADBlockCipher.processBytes(bArr, i, i2, this.buf, 0);
            if (iProcessBytes2 != 0) {
                ((FilterOutputStream) this).out.write(this.buf, 0, iProcessBytes2);
            }
        }
    }
}
