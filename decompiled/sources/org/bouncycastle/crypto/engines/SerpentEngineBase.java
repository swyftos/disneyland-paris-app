package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

/* loaded from: classes6.dex */
public abstract class SerpentEngineBase implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;
    protected int X0;
    protected int X1;
    protected int X2;
    protected int X3;
    protected boolean encrypting;
    protected int[] wKey;

    SerpentEngineBase() {
    }

    protected static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    protected static int rotateRight(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    protected final void LT() {
        int iRotateLeft = rotateLeft(this.X0, 13);
        int iRotateLeft2 = rotateLeft(this.X2, 3);
        int i = (this.X1 ^ iRotateLeft) ^ iRotateLeft2;
        int i2 = (this.X3 ^ iRotateLeft2) ^ (iRotateLeft << 3);
        this.X1 = rotateLeft(i, 1);
        int iRotateLeft3 = rotateLeft(i2, 7);
        this.X3 = iRotateLeft3;
        this.X0 = rotateLeft((iRotateLeft ^ this.X1) ^ iRotateLeft3, 5);
        this.X2 = rotateLeft((this.X3 ^ iRotateLeft2) ^ (this.X1 << 7), 22);
    }

    protected abstract void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2);

    protected abstract void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2);

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "Serpent";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    protected final void ib0(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i;
        int i7 = (i5 | i6) ^ i4;
        int i8 = i3 ^ i7;
        int i9 = i6 ^ i8;
        this.X2 = i9;
        int i10 = (i6 & i4) ^ i5;
        int i11 = (i9 & i10) ^ i7;
        this.X1 = i11;
        int i12 = (i & i7) ^ (i11 | i8);
        this.X3 = i12;
        this.X0 = i12 ^ (i10 ^ i8);
    }

    protected final void ib1(int i, int i2, int i3, int i4) {
        int i5 = i4 ^ i2;
        int i6 = i ^ (i2 & i5);
        int i7 = i5 ^ i6;
        int i8 = i3 ^ i7;
        this.X3 = i8;
        int i9 = i2 ^ (i5 & i6);
        int i10 = i6 ^ (i8 | i9);
        this.X1 = i10;
        int i11 = ~i10;
        int i12 = i9 ^ i8;
        this.X0 = i11 ^ i12;
        this.X2 = (i11 | i12) ^ i7;
    }

    protected final void ib2(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i4;
        int i6 = ~i5;
        int i7 = i ^ i3;
        int i8 = i3 ^ i5;
        int i9 = (i2 & i8) ^ i7;
        this.X0 = i9;
        int i10 = (((i | i6) ^ i4) | i7) ^ i5;
        this.X3 = i10;
        int i11 = ~i8;
        int i12 = i10 | i9;
        this.X1 = i11 ^ i12;
        this.X2 = (i12 ^ i7) ^ (i4 & i11);
    }

    protected final void ib3(int i, int i2, int i3, int i4) {
        int i5 = i | i2;
        int i6 = i2 ^ i3;
        int i7 = i ^ (i2 & i6);
        int i8 = i3 ^ i7;
        int i9 = i4 | i7;
        int i10 = i6 ^ i9;
        this.X0 = i10;
        int i11 = (i9 | i6) ^ i4;
        this.X2 = i8 ^ i11;
        int i12 = i5 ^ i11;
        int i13 = i7 ^ (i10 & i12);
        this.X3 = i13;
        this.X1 = i13 ^ (i12 ^ i10);
    }

    protected final void ib4(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ ((i3 | i4) & i);
        int i6 = i3 ^ (i & i5);
        int i7 = i4 ^ i6;
        this.X1 = i7;
        int i8 = ~i;
        int i9 = (i6 & i7) ^ i5;
        this.X3 = i9;
        int i10 = i4 ^ (i7 | i8);
        this.X0 = i9 ^ i10;
        this.X2 = (i8 ^ i7) ^ (i5 & i10);
    }

    protected final void ib5(int i, int i2, int i3, int i4) {
        int i5 = ~i3;
        int i6 = (i2 & i5) ^ i4;
        int i7 = i & i6;
        int i8 = (i2 ^ i5) ^ i7;
        this.X3 = i8;
        int i9 = i8 | i2;
        this.X1 = i6 ^ (i & i9);
        int i10 = i4 | i;
        this.X0 = (i5 ^ i9) ^ i10;
        this.X2 = ((i ^ i3) | i7) ^ (i2 & i10);
    }

    protected final void ib6(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        int i7 = i3 ^ i6;
        int i8 = (i3 | i5) ^ i4;
        this.X1 = i7 ^ i8;
        int i9 = i6 ^ (i7 & i8);
        int i10 = i8 ^ (i2 | i9);
        this.X3 = i10;
        int i11 = i2 | i10;
        this.X0 = i9 ^ i11;
        this.X2 = (i4 & i5) ^ (i11 ^ i7);
    }

    protected final void ib7(int i, int i2, int i3, int i4) {
        int i5 = (i & i2) | i3;
        int i6 = (i | i2) & i4;
        int i7 = i5 ^ i6;
        this.X3 = i7;
        int i8 = i2 ^ i6;
        int i9 = ((i7 ^ (~i4)) | i8) ^ i;
        this.X1 = i9;
        int i10 = (i8 ^ i3) ^ (i4 | i9);
        this.X0 = i10;
        this.X2 = ((i & i7) ^ i10) ^ (i5 ^ i9);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z;
            this.wKey = makeWorkingKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to " + getAlgorithmName() + " init - " + cipherParameters.getClass().getName());
    }

    protected final void inverseLT() {
        int iRotateRight = (rotateRight(this.X2, 22) ^ this.X3) ^ (this.X1 << 7);
        int iRotateRight2 = rotateRight(this.X0, 5) ^ this.X1;
        int i = this.X3;
        int i2 = iRotateRight2 ^ i;
        int iRotateRight3 = rotateRight(i, 7);
        int iRotateRight4 = rotateRight(this.X1, 1);
        this.X3 = (iRotateRight3 ^ iRotateRight) ^ (i2 << 3);
        this.X1 = (iRotateRight4 ^ i2) ^ iRotateRight;
        this.X2 = rotateRight(iRotateRight, 3);
        this.X0 = rotateRight(i2, 13);
    }

    protected abstract int[] makeWorkingKey(byte[] bArr);

    @Override // org.bouncycastle.crypto.BlockCipher
    public final int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.wKey == null) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
        decryptBlock(bArr, i, bArr2, i2);
        return 16;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }

    protected final void sb0(int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ i5;
        int i7 = i2 ^ i6;
        int i8 = (i4 & i) ^ i7;
        this.X3 = i8;
        int i9 = i ^ (i2 & i5);
        this.X2 = (i3 | i9) ^ i7;
        int i10 = (i6 ^ i9) & i8;
        this.X1 = (~i6) ^ i10;
        this.X0 = (~i9) ^ i10;
    }

    protected final void sb1(int i, int i2, int i3, int i4) {
        int i5 = (~i) ^ i2;
        int i6 = (i | i5) ^ i3;
        int i7 = i4 ^ i6;
        this.X2 = i7;
        int i8 = i2 ^ (i4 | i5);
        int i9 = i7 ^ i5;
        int i10 = (i6 & i8) ^ i9;
        this.X3 = i10;
        int i11 = i8 ^ i6;
        this.X1 = i10 ^ i11;
        this.X0 = i6 ^ (i11 & i9);
    }

    protected final void sb2(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i4;
        int i7 = (i3 & i5) ^ i6;
        this.X0 = i7;
        int i8 = i3 ^ i5;
        int i9 = i2 & (i3 ^ i7);
        int i10 = i8 ^ i9;
        this.X3 = i10;
        int i11 = i ^ ((i9 | i4) & (i7 | i8));
        this.X2 = i11;
        this.X1 = (i11 ^ (i4 | i5)) ^ (i6 ^ i10);
    }

    protected final void sb3(int i, int i2, int i3, int i4) {
        int i5 = i ^ i2;
        int i6 = i & i3;
        int i7 = i | i4;
        int i8 = i3 ^ i4;
        int i9 = i6 | (i5 & i7);
        int i10 = i8 ^ i9;
        this.X2 = i10;
        int i11 = (i7 ^ i2) ^ i9;
        int i12 = i5 ^ (i8 & i11);
        this.X0 = i12;
        int i13 = i12 & i10;
        this.X1 = i11 ^ i13;
        this.X3 = (i2 | i4) ^ (i8 ^ i13);
    }

    protected final void sb4(int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ (i4 & i5);
        int i7 = i2 | i6;
        this.X3 = i5 ^ i7;
        int i8 = ~i2;
        int i9 = (i5 | i8) ^ i6;
        this.X0 = i9;
        int i10 = i8 ^ i5;
        int i11 = (i7 & i10) ^ (i9 & i);
        this.X2 = i11;
        this.X1 = (i ^ i6) ^ (i10 & i11);
    }

    protected final void sb5(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        int i7 = i ^ i4;
        int i8 = (i3 ^ i5) ^ (i6 | i7);
        this.X0 = i8;
        int i9 = i4 & i8;
        int i10 = (i6 ^ i8) ^ i9;
        this.X1 = i10;
        int i11 = i7 ^ (i8 | i5);
        this.X2 = (i6 | i9) ^ i11;
        this.X3 = (i11 & i10) ^ (i2 ^ i9);
    }

    protected final void sb6(int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i4;
        int i7 = i2 ^ i6;
        int i8 = i3 ^ (i5 | i6);
        int i9 = i2 ^ i8;
        this.X1 = i9;
        int i10 = (i6 | i9) ^ i4;
        int i11 = (i8 & i10) ^ i7;
        this.X2 = i11;
        int i12 = i10 ^ i8;
        this.X0 = i11 ^ i12;
        this.X3 = (i12 & i7) ^ (~i8);
    }

    protected final void sb7(int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i3;
        int i6 = (i3 & i5) ^ i4;
        int i7 = i ^ i6;
        int i8 = i2 ^ ((i4 | i5) & i7);
        this.X1 = i8;
        int i9 = (i & i7) ^ i5;
        this.X3 = i9;
        int i10 = (i8 | i6) ^ i7;
        int i11 = i6 ^ (i9 & i10);
        this.X2 = i11;
        this.X0 = (i9 & i11) ^ (~i10);
    }
}
