package org.bouncycastle.openpgp;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.bcpg.InputStreamPacket;
import org.bouncycastle.bcpg.SymmetricEncIntegrityPacket;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.openpgp.operator.PGPDigestCalculator;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public abstract class PGPEncryptedData implements SymmetricKeyAlgorithmTags {
    InputStreamPacket encData;
    InputStream encStream;
    PGPDigestCalculator integrityCalculator;
    TruncatedStream truncStream;

    protected class TruncatedStream extends InputStream {
        int bufPtr;
        InputStream in;
        int[] lookAhead = new int[22];

        TruncatedStream(InputStream inputStream) throws IOException {
            int i = 0;
            while (true) {
                int[] iArr = this.lookAhead;
                if (i == iArr.length) {
                    this.bufPtr = 0;
                    this.in = inputStream;
                    return;
                } else {
                    int i2 = inputStream.read();
                    iArr[i] = i2;
                    if (i2 < 0) {
                        throw new EOFException();
                    }
                    i++;
                }
            }
        }

        int[] getLookAhead() {
            int[] iArr = new int[this.lookAhead.length];
            int i = this.bufPtr;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.lookAhead;
                if (i == iArr2.length) {
                    break;
                }
                iArr[i3] = iArr2[i];
                i++;
                i3++;
            }
            while (i2 != this.bufPtr) {
                iArr[i3] = this.lookAhead[i2];
                i2++;
                i3++;
            }
            return iArr;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = this.in.read();
            if (i < 0) {
                return -1;
            }
            int[] iArr = this.lookAhead;
            int i2 = this.bufPtr;
            int i3 = iArr[i2];
            iArr[i2] = i;
            this.bufPtr = (i2 + 1) % iArr.length;
            return i3;
        }
    }

    PGPEncryptedData(InputStreamPacket inputStreamPacket) {
        this.encData = inputStreamPacket;
    }

    public InputStream getInputStream() {
        return this.encData.getInputStream();
    }

    public boolean isIntegrityProtected() {
        return this.encData instanceof SymmetricEncIntegrityPacket;
    }

    public boolean verify() throws IOException, PGPException {
        if (!isIntegrityProtected()) {
            throw new PGPException("data not integrity protected.");
        }
        while (this.encStream.read() >= 0) {
        }
        int[] lookAhead = this.truncStream.getLookAhead();
        OutputStream outputStream = this.integrityCalculator.getOutputStream();
        outputStream.write((byte) lookAhead[0]);
        outputStream.write((byte) lookAhead[1]);
        byte[] digest = this.integrityCalculator.getDigest();
        int length = digest.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i != length; i++) {
            bArr[i] = (byte) lookAhead[i + 2];
        }
        return Arrays.constantTimeAreEqual(digest, bArr);
    }
}
