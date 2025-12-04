package org.bouncycastle.crypto.engines;

import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

/* loaded from: classes6.dex */
public class Salsa20Engine implements SkippingStreamCipher {
    public static final int DEFAULT_ROUNDS = 20;
    private static final int[] TAU_SIGMA = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
    protected static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
    protected static final byte[] tau = Strings.toByteArray("expand 16-byte k");
    private int cW0;
    private int cW1;
    private int cW2;
    protected int[] engineState;
    private int index;
    private boolean initialised;
    private byte[] keyStream;
    protected int rounds;
    protected int[] x;

    public Salsa20Engine() {
        this(20);
    }

    public Salsa20Engine(int i) {
        this.index = 0;
        this.engineState = new int[16];
        this.x = new int[16];
        this.keyStream = new byte[64];
        this.initialised = false;
        if (i <= 0 || (i & 1) != 0) {
            throw new IllegalArgumentException("'rounds' must be a positive, even number");
        }
        this.rounds = i;
    }

    private boolean limitExceeded() {
        int i = this.cW0 + 1;
        this.cW0 = i;
        if (i == 0) {
            int i2 = this.cW1 + 1;
            this.cW1 = i2;
            if (i2 == 0) {
                int i3 = this.cW2 + 1;
                this.cW2 = i3;
                return (i3 & 32) != 0;
            }
        }
        return false;
    }

    private boolean limitExceeded(int i) {
        int i2 = this.cW0 + i;
        this.cW0 = i2;
        if (i2 >= i || i2 < 0) {
            return false;
        }
        int i3 = this.cW1 + 1;
        this.cW1 = i3;
        if (i3 != 0) {
            return false;
        }
        int i4 = this.cW2 + 1;
        this.cW2 = i4;
        return (i4 & 32) != 0;
    }

    private void resetLimitCounter() {
        this.cW0 = 0;
        this.cW1 = 0;
        this.cW2 = 0;
    }

    public static void salsaCore(int i, int[] iArr, int[] iArr2) {
        if (iArr.length != 16) {
            throw new IllegalArgumentException();
        }
        if (iArr2.length != 16) {
            throw new IllegalArgumentException();
        }
        if (i % 2 != 0) {
            throw new IllegalArgumentException("Number of rounds must be even");
        }
        boolean z = false;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = 7;
        int i10 = iArr[7];
        int i11 = iArr[8];
        int i12 = 9;
        int i13 = iArr[9];
        int i14 = iArr[10];
        int i15 = iArr[11];
        int i16 = iArr[12];
        int i17 = 13;
        int i18 = iArr[13];
        int i19 = iArr[14];
        int iRotateLeft = iArr[15];
        int iRotateLeft2 = i19;
        int iRotateLeft3 = i18;
        int iRotateLeft4 = i16;
        int iRotateLeft5 = i15;
        int iRotateLeft6 = i14;
        int iRotateLeft7 = i13;
        int i20 = i11;
        int iRotateLeft8 = i10;
        int iRotateLeft9 = i8;
        int iRotateLeft10 = i7;
        int i21 = i6;
        int i22 = i5;
        int iRotateLeft11 = i4;
        int iRotateLeft12 = i3;
        int i23 = i2;
        int i24 = i;
        while (i24 > 0) {
            int iRotateLeft13 = Integers.rotateLeft(i23 + iRotateLeft4, i9) ^ i21;
            int iRotateLeft14 = i20 ^ Integers.rotateLeft(iRotateLeft13 + i23, i12);
            int iRotateLeft15 = iRotateLeft4 ^ Integers.rotateLeft(iRotateLeft14 + iRotateLeft13, i17);
            int iRotateLeft16 = Integers.rotateLeft(iRotateLeft15 + iRotateLeft14, 18) ^ i23;
            int iRotateLeft17 = iRotateLeft7 ^ Integers.rotateLeft(iRotateLeft10 + iRotateLeft12, i9);
            int iRotateLeft18 = iRotateLeft3 ^ Integers.rotateLeft(iRotateLeft17 + iRotateLeft10, i12);
            int iRotateLeft19 = iRotateLeft12 ^ Integers.rotateLeft(iRotateLeft18 + iRotateLeft17, i17);
            int iRotateLeft20 = Integers.rotateLeft(iRotateLeft19 + iRotateLeft18, 18) ^ iRotateLeft10;
            int iRotateLeft21 = iRotateLeft2 ^ Integers.rotateLeft(iRotateLeft6 + iRotateLeft9, 7);
            int iRotateLeft22 = iRotateLeft11 ^ Integers.rotateLeft(iRotateLeft21 + iRotateLeft6, 9);
            int iRotateLeft23 = iRotateLeft9 ^ Integers.rotateLeft(iRotateLeft22 + iRotateLeft21, 13);
            int iRotateLeft24 = iRotateLeft6 ^ Integers.rotateLeft(iRotateLeft23 + iRotateLeft22, 18);
            int iRotateLeft25 = i22 ^ Integers.rotateLeft(iRotateLeft + iRotateLeft5, 7);
            int iRotateLeft26 = iRotateLeft8 ^ Integers.rotateLeft(iRotateLeft25 + iRotateLeft, 9);
            int i25 = i24;
            int iRotateLeft27 = iRotateLeft5 ^ Integers.rotateLeft(iRotateLeft26 + iRotateLeft25, 13);
            int iRotateLeft28 = iRotateLeft ^ Integers.rotateLeft(iRotateLeft27 + iRotateLeft26, 18);
            iRotateLeft12 = iRotateLeft19 ^ Integers.rotateLeft(iRotateLeft16 + iRotateLeft25, 7);
            iRotateLeft11 = iRotateLeft22 ^ Integers.rotateLeft(iRotateLeft12 + iRotateLeft16, 9);
            int iRotateLeft29 = iRotateLeft25 ^ Integers.rotateLeft(iRotateLeft11 + iRotateLeft12, 13);
            int iRotateLeft30 = iRotateLeft16 ^ Integers.rotateLeft(iRotateLeft29 + iRotateLeft11, 18);
            iRotateLeft9 = iRotateLeft23 ^ Integers.rotateLeft(iRotateLeft20 + iRotateLeft13, 7);
            iRotateLeft8 = iRotateLeft26 ^ Integers.rotateLeft(iRotateLeft9 + iRotateLeft20, 9);
            int iRotateLeft31 = Integers.rotateLeft(iRotateLeft8 + iRotateLeft9, 13) ^ iRotateLeft13;
            iRotateLeft10 = iRotateLeft20 ^ Integers.rotateLeft(iRotateLeft31 + iRotateLeft8, 18);
            iRotateLeft5 = iRotateLeft27 ^ Integers.rotateLeft(iRotateLeft24 + iRotateLeft17, 7);
            int iRotateLeft32 = Integers.rotateLeft(iRotateLeft5 + iRotateLeft24, 9) ^ iRotateLeft14;
            iRotateLeft7 = iRotateLeft17 ^ Integers.rotateLeft(iRotateLeft32 + iRotateLeft5, 13);
            iRotateLeft6 = iRotateLeft24 ^ Integers.rotateLeft(iRotateLeft7 + iRotateLeft32, 18);
            iRotateLeft4 = iRotateLeft15 ^ Integers.rotateLeft(iRotateLeft28 + iRotateLeft21, 7);
            iRotateLeft3 = iRotateLeft18 ^ Integers.rotateLeft(iRotateLeft4 + iRotateLeft28, 9);
            iRotateLeft2 = iRotateLeft21 ^ Integers.rotateLeft(iRotateLeft3 + iRotateLeft4, 13);
            iRotateLeft = iRotateLeft28 ^ Integers.rotateLeft(iRotateLeft2 + iRotateLeft3, 18);
            i22 = iRotateLeft29;
            i20 = iRotateLeft32;
            i23 = iRotateLeft30;
            i21 = iRotateLeft31;
            z = false;
            i17 = 13;
            i12 = 9;
            i9 = 7;
            i24 = i25 - 2;
        }
        boolean z2 = z;
        iArr2[z2 ? 1 : 0] = i23 + iArr[z2 ? 1 : 0];
        iArr2[1] = iRotateLeft12 + iArr[1];
        iArr2[2] = iRotateLeft11 + iArr[2];
        iArr2[3] = i22 + iArr[3];
        iArr2[4] = i21 + iArr[4];
        iArr2[5] = iRotateLeft10 + iArr[5];
        iArr2[6] = iRotateLeft9 + iArr[6];
        iArr2[7] = iRotateLeft8 + iArr[7];
        iArr2[8] = i20 + iArr[8];
        iArr2[9] = iRotateLeft7 + iArr[9];
        iArr2[10] = iRotateLeft6 + iArr[10];
        iArr2[11] = iRotateLeft5 + iArr[11];
        iArr2[12] = iRotateLeft4 + iArr[12];
        iArr2[13] = iRotateLeft3 + iArr[13];
        iArr2[14] = iRotateLeft2 + iArr[14];
        iArr2[15] = iRotateLeft + iArr[15];
    }

    protected void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[8] + 1;
        iArr[8] = i;
        if (i == 0) {
            iArr[9] = iArr[9] + 1;
        }
    }

    protected void advanceCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i > 0) {
            int[] iArr = this.engineState;
            iArr[9] = iArr[9] + i;
        }
        int[] iArr2 = this.engineState;
        int i3 = iArr2[8];
        int i4 = i2 + i3;
        iArr2[8] = i4;
        if (i3 == 0 || i4 >= i3) {
            return;
        }
        iArr2[9] = iArr2[9] + 1;
    }

    protected void generateKeyStream(byte[] bArr) {
        salsaCore(this.rounds, this.engineState, this.x);
        Pack.intToLittleEndian(this.x, bArr, 0);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        if (this.rounds == 20) {
            return "Salsa20";
        }
        return "Salsa20/" + this.rounds;
    }

    protected long getCounter() {
        int[] iArr = this.engineState;
        return (iArr[9] << 32) | (iArr[8] & BodyPartID.bodyIdMax);
    }

    protected int getNonceSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long getPosition() {
        return (getCounter() * 64) + this.index;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        byte[] iv = parametersWithIV.getIV();
        if (iv == null || iv.length != getNonceSize()) {
            throw new IllegalArgumentException(getAlgorithmName() + " requires exactly " + getNonceSize() + " bytes of IV");
        }
        CipherParameters parameters = parametersWithIV.getParameters();
        if (parameters == null) {
            if (!this.initialised) {
                throw new IllegalStateException(getAlgorithmName() + " KeyParameter can not be null for first initialisation");
            }
            setKey(null, iv);
        } else {
            if (!(parameters instanceof KeyParameter)) {
                throw new IllegalArgumentException(getAlgorithmName() + " Init parameters must contain a KeyParameter (or null for re-init)");
            }
            setKey(((KeyParameter) parameters).getKey(), iv);
        }
        reset();
        this.initialised = true;
    }

    protected void packTauOrSigma(int i, int[] iArr, int i2) {
        int i3 = (i - 16) / 4;
        int[] iArr2 = TAU_SIGMA;
        iArr[i2] = iArr2[i3];
        iArr[i2 + 1] = iArr2[i3 + 1];
        iArr[i2 + 2] = iArr2[i3 + 2];
        iArr[i2 + 3] = iArr2[i3 + 3];
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (limitExceeded(i2)) {
            throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            byte[] bArr3 = this.keyStream;
            int i5 = this.index;
            bArr2[i4 + i3] = (byte) (bArr3[i5] ^ bArr[i4 + i]);
            int i6 = (i5 + 1) & 63;
            this.index = i6;
            if (i6 == 0) {
                advanceCounter();
                generateKeyStream(this.keyStream);
            }
        }
        return i2;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        this.index = 0;
        resetLimitCounter();
        resetCounter();
        generateKeyStream(this.keyStream);
    }

    protected void resetCounter() {
        int[] iArr = this.engineState;
        iArr[9] = 0;
        iArr[8] = 0;
    }

    protected void retreatCounter() {
        int[] iArr = this.engineState;
        int i = iArr[8];
        if (i == 0 && iArr[9] == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int i2 = i - 1;
        iArr[8] = i2;
        if (i2 == -1) {
            iArr[9] = iArr[9] - 1;
        }
    }

    protected void retreatCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i != 0) {
            int[] iArr = this.engineState;
            int i3 = iArr[9];
            if ((i3 & BodyPartID.bodyIdMax) < (i & BodyPartID.bodyIdMax)) {
                throw new IllegalStateException("attempt to reduce counter past zero.");
            }
            iArr[9] = i3 - i;
        }
        int[] iArr2 = this.engineState;
        int i4 = iArr2[8];
        if ((i4 & BodyPartID.bodyIdMax) >= (BodyPartID.bodyIdMax & i2)) {
            iArr2[8] = i4 - i2;
            return;
        }
        int i5 = iArr2[9];
        if (i5 == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr2[9] = i5 - 1;
        iArr2[8] = i4 - i2;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        if (limitExceeded()) {
            throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
        }
        byte[] bArr = this.keyStream;
        int i = this.index;
        byte b2 = (byte) (b ^ bArr[i]);
        int i2 = (i + 1) & 63;
        this.index = i2;
        if (i2 == 0) {
            advanceCounter();
            generateKeyStream(this.keyStream);
        }
        return b2;
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long seekTo(long j) {
        reset();
        return skip(j);
    }

    protected void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 16 && bArr.length != 32) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 128 bit or 256 bit key");
            }
            int length = (bArr.length - 16) / 4;
            int[] iArr = this.engineState;
            int[] iArr2 = TAU_SIGMA;
            iArr[0] = iArr2[length];
            iArr[5] = iArr2[length + 1];
            iArr[10] = iArr2[length + 2];
            iArr[15] = iArr2[length + 3];
            Pack.littleEndianToInt(bArr, 0, iArr, 1, 4);
            Pack.littleEndianToInt(bArr, bArr.length - 16, this.engineState, 11, 4);
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 6, 2);
    }

    @Override // org.bouncycastle.crypto.SkippingCipher
    public long skip(long j) {
        long j2;
        if (j >= 0) {
            if (j >= 64) {
                long j3 = j / 64;
                advanceCounter(j3);
                j2 = j - (j3 * 64);
            } else {
                j2 = j;
            }
            int i = this.index;
            int i2 = (((int) j2) + i) & 63;
            this.index = i2;
            if (i2 < i) {
                advanceCounter();
            }
        } else {
            long j4 = -j;
            if (j4 >= 64) {
                long j5 = j4 / 64;
                retreatCounter(j5);
                j4 -= j5 * 64;
            }
            for (long j6 = 0; j6 < j4; j6++) {
                if (this.index == 0) {
                    retreatCounter();
                }
                this.index = (this.index - 1) & 63;
            }
        }
        generateKeyStream(this.keyStream);
        return j;
    }
}
