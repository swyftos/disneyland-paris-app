package org.bouncycastle.openpgp.bc;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.bouncycastle.openpgp.PGPObjectFactory;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;

/* loaded from: classes6.dex */
public class BcPGPObjectFactory extends PGPObjectFactory {
    public BcPGPObjectFactory(InputStream inputStream) {
        super(inputStream, new BcKeyFingerprintCalculator());
    }

    public BcPGPObjectFactory(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
