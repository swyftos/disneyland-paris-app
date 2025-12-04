package org.bouncycastle.openpgp.jcajce;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.openpgp.operator.KeyFingerPrintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;

/* loaded from: classes6.dex */
public class JcaPGPSecretKeyRing extends PGPSecretKeyRing {
    public JcaPGPSecretKeyRing(InputStream inputStream) throws IOException, PGPException {
        super(inputStream, getFingerPrintCalculator());
    }

    public JcaPGPSecretKeyRing(byte[] bArr) throws IOException, PGPException {
        super(bArr, getFingerPrintCalculator());
    }

    private static KeyFingerPrintCalculator getFingerPrintCalculator() {
        return new JcaKeyFingerprintCalculator();
    }
}
