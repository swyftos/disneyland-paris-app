package org.bouncycastle.pqc.crypto.rainbow;

/* JADX INFO: loaded from: classes6.dex */
public class RainbowPrivateKeyParameters extends RainbowKeyParameters {
    private short[][] A1inv;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1 */
    private short[] f4909b1;

    /* JADX INFO: renamed from: b2 */
    private short[] f4910b2;
    private Layer[] layers;

    /* JADX INFO: renamed from: vi */
    private int[] f4911vi;

    public RainbowPrivateKeyParameters(short[][] sArr, short[] sArr2, short[][] sArr3, short[] sArr4, int[] iArr, Layer[] layerArr) {
        super(true, iArr[iArr.length - 1] - iArr[0]);
        this.A1inv = sArr;
        this.f4909b1 = sArr2;
        this.A2inv = sArr3;
        this.f4910b2 = sArr4;
        this.f4911vi = iArr;
        this.layers = layerArr;
    }

    public short[] getB1() {
        return this.f4909b1;
    }

    public short[] getB2() {
        return this.f4910b2;
    }

    public short[][] getInvA1() {
        return this.A1inv;
    }

    public short[][] getInvA2() {
        return this.A2inv;
    }

    public Layer[] getLayers() {
        return this.layers;
    }

    public int[] getVi() {
        return this.f4911vi;
    }
}
