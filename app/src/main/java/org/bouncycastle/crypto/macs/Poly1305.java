package org.bouncycastle.crypto.macs;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public class Poly1305 implements Mac {
    private final BlockCipher cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* JADX INFO: renamed from: h0 */
    private int f4445h0;

    /* JADX INFO: renamed from: h1 */
    private int f4446h1;

    /* JADX INFO: renamed from: h2 */
    private int f4447h2;

    /* JADX INFO: renamed from: h3 */
    private int f4448h3;

    /* JADX INFO: renamed from: h4 */
    private int f4449h4;

    /* JADX INFO: renamed from: k0 */
    private int f4450k0;

    /* JADX INFO: renamed from: k1 */
    private int f4451k1;

    /* JADX INFO: renamed from: k2 */
    private int f4452k2;

    /* JADX INFO: renamed from: k3 */
    private int f4453k3;

    /* JADX INFO: renamed from: r0 */
    private int f4454r0;

    /* JADX INFO: renamed from: r1 */
    private int f4455r1;

    /* JADX INFO: renamed from: r2 */
    private int f4456r2;

    /* JADX INFO: renamed from: r3 */
    private int f4457r3;

    /* JADX INFO: renamed from: r4 */
    private int f4458r4;

    /* JADX INFO: renamed from: s1 */
    private int f4459s1;

    /* JADX INFO: renamed from: s2 */
    private int f4460s2;

    /* JADX INFO: renamed from: s3 */
    private int f4461s3;

    /* JADX INFO: renamed from: s4 */
    private int f4462s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.cipher = null;
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
        }
        this.cipher = blockCipher;
    }

    private static final long mul32x32_64(int i, int i2) {
        return (((long) i) & BodyPartID.bodyIdMax) * ((long) i2);
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long jLittleEndianToInt = Pack.littleEndianToInt(this.currentBlock, 0);
        long j = jLittleEndianToInt & BodyPartID.bodyIdMax;
        long jLittleEndianToInt2 = ((long) Pack.littleEndianToInt(this.currentBlock, 4)) & BodyPartID.bodyIdMax;
        long jLittleEndianToInt3 = ((long) Pack.littleEndianToInt(this.currentBlock, 8)) & BodyPartID.bodyIdMax;
        long jLittleEndianToInt4 = BodyPartID.bodyIdMax & ((long) Pack.littleEndianToInt(this.currentBlock, 12));
        int i3 = (int) (((long) this.f4445h0) + (jLittleEndianToInt & 67108863));
        this.f4445h0 = i3;
        this.f4446h1 = (int) (((long) this.f4446h1) + ((((jLittleEndianToInt2 << 32) | j) >>> 26) & 67108863));
        this.f4447h2 = (int) (((long) this.f4447h2) + (((jLittleEndianToInt2 | (jLittleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f4448h3 = (int) (((long) this.f4448h3) + ((((jLittleEndianToInt4 << 32) | jLittleEndianToInt3) >>> 14) & 67108863));
        int i4 = (int) (((long) this.f4449h4) + (jLittleEndianToInt4 >>> 8));
        this.f4449h4 = i4;
        if (this.currentBlockOffset == 16) {
            this.f4449h4 = i4 + 16777216;
        }
        long jMul32x32_64 = mul32x32_64(i3, this.f4454r0) + mul32x32_64(this.f4446h1, this.f4462s4) + mul32x32_64(this.f4447h2, this.f4461s3) + mul32x32_64(this.f4448h3, this.f4460s2) + mul32x32_64(this.f4449h4, this.f4459s1);
        long jMul32x32_65 = mul32x32_64(this.f4445h0, this.f4455r1) + mul32x32_64(this.f4446h1, this.f4454r0) + mul32x32_64(this.f4447h2, this.f4462s4) + mul32x32_64(this.f4448h3, this.f4461s3) + mul32x32_64(this.f4449h4, this.f4460s2);
        long jMul32x32_66 = mul32x32_64(this.f4445h0, this.f4456r2) + mul32x32_64(this.f4446h1, this.f4455r1) + mul32x32_64(this.f4447h2, this.f4454r0) + mul32x32_64(this.f4448h3, this.f4462s4) + mul32x32_64(this.f4449h4, this.f4461s3);
        long jMul32x32_67 = mul32x32_64(this.f4445h0, this.f4457r3) + mul32x32_64(this.f4446h1, this.f4456r2) + mul32x32_64(this.f4447h2, this.f4455r1) + mul32x32_64(this.f4448h3, this.f4454r0) + mul32x32_64(this.f4449h4, this.f4462s4);
        long jMul32x32_68 = mul32x32_64(this.f4445h0, this.f4458r4) + mul32x32_64(this.f4446h1, this.f4457r3) + mul32x32_64(this.f4447h2, this.f4456r2) + mul32x32_64(this.f4448h3, this.f4455r1) + mul32x32_64(this.f4449h4, this.f4454r0);
        long j2 = jMul32x32_65 + (jMul32x32_64 >>> 26);
        long j3 = jMul32x32_66 + (j2 >>> 26);
        this.f4447h2 = ((int) j3) & 67108863;
        long j4 = jMul32x32_67 + (j3 >>> 26);
        this.f4448h3 = ((int) j4) & 67108863;
        long j5 = jMul32x32_68 + (j4 >>> 26);
        this.f4449h4 = ((int) j5) & 67108863;
        int i5 = (((int) jMul32x32_64) & 67108863) + (((int) (j5 >>> 26)) * 5);
        this.f4446h1 = (((int) j2) & 67108863) + (i5 >>> 26);
        this.f4445h0 = i5 & 67108863;
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        int i = 16;
        if (this.cipher != null && (bArr2 == null || bArr2.length != 16)) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        int iLittleEndianToInt = Pack.littleEndianToInt(bArr, 0);
        int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, 4);
        int iLittleEndianToInt3 = Pack.littleEndianToInt(bArr, 8);
        int iLittleEndianToInt4 = Pack.littleEndianToInt(bArr, 12);
        this.f4454r0 = 67108863 & iLittleEndianToInt;
        int i2 = ((iLittleEndianToInt >>> 26) | (iLittleEndianToInt2 << 6)) & 67108611;
        this.f4455r1 = i2;
        int i3 = ((iLittleEndianToInt2 >>> 20) | (iLittleEndianToInt3 << 12)) & 67092735;
        this.f4456r2 = i3;
        int i4 = ((iLittleEndianToInt3 >>> 14) | (iLittleEndianToInt4 << 18)) & 66076671;
        this.f4457r3 = i4;
        int i5 = (iLittleEndianToInt4 >>> 8) & 1048575;
        this.f4458r4 = i5;
        this.f4459s1 = i2 * 5;
        this.f4460s2 = i3 * 5;
        this.f4461s3 = i4 * 5;
        this.f4462s4 = i5 * 5;
        BlockCipher blockCipher = this.cipher;
        if (blockCipher != null) {
            byte[] bArr3 = new byte[16];
            blockCipher.init(true, new KeyParameter(bArr, 16, 16));
            this.cipher.processBlock(bArr2, 0, bArr3, 0);
            i = 0;
            bArr = bArr3;
        }
        this.f4450k0 = Pack.littleEndianToInt(bArr, i);
        this.f4451k1 = Pack.littleEndianToInt(bArr, i + 4);
        this.f4452k2 = Pack.littleEndianToInt(bArr, i + 8);
        this.f4453k3 = Pack.littleEndianToInt(bArr, i + 12);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i) throws IllegalStateException, DataLengthException {
        if (i + 16 > bArr.length) {
            throw new OutputLengthException("Output buffer is too short.");
        }
        if (this.currentBlockOffset > 0) {
            processBlock();
        }
        int i2 = this.f4446h1;
        int i3 = this.f4445h0;
        int i4 = i2 + (i3 >>> 26);
        int i5 = this.f4447h2 + (i4 >>> 26);
        int i6 = this.f4448h3 + (i5 >>> 26);
        int i7 = i5 & 67108863;
        int i8 = this.f4449h4 + (i6 >>> 26);
        int i9 = i6 & 67108863;
        int i10 = (i3 & 67108863) + ((i8 >>> 26) * 5);
        int i11 = i8 & 67108863;
        int i12 = (i4 & 67108863) + (i10 >>> 26);
        int i13 = i10 & 67108863;
        int i14 = i13 + 5;
        int i15 = (i14 >>> 26) + i12;
        int i16 = (i15 >>> 26) + i7;
        int i17 = (i16 >>> 26) + i9;
        int i18 = 67108863 & i17;
        int i19 = ((i17 >>> 26) + i11) - AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        int i20 = (i19 >>> 31) - 1;
        int i21 = ~i20;
        int i22 = (i13 & i21) | (i14 & 67108863 & i20);
        this.f4445h0 = i22;
        int i23 = (i12 & i21) | (i15 & 67108863 & i20);
        this.f4446h1 = i23;
        int i24 = (i7 & i21) | (i16 & 67108863 & i20);
        this.f4447h2 = i24;
        int i25 = (i18 & i20) | (i9 & i21);
        this.f4448h3 = i25;
        int i26 = (i11 & i21) | (i19 & i20);
        this.f4449h4 = i26;
        long j = (((long) (i22 | (i23 << 26))) & BodyPartID.bodyIdMax) + (((long) this.f4450k0) & BodyPartID.bodyIdMax);
        long j2 = (((long) ((i23 >>> 6) | (i24 << 20))) & BodyPartID.bodyIdMax) + (((long) this.f4451k1) & BodyPartID.bodyIdMax);
        long j3 = (((long) ((i24 >>> 12) | (i25 << 14))) & BodyPartID.bodyIdMax) + (((long) this.f4452k2) & BodyPartID.bodyIdMax);
        long j4 = (((long) ((i25 >>> 18) | (i26 << 8))) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & ((long) this.f4453k3));
        Pack.intToLittleEndian((int) j, bArr, i);
        long j5 = j2 + (j >>> 32);
        Pack.intToLittleEndian((int) j5, bArr, i + 4);
        long j6 = j3 + (j5 >>> 32);
        Pack.intToLittleEndian((int) j6, bArr, i + 8);
        Pack.intToLittleEndian((int) (j4 + (j6 >>> 32)), bArr, i + 12);
        reset();
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        if (this.cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) throws IllegalArgumentException {
        byte[] iv;
        if (this.cipher == null) {
            iv = null;
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            iv = parametersWithIV.getIV();
            cipherParameters = parametersWithIV.getParameters();
        }
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Poly1305 requires a key.");
        }
        setKey(((KeyParameter) cipherParameters).getKey(), iv);
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.currentBlockOffset = 0;
        this.f4449h4 = 0;
        this.f4448h3 = 0;
        this.f4447h2 = 0;
        this.f4446h1 = 0;
        this.f4445h0 = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b) throws IllegalStateException {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        update(bArr, 0, 1);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i, int i2) throws IllegalStateException, DataLengthException {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int iMin = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, iMin);
            i3 += iMin;
            this.currentBlockOffset += iMin;
        }
    }
}
