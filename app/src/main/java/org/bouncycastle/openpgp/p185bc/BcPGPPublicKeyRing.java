package org.bouncycastle.openpgp.p185bc;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.p186bc.BcKeyFingerprintCalculator;

/* JADX INFO: loaded from: classes6.dex */
public class BcPGPPublicKeyRing extends PGPPublicKeyRing {
    private static KeyFingerPrintCalculator fingerPrintCalculator = new BcKeyFingerprintCalculator();

    public BcPGPPublicKeyRing(InputStream inputStream) throws IOException {
        super(inputStream, fingerPrintCalculator);
    }

    public BcPGPPublicKeyRing(byte[] bArr) throws IOException {
        super(bArr, fingerPrintCalculator);
    }
}
