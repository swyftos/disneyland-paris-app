package com.amazonaws.services.s3.internal.crypto;

import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

@Deprecated
/* loaded from: classes2.dex */
final class GCMCipherLite extends CipherLite {
    private static final int TAG_LENGTH = ContentCryptoScheme.AES_GCM.getTagLengthInBits() / 8;
    private CipherLite aux;
    private long currentCount;
    private boolean doneFinal;
    private byte[] finalBytes;
    private boolean invisiblyProcessed;
    private long markedCount;
    private long outputByteCount;
    private boolean securityViolated;
    private final int tagLen;

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    boolean markSupported() {
        return true;
    }

    GCMCipherLite(Cipher cipher, SecretKey secretKey, int i) {
        super(cipher, ContentCryptoScheme.AES_GCM, secretKey, i);
        this.tagLen = i == 1 ? TAG_LENGTH : 0;
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException();
        }
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    byte[] doFinal() {
        if (this.doneFinal) {
            if (this.securityViolated) {
                throw new SecurityException();
            }
            byte[] bArr = this.finalBytes;
            if (bArr == null) {
                return null;
            }
            return (byte[]) bArr.clone();
        }
        this.doneFinal = true;
        byte[] bArrDoFinal = super.doFinal();
        this.finalBytes = bArrDoFinal;
        if (bArrDoFinal == null) {
            return null;
        }
        this.outputByteCount += checkMax(bArrDoFinal.length - this.tagLen);
        return (byte[]) this.finalBytes.clone();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    byte[] update(byte[] bArr, int i, int i2) {
        byte[] bArrUpdate;
        CipherLite cipherLite = this.aux;
        z = false;
        boolean z = false;
        if (cipherLite == null) {
            bArrUpdate = super.update(bArr, i, i2);
            if (bArrUpdate == null) {
                this.invisiblyProcessed = bArr.length > 0;
                return null;
            }
            this.outputByteCount += checkMax(bArrUpdate.length);
            if (bArrUpdate.length == 0 && i2 > 0) {
                z = true;
            }
            this.invisiblyProcessed = z;
        } else {
            bArrUpdate = cipherLite.update(bArr, i, i2);
            if (bArrUpdate == null) {
                return null;
            }
            long length = this.currentCount + bArrUpdate.length;
            this.currentCount = length;
            long j = this.outputByteCount;
            if (length == j) {
                this.aux = null;
            } else if (length > j) {
                if (1 == getCipherMode()) {
                    throw new IllegalStateException("currentCount=" + this.currentCount + " > outputByteCount=" + this.outputByteCount);
                }
                byte[] bArr2 = this.finalBytes;
                int length2 = bArr2 != null ? bArr2.length : 0;
                long j2 = this.outputByteCount;
                long j3 = length2;
                long length3 = (j2 - (this.currentCount - bArrUpdate.length)) - j3;
                this.currentCount = j2 - j3;
                this.aux = null;
                return Arrays.copyOf(bArrUpdate, (int) length3);
            }
        }
        return bArrUpdate;
    }

    private int checkMax(int i) {
        if (this.outputByteCount + i <= 68719476704L) {
            return i;
        }
        this.securityViolated = true;
        throw new SecurityException("Number of bytes processed has exceeded the maximum allowed by AES/GCM; [outputByteCount=" + this.outputByteCount + ", delta=" + i + "]");
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    long mark() {
        long j = this.aux == null ? this.outputByteCount : this.currentCount;
        this.markedCount = j;
        return j;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.CipherLite
    void reset() {
        long j = this.markedCount;
        if (j < this.outputByteCount || this.invisiblyProcessed) {
            try {
                this.aux = createAuxiliary(j);
                this.currentCount = this.markedCount;
            } catch (Exception e) {
                if (!(e instanceof RuntimeException)) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }
}
