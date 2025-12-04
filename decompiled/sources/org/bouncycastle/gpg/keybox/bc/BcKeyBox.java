package org.bouncycastle.gpg.keybox.bc;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.gpg.keybox.KeyBox;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

/* loaded from: classes6.dex */
public class BcKeyBox extends KeyBox {
    public BcKeyBox(InputStream inputStream) throws IOException {
        super(inputStream, new BcKeyFingerprintCalculator(), new BcBlobVerifier());
    }

    public BcKeyBox(byte[] bArr) throws IOException {
        super(bArr, new BcKeyFingerprintCalculator(), new BcBlobVerifier());
    }
}
