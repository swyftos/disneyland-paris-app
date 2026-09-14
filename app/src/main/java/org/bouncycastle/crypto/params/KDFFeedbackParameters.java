package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class KDFFeedbackParameters implements DerivationParameters {
    private final byte[] fixedInputData;

    /* JADX INFO: renamed from: iv */
    private final byte[] f4576iv;

    /* JADX INFO: renamed from: ki */
    private final byte[] f4577ki;

    /* JADX INFO: renamed from: r */
    private final int f4578r;
    private final boolean useCounter;

    private KDFFeedbackParameters(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, boolean z) {
        if (bArr == null) {
            throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
        }
        this.f4577ki = Arrays.clone(bArr);
        if (bArr3 == null) {
            this.fixedInputData = new byte[0];
        } else {
            this.fixedInputData = Arrays.clone(bArr3);
        }
        this.f4578r = i;
        if (bArr2 == null) {
            this.f4576iv = new byte[0];
        } else {
            this.f4576iv = Arrays.clone(bArr2);
        }
        this.useCounter = z;
    }

    public static KDFFeedbackParameters createWithCounter(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        if (i == 8 || i == 16 || i == 24 || i == 32) {
            return new KDFFeedbackParameters(bArr, bArr2, bArr3, i, true);
        }
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    }

    public static KDFFeedbackParameters createWithoutCounter(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return new KDFFeedbackParameters(bArr, bArr2, bArr3, -1, false);
    }

    public byte[] getFixedInputData() {
        return Arrays.clone(this.fixedInputData);
    }

    public byte[] getIV() {
        return this.f4576iv;
    }

    public byte[] getKI() {
        return this.f4577ki;
    }

    public int getR() {
        return this.f4578r;
    }

    public boolean useCounter() {
        return this.useCounter;
    }
}
