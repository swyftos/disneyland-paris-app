package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public abstract class LongDigest implements ExtendedDigest, Memoable, EncodableDigest {

    /* JADX INFO: renamed from: K */
    static final long[] f4203K = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};

    /* JADX INFO: renamed from: H1 */
    protected long f4204H1;

    /* JADX INFO: renamed from: H2 */
    protected long f4205H2;

    /* JADX INFO: renamed from: H3 */
    protected long f4206H3;

    /* JADX INFO: renamed from: H4 */
    protected long f4207H4;

    /* JADX INFO: renamed from: H5 */
    protected long f4208H5;

    /* JADX INFO: renamed from: H6 */
    protected long f4209H6;

    /* JADX INFO: renamed from: H7 */
    protected long f4210H7;

    /* JADX INFO: renamed from: H8 */
    protected long f4211H8;

    /* JADX INFO: renamed from: W */
    private long[] f4212W;
    private long byteCount1;
    private long byteCount2;
    private int wOff;
    private byte[] xBuf;
    private int xBufOff;

    protected LongDigest() {
        this.xBuf = new byte[8];
        this.f4212W = new long[80];
        this.xBufOff = 0;
        reset();
    }

    protected LongDigest(LongDigest longDigest) {
        this.xBuf = new byte[8];
        this.f4212W = new long[80];
        copyIn(longDigest);
    }

    /* JADX INFO: renamed from: Ch */
    private long m2005Ch(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    private long Maj(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    private long Sigma0(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    private long Sigma1(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    private long Sum0(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    private long Sum1(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    private void adjustByteCounts() {
        long j = this.byteCount1;
        if (j > 2305843009213693951L) {
            this.byteCount2 += j >>> 61;
            this.byteCount1 = j & 2305843009213693951L;
        }
    }

    protected void copyIn(LongDigest longDigest) {
        byte[] bArr = longDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = longDigest.xBufOff;
        this.byteCount1 = longDigest.byteCount1;
        this.byteCount2 = longDigest.byteCount2;
        this.f4204H1 = longDigest.f4204H1;
        this.f4205H2 = longDigest.f4205H2;
        this.f4206H3 = longDigest.f4206H3;
        this.f4207H4 = longDigest.f4207H4;
        this.f4208H5 = longDigest.f4208H5;
        this.f4209H6 = longDigest.f4209H6;
        this.f4210H7 = longDigest.f4210H7;
        this.f4211H8 = longDigest.f4211H8;
        long[] jArr = longDigest.f4212W;
        System.arraycopy(jArr, 0, this.f4212W, 0, jArr.length);
        this.wOff = longDigest.wOff;
    }

    public void finish() {
        adjustByteCounts();
        long j = this.byteCount1 << 3;
        long j2 = this.byteCount2;
        byte b = -128;
        while (true) {
            update(b);
            if (this.xBufOff == 0) {
                processLength(j, j2);
                processBlock();
                return;
            }
            b = 0;
        }
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 128;
    }

    protected int getEncodedStateSize() {
        return (this.wOff * 8) + 96;
    }

    protected void populateState(byte[] bArr) {
        System.arraycopy(this.xBuf, 0, bArr, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, bArr, 8);
        Pack.longToBigEndian(this.byteCount1, bArr, 12);
        Pack.longToBigEndian(this.byteCount2, bArr, 20);
        Pack.longToBigEndian(this.f4204H1, bArr, 28);
        Pack.longToBigEndian(this.f4205H2, bArr, 36);
        Pack.longToBigEndian(this.f4206H3, bArr, 44);
        Pack.longToBigEndian(this.f4207H4, bArr, 52);
        Pack.longToBigEndian(this.f4208H5, bArr, 60);
        Pack.longToBigEndian(this.f4209H6, bArr, 68);
        Pack.longToBigEndian(this.f4210H7, bArr, 76);
        Pack.longToBigEndian(this.f4211H8, bArr, 84);
        Pack.intToBigEndian(this.wOff, bArr, 92);
        for (int i = 0; i < this.wOff; i++) {
            Pack.longToBigEndian(this.f4212W[i], bArr, (i * 8) + 96);
        }
    }

    protected void processBlock() {
        adjustByteCounts();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.f4212W;
            long jSigma1 = Sigma1(jArr[i - 2]);
            long[] jArr2 = this.f4212W;
            jArr[i] = jSigma1 + jArr2[i - 7] + Sigma0(jArr2[i - 15]) + this.f4212W[i - 16];
        }
        long j = this.f4204H1;
        long j2 = this.f4205H2;
        long j3 = this.f4206H3;
        long j4 = this.f4207H4;
        long j5 = this.f4208H5;
        long j6 = this.f4209H6;
        long j7 = this.f4210H7;
        long j8 = j6;
        long j9 = j4;
        int i2 = 0;
        long jSum0 = j2;
        long j10 = j3;
        long j11 = j5;
        int i3 = 0;
        long j12 = this.f4211H8;
        long j13 = j;
        long j14 = j7;
        while (i3 < 10) {
            long j15 = j11;
            long jSum1 = Sum1(j11) + m2005Ch(j11, j8, j14);
            long[] jArr3 = f4203K;
            int i4 = i2 + 1;
            long j16 = j12 + jSum1 + jArr3[i2] + this.f4212W[i2];
            long j17 = j9 + j16;
            long jSum2 = j16 + Sum0(j13) + Maj(j13, jSum0, j10);
            int i5 = i2 + 2;
            long jSum3 = j14 + Sum1(j17) + m2005Ch(j17, j15, j8) + jArr3[i4] + this.f4212W[i4];
            long j18 = j10 + jSum3;
            long jSum4 = jSum3 + Sum0(jSum2) + Maj(jSum2, j13, jSum0);
            int i6 = i2 + 3;
            long jSum5 = j8 + Sum1(j18) + m2005Ch(j18, j17, j15) + jArr3[i5] + this.f4212W[i5];
            long j19 = jSum0 + jSum5;
            long jSum6 = jSum5 + Sum0(jSum4) + Maj(jSum4, jSum2, j13);
            int i7 = i2 + 4;
            long jSum7 = j15 + Sum1(j19) + m2005Ch(j19, j18, j17) + jArr3[i6] + this.f4212W[i6];
            long j20 = j13 + jSum7;
            long jSum8 = jSum7 + Sum0(jSum6) + Maj(jSum6, jSum4, jSum2);
            int i8 = i2 + 5;
            long jSum9 = j17 + Sum1(j20) + m2005Ch(j20, j19, j18) + jArr3[i7] + this.f4212W[i7];
            long j21 = jSum2 + jSum9;
            long jSum10 = jSum9 + Sum0(jSum8) + Maj(jSum8, jSum6, jSum4);
            int i9 = i2 + 6;
            long jSum11 = j18 + Sum1(j21) + m2005Ch(j21, j20, j19) + jArr3[i8] + this.f4212W[i8];
            long j22 = jSum4 + jSum11;
            long jSum12 = jSum11 + Sum0(jSum10) + Maj(jSum10, jSum8, jSum6);
            int i10 = i2 + 7;
            long jSum13 = j19 + Sum1(j22) + m2005Ch(j22, j21, j20) + jArr3[i9] + this.f4212W[i9];
            long j23 = jSum6 + jSum13;
            j9 = jSum10;
            jSum0 = jSum13 + Sum0(jSum12) + Maj(jSum12, jSum10, jSum8);
            i2 += 8;
            long jSum14 = j20 + Sum1(j23) + m2005Ch(j23, j22, j21) + jArr3[i10] + this.f4212W[i10];
            long jSum15 = jSum14 + Sum0(jSum0) + Maj(jSum0, jSum12, j9);
            i3++;
            j11 = jSum8 + jSum14;
            j10 = jSum12;
            j12 = j21;
            j13 = jSum15;
            j8 = j23;
            j14 = j22;
        }
        this.f4204H1 += j13;
        this.f4205H2 += jSum0;
        this.f4206H3 += j10;
        this.f4207H4 += j9;
        this.f4208H5 += j11;
        this.f4209H6 += j8;
        this.f4210H7 += j14;
        this.f4211H8 += j12;
        this.wOff = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.f4212W[i11] = 0;
        }
    }

    protected void processLength(long j, long j2) {
        if (this.wOff > 14) {
            processBlock();
        }
        long[] jArr = this.f4212W;
        jArr[14] = j2;
        jArr[15] = j;
    }

    protected void processWord(byte[] bArr, int i) {
        this.f4212W[this.wOff] = Pack.bigEndianToLong(bArr, i);
        int i2 = this.wOff + 1;
        this.wOff = i2;
        if (i2 == 16) {
            processBlock();
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.byteCount1 = 0L;
        this.byteCount2 = 0L;
        int i = 0;
        this.xBufOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.wOff = 0;
        while (true) {
            long[] jArr = this.f4212W;
            if (i == jArr.length) {
                return;
            }
            jArr[i] = 0;
            i++;
        }
    }

    protected void restoreState(byte[] bArr) {
        int iBigEndianToInt = Pack.bigEndianToInt(bArr, 8);
        this.xBufOff = iBigEndianToInt;
        System.arraycopy(bArr, 0, this.xBuf, 0, iBigEndianToInt);
        this.byteCount1 = Pack.bigEndianToLong(bArr, 12);
        this.byteCount2 = Pack.bigEndianToLong(bArr, 20);
        this.f4204H1 = Pack.bigEndianToLong(bArr, 28);
        this.f4205H2 = Pack.bigEndianToLong(bArr, 36);
        this.f4206H3 = Pack.bigEndianToLong(bArr, 44);
        this.f4207H4 = Pack.bigEndianToLong(bArr, 52);
        this.f4208H5 = Pack.bigEndianToLong(bArr, 60);
        this.f4209H6 = Pack.bigEndianToLong(bArr, 68);
        this.f4210H7 = Pack.bigEndianToLong(bArr, 76);
        this.f4211H8 = Pack.bigEndianToLong(bArr, 84);
        this.wOff = Pack.bigEndianToInt(bArr, 92);
        for (int i = 0; i < this.wOff; i++) {
            this.f4212W[i] = Pack.bigEndianToLong(bArr, (i * 8) + 96);
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b) {
        byte[] bArr = this.xBuf;
        int i = this.xBufOff;
        int i2 = i + 1;
        this.xBufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount1++;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i, int i2) {
        while (this.xBufOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.xBuf.length) {
            processWord(bArr, i);
            byte[] bArr2 = this.xBuf;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.byteCount1 += (long) bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }
}
