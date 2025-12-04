package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes6.dex */
public class PGPCFBBlockCipher implements BlockCipher {
    private byte[] FR;
    private byte[] FRE;
    private byte[] IV;
    private int blockSize;
    private BlockCipher cipher;
    private int count;
    private boolean forEncryption;
    private boolean inlineIv;
    private byte[] tmp;

    public PGPCFBBlockCipher(BlockCipher blockCipher, boolean z) {
        this.cipher = blockCipher;
        this.inlineIv = z;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        this.IV = new byte[blockSize];
        this.FR = new byte[blockSize];
        this.FRE = new byte[blockSize];
        this.tmp = new byte[blockSize];
    }

    private int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i4 = 0;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        for (int i5 = 0; i5 < this.blockSize; i5++) {
            bArr2[i2 + i5] = encryptByte(bArr[i + i5], i5);
        }
        while (true) {
            int i6 = this.blockSize;
            if (i4 >= i6) {
                return i6;
            }
            this.FR[i4] = bArr[i + i4];
            i4++;
        }
    }

    private int decryptBlockWithIV(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3;
        int i4 = this.blockSize;
        if (i + i4 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + i4 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i5 = this.count;
        if (i5 == 0) {
            for (int i6 = 0; i6 < this.blockSize; i6++) {
                this.FR[i6] = bArr[i + i6];
            }
            this.cipher.processBlock(this.FR, 0, this.FRE, 0);
            this.count += this.blockSize;
            return 0;
        }
        if (i5 != i4) {
            if (i5 >= i4 + 2) {
                System.arraycopy(bArr, i, this.tmp, 0, i4);
                bArr2[i2] = encryptByte(this.tmp[0], this.blockSize - 2);
                bArr2[i2 + 1] = encryptByte(this.tmp[1], this.blockSize - 1);
                System.arraycopy(this.tmp, 0, this.FR, this.blockSize - 2, 2);
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i7 = 0;
                while (true) {
                    i3 = this.blockSize;
                    if (i7 >= i3 - 2) {
                        break;
                    }
                    bArr2[i2 + i7 + 2] = encryptByte(this.tmp[i7 + 2], i7);
                    i7++;
                }
                System.arraycopy(this.tmp, 2, this.FR, 0, i3 - 2);
            }
            return this.blockSize;
        }
        System.arraycopy(bArr, i, this.tmp, 0, i4);
        byte[] bArr3 = this.FR;
        System.arraycopy(bArr3, 2, bArr3, 0, this.blockSize - 2);
        byte[] bArr4 = this.FR;
        int i8 = this.blockSize;
        byte[] bArr5 = this.tmp;
        bArr4[i8 - 2] = bArr5[0];
        bArr4[i8 - 1] = bArr5[1];
        this.cipher.processBlock(bArr4, 0, this.FRE, 0);
        int i9 = 0;
        while (true) {
            int i10 = this.blockSize;
            if (i9 >= i10 - 2) {
                System.arraycopy(this.tmp, 2, this.FR, 0, i10 - 2);
                this.count += 2;
                return this.blockSize - 2;
            }
            bArr2[i2 + i9] = encryptByte(this.tmp[i9 + 2], i9);
            i9++;
        }
    }

    private int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3 = this.blockSize;
        if (i + i3 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        int i4 = 0;
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        for (int i5 = 0; i5 < this.blockSize; i5++) {
            bArr2[i2 + i5] = encryptByte(bArr[i + i5], i5);
        }
        while (true) {
            int i6 = this.blockSize;
            if (i4 >= i6) {
                return i6;
            }
            this.FR[i4] = bArr2[i2 + i4];
            i4++;
        }
    }

    private int encryptBlockWithIV(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        int i3;
        int i4;
        int i5 = this.blockSize;
        if (i + i5 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        int i6 = this.count;
        if (i6 != 0) {
            if (i6 >= i5 + 2) {
                if (i5 + i2 > bArr2.length) {
                    throw new OutputLengthException("output buffer too short");
                }
                this.cipher.processBlock(this.FR, 0, this.FRE, 0);
                int i7 = 0;
                while (true) {
                    i3 = this.blockSize;
                    if (i7 >= i3) {
                        break;
                    }
                    bArr2[i2 + i7] = encryptByte(bArr[i + i7], i7);
                    i7++;
                }
                System.arraycopy(bArr2, i2, this.FR, 0, i3);
            }
            return this.blockSize;
        }
        if ((i5 * 2) + i2 + 2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int i8 = 0;
        while (true) {
            i4 = this.blockSize;
            if (i8 >= i4) {
                break;
            }
            bArr2[i2 + i8] = encryptByte(this.IV[i8], i8);
            i8++;
        }
        System.arraycopy(bArr2, i2, this.FR, 0, i4);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int i9 = this.blockSize;
        bArr2[i2 + i9] = encryptByte(this.IV[i9 - 2], 0);
        int i10 = this.blockSize;
        bArr2[i2 + i10 + 1] = encryptByte(this.IV[i10 - 1], 1);
        System.arraycopy(bArr2, i2 + 2, this.FR, 0, this.blockSize);
        this.cipher.processBlock(this.FR, 0, this.FRE, 0);
        int i11 = 0;
        while (true) {
            int i12 = this.blockSize;
            if (i11 >= i12) {
                System.arraycopy(bArr2, i2 + i12 + 2, this.FR, 0, i12);
                int i13 = this.count;
                int i14 = this.blockSize;
                this.count = i13 + (i14 * 2) + 2;
                return (i14 * 2) + 2;
            }
            bArr2[i12 + i2 + 2 + i11] = encryptByte(bArr[i + i11], i11);
            i11++;
        }
    }

    private byte encryptByte(byte b, int i) {
        return (byte) (this.FRE[i] ^ b);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        StringBuilder sb;
        String str;
        if (this.inlineIv) {
            sb = new StringBuilder();
            sb.append(this.cipher.getAlgorithmName());
            str = "/PGPCFBwithIV";
        } else {
            sb = new StringBuilder();
            sb.append(this.cipher.getAlgorithmName());
            str = "/PGPCFB";
        }
        sb.append(str);
        return sb.toString();
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.forEncryption = z;
        if (!(cipherParameters instanceof ParametersWithIV)) {
            reset();
            this.cipher.init(true, cipherParameters);
            return;
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] iv = parametersWithIV.getIV();
        int length = iv.length;
        byte[] bArr = this.IV;
        if (length < bArr.length) {
            System.arraycopy(iv, 0, bArr, bArr.length - iv.length, iv.length);
            int i = 0;
            while (true) {
                byte[] bArr2 = this.IV;
                if (i >= bArr2.length - iv.length) {
                    break;
                }
                bArr2[i] = 0;
                i++;
            }
        } else {
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
        }
        reset();
        this.cipher.init(true, parametersWithIV.getParameters());
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException, DataLengthException {
        return this.inlineIv ? this.forEncryption ? encryptBlockWithIV(bArr, i, bArr2, i2) : decryptBlockWithIV(bArr, i, bArr2, i2) : this.forEncryption ? encryptBlock(bArr, i, bArr2, i2) : decryptBlock(bArr, i, bArr2, i2);
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
        this.count = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.FR;
            if (i == bArr.length) {
                this.cipher.reset();
                return;
            }
            if (this.inlineIv) {
                bArr[i] = 0;
            } else {
                bArr[i] = this.IV[i];
            }
            i++;
        }
    }
}
