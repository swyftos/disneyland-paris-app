package org.bouncycastle.math.p183ec.rfc8032;

import androidx.media3.extractor.p007ts.PsExtractor;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.math.p183ec.rfc7748.X25519;
import org.bouncycastle.math.p183ec.rfc7748.X25519Field;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public abstract class Ed25519 {
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 32;
    public static final int SECRET_KEY_SIZE = 32;
    public static final int SIGNATURE_SIZE = 64;
    private static final byte[] DOM2_PREFIX = {83, 105, 103, 69, 100, 50, 53, 53, 49, 57, 32, 110, 111, 32, 69, 100, 50, 53, 53, 49, 57, 32, 99, 111, 108, 108, 105, 115, 105, 111, 110, 115};

    /* JADX INFO: renamed from: P */
    private static final int[] f4774P = {-19, -1, -1, -1, -1, -1, -1, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: L */
    private static final int[] f4773L = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};
    private static final int[] B_x = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};
    private static final int[] B_y = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};
    private static final int[] C_d = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};
    private static final int[] C_d2 = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};
    private static final int[] C_d4 = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};
    private static final Object precompLock = new Object();
    private static PointExt[] precompBaseTable = null;
    private static int[] precompBase = null;

    public static final class Algorithm {
        public static final int Ed25519 = 0;
        public static final int Ed25519ctx = 1;
        public static final int Ed25519ph = 2;
    }

    private static class PointAccum {

        /* JADX INFO: renamed from: u */
        int[] f4775u;

        /* JADX INFO: renamed from: v */
        int[] f4776v;

        /* JADX INFO: renamed from: x */
        int[] f4777x;

        /* JADX INFO: renamed from: y */
        int[] f4778y;

        /* JADX INFO: renamed from: z */
        int[] f4779z;

        private PointAccum() {
            this.f4777x = X25519Field.create();
            this.f4778y = X25519Field.create();
            this.f4779z = X25519Field.create();
            this.f4775u = X25519Field.create();
            this.f4776v = X25519Field.create();
        }
    }

    private static class PointAffine {

        /* JADX INFO: renamed from: x */
        int[] f4780x;

        /* JADX INFO: renamed from: y */
        int[] f4781y;

        private PointAffine() {
            this.f4780x = X25519Field.create();
            this.f4781y = X25519Field.create();
        }
    }

    private static class PointExt {

        /* JADX INFO: renamed from: t */
        int[] f4782t;

        /* JADX INFO: renamed from: x */
        int[] f4783x;

        /* JADX INFO: renamed from: y */
        int[] f4784y;

        /* JADX INFO: renamed from: z */
        int[] f4785z;

        private PointExt() {
            this.f4783x = X25519Field.create();
            this.f4784y = X25519Field.create();
            this.f4785z = X25519Field.create();
            this.f4782t = X25519Field.create();
        }
    }

    private static class PointPrecomp {
        int[] xyd;
        int[] ymx_h;
        int[] ypx_h;

        private PointPrecomp() {
            this.ypx_h = X25519Field.create();
            this.ymx_h = X25519Field.create();
            this.xyd = X25519Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[8];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[8];
        decodeScalar(bArr3, 0, iArr3);
        Nat256.mulAddTo(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i = 0; i < 16; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr, byte b) {
        return (bArr == null && b == 0) || (bArr != null && bArr.length < 256);
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        int[] iArrCreate3 = X25519Field.create();
        X25519Field.sqr(iArr, iArrCreate2);
        X25519Field.sqr(iArr2, iArrCreate3);
        X25519Field.mul(iArrCreate2, iArrCreate3, iArrCreate);
        X25519Field.sub(iArrCreate3, iArrCreate2, iArrCreate3);
        X25519Field.mul(iArrCreate, C_d, iArrCreate);
        X25519Field.addOne(iArrCreate);
        X25519Field.sub(iArrCreate, iArrCreate3, iArrCreate);
        X25519Field.normalize(iArrCreate);
        return X25519Field.isZero(iArrCreate);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        int[] iArrCreate3 = X25519Field.create();
        int[] iArrCreate4 = X25519Field.create();
        X25519Field.sqr(iArr, iArrCreate2);
        X25519Field.sqr(iArr2, iArrCreate3);
        X25519Field.sqr(iArr3, iArrCreate4);
        X25519Field.mul(iArrCreate2, iArrCreate3, iArrCreate);
        X25519Field.sub(iArrCreate3, iArrCreate2, iArrCreate3);
        X25519Field.mul(iArrCreate3, iArrCreate4, iArrCreate3);
        X25519Field.sqr(iArrCreate4, iArrCreate4);
        X25519Field.mul(iArrCreate, C_d, iArrCreate);
        X25519Field.add(iArrCreate, iArrCreate4, iArrCreate);
        X25519Field.sub(iArrCreate, iArrCreate3, iArrCreate);
        X25519Field.normalize(iArrCreate);
        return X25519Field.isZero(iArrCreate);
    }

    private static boolean checkPointVar(byte[] bArr) {
        int[] iArr = new int[8];
        decode32(bArr, 0, iArr, 0, 8);
        iArr[7] = iArr[7] & Integer.MAX_VALUE;
        return !Nat256.gte(iArr, f4774P);
    }

    private static boolean checkScalarVar(byte[] bArr) {
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        return !Nat256.gte(iArr, f4773L);
    }

    private static Digest createDigest() {
        return new SHA512Digest();
    }

    public static Digest createPrehash() {
        return createDigest();
    }

    private static int decode24(byte[] bArr, int i) {
        return ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
    }

    private static int decode32(byte[] bArr, int i) {
        return (bArr[i + 3] << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private static void decode32(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = decode32(bArr, (i4 * 4) + i);
        }
    }

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointAffine pointAffine) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i + 32);
        if (!checkPointVar(bArrCopyOfRange)) {
            return false;
        }
        byte b = bArrCopyOfRange[31];
        int i2 = (b & 128) >>> 7;
        bArrCopyOfRange[31] = (byte) (b & 127);
        X25519Field.decode(bArrCopyOfRange, 0, pointAffine.f4781y);
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        X25519Field.sqr(pointAffine.f4781y, iArrCreate);
        X25519Field.mul(C_d, iArrCreate, iArrCreate2);
        X25519Field.subOne(iArrCreate);
        X25519Field.addOne(iArrCreate2);
        if (!X25519Field.sqrtRatioVar(iArrCreate, iArrCreate2, pointAffine.f4780x)) {
            return false;
        }
        X25519Field.normalize(pointAffine.f4780x);
        if (i2 == 1 && X25519Field.isZeroVar(pointAffine.f4780x)) {
            return false;
        }
        int[] iArr = pointAffine.f4780x;
        if (z ^ (i2 != (iArr[0] & 1))) {
            X25519Field.negate(iArr, iArr);
        }
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 8);
    }

    private static void dom2(Digest digest, byte b, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = DOM2_PREFIX;
            int length = bArr2.length;
            int i = length + 2;
            int length2 = bArr.length + i;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr2, 0, bArr3, 0, length);
            bArr3[length] = b;
            bArr3[length + 1] = (byte) bArr.length;
            System.arraycopy(bArr, 0, bArr3, i, bArr.length);
            digest.update(bArr3, 0, length2);
        }
    }

    private static void encode24(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
    }

    private static void encode32(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 3] = (byte) (i >>> 24);
    }

    private static void encode56(long j, byte[] bArr, int i) {
        encode32((int) j, bArr, i);
        encode24((int) (j >>> 32), bArr, i + 4);
    }

    private static int encodePoint(PointAccum pointAccum, byte[] bArr, int i) {
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        X25519Field.inv(pointAccum.f4779z, iArrCreate2);
        X25519Field.mul(pointAccum.f4777x, iArrCreate2, iArrCreate);
        X25519Field.mul(pointAccum.f4778y, iArrCreate2, iArrCreate2);
        X25519Field.normalize(iArrCreate);
        X25519Field.normalize(iArrCreate2);
        int iCheckPoint = checkPoint(iArrCreate, iArrCreate2);
        X25519Field.encode(iArrCreate2, bArr, i);
        int i2 = i + 31;
        bArr[i2] = (byte) (((iArrCreate[0] & 1) << 7) | bArr[i2]);
        return iCheckPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Digest digestCreateDigest = createDigest();
        byte[] bArr3 = new byte[digestCreateDigest.getDigestSize()];
        digestCreateDigest.update(bArr, i, 32);
        digestCreateDigest.doFinal(bArr3, 0);
        byte[] bArr4 = new byte[32];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
        int[] iArr2 = new int[16];
        int i2 = 0;
        int i3 = 8;
        int i4 = 16;
        int i5 = 0;
        while (true) {
            i3--;
            if (i3 < 0) {
                break;
            }
            int i6 = iArr[i3];
            iArr2[i4 - 1] = (i5 << 16) | (i6 >>> 16);
            i4 -= 2;
            iArr2[i4] = i6;
            i5 = i6;
        }
        byte[] bArr = new byte[253];
        int i7 = 1 << i;
        int i8 = i7 - 1;
        int i9 = i7 >>> 1;
        int i10 = 0;
        int i11 = 0;
        while (i2 < 16) {
            int i12 = iArr2[i2];
            while (i10 < 16) {
                int i13 = i12 >>> i10;
                if ((i13 & 1) == i11) {
                    i10++;
                } else {
                    int i14 = (i13 & i8) + i11;
                    int i15 = i14 & i9;
                    int i16 = i14 - (i15 << 1);
                    i11 = i15 >>> (i - 1);
                    bArr[(i2 << 4) + i10] = (byte) i16;
                    i10 += i;
                }
            }
            i2++;
            i10 -= 16;
        }
        return bArr;
    }

    private static void implSign(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom2(digest, b, bArr4);
        digest.update(bArr, 32, 32);
        digest.update(bArr5, i2, i3);
        digest.doFinal(bArr, 0);
        byte[] bArrReduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(bArrReduceScalar, bArr7, 0);
        dom2(digest, b, bArr4);
        digest.update(bArr7, 0, 32);
        digest.update(bArr3, i, 32);
        digest.update(bArr5, i2, i3);
        digest.doFinal(bArr, 0);
        byte[] bArrCalculateS = calculateS(bArrReduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 32);
        System.arraycopy(bArrCalculateS, 0, bArr6, i4 + 32, 32);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (!checkContextVar(bArr2, b)) {
            throw new IllegalArgumentException("ctx");
        }
        Digest digestCreateDigest = createDigest();
        byte[] bArr5 = new byte[digestCreateDigest.getDigestSize()];
        digestCreateDigest.update(bArr, i, 32);
        digestCreateDigest.doFinal(bArr5, 0);
        byte[] bArr6 = new byte[32];
        pruneScalar(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[32];
        scalarMultBaseEncoded(bArr6, bArr7, 0);
        implSign(digestCreateDigest, bArr5, bArr6, bArr7, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!checkContextVar(bArr3, b)) {
            throw new IllegalArgumentException("ctx");
        }
        Digest digestCreateDigest = createDigest();
        byte[] bArr6 = new byte[digestCreateDigest.getDigestSize()];
        digestCreateDigest.update(bArr, i, 32);
        digestCreateDigest.doFinal(bArr6, 0);
        byte[] bArr7 = new byte[32];
        pruneScalar(bArr6, 0, bArr7);
        implSign(digestCreateDigest, bArr6, bArr7, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        if (!checkContextVar(bArr3, b)) {
            throw new IllegalArgumentException("ctx");
        }
        int i5 = i + 32;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i5);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i5, i + 64);
        if (!checkPointVar(bArrCopyOfRange) || !checkScalarVar(bArrCopyOfRange2)) {
            return false;
        }
        PointAffine pointAffine = new PointAffine();
        if (!decodePointVar(bArr2, i2, true, pointAffine)) {
            return false;
        }
        Digest digestCreateDigest = createDigest();
        byte[] bArr5 = new byte[digestCreateDigest.getDigestSize()];
        dom2(digestCreateDigest, b, bArr3);
        digestCreateDigest.update(bArrCopyOfRange, 0, 32);
        digestCreateDigest.update(bArr2, i2, 32);
        digestCreateDigest.update(bArr4, i3, i4);
        digestCreateDigest.doFinal(bArr5, 0);
        byte[] bArrReduceScalar = reduceScalar(bArr5);
        int[] iArr = new int[8];
        decodeScalar(bArrCopyOfRange2, 0, iArr);
        int[] iArr2 = new int[8];
        decodeScalar(bArrReduceScalar, 0, iArr2);
        PointAccum pointAccum = new PointAccum();
        scalarMultStrausVar(iArr, iArr2, pointAffine, pointAccum);
        byte[] bArr6 = new byte[32];
        return encodePoint(pointAccum, bArr6, 0) != 0 && Arrays.areEqual(bArr6, bArrCopyOfRange);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointAccum pointAccum) {
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        int[] iArrCreate3 = X25519Field.create();
        int[] iArr = pointAccum.f4775u;
        int[] iArrCreate4 = X25519Field.create();
        int[] iArrCreate5 = X25519Field.create();
        int[] iArr2 = pointAccum.f4776v;
        X25519Field.apm(pointAccum.f4778y, pointAccum.f4777x, iArrCreate2, iArrCreate);
        X25519Field.mul(iArrCreate, pointPrecomp.ymx_h, iArrCreate);
        X25519Field.mul(iArrCreate2, pointPrecomp.ypx_h, iArrCreate2);
        X25519Field.mul(pointAccum.f4775u, pointAccum.f4776v, iArrCreate3);
        X25519Field.mul(iArrCreate3, pointPrecomp.xyd, iArrCreate3);
        X25519Field.apm(iArrCreate2, iArrCreate, iArr2, iArr);
        X25519Field.apm(pointAccum.f4779z, iArrCreate3, iArrCreate5, iArrCreate4);
        X25519Field.carry(iArrCreate5);
        X25519Field.mul(iArr, iArrCreate4, pointAccum.f4777x);
        X25519Field.mul(iArrCreate5, iArr2, pointAccum.f4778y);
        X25519Field.mul(iArrCreate4, iArrCreate5, pointAccum.f4779z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointAccum pointAccum) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        int[] iArrCreate3 = X25519Field.create();
        int[] iArrCreate4 = X25519Field.create();
        int[] iArr5 = pointAccum.f4775u;
        int[] iArrCreate5 = X25519Field.create();
        int[] iArrCreate6 = X25519Field.create();
        int[] iArr6 = pointAccum.f4776v;
        if (z) {
            iArr2 = iArrCreate3;
            iArr = iArrCreate4;
            iArr4 = iArrCreate5;
            iArr3 = iArrCreate6;
        } else {
            iArr = iArrCreate3;
            iArr2 = iArrCreate4;
            iArr3 = iArrCreate5;
            iArr4 = iArrCreate6;
        }
        X25519Field.apm(pointAccum.f4778y, pointAccum.f4777x, iArrCreate2, iArrCreate);
        X25519Field.apm(pointExt.f4784y, pointExt.f4783x, iArr2, iArr);
        X25519Field.mul(iArrCreate, iArrCreate3, iArrCreate);
        X25519Field.mul(iArrCreate2, iArrCreate4, iArrCreate2);
        X25519Field.mul(pointAccum.f4775u, pointAccum.f4776v, iArrCreate3);
        X25519Field.mul(iArrCreate3, pointExt.f4782t, iArrCreate3);
        X25519Field.mul(iArrCreate3, C_d2, iArrCreate3);
        X25519Field.mul(pointAccum.f4779z, pointExt.f4785z, iArrCreate4);
        X25519Field.add(iArrCreate4, iArrCreate4, iArrCreate4);
        X25519Field.apm(iArrCreate2, iArrCreate, iArr6, iArr5);
        X25519Field.apm(iArrCreate4, iArrCreate3, iArr4, iArr3);
        X25519Field.carry(iArr4);
        X25519Field.mul(iArr5, iArrCreate5, pointAccum.f4777x);
        X25519Field.mul(iArrCreate6, iArr6, pointAccum.f4778y);
        X25519Field.mul(iArrCreate5, iArrCreate6, pointAccum.f4779z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2, PointExt pointExt3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        int[] iArrCreate3 = X25519Field.create();
        int[] iArrCreate4 = X25519Field.create();
        int[] iArrCreate5 = X25519Field.create();
        int[] iArrCreate6 = X25519Field.create();
        int[] iArrCreate7 = X25519Field.create();
        int[] iArrCreate8 = X25519Field.create();
        if (z) {
            iArr2 = iArrCreate3;
            iArr = iArrCreate4;
            iArr4 = iArrCreate6;
            iArr3 = iArrCreate7;
        } else {
            iArr = iArrCreate3;
            iArr2 = iArrCreate4;
            iArr3 = iArrCreate6;
            iArr4 = iArrCreate7;
        }
        X25519Field.apm(pointExt.f4784y, pointExt.f4783x, iArrCreate2, iArrCreate);
        X25519Field.apm(pointExt2.f4784y, pointExt2.f4783x, iArr2, iArr);
        X25519Field.mul(iArrCreate, iArrCreate3, iArrCreate);
        X25519Field.mul(iArrCreate2, iArrCreate4, iArrCreate2);
        X25519Field.mul(pointExt.f4782t, pointExt2.f4782t, iArrCreate3);
        X25519Field.mul(iArrCreate3, C_d2, iArrCreate3);
        X25519Field.mul(pointExt.f4785z, pointExt2.f4785z, iArrCreate4);
        X25519Field.add(iArrCreate4, iArrCreate4, iArrCreate4);
        X25519Field.apm(iArrCreate2, iArrCreate, iArrCreate8, iArrCreate5);
        X25519Field.apm(iArrCreate4, iArrCreate3, iArr4, iArr3);
        X25519Field.carry(iArr4);
        X25519Field.mul(iArrCreate5, iArrCreate6, pointExt3.f4783x);
        X25519Field.mul(iArrCreate7, iArrCreate8, pointExt3.f4784y);
        X25519Field.mul(iArrCreate6, iArrCreate7, pointExt3.f4785z);
        X25519Field.mul(iArrCreate5, iArrCreate8, pointExt3.f4782t);
    }

    private static PointExt pointCopy(PointAccum pointAccum) {
        PointExt pointExt = new PointExt();
        X25519Field.copy(pointAccum.f4777x, 0, pointExt.f4783x, 0);
        X25519Field.copy(pointAccum.f4778y, 0, pointExt.f4784y, 0);
        X25519Field.copy(pointAccum.f4779z, 0, pointExt.f4785z, 0);
        X25519Field.mul(pointAccum.f4775u, pointAccum.f4776v, pointExt.f4782t);
        return pointExt;
    }

    private static PointExt pointCopy(PointAffine pointAffine) {
        PointExt pointExt = new PointExt();
        X25519Field.copy(pointAffine.f4780x, 0, pointExt.f4783x, 0);
        X25519Field.copy(pointAffine.f4781y, 0, pointExt.f4784y, 0);
        pointExtendXY(pointExt);
        return pointExt;
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X25519Field.copy(pointExt.f4783x, 0, pointExt2.f4783x, 0);
        X25519Field.copy(pointExt.f4784y, 0, pointExt2.f4784y, 0);
        X25519Field.copy(pointExt.f4785z, 0, pointExt2.f4785z, 0);
        X25519Field.copy(pointExt.f4782t, 0, pointExt2.f4782t, 0);
    }

    private static void pointDouble(PointAccum pointAccum) {
        int[] iArrCreate = X25519Field.create();
        int[] iArrCreate2 = X25519Field.create();
        int[] iArrCreate3 = X25519Field.create();
        int[] iArr = pointAccum.f4775u;
        int[] iArrCreate4 = X25519Field.create();
        int[] iArrCreate5 = X25519Field.create();
        int[] iArr2 = pointAccum.f4776v;
        X25519Field.sqr(pointAccum.f4777x, iArrCreate);
        X25519Field.sqr(pointAccum.f4778y, iArrCreate2);
        X25519Field.sqr(pointAccum.f4779z, iArrCreate3);
        X25519Field.add(iArrCreate3, iArrCreate3, iArrCreate3);
        X25519Field.apm(iArrCreate, iArrCreate2, iArr2, iArrCreate5);
        X25519Field.add(pointAccum.f4777x, pointAccum.f4778y, iArr);
        X25519Field.sqr(iArr, iArr);
        X25519Field.sub(iArr2, iArr, iArr);
        X25519Field.add(iArrCreate3, iArrCreate5, iArrCreate4);
        X25519Field.carry(iArrCreate4);
        X25519Field.mul(iArr, iArrCreate4, pointAccum.f4777x);
        X25519Field.mul(iArrCreate5, iArr2, pointAccum.f4778y);
        X25519Field.mul(iArrCreate4, iArrCreate5, pointAccum.f4779z);
    }

    private static void pointExtendXY(PointAccum pointAccum) {
        X25519Field.one(pointAccum.f4779z);
        X25519Field.copy(pointAccum.f4777x, 0, pointAccum.f4775u, 0);
        X25519Field.copy(pointAccum.f4778y, 0, pointAccum.f4776v, 0);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X25519Field.one(pointExt.f4785z);
        X25519Field.mul(pointExt.f4783x, pointExt.f4784y, pointExt.f4782t);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * PsExtractor.VIDEO_STREAM_MASK;
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X25519Field.cmov(i5, precompBase, i3, pointPrecomp.ypx_h, 0);
            X25519Field.cmov(i5, precompBase, i3 + 10, pointPrecomp.ymx_h, 0);
            X25519Field.cmov(i5, precompBase, i3 + 20, pointPrecomp.xyd, 0);
            i3 += 30;
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointExt2 = new PointExt();
        pointAddVar(false, pointExt, pointExt, pointExt2);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            PointExt pointExt3 = pointExtArr[i2 - 1];
            PointExt pointExt4 = new PointExt();
            pointExtArr[i2] = pointExt4;
            pointAddVar(false, pointExt3, pointExt2, pointExt4);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointAccum pointAccum) {
        X25519Field.zero(pointAccum.f4777x);
        X25519Field.one(pointAccum.f4778y);
        X25519Field.one(pointAccum.f4779z);
        X25519Field.zero(pointAccum.f4775u);
        X25519Field.one(pointAccum.f4776v);
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X25519Field.zero(pointExt.f4783x);
        X25519Field.one(pointExt.f4784y);
        X25519Field.one(pointExt.f4785z);
        X25519Field.zero(pointExt.f4782t);
    }

    public static void precompute() {
        int i;
        synchronized (precompLock) {
            try {
                if (precompBase != null) {
                    return;
                }
                PointExt pointExt = new PointExt();
                int[] iArr = B_x;
                X25519Field.copy(iArr, 0, pointExt.f4783x, 0);
                int[] iArr2 = B_y;
                X25519Field.copy(iArr2, 0, pointExt.f4784y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                PointAccum pointAccum = new PointAccum();
                X25519Field.copy(iArr, 0, pointAccum.f4777x, 0);
                X25519Field.copy(iArr2, 0, pointAccum.f4778y, 0);
                pointExtendXY(pointAccum);
                precompBase = X25519Field.createTable(192);
                int i2 = 0;
                for (int i3 = 0; i3 < 8; i3++) {
                    PointExt[] pointExtArr = new PointExt[4];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i4 = 0;
                    while (true) {
                        i = 1;
                        if (i4 >= 4) {
                            break;
                        }
                        pointAddVar(true, pointExt2, pointCopy(pointAccum), pointExt2);
                        pointDouble(pointAccum);
                        pointExtArr[i4] = pointCopy(pointAccum);
                        if (i3 + i4 != 10) {
                            while (i < 8) {
                                pointDouble(pointAccum);
                                i++;
                            }
                        }
                        i4++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[8];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 0;
                    int i6 = 1;
                    while (i5 < 3) {
                        int i7 = i << i5;
                        int i8 = 0;
                        while (i8 < i7) {
                            PointExt pointExt3 = pointExtArr2[i6 - i7];
                            PointExt pointExt4 = pointExtArr[i5];
                            PointExt pointExt5 = new PointExt();
                            pointExtArr2[i6] = pointExt5;
                            pointAddVar(false, pointExt3, pointExt4, pointExt5);
                            i8++;
                            i6++;
                        }
                        i5++;
                        i = 1;
                    }
                    int[] iArrCreateTable = X25519Field.createTable(8);
                    int[] iArrCreate = X25519Field.create();
                    X25519Field.copy(pointExtArr2[0].f4785z, 0, iArrCreate, 0);
                    X25519Field.copy(iArrCreate, 0, iArrCreateTable, 0);
                    int i9 = 0;
                    while (true) {
                        int i10 = i9 + 1;
                        if (i10 >= 8) {
                            break;
                        }
                        X25519Field.mul(iArrCreate, pointExtArr2[i10].f4785z, iArrCreate);
                        X25519Field.copy(iArrCreate, 0, iArrCreateTable, i10 * 10);
                        i9 = i10;
                    }
                    X25519Field.add(iArrCreate, iArrCreate, iArrCreate);
                    X25519Field.invVar(iArrCreate, iArrCreate);
                    int[] iArrCreate2 = X25519Field.create();
                    while (i9 > 0) {
                        int i11 = i9 - 1;
                        X25519Field.copy(iArrCreateTable, i11 * 10, iArrCreate2, 0);
                        X25519Field.mul(iArrCreate2, iArrCreate, iArrCreate2);
                        X25519Field.copy(iArrCreate2, 0, iArrCreateTable, i9 * 10);
                        X25519Field.mul(iArrCreate, pointExtArr2[i9].f4785z, iArrCreate);
                        i9 = i11;
                    }
                    X25519Field.copy(iArrCreate, 0, iArrCreateTable, 0);
                    for (int i12 = 0; i12 < 8; i12++) {
                        PointExt pointExt6 = pointExtArr2[i12];
                        int[] iArrCreate3 = X25519Field.create();
                        int[] iArrCreate4 = X25519Field.create();
                        X25519Field.copy(iArrCreateTable, i12 * 10, iArrCreate4, 0);
                        X25519Field.mul(pointExt6.f4783x, iArrCreate4, iArrCreate3);
                        X25519Field.mul(pointExt6.f4784y, iArrCreate4, iArrCreate4);
                        PointPrecomp pointPrecomp = new PointPrecomp();
                        X25519Field.apm(iArrCreate4, iArrCreate3, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                        X25519Field.mul(iArrCreate3, iArrCreate4, pointPrecomp.xyd);
                        int[] iArr3 = pointPrecomp.xyd;
                        X25519Field.mul(iArr3, C_d4, iArr3);
                        X25519Field.normalize(pointPrecomp.ypx_h);
                        X25519Field.normalize(pointPrecomp.ymx_h);
                        X25519Field.copy(pointPrecomp.ypx_h, 0, precompBase, i2);
                        X25519Field.copy(pointPrecomp.ymx_h, 0, precompBase, i2 + 10);
                        X25519Field.copy(pointPrecomp.xyd, 0, precompBase, i2 + 20);
                        i2 += 30;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        byte b = (byte) (bArr2[31] & 127);
        bArr2[31] = b;
        bArr2[31] = (byte) (b | 64);
    }

    private static byte[] reduceScalar(byte[] bArr) {
        long jDecode32 = ((long) decode32(bArr, 0)) & BodyPartID.bodyIdMax;
        long jDecode24 = ((long) (decode24(bArr, 4) << 4)) & BodyPartID.bodyIdMax;
        long jDecode33 = ((long) decode32(bArr, 7)) & BodyPartID.bodyIdMax;
        long jDecode25 = ((long) (decode24(bArr, 11) << 4)) & BodyPartID.bodyIdMax;
        long jDecode34 = ((long) decode32(bArr, 14)) & BodyPartID.bodyIdMax;
        long jDecode26 = ((long) (decode24(bArr, 18) << 4)) & BodyPartID.bodyIdMax;
        long jDecode35 = ((long) decode32(bArr, 21)) & BodyPartID.bodyIdMax;
        long jDecode27 = ((long) (decode24(bArr, 25) << 4)) & BodyPartID.bodyIdMax;
        long jDecode36 = ((long) decode32(bArr, 28)) & BodyPartID.bodyIdMax;
        long jDecode28 = ((long) (decode24(bArr, 32) << 4)) & BodyPartID.bodyIdMax;
        long jDecode37 = ((long) decode32(bArr, 35)) & BodyPartID.bodyIdMax;
        long jDecode29 = ((long) (decode24(bArr, 39) << 4)) & BodyPartID.bodyIdMax;
        long jDecode38 = ((long) decode32(bArr, 42)) & BodyPartID.bodyIdMax;
        long jDecode210 = ((long) (decode24(bArr, 46) << 4)) & BodyPartID.bodyIdMax;
        long jDecode39 = decode32(bArr, 49);
        long j = jDecode39 & BodyPartID.bodyIdMax;
        long jDecode211 = ((long) (decode24(bArr, 53) << 4)) & BodyPartID.bodyIdMax;
        long jDecode310 = decode32(bArr, 56);
        long j2 = jDecode310 & BodyPartID.bodyIdMax;
        long jDecode212 = ((long) (decode24(bArr, 60) << 4)) & BodyPartID.bodyIdMax;
        long j3 = ((long) bArr[63]) & 255;
        long j4 = jDecode212 + (j2 >> 28);
        long j5 = jDecode310 & 268435455;
        long j6 = jDecode36 - (j4 * (-50998291));
        long j7 = (jDecode28 - (j3 * (-50998291))) - (j4 * 19280294);
        long j8 = (jDecode38 - (j3 * (-6428113))) - (j4 * 5343);
        long j9 = ((jDecode29 - (j3 * 127719000)) - (j4 * (-6428113))) - (j5 * 5343);
        long j10 = jDecode211 + (j >> 28);
        long j11 = jDecode39 & 268435455;
        long j12 = (((jDecode37 - (j3 * 19280294)) - (j4 * 127719000)) - (j5 * (-6428113))) - (j10 * 5343);
        long j13 = ((jDecode27 - (j5 * (-50998291))) - (j10 * 19280294)) - (j11 * 127719000);
        long j14 = ((j7 - (j5 * 127719000)) - (j10 * (-6428113))) - (j11 * 5343);
        long j15 = (jDecode210 - (j3 * 5343)) + (j8 >> 28);
        long j16 = (j8 & 268435455) + (j9 >> 28);
        long j17 = jDecode25 - (j16 * (-50998291));
        long j18 = (jDecode34 - (j15 * (-50998291))) - (j16 * 19280294);
        long j19 = ((jDecode26 - (j11 * (-50998291))) - (j15 * 19280294)) - (j16 * 127719000);
        long j20 = (((jDecode35 - (j10 * (-50998291))) - (j11 * 19280294)) - (j15 * 127719000)) - (j16 * (-6428113));
        long j21 = (j13 - (j15 * (-6428113))) - (j16 * 5343);
        long j22 = (j9 & 268435455) + (j12 >> 28);
        long j23 = j12 & 268435455;
        long j24 = jDecode33 - (j22 * (-50998291));
        long j25 = j17 - (j22 * 19280294);
        long j26 = j18 - (j22 * 127719000);
        long j27 = j19 - (j22 * (-6428113));
        long j28 = j20 - (j22 * 5343);
        long j29 = j23 + (j14 >> 28);
        long j30 = j14 & 268435455;
        long j31 = jDecode24 - (j29 * (-50998291));
        long j32 = j24 - (j29 * 19280294);
        long j33 = j25 - (j29 * 127719000);
        long j34 = j26 - (j29 * (-6428113));
        long j35 = j27 - (j29 * 5343);
        long j36 = ((((j6 - (j5 * 19280294)) - (j10 * 127719000)) - (j11 * (-6428113))) - (j15 * 5343)) + (j21 >> 28);
        long j37 = j36 & 268435455;
        long j38 = j37 >>> 27;
        long j39 = j30 + (j36 >> 28) + j38;
        long j40 = jDecode32 - (j39 * (-50998291));
        long j41 = (j31 - (j39 * 19280294)) + (j40 >> 28);
        long j42 = j40 & 268435455;
        long j43 = (j32 - (j39 * 127719000)) + (j41 >> 28);
        long j44 = (j33 - (j39 * (-6428113))) + (j43 >> 28);
        long j45 = (j34 - (j39 * 5343)) + (j44 >> 28);
        long j46 = j35 + (j45 >> 28);
        long j47 = j45 & 268435455;
        long j48 = j28 + (j46 >> 28);
        long j49 = (j21 & 268435455) + (j48 >> 28);
        long j50 = j37 + (j49 >> 28);
        long j51 = (j50 >> 28) - j38;
        long j52 = j42 + (j51 & (-50998291));
        long j53 = (j41 & 268435455) + (j51 & 19280294) + (j52 >> 28);
        long j54 = (j43 & 268435455) + (j51 & 127719000) + (j53 >> 28);
        long j55 = (j44 & 268435455) + (j51 & (-6428113)) + (j54 >> 28);
        long j56 = j47 + (j51 & 5343) + (j55 >> 28);
        long j57 = (j46 & 268435455) + (j56 >> 28);
        long j58 = (j48 & 268435455) + (j57 >> 28);
        long j59 = (j49 & 268435455) + (j58 >> 28);
        byte[] bArr2 = new byte[32];
        encode56((j52 & 268435455) | ((j53 & 268435455) << 28), bArr2, 0);
        encode56(((j55 & 268435455) << 28) | (j54 & 268435455), bArr2, 7);
        encode56((j56 & 268435455) | ((j57 & 268435455) << 28), bArr2, 14);
        encode56((j58 & 268435455) | ((j59 & 268435455) << 28), bArr2, 21);
        encode32((int) ((j50 & 268435455) + (j59 >> 28)), bArr2, 28);
        return bArr2;
    }

    private static void scalarMultBase(byte[] bArr, PointAccum pointAccum) {
        precompute();
        int[] iArr = new int[8];
        decodeScalar(bArr, 0, iArr);
        Nat.cadd(8, (~iArr[0]) & 1, iArr, f4773L, iArr);
        Nat.shiftDownBit(8, iArr, 1);
        for (int i = 0; i < 8; i++) {
            iArr[i] = Interleave.shuffle2(iArr[i]);
        }
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointAccum);
        int i2 = 28;
        while (true) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = iArr[i3] >>> i2;
                int i5 = (i4 >>> 3) & 1;
                pointLookup(i3, (i4 ^ (-i5)) & 7, pointPrecomp);
                X25519Field.cswap(i5, pointPrecomp.ypx_h, pointPrecomp.ymx_h);
                X25519Field.cnegate(i5, pointPrecomp.xyd);
                pointAddPrecomp(pointPrecomp, pointAccum);
            }
            i2 -= 4;
            if (i2 < 0) {
                return;
            } else {
                pointDouble(pointAccum);
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr, pointAccum);
        if (encodePoint(pointAccum, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseYZ(X25519.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by X25519");
        }
        byte[] bArr2 = new byte[32];
        pruneScalar(bArr, i, bArr2);
        PointAccum pointAccum = new PointAccum();
        scalarMultBase(bArr2, pointAccum);
        if (checkPoint(pointAccum.f4777x, pointAccum.f4778y, pointAccum.f4779z) == 0) {
            throw new IllegalStateException();
        }
        X25519Field.copy(pointAccum.f4778y, 0, iArr, 0);
        X25519Field.copy(pointAccum.f4779z, 0, iArr2, 0);
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointAffine pointAffine, PointAccum pointAccum) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointExtArrPointPrecomputeVar = pointPrecomputeVar(pointCopy(pointAffine), 8);
        pointSetNeutral(pointAccum);
        int i = 252;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> Ascii.f3534US;
                pointAddVar(i2 != 0, precompBaseTable[(b ^ i2) >>> 1], pointAccum);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i3 = b2 >> Ascii.f3534US;
                pointAddVar(i3 != 0, pointExtArrPointPrecomputeVar[(b2 ^ i3) >>> 1], pointAccum);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointAccum);
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, int i3, byte[] bArr3, int i4) {
        implSign(bArr, i, null, (byte) 0, bArr2, i2, i3, bArr3, i4);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, byte[] bArr4, int i5) {
        implSign(bArr, i, bArr2, i2, null, (byte) 0, bArr3, i3, i4, bArr4, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Digest digest, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 != digest.doFinal(bArr5, 0)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Digest digest, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 != digest.doFinal(bArr4, 0)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, null, (byte) 0, bArr3, i3, i4);
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Digest digest) {
        byte[] bArr4 = new byte[64];
        if (64 == digest.doFinal(bArr4, 0)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
