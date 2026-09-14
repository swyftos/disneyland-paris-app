package org.bouncycastle.crypto.engines;

import androidx.core.app.FrameMetricsAggregator;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import com.google.android.material.internal.ViewUtils;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* JADX INFO: loaded from: classes6.dex */
public class HC128Engine implements StreamCipher {
    private boolean initialised;

    /* JADX INFO: renamed from: iv */
    private byte[] f4367iv;
    private byte[] key;

    /* JADX INFO: renamed from: p */
    private int[] f4368p = new int[512];

    /* JADX INFO: renamed from: q */
    private int[] f4369q = new int[512];
    private int cnt = 0;
    private byte[] buf = new byte[4];
    private int idx = 0;

    private static int dim(int i, int i2) {
        return mod512(i - i2);
    }

    /* JADX INFO: renamed from: f1 */
    private static int m2064f1(int i) {
        return (i >>> 3) ^ (rotateRight(i, 7) ^ rotateRight(i, 18));
    }

    /* JADX INFO: renamed from: f2 */
    private static int m2065f2(int i) {
        return (i >>> 10) ^ (rotateRight(i, 17) ^ rotateRight(i, 19));
    }

    /* JADX INFO: renamed from: g1 */
    private int m2066g1(int i, int i2, int i3) {
        return (rotateRight(i, 10) ^ rotateRight(i3, 23)) + rotateRight(i2, 8);
    }

    /* JADX INFO: renamed from: g2 */
    private int m2067g2(int i, int i2, int i3) {
        return (rotateLeft(i, 10) ^ rotateLeft(i3, 23)) + rotateLeft(i2, 8);
    }

    private byte getByte() {
        if (this.idx == 0) {
            int iStep = step();
            byte[] bArr = this.buf;
            bArr[0] = (byte) (iStep & 255);
            bArr[1] = (byte) ((iStep >> 8) & 255);
            bArr[2] = (byte) ((iStep >> 16) & 255);
            bArr[3] = (byte) ((iStep >> 24) & 255);
        }
        byte[] bArr2 = this.buf;
        int i = this.idx;
        byte b = bArr2[i];
        this.idx = 3 & (i + 1);
        return b;
    }

    /* JADX INFO: renamed from: h1 */
    private int m2068h1(int i) {
        int[] iArr = this.f4369q;
        return iArr[i & 255] + iArr[((i >> 16) & 255) + 256];
    }

    /* JADX INFO: renamed from: h2 */
    private int m2069h2(int i) {
        int[] iArr = this.f4368p;
        return iArr[i & 255] + iArr[((i >> 16) & 255) + 256];
    }

    private void init() {
        if (this.key.length != 16) {
            throw new IllegalArgumentException("The key must be 128 bits long");
        }
        this.idx = 0;
        this.cnt = 0;
        int[] iArr = new int[1280];
        for (int i = 0; i < 16; i++) {
            int i2 = i >> 2;
            iArr[i2] = ((this.key[i] & 255) << ((i & 3) * 8)) | iArr[i2];
        }
        System.arraycopy(iArr, 0, iArr, 4, 4);
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f4367iv;
            if (i3 >= bArr.length || i3 >= 16) {
                break;
            }
            int i4 = (i3 >> 2) + 8;
            iArr[i4] = ((bArr[i3] & 255) << ((i3 & 3) * 8)) | iArr[i4];
            i3++;
        }
        System.arraycopy(iArr, 8, iArr, 12, 4);
        for (int i5 = 16; i5 < 1280; i5++) {
            iArr[i5] = m2065f2(iArr[i5 - 2]) + iArr[i5 - 7] + m2064f1(iArr[i5 - 15]) + iArr[i5 - 16] + i5;
        }
        System.arraycopy(iArr, 256, this.f4368p, 0, 512);
        System.arraycopy(iArr, ViewUtils.EDGE_TO_EDGE_FLAGS, this.f4369q, 0, 512);
        for (int i6 = 0; i6 < 512; i6++) {
            this.f4368p[i6] = step();
        }
        for (int i7 = 0; i7 < 512; i7++) {
            this.f4369q[i7] = step();
        }
        this.cnt = 0;
    }

    private static int mod1024(int i) {
        return i & AnalyticsListener.EVENT_DRM_KEYS_LOADED;
    }

    private static int mod512(int i) {
        return i & FrameMetricsAggregator.EVERY_DURATION;
    }

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private static int rotateRight(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    private int step() {
        int iM2069h2;
        int i;
        int iMod512 = mod512(this.cnt);
        if (this.cnt < 512) {
            int[] iArr = this.f4368p;
            iArr[iMod512] = iArr[iMod512] + m2066g1(iArr[dim(iMod512, 3)], this.f4368p[dim(iMod512, 10)], this.f4368p[dim(iMod512, FrameMetricsAggregator.EVERY_DURATION)]);
            iM2069h2 = m2068h1(this.f4368p[dim(iMod512, 12)]);
            i = this.f4368p[iMod512];
        } else {
            int[] iArr2 = this.f4369q;
            iArr2[iMod512] = iArr2[iMod512] + m2067g2(iArr2[dim(iMod512, 3)], this.f4369q[dim(iMod512, 10)], this.f4369q[dim(iMod512, FrameMetricsAggregator.EVERY_DURATION)]);
            iM2069h2 = m2069h2(this.f4369q[dim(iMod512, 12)]);
            i = this.f4369q[iMod512];
        }
        int i2 = i ^ iM2069h2;
        this.cnt = mod1024(this.cnt + 1);
        return i2;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-128";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters parameters;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f4367iv = parametersWithIV.getIV();
            parameters = parametersWithIV.getParameters();
        } else {
            this.f4367iv = new byte[0];
            parameters = cipherParameters;
        }
        if (parameters instanceof KeyParameter) {
            this.key = ((KeyParameter) parameters).getKey();
            init();
            this.initialised = true;
        } else {
            throw new IllegalArgumentException("Invalid parameter passed to HC128 init - " + cipherParameters.getClass().getName());
        }
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws DataLengthException {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i3 + i4] = (byte) (bArr[i + i4] ^ getByte());
        }
        return i2;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        init();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b) {
        return (byte) (getByte() ^ b);
    }
}
