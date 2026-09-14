package org.bouncycastle.crypto.modes.gcm;

import com.google.common.base.Ascii;
import java.lang.reflect.Array;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* JADX INFO: loaded from: classes6.dex */
public class Tables8kGCMMultiplier implements GCMMultiplier {

    /* JADX INFO: renamed from: H */
    private byte[] f4518H;

    /* JADX INFO: renamed from: T */
    private long[][][] f4519T;

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void init(byte[] bArr) {
        if (this.f4519T == null) {
            this.f4519T = (long[][][]) Array.newInstance((Class<?>) Long.TYPE, 32, 16, 2);
        } else if (Arrays.areEqual(this.f4518H, bArr)) {
            return;
        }
        this.f4518H = Arrays.clone(bArr);
        for (int i = 0; i < 32; i++) {
            long[][][] jArr = this.f4519T;
            long[][] jArr2 = jArr[i];
            if (i == 0) {
                GCMUtil.asLongs(this.f4518H, jArr2[1]);
                long[] jArr3 = jArr2[1];
                GCMUtil.multiplyP3(jArr3, jArr3);
            } else {
                GCMUtil.multiplyP4(jArr[i - 1][1], jArr2[1]);
            }
            for (int i2 = 2; i2 < 16; i2 += 2) {
                GCMUtil.divideP(jArr2[i2 >> 1], jArr2[i2]);
                GCMUtil.xor(jArr2[i2], jArr2[1], jArr2[i2 + 1]);
            }
        }
    }

    @Override // org.bouncycastle.crypto.modes.gcm.GCMMultiplier
    public void multiplyH(byte[] bArr) {
        long j = 0;
        long j2 = 0;
        for (int i = 15; i >= 0; i--) {
            long[][][] jArr = this.f4519T;
            int i2 = i + i;
            long[][] jArr2 = jArr[i2 + 1];
            byte b = bArr[i];
            long[] jArr3 = jArr2[b & Ascii.f3531SI];
            long[] jArr4 = jArr[i2][(b & 240) >>> 4];
            j ^= jArr3[0] ^ jArr4[0];
            j2 ^= jArr4[1] ^ jArr3[1];
        }
        Pack.longToBigEndian(j, bArr, 0);
        Pack.longToBigEndian(j2, bArr, 8);
    }
}
