package org.bouncycastle.math.ec.rfc8032;

import ch.qos.logback.core.net.SyslogConstants;
import com.contentsquare.android.api.Currencies;
import com.google.common.base.Ascii;
import java.security.SecureRandom;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.math.ec.rfc7748.X448;
import org.bouncycastle.math.ec.rfc7748.X448Field;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

/* loaded from: classes6.dex */
public abstract class Ed448 {
    public static final int PREHASH_SIZE = 64;
    public static final int PUBLIC_KEY_SIZE = 57;
    public static final int SECRET_KEY_SIZE = 57;
    public static final int SIGNATURE_SIZE = 114;
    private static final byte[] DOM4_PREFIX = {83, 105, 103, 69, 100, 52, 52, 56};
    private static final int[] P = {-1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1};
    private static final int[] L = {-1420278541, 595116690, -1916432555, 560775794, -1361693040, -1001465015, 2093622249, -1, -1, -1, -1, -1, -1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK};
    private static final int[] B_x = {118276190, 40534716, 9670182, 135141552, 85017403, 259173222, 68333082, 171784774, 174973732, 15824510, 73756743, 57518561, 94773951, 248652241, 107736333, 82941708};
    private static final int[] B_y = {36764180, 8885695, 130592152, 20104429, 163904957, 30304195, 121295871, 5901357, 125344798, 171541512, 175338348, 209069246, 3626697, 38307682, 24032956, 110359655};
    private static final Object precompLock = new Object();
    private static PointExt[] precompBaseTable = null;
    private static int[] precompBase = null;

    public static final class Algorithm {
        public static final int Ed448 = 0;
        public static final int Ed448ph = 1;
    }

    private static class PointExt {
        int[] x;
        int[] y;
        int[] z;

        private PointExt() {
            this.x = X448Field.create();
            this.y = X448Field.create();
            this.z = X448Field.create();
        }
    }

    private static class PointPrecomp {
        int[] x;
        int[] y;

        private PointPrecomp() {
            this.x = X448Field.create();
            this.y = X448Field.create();
        }
    }

    private static byte[] calculateS(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[28];
        decodeScalar(bArr, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArr2, 0, iArr2);
        int[] iArr3 = new int[14];
        decodeScalar(bArr3, 0, iArr3);
        Nat.mulAddTo(14, iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[114];
        for (int i = 0; i < 28; i++) {
            encode32(iArr[i], bArr4, i * 4);
        }
        return reduceScalar(bArr4);
    }

    private static boolean checkContextVar(byte[] bArr) {
        return bArr != null && bArr.length < 256;
    }

    private static int checkPoint(int[] iArr, int[] iArr2) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        X448Field.sqr(iArr, iArrCreate2);
        X448Field.sqr(iArr2, iArrCreate3);
        X448Field.mul(iArrCreate2, iArrCreate3, iArrCreate);
        X448Field.add(iArrCreate2, iArrCreate3, iArrCreate2);
        X448Field.mul(iArrCreate, 39081, iArrCreate);
        X448Field.subOne(iArrCreate);
        X448Field.add(iArrCreate, iArrCreate2, iArrCreate);
        X448Field.normalize(iArrCreate);
        return X448Field.isZero(iArrCreate);
    }

    private static int checkPoint(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        X448Field.sqr(iArr, iArrCreate2);
        X448Field.sqr(iArr2, iArrCreate3);
        X448Field.sqr(iArr3, iArrCreate4);
        X448Field.mul(iArrCreate2, iArrCreate3, iArrCreate);
        X448Field.add(iArrCreate2, iArrCreate3, iArrCreate2);
        X448Field.mul(iArrCreate2, iArrCreate4, iArrCreate2);
        X448Field.sqr(iArrCreate4, iArrCreate4);
        X448Field.mul(iArrCreate, 39081, iArrCreate);
        X448Field.sub(iArrCreate, iArrCreate4, iArrCreate);
        X448Field.add(iArrCreate, iArrCreate2, iArrCreate);
        X448Field.normalize(iArrCreate);
        return X448Field.isZero(iArrCreate);
    }

    private static boolean checkPointVar(byte[] bArr) {
        if ((bArr[56] & 127) != 0) {
            return false;
        }
        decode32(bArr, 0, new int[14], 0, 14);
        return !Nat.gte(14, r2, P);
    }

    private static boolean checkScalarVar(byte[] bArr) {
        if (bArr[56] != 0) {
            return false;
        }
        decodeScalar(bArr, 0, new int[14]);
        return !Nat.gte(14, r2, L);
    }

    public static Xof createPrehash() {
        return createXof();
    }

    private static Xof createXof() {
        return new SHAKEDigest(256);
    }

    private static int decode16(byte[] bArr, int i) {
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
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

    private static boolean decodePointVar(byte[] bArr, int i, boolean z, PointExt pointExt) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i + 57);
        if (!checkPointVar(bArrCopyOfRange)) {
            return false;
        }
        byte b = bArrCopyOfRange[56];
        int i2 = (b & 128) >>> 7;
        bArrCopyOfRange[56] = (byte) (b & 127);
        X448Field.decode(bArrCopyOfRange, 0, pointExt.y);
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        X448Field.sqr(pointExt.y, iArrCreate);
        X448Field.mul(iArrCreate, 39081, iArrCreate2);
        X448Field.negate(iArrCreate, iArrCreate);
        X448Field.addOne(iArrCreate);
        X448Field.addOne(iArrCreate2);
        if (!X448Field.sqrtRatioVar(iArrCreate, iArrCreate2, pointExt.x)) {
            return false;
        }
        X448Field.normalize(pointExt.x);
        if (i2 == 1 && X448Field.isZeroVar(pointExt.x)) {
            return false;
        }
        int[] iArr = pointExt.x;
        if (z ^ (i2 != (iArr[0] & 1))) {
            X448Field.negate(iArr, iArr);
        }
        pointExtendXY(pointExt);
        return true;
    }

    private static void decodeScalar(byte[] bArr, int i, int[] iArr) {
        decode32(bArr, i, iArr, 0, 14);
    }

    private static void dom4(Xof xof, byte b, byte[] bArr) {
        byte[] bArr2 = DOM4_PREFIX;
        int length = bArr2.length;
        int i = length + 2;
        int length2 = bArr.length + i;
        byte[] bArr3 = new byte[length2];
        System.arraycopy(bArr2, 0, bArr3, 0, length);
        bArr3[length] = b;
        bArr3[length + 1] = (byte) bArr.length;
        System.arraycopy(bArr, 0, bArr3, i, bArr.length);
        xof.update(bArr3, 0, length2);
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

    private static int encodePoint(PointExt pointExt, byte[] bArr, int i) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        X448Field.inv(pointExt.z, iArrCreate2);
        X448Field.mul(pointExt.x, iArrCreate2, iArrCreate);
        X448Field.mul(pointExt.y, iArrCreate2, iArrCreate2);
        X448Field.normalize(iArrCreate);
        X448Field.normalize(iArrCreate2);
        int iCheckPoint = checkPoint(iArrCreate, iArrCreate2);
        X448Field.encode(iArrCreate2, bArr, i);
        bArr[i + 56] = (byte) ((iArrCreate[0] & 1) << 7);
        return iCheckPoint;
    }

    public static void generatePrivateKey(SecureRandom secureRandom, byte[] bArr) {
        secureRandom.nextBytes(bArr);
    }

    public static void generatePublicKey(byte[] bArr, int i, byte[] bArr2, int i2) {
        Xof xofCreateXof = createXof();
        byte[] bArr3 = new byte[114];
        xofCreateXof.update(bArr, i, 57);
        xofCreateXof.doFinal(bArr3, 0, 114);
        byte[] bArr4 = new byte[57];
        pruneScalar(bArr3, 0, bArr4);
        scalarMultBaseEncoded(bArr4, bArr2, i2);
    }

    private static byte[] getWnafVar(int[] iArr, int i) {
        int[] iArr2 = new int[28];
        int i2 = 0;
        int i3 = 14;
        int i4 = 28;
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
        byte[] bArr = new byte[447];
        int i7 = 1 << i;
        int i8 = i7 - 1;
        int i9 = i7 >>> 1;
        int i10 = 0;
        int i11 = 0;
        while (i2 < 28) {
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

    private static void implSign(Xof xof, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        dom4(xof, b, bArr4);
        xof.update(bArr, 57, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] bArrReduceScalar = reduceScalar(bArr);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArrReduceScalar, bArr7, 0);
        dom4(xof, b, bArr4);
        xof.update(bArr7, 0, 57);
        xof.update(bArr3, i, 57);
        xof.update(bArr5, i2, i3);
        xof.doFinal(bArr, 0, bArr.length);
        byte[] bArrCalculateS = calculateS(bArrReduceScalar, reduceScalar(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 57);
        System.arraycopy(bArrCalculateS, 0, bArr6, i4 + 57, 57);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, byte b, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        if (!checkContextVar(bArr2)) {
            throw new IllegalArgumentException("ctx");
        }
        Xof xofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        xofCreateXof.update(bArr, i, 57);
        xofCreateXof.doFinal(bArr5, 0, 114);
        byte[] bArr6 = new byte[57];
        pruneScalar(bArr5, 0, bArr6);
        byte[] bArr7 = new byte[57];
        scalarMultBaseEncoded(bArr6, bArr7, 0);
        implSign(xofCreateXof, bArr5, bArr6, bArr7, 0, bArr2, b, bArr3, i2, i3, bArr4, i4);
    }

    private static void implSign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        Xof xofCreateXof = createXof();
        byte[] bArr6 = new byte[114];
        xofCreateXof.update(bArr, i, 57);
        xofCreateXof.doFinal(bArr6, 0, 114);
        byte[] bArr7 = new byte[57];
        pruneScalar(bArr6, 0, bArr7);
        implSign(xofCreateXof, bArr6, bArr7, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
    }

    private static boolean implVerify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4) {
        if (!checkContextVar(bArr3)) {
            throw new IllegalArgumentException("ctx");
        }
        int i5 = i + 57;
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i5);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, i5, i + 114);
        if (!checkPointVar(bArrCopyOfRange) || !checkScalarVar(bArrCopyOfRange2)) {
            return false;
        }
        PointExt pointExt = new PointExt();
        if (!decodePointVar(bArr2, i2, true, pointExt)) {
            return false;
        }
        Xof xofCreateXof = createXof();
        byte[] bArr5 = new byte[114];
        dom4(xofCreateXof, b, bArr3);
        xofCreateXof.update(bArrCopyOfRange, 0, 57);
        xofCreateXof.update(bArr2, i2, 57);
        xofCreateXof.update(bArr4, i3, i4);
        xofCreateXof.doFinal(bArr5, 0, 114);
        byte[] bArrReduceScalar = reduceScalar(bArr5);
        int[] iArr = new int[14];
        decodeScalar(bArrCopyOfRange2, 0, iArr);
        int[] iArr2 = new int[14];
        decodeScalar(bArrReduceScalar, 0, iArr2);
        PointExt pointExt2 = new PointExt();
        scalarMultStrausVar(iArr, iArr2, pointExt, pointExt2);
        byte[] bArr6 = new byte[57];
        return encodePoint(pointExt2, bArr6, 0) != 0 && Arrays.areEqual(bArr6, bArrCopyOfRange);
    }

    private static void pointAddPrecomp(PointPrecomp pointPrecomp, PointExt pointExt) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        int[] iArrCreate7 = X448Field.create();
        X448Field.sqr(pointExt.z, iArrCreate);
        X448Field.mul(pointPrecomp.x, pointExt.x, iArrCreate2);
        X448Field.mul(pointPrecomp.y, pointExt.y, iArrCreate3);
        X448Field.mul(iArrCreate2, iArrCreate3, iArrCreate4);
        X448Field.mul(iArrCreate4, 39081, iArrCreate4);
        X448Field.add(iArrCreate, iArrCreate4, iArrCreate5);
        X448Field.sub(iArrCreate, iArrCreate4, iArrCreate6);
        X448Field.add(pointPrecomp.x, pointPrecomp.y, iArrCreate);
        X448Field.add(pointExt.x, pointExt.y, iArrCreate4);
        X448Field.mul(iArrCreate, iArrCreate4, iArrCreate7);
        X448Field.add(iArrCreate3, iArrCreate2, iArrCreate);
        X448Field.sub(iArrCreate3, iArrCreate2, iArrCreate4);
        X448Field.carry(iArrCreate);
        X448Field.sub(iArrCreate7, iArrCreate, iArrCreate7);
        X448Field.mul(iArrCreate7, pointExt.z, iArrCreate7);
        X448Field.mul(iArrCreate4, pointExt.z, iArrCreate4);
        X448Field.mul(iArrCreate5, iArrCreate7, pointExt.x);
        X448Field.mul(iArrCreate4, iArrCreate6, pointExt.y);
        X448Field.mul(iArrCreate5, iArrCreate6, pointExt.z);
    }

    private static void pointAddVar(boolean z, PointExt pointExt, PointExt pointExt2) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        int[] iArrCreate7 = X448Field.create();
        int[] iArrCreate8 = X448Field.create();
        if (z) {
            X448Field.sub(pointExt.y, pointExt.x, iArrCreate8);
            iArr2 = iArrCreate2;
            iArr = iArrCreate5;
            iArr4 = iArrCreate6;
            iArr3 = iArrCreate7;
        } else {
            X448Field.add(pointExt.y, pointExt.x, iArrCreate8);
            iArr = iArrCreate2;
            iArr2 = iArrCreate5;
            iArr3 = iArrCreate6;
            iArr4 = iArrCreate7;
        }
        X448Field.mul(pointExt.z, pointExt2.z, iArrCreate);
        X448Field.sqr(iArrCreate, iArrCreate2);
        X448Field.mul(pointExt.x, pointExt2.x, iArrCreate3);
        X448Field.mul(pointExt.y, pointExt2.y, iArrCreate4);
        X448Field.mul(iArrCreate3, iArrCreate4, iArrCreate5);
        X448Field.mul(iArrCreate5, 39081, iArrCreate5);
        X448Field.add(iArrCreate2, iArrCreate5, iArr3);
        X448Field.sub(iArrCreate2, iArrCreate5, iArr4);
        X448Field.add(pointExt2.x, pointExt2.y, iArrCreate5);
        X448Field.mul(iArrCreate8, iArrCreate5, iArrCreate8);
        X448Field.add(iArrCreate4, iArrCreate3, iArr);
        X448Field.sub(iArrCreate4, iArrCreate3, iArr2);
        X448Field.carry(iArr);
        X448Field.sub(iArrCreate8, iArrCreate2, iArrCreate8);
        X448Field.mul(iArrCreate8, iArrCreate, iArrCreate8);
        X448Field.mul(iArrCreate5, iArrCreate, iArrCreate5);
        X448Field.mul(iArrCreate6, iArrCreate8, pointExt2.x);
        X448Field.mul(iArrCreate5, iArrCreate7, pointExt2.y);
        X448Field.mul(iArrCreate6, iArrCreate7, pointExt2.z);
    }

    private static PointExt pointCopy(PointExt pointExt) {
        PointExt pointExt2 = new PointExt();
        pointCopy(pointExt, pointExt2);
        return pointExt2;
    }

    private static void pointCopy(PointExt pointExt, PointExt pointExt2) {
        X448Field.copy(pointExt.x, 0, pointExt2.x, 0);
        X448Field.copy(pointExt.y, 0, pointExt2.y, 0);
        X448Field.copy(pointExt.z, 0, pointExt2.z, 0);
    }

    private static void pointDouble(PointExt pointExt) {
        int[] iArrCreate = X448Field.create();
        int[] iArrCreate2 = X448Field.create();
        int[] iArrCreate3 = X448Field.create();
        int[] iArrCreate4 = X448Field.create();
        int[] iArrCreate5 = X448Field.create();
        int[] iArrCreate6 = X448Field.create();
        X448Field.add(pointExt.x, pointExt.y, iArrCreate);
        X448Field.sqr(iArrCreate, iArrCreate);
        X448Field.sqr(pointExt.x, iArrCreate2);
        X448Field.sqr(pointExt.y, iArrCreate3);
        X448Field.add(iArrCreate2, iArrCreate3, iArrCreate4);
        X448Field.carry(iArrCreate4);
        X448Field.sqr(pointExt.z, iArrCreate5);
        X448Field.add(iArrCreate5, iArrCreate5, iArrCreate5);
        X448Field.carry(iArrCreate5);
        X448Field.sub(iArrCreate4, iArrCreate5, iArrCreate6);
        X448Field.sub(iArrCreate, iArrCreate4, iArrCreate);
        X448Field.sub(iArrCreate2, iArrCreate3, iArrCreate2);
        X448Field.mul(iArrCreate, iArrCreate6, pointExt.x);
        X448Field.mul(iArrCreate4, iArrCreate2, pointExt.y);
        X448Field.mul(iArrCreate4, iArrCreate6, pointExt.z);
    }

    private static void pointExtendXY(PointExt pointExt) {
        X448Field.one(pointExt.z);
    }

    private static void pointLookup(int i, int i2, PointPrecomp pointPrecomp) {
        int i3 = i * 512;
        for (int i4 = 0; i4 < 16; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            X448Field.cmov(i5, precompBase, i3, pointPrecomp.x, 0);
            X448Field.cmov(i5, precompBase, i3 + 16, pointPrecomp.y, 0);
            i3 += 32;
        }
    }

    private static PointExt[] pointPrecomputeVar(PointExt pointExt, int i) {
        PointExt pointExtPointCopy = pointCopy(pointExt);
        pointDouble(pointExtPointCopy);
        PointExt[] pointExtArr = new PointExt[i];
        pointExtArr[0] = pointCopy(pointExt);
        for (int i2 = 1; i2 < i; i2++) {
            PointExt pointExtPointCopy2 = pointCopy(pointExtArr[i2 - 1]);
            pointExtArr[i2] = pointExtPointCopy2;
            pointAddVar(false, pointExtPointCopy, pointExtPointCopy2);
        }
        return pointExtArr;
    }

    private static void pointSetNeutral(PointExt pointExt) {
        X448Field.zero(pointExt.x);
        X448Field.one(pointExt.y);
        X448Field.one(pointExt.z);
    }

    public static void precompute() {
        synchronized (precompLock) {
            try {
                if (precompBase != null) {
                    return;
                }
                PointExt pointExt = new PointExt();
                X448Field.copy(B_x, 0, pointExt.x, 0);
                X448Field.copy(B_y, 0, pointExt.y, 0);
                pointExtendXY(pointExt);
                precompBaseTable = pointPrecomputeVar(pointExt, 32);
                precompBase = X448Field.createTable(160);
                int i = 0;
                for (int i2 = 0; i2 < 5; i2++) {
                    PointExt[] pointExtArr = new PointExt[5];
                    PointExt pointExt2 = new PointExt();
                    pointSetNeutral(pointExt2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= 5) {
                            break;
                        }
                        pointAddVar(true, pointExt, pointExt2);
                        pointDouble(pointExt);
                        pointExtArr[i3] = pointCopy(pointExt);
                        if (i2 + i3 != 8) {
                            for (int i4 = 1; i4 < 18; i4++) {
                                pointDouble(pointExt);
                            }
                        }
                        i3++;
                    }
                    PointExt[] pointExtArr2 = new PointExt[16];
                    pointExtArr2[0] = pointExt2;
                    int i5 = 1;
                    for (int i6 = 0; i6 < 4; i6++) {
                        int i7 = 1 << i6;
                        int i8 = 0;
                        while (i8 < i7) {
                            PointExt pointExtPointCopy = pointCopy(pointExtArr2[i5 - i7]);
                            pointExtArr2[i5] = pointExtPointCopy;
                            pointAddVar(false, pointExtArr[i6], pointExtPointCopy);
                            i8++;
                            i5++;
                        }
                    }
                    int[] iArrCreateTable = X448Field.createTable(16);
                    int[] iArrCreate = X448Field.create();
                    X448Field.copy(pointExtArr2[0].z, 0, iArrCreate, 0);
                    X448Field.copy(iArrCreate, 0, iArrCreateTable, 0);
                    int i9 = 0;
                    while (true) {
                        int i10 = i9 + 1;
                        if (i10 >= 16) {
                            break;
                        }
                        X448Field.mul(iArrCreate, pointExtArr2[i10].z, iArrCreate);
                        X448Field.copy(iArrCreate, 0, iArrCreateTable, i10 * 16);
                        i9 = i10;
                    }
                    X448Field.invVar(iArrCreate, iArrCreate);
                    int[] iArrCreate2 = X448Field.create();
                    while (i9 > 0) {
                        int i11 = i9 - 1;
                        X448Field.copy(iArrCreateTable, i11 * 16, iArrCreate2, 0);
                        X448Field.mul(iArrCreate2, iArrCreate, iArrCreate2);
                        X448Field.copy(iArrCreate2, 0, iArrCreateTable, i9 * 16);
                        X448Field.mul(iArrCreate, pointExtArr2[i9].z, iArrCreate);
                        i9 = i11;
                    }
                    X448Field.copy(iArrCreate, 0, iArrCreateTable, 0);
                    for (int i12 = 0; i12 < 16; i12++) {
                        PointExt pointExt3 = pointExtArr2[i12];
                        X448Field.copy(iArrCreateTable, i12 * 16, pointExt3.z, 0);
                        int[] iArr = pointExt3.x;
                        X448Field.mul(iArr, pointExt3.z, iArr);
                        int[] iArr2 = pointExt3.y;
                        X448Field.mul(iArr2, pointExt3.z, iArr2);
                        X448Field.copy(pointExt3.x, 0, precompBase, i);
                        X448Field.copy(pointExt3.y, 0, precompBase, i + 16);
                        i += 32;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void pruneScalar(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 56);
        bArr2[0] = (byte) (bArr2[0] & 252);
        bArr2[55] = (byte) (bArr2[55] | 128);
        bArr2[56] = 0;
    }

    private static byte[] reduceScalar(byte[] bArr) {
        long jDecode32 = decode32(bArr, 0) & BodyPartID.bodyIdMax;
        long jDecode24 = (decode24(bArr, 4) << 4) & BodyPartID.bodyIdMax;
        long jDecode322 = decode32(bArr, 7) & BodyPartID.bodyIdMax;
        long jDecode242 = (decode24(bArr, 11) << 4) & BodyPartID.bodyIdMax;
        long jDecode323 = decode32(bArr, 14) & BodyPartID.bodyIdMax;
        long jDecode243 = (decode24(bArr, 18) << 4) & BodyPartID.bodyIdMax;
        long jDecode324 = decode32(bArr, 21) & BodyPartID.bodyIdMax;
        long jDecode244 = (decode24(bArr, 25) << 4) & BodyPartID.bodyIdMax;
        long jDecode325 = decode32(bArr, 28) & BodyPartID.bodyIdMax;
        long jDecode245 = (decode24(bArr, 32) << 4) & BodyPartID.bodyIdMax;
        long jDecode326 = decode32(bArr, 35) & BodyPartID.bodyIdMax;
        long jDecode246 = (decode24(bArr, 39) << 4) & BodyPartID.bodyIdMax;
        long jDecode327 = decode32(bArr, 42) & BodyPartID.bodyIdMax;
        long jDecode247 = (decode24(bArr, 46) << 4) & BodyPartID.bodyIdMax;
        long jDecode328 = decode32(bArr, 49) & BodyPartID.bodyIdMax;
        long jDecode248 = (decode24(bArr, 53) << 4) & BodyPartID.bodyIdMax;
        long jDecode329 = decode32(bArr, 56) & BodyPartID.bodyIdMax;
        long jDecode249 = (decode24(bArr, 60) << 4) & BodyPartID.bodyIdMax;
        long jDecode3210 = decode32(bArr, 63) & BodyPartID.bodyIdMax;
        long jDecode2410 = (decode24(bArr, 67) << 4) & BodyPartID.bodyIdMax;
        long jDecode3211 = decode32(bArr, 70) & BodyPartID.bodyIdMax;
        long jDecode2411 = (decode24(bArr, 74) << 4) & BodyPartID.bodyIdMax;
        long jDecode3212 = decode32(bArr, 77) & BodyPartID.bodyIdMax;
        long jDecode2412 = (decode24(bArr, 81) << 4) & BodyPartID.bodyIdMax;
        long jDecode3213 = decode32(bArr, 84);
        long j = jDecode3213 & BodyPartID.bodyIdMax;
        long jDecode2413 = (decode24(bArr, 88) << 4) & BodyPartID.bodyIdMax;
        long jDecode3214 = decode32(bArr, 91);
        long j2 = jDecode3214 & BodyPartID.bodyIdMax;
        long jDecode2414 = (decode24(bArr, 95) << 4) & BodyPartID.bodyIdMax;
        long jDecode3215 = decode32(bArr, 98);
        long j3 = jDecode3215 & BodyPartID.bodyIdMax;
        long jDecode2415 = (decode24(bArr, 102) << 4) & BodyPartID.bodyIdMax;
        long jDecode3216 = decode32(bArr, 105);
        long j4 = jDecode3216 & BodyPartID.bodyIdMax;
        long jDecode2416 = (decode24(bArr, 109) << 4) & BodyPartID.bodyIdMax;
        long jDecode16 = decode16(bArr, SyslogConstants.LOG_ALERT) & BodyPartID.bodyIdMax;
        long j5 = jDecode2416 + (j4 >>> 28);
        long j6 = jDecode3216 & 268435455;
        long j7 = jDecode2411 + (jDecode16 * 227822194) + (j5 * 149865618);
        long j8 = jDecode3212 + (jDecode16 * 149865618) + (j5 * 550336261);
        long j9 = jDecode328 + (j6 * 43969588);
        long j10 = jDecode248 + (j5 * 43969588) + (j6 * 30366549);
        long j11 = jDecode329 + (jDecode16 * 43969588) + (j5 * 30366549) + (j6 * 163752818);
        long j12 = jDecode249 + (jDecode16 * 30366549) + (j5 * 163752818) + (j6 * 258169998);
        long j13 = jDecode3210 + (jDecode16 * 163752818) + (j5 * 258169998) + (j6 * 96434764);
        long j14 = jDecode2410 + (jDecode16 * 258169998) + (j5 * 96434764) + (j6 * 227822194);
        long j15 = jDecode3211 + (jDecode16 * 96434764) + (j5 * 227822194) + (j6 * 149865618);
        long j16 = jDecode2415 + (j3 >>> 28);
        long j17 = jDecode3215 & 268435455;
        long j18 = jDecode247 + (j16 * 43969588);
        long j19 = j14 + (j16 * 149865618);
        long j20 = j15 + (j16 * 550336261);
        long j21 = jDecode327 + (j17 * 43969588);
        long j22 = j9 + (j16 * 30366549) + (j17 * 163752818);
        long j23 = j10 + (j16 * 163752818) + (j17 * 258169998);
        long j24 = j11 + (j16 * 258169998) + (j17 * 96434764);
        long j25 = j12 + (j16 * 96434764) + (j17 * 227822194);
        long j26 = j13 + (j16 * 227822194) + (j17 * 149865618);
        long j27 = jDecode2414 + (j2 >>> 28);
        long j28 = jDecode3214 & 268435455;
        long j29 = jDecode246 + (j27 * 43969588);
        long j30 = j26 + (j27 * 550336261);
        long j31 = jDecode326 + (j28 * 43969588);
        long j32 = j21 + (j27 * 30366549) + (j28 * 163752818);
        long j33 = j18 + (j17 * 30366549) + (j27 * 163752818) + (j28 * 258169998);
        long j34 = j22 + (j27 * 258169998) + (j28 * 96434764);
        long j35 = j23 + (j27 * 96434764) + (j28 * 227822194);
        long j36 = j24 + (j27 * 227822194) + (j28 * 149865618);
        long j37 = j25 + (j27 * 149865618) + (j28 * 550336261);
        long j38 = jDecode2413 + (j >>> 28);
        long j39 = j7 + (j6 * 550336261) + (j20 >>> 28);
        long j40 = j8 + (j39 >>> 28);
        long j41 = jDecode2412 + (jDecode16 * 550336261) + (j40 >>> 28);
        long j42 = j40 & 268435455;
        long j43 = (jDecode3213 & 268435455) + (j41 >>> 28);
        long j44 = j41 & 268435455;
        long j45 = jDecode244 + (j44 * 43969588);
        long j46 = jDecode325 + (j43 * 43969588) + (j44 * 30366549);
        long j47 = jDecode245 + (j38 * 43969588) + (j43 * 30366549) + (j44 * 163752818);
        long j48 = j31 + (j38 * 30366549) + (j43 * 163752818) + (j44 * 258169998);
        long j49 = j29 + (j28 * 30366549) + (j38 * 163752818) + (j43 * 258169998) + (j44 * 96434764);
        long j50 = j32 + (j38 * 258169998) + (j43 * 96434764) + (j44 * 227822194);
        long j51 = j33 + (j38 * 96434764) + (j43 * 227822194) + (j44 * 149865618);
        long j52 = j34 + (j38 * 227822194) + (j43 * 149865618) + (j44 * 550336261);
        long j53 = jDecode324 + (j42 * 43969588);
        long j54 = j30 + (j37 >>> 28);
        long j55 = j19 + (j17 * 550336261) + (j54 >>> 28);
        long j56 = (j20 & 268435455) + (j55 >>> 28);
        long j57 = j55 & 268435455;
        long j58 = (j39 & 268435455) + (j56 >>> 28);
        long j59 = j56 & 268435455;
        long j60 = jDecode323 + (j59 * 43969588);
        long j61 = jDecode243 + (j58 * 43969588) + (j59 * 30366549);
        long j62 = j53 + (j58 * 30366549) + (j59 * 163752818);
        long j63 = j45 + (j42 * 30366549) + (j58 * 163752818) + (j59 * 258169998);
        long j64 = j46 + (j42 * 163752818) + (j58 * 258169998) + (j59 * 96434764);
        long j65 = j47 + (j42 * 258169998) + (j58 * 96434764) + (j59 * 227822194);
        long j66 = j48 + (j42 * 96434764) + (j58 * 227822194) + (j59 * 149865618);
        long j67 = j49 + (j42 * 227822194) + (j58 * 149865618) + (j59 * 550336261);
        long j68 = j35 + (j38 * 149865618) + (j43 * 550336261) + (j52 >>> 28);
        long j69 = j36 + (j38 * 550336261) + (j68 >>> 28);
        long j70 = (j37 & 268435455) + (j69 >>> 28);
        long j71 = (j54 & 268435455) + (j70 >>> 28);
        long j72 = j70 & 268435455;
        long j73 = j64 + (j57 * 227822194) + (j71 * 149865618);
        long j74 = j65 + (j57 * 149865618) + (j71 * 550336261);
        long j75 = ((j69 & 268435455) * 4) + ((j68 & 268435455) >>> 26) + 1;
        long j76 = jDecode32 + (78101261 * j75);
        long j77 = jDecode322 + (j71 * 43969588) + (30366549 * j72) + (175155932 * j75);
        long j78 = jDecode242 + (j57 * 43969588) + (j71 * 30366549) + (163752818 * j72) + (64542499 * j75);
        long j79 = j60 + (j57 * 30366549) + (j71 * 163752818) + (258169998 * j72) + (158326419 * j75);
        long j80 = j61 + (j57 * 163752818) + (j71 * 258169998) + (96434764 * j72) + (191173276 * j75);
        long j81 = j62 + (j57 * 258169998) + (j71 * 96434764) + (227822194 * j72) + (104575268 * j75);
        long j82 = j63 + (j57 * 96434764) + (j71 * 227822194) + (149865618 * j72) + (j75 * 137584065);
        long j83 = jDecode24 + (43969588 * j72) + (141809365 * j75) + (j76 >>> 28);
        long j84 = j77 + (j83 >>> 28);
        long j85 = j78 + (j84 >>> 28);
        long j86 = j79 + (j85 >>> 28);
        long j87 = j80 + (j86 >>> 28);
        long j88 = j86 & 268435455;
        long j89 = j81 + (j87 >>> 28);
        long j90 = j87 & 268435455;
        long j91 = j82 + (j89 >>> 28);
        long j92 = j73 + (j72 * 550336261) + (j91 >>> 28);
        long j93 = j74 + (j92 >>> 28);
        long j94 = j92 & 268435455;
        long j95 = j66 + (j57 * 550336261) + (j93 >>> 28);
        long j96 = j67 + (j95 >>> 28);
        long j97 = j50 + (j42 * 149865618) + (j58 * 550336261) + (j96 >>> 28);
        long j98 = j96 & 268435455;
        long j99 = j51 + (j42 * 550336261) + (j97 >>> 28);
        long j100 = (j52 & 268435455) + (j99 >>> 28);
        long j101 = (j68 & 67108863) + (j100 >>> 28);
        long j102 = (j101 >>> 26) - 1;
        long j103 = (j76 & 268435455) - (j102 & 78101261);
        long j104 = ((j83 & 268435455) - (j102 & 141809365)) + (j103 >> 28);
        long j105 = ((j84 & 268435455) - (j102 & 175155932)) + (j104 >> 28);
        long j106 = ((j85 & 268435455) - (j102 & 64542499)) + (j105 >> 28);
        long j107 = j105 & 268435455;
        long j108 = (j88 - (j102 & 158326419)) + (j106 >> 28);
        long j109 = (j90 - (j102 & 191173276)) + (j108 >> 28);
        long j110 = ((j89 & 268435455) - (j102 & 104575268)) + (j109 >> 28);
        long j111 = ((j91 & 268435455) - (j102 & 137584065)) + (j110 >> 28);
        long j112 = j94 + (j111 >> 28);
        long j113 = (j93 & 268435455) + (j112 >> 28);
        long j114 = (j95 & 268435455) + (j113 >> 28);
        long j115 = j98 + (j114 >> 28);
        long j116 = (j97 & 268435455) + (j115 >> 28);
        long j117 = (j99 & 268435455) + (j116 >> 28);
        long j118 = (j100 & 268435455) + (j117 >> 28);
        byte[] bArr2 = new byte[57];
        encode56(((j104 & 268435455) << 28) | (j103 & 268435455), bArr2, 0);
        encode56(((j106 & 268435455) << 28) | j107, bArr2, 7);
        encode56((j108 & 268435455) | ((j109 & 268435455) << 28), bArr2, 14);
        encode56((j110 & 268435455) | ((j111 & 268435455) << 28), bArr2, 21);
        encode56((j112 & 268435455) | ((j113 & 268435455) << 28), bArr2, 28);
        encode56((j114 & 268435455) | ((j115 & 268435455) << 28), bArr2, 35);
        encode56((j116 & 268435455) | ((j117 & 268435455) << 28), bArr2, 42);
        encode56((((j101 & 67108863) + (j118 >> 28)) << 28) | (j118 & 268435455), bArr2, 49);
        return bArr2;
    }

    private static void scalarMultBase(byte[] bArr, PointExt pointExt) {
        precompute();
        int[] iArr = new int[15];
        decodeScalar(bArr, 0, iArr);
        iArr[14] = Nat.cadd(14, (~iArr[0]) & 1, iArr, L, iArr) + 4;
        Nat.shiftDownBit(15, iArr, 0);
        PointPrecomp pointPrecomp = new PointPrecomp();
        pointSetNeutral(pointExt);
        int i = 17;
        while (true) {
            int i2 = i;
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = 0;
                for (int i5 = 0; i5 < 5; i5++) {
                    i4 = (i4 & (~(1 << i5))) ^ ((iArr[i2 >>> 5] >>> (i2 & 31)) << i5);
                    i2 += 18;
                }
                int i6 = (i4 >>> 4) & 1;
                pointLookup(i3, ((-i6) ^ i4) & 15, pointPrecomp);
                X448Field.cnegate(i6, pointPrecomp.x);
                pointAddPrecomp(pointPrecomp, pointExt);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointExt);
            }
        }
    }

    private static void scalarMultBaseEncoded(byte[] bArr, byte[] bArr2, int i) {
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr, pointExt);
        if (encodePoint(pointExt, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    public static void scalarMultBaseXY(X448.Friend friend, byte[] bArr, int i, int[] iArr, int[] iArr2) {
        if (friend == null) {
            throw new NullPointerException("This method is only for use by X448");
        }
        byte[] bArr2 = new byte[57];
        pruneScalar(bArr, i, bArr2);
        PointExt pointExt = new PointExt();
        scalarMultBase(bArr2, pointExt);
        if (checkPoint(pointExt.x, pointExt.y, pointExt.z) == 0) {
            throw new IllegalStateException();
        }
        X448Field.copy(pointExt.x, 0, iArr, 0);
        X448Field.copy(pointExt.y, 0, iArr2, 0);
    }

    private static void scalarMultStrausVar(int[] iArr, int[] iArr2, PointExt pointExt, PointExt pointExt2) {
        precompute();
        byte[] wnafVar = getWnafVar(iArr, 7);
        byte[] wnafVar2 = getWnafVar(iArr2, 5);
        PointExt[] pointExtArrPointPrecomputeVar = pointPrecomputeVar(pointExt, 8);
        pointSetNeutral(pointExt2);
        int i = Currencies.MOP;
        while (true) {
            byte b = wnafVar[i];
            if (b != 0) {
                int i2 = b >> Ascii.US;
                pointAddVar(i2 != 0, precompBaseTable[(b ^ i2) >>> 1], pointExt2);
            }
            byte b2 = wnafVar2[i];
            if (b2 != 0) {
                int i3 = b2 >> Ascii.US;
                pointAddVar(i3 != 0, pointExtArrPointPrecomputeVar[(b2 ^ i3) >>> 1], pointExt2);
            }
            i--;
            if (i < 0) {
                return;
            } else {
                pointDouble(pointExt2);
            }
        }
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    public static void sign(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4, int i4) {
        implSign(bArr, i, bArr2, (byte) 0, bArr3, i2, i3, bArr4, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof, byte[] bArr4, int i3) {
        byte[] bArr5 = new byte[64];
        if (64 != xof.doFinal(bArr5, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr5, 0, 64, bArr4, i3);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        implSign(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, Xof xof, byte[] bArr3, int i2) {
        byte[] bArr4 = new byte[64];
        if (64 != xof.doFinal(bArr4, 0, 64)) {
            throw new IllegalArgumentException("ph");
        }
        implSign(bArr, i, bArr2, (byte) 1, bArr4, 0, 64, bArr3, i2);
    }

    public static void signPrehash(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2, byte[] bArr4, int i3) {
        implSign(bArr, i, bArr2, (byte) 1, bArr3, i2, 64, bArr4, i3);
    }

    public static boolean verify(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4);
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, Xof xof) {
        byte[] bArr4 = new byte[64];
        if (64 == xof.doFinal(bArr4, 0, 64)) {
            return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, 0, 64);
        }
        throw new IllegalArgumentException("ph");
    }

    public static boolean verifyPrehash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3) {
        return implVerify(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64);
    }
}
