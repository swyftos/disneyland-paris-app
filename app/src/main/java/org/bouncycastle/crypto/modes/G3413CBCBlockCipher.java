package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class G3413CBCBlockCipher implements BlockCipher {

    /* JADX INFO: renamed from: R */
    private byte[] f4483R;
    private byte[] R_init;
    private int blockSize;
    private BlockCipher cipher;
    private boolean forEncryption;
    private boolean initialized = false;

    /* JADX INFO: renamed from: m */
    private int f4484m;

    public G3413CBCBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        this.cipher = blockCipher;
    }

    private int decrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArrMSB = GOST3413CipherUtil.MSB(this.f4483R, this.blockSize);
        byte[] bArrCopyFromInput = GOST3413CipherUtil.copyFromInput(bArr, this.blockSize, i);
        byte[] bArr3 = new byte[bArrCopyFromInput.length];
        this.cipher.processBlock(bArrCopyFromInput, 0, bArr3, 0);
        byte[] bArrSum = GOST3413CipherUtil.sum(bArr3, bArrMSB);
        System.arraycopy(bArrSum, 0, bArr2, i2, bArrSum.length);
        if (bArr2.length > i2 + bArrSum.length) {
            generateR(bArrCopyFromInput);
        }
        return bArrSum.length;
    }

    private int encrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        byte[] bArrSum = GOST3413CipherUtil.sum(GOST3413CipherUtil.copyFromInput(bArr, this.blockSize, i), GOST3413CipherUtil.MSB(this.f4483R, this.blockSize));
        int length = bArrSum.length;
        byte[] bArr3 = new byte[length];
        this.cipher.processBlock(bArrSum, 0, bArr3, 0);
        System.arraycopy(bArr3, 0, bArr2, i2, length);
        if (bArr2.length > i2 + bArrSum.length) {
            generateR(bArr3);
        }
        return length;
    }

    private void generateR(byte[] bArr) {
        byte[] bArrLSB = GOST3413CipherUtil.LSB(this.f4483R, this.f4484m - this.blockSize);
        System.arraycopy(bArrLSB, 0, this.f4483R, 0, bArrLSB.length);
        System.arraycopy(bArr, 0, this.f4483R, bArrLSB.length, this.f4484m - bArrLSB.length);
    }

    private void initArrays() {
        int i = this.f4484m;
        this.f4483R = new byte[i];
        this.R_init = new byte[i];
    }

    private void setupDefaultParams() {
        this.f4484m = this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CBC";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.forEncryption = z;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            if (iv.length < this.blockSize) {
                throw new IllegalArgumentException("Parameter m must blockSize <= m");
            }
            this.f4484m = iv.length;
            initArrays();
            byte[] bArrClone = Arrays.clone(iv);
            this.R_init = bArrClone;
            System.arraycopy(bArrClone, 0, this.f4483R, 0, bArrClone.length);
            if (parametersWithIV.getParameters() != null) {
                blockCipher = this.cipher;
                cipherParameters = parametersWithIV.getParameters();
                blockCipher.init(z, cipherParameters);
            }
        } else {
            setupDefaultParams();
            initArrays();
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.f4483R, 0, bArr.length);
            if (cipherParameters != null) {
                blockCipher = this.cipher;
                blockCipher.init(z, cipherParameters);
            }
        }
        this.initialized = true;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        return this.forEncryption ? encrypt(bArr, i, bArr2, i2) : decrypt(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        if (this.initialized) {
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.f4483R, 0, bArr.length);
            this.cipher.reset();
        }
    }
}
